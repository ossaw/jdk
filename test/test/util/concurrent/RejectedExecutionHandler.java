package test.util.concurrent;

import test.util.concurrent.ThreadPoolExecutor;

public interface RejectedExecutionHandler {

	void rejectedExecution(Runnable r, ThreadPoolExecutor executor);

}
