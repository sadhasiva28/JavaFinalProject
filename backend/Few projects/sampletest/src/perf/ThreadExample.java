package perf;

public class ThreadExample {
    public static void main(String[] args) {
        // Create a long-running thread
        Thread longRunningThread = new Thread(() -> {
            while (true) {
                System.out.println("Long-running thread is running...");
                try {
                    Thread.sleep(1000); // sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        longRunningThread.setDaemon(false); // long-running thread is not a daemon thread
        longRunningThread.start(); // start the long-running thread
        
        // Create a short-running thread
        Thread shortRunningThread = new Thread(() -> {
            System.out.println("Short-running thread is running...");
        });
        shortRunningThread.setDaemon(false); // short-running thread is not a daemon thread
        shortRunningThread.start(); // start the short-running thread
    }
}
