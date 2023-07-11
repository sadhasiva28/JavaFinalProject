package perf;

public class ThreadDemo {
	public static void main(String[] args) {
		// Create a long running thread
		Thread longRunningThread = new Thread(new LongRunningTask());
		longRunningThread.start();

		// Create multiple short running threads
		for (int i = 0; i < 5; i++) {
			Thread shortRunningThread = new Thread(new ShortRunningTask());
			shortRunningThread.start();
		}
	}
}

class LongRunningTask implements Runnable {
	@Override
	public void run() {
		while (true) {
			// Do some long running task here
			System.out.println("Long running task executing...");
			try {
				Thread.sleep(5000); // Sleep for 5 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ShortRunningTask implements Runnable {
	@Override
	public void run() {
		// Do some short running task here
		System.out.println("Short running task executing...");
	}
}
