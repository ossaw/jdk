package test.util.concurrent;

public interface ThreadFactory {
	
	Thread newThread(Runnable runnable);

}
