package test.util.concurrent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutor extends AbstractExecutorService {

	private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
	private static final int COUNT_BIT = Integer.SIZE - 3;
	// 000 11111111111111111111111111111
	private static final int CAPACITY = (1 << COUNT_BIT) - 1;

	// 111 00000000000000000000000000000
	private static final int RUNNING = -1 << COUNT_BIT;
	// 000 00000000000000000000000000000
	private static final int SHUTDOWN = 0 << COUNT_BIT;
	// 001 00000000000000000000000000000
	private static final int STOP = 1 << COUNT_BIT;
	// 010 00000000000000000000000000000
	private static final int TIDYING = 2 << COUNT_BIT;
	// 011 00000000000000000000000000000
	private static final int TERMINATED = 3 << COUNT_BIT;

	private volatile int corePoolSize;
	private volatile int maxPoolSize;
	private volatile long keepAliveTime;
	private volatile TimeUnit unit;
	private volatile ThreadFactory threadFactory;
	private volatile RejectedExecutionHandler handler;
	private volatile BlockingQueue<Runnable> workerQueue;
	private static final RejectedExecutionHandler defaultRejectHandler = new AbortPolicy();

	private final Set<Worker> workers = new HashSet<>();
	private final ReentrantLock mainLock = new ReentrantLock();
	private int largestPoolSize;

	public ThreadPoolExecutor(int corePoolSize, int maxPoolSize,
			long keepAliveTime, TimeUnit unit, ThreadFactory threadFactory,
			BlockingQueue<Runnable> workerQueue,
			RejectedExecutionHandler handler) {
		if (corePoolSize < 0 || maxPoolSize < 0 || corePoolSize > maxPoolSize
				|| keepAliveTime < 0)
			throw new IllegalArgumentException();

		this.corePoolSize = corePoolSize;
		this.maxPoolSize = maxPoolSize;
		this.keepAliveTime = unit.toNanos(keepAliveTime);
		this.workerQueue = workerQueue;
		if (threadFactory == null)
			this.threadFactory = new DefaultThreadFactory();
		else
			this.threadFactory = threadFactory;
		this.handler = handler;
	}

	private static int workCountOf(int c) {
		return c & CAPACITY;
	}

	private static int runStateOf(int c) {
		return c & ~CAPACITY;
	}

	private static int ctlOf(int wc, int rt) {
		return wc | rt;
	}

	private static boolean isRunning(int c) {
		return c < SHUTDOWN;
	}

	@Override
	public void execute(Runnable command) {
		if (command == null)
			throw new NullPointerException("task is null ...");

		int c = ctl.get();
		if (workCountOf(c) < corePoolSize)
			if (addWorker(command, false))
				return;
		c = ctl.get();
		if (isRunning(c) && workerQueue.offer(command)) {
			int recheck = ctl.get();
			if (!isRunning(recheck) && remove(command))
				reject(command);
			else if (workCountOf(recheck) == 0)
				addWorker(null, false);
		} else if (!addWorker(command, false))
			reject(command);
	}

	private boolean addWorker(Runnable firstTask, boolean core) {
		retry: for (;;) {
			int c = ctl.get();
			int rs = runStateOf(c);
			if (rs > SHUTDOWN || !(rs == SHUTDOWN && !workerQueue.isEmpty()
					&& firstTask == null))
				return false;

			for (;;) {
				int wc = workCountOf(ctl.get());
				if (wc >= CAPACITY || wc >= (core ? corePoolSize : maxPoolSize))
					return false;
				if (compareAndIncrementWorkerCount(c))
					break retry;
				c = ctl.get();
				if (rs != runStateOf(c))
					continue retry;
			}
		}

		boolean workerStarted = false;
		boolean workerAdded = false;
		Worker w = null;
		try {
			w = new Worker(firstTask);
			final Thread t = w.thread;
			final ReentrantLock lock = this.mainLock;
			lock.lock();
			try {
				if (t != null) {
					if (t.isAlive())
						throw new IllegalStateException();
					int rs = runStateOf(ctl.get());
					if (rs < SHUTDOWN || (rs == SHUTDOWN
							&& firstTask == null)) {
						workers.add(w);
						int s = workers.size();
						if (s > largestPoolSize)
							largestPoolSize = s;
						workerAdded = true;
					}
				}
			} finally {
				lock.unlock();
				if (workerAdded) {
					t.start();
					workerStarted = true;
				}
			}
		} finally {
			if (!workerStarted) {
				// ÃÌº” ß∞‹
			}
		}
		return workerStarted;
	}

	private final void reject(Runnable task) {
		handler.rejectedExecution(task, this);
	}

	private boolean compareAndIncrementWorkerCount(int expect) {
		return ctl.compareAndSet(expect, expect + 1);
	}

	private boolean remove(Runnable task) {
		boolean removed = workerQueue.remove(task);
		// tryTerminate()
		return removed;
	}

	private final class Worker extends AbstractQueuedSynchronizer implements
			Runnable {
		private Runnable firstTask;
		private final Thread thread;

		public Worker(Runnable firstTask) {
			setState(-1);
			this.firstTask = firstTask;
			thread = ThreadPoolExecutor.this.getThreadFactory().newThread(this);
		}

		@Override
		public void run() {
			runWorker(this);
		}

		private void runWorker(Worker worker) {

		}
	}

	@Override
	public void shutdown() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
		return false;
	}

	private static class AbortPolicy implements RejectedExecutionHandler {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			throw new RejectedExecutionException(r + " is refused execute ...");
		}
	}

	private ThreadFactory getThreadFactory() {
		return threadFactory;
	}

	private static class DefaultThreadFactory implements ThreadFactory {
		@Override
		public Thread newThread(Runnable runnable) {
			return new Thread(runnable);
		}
	}

}
