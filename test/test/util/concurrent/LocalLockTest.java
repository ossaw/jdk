package test.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LocalLockTest implements Runnable {
	private static final ReentrantLock lock = new ReentrantLock(true);
	private static int counter = 0;

	@Override
	public void run() {
		final ReentrantLock localLock = lock;
		try {
			localLock.lock();
			System.out.println("++++++++++++" + counter++);
			Thread.yield();
			System.out.println();
		} finally {
			localLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++)
			exec.execute(new LocalLockTest());
		exec.shutdown();
	}
}
