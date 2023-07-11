package mypack2;

 class Counter {
    private volatile int count;

    public int getCount() {
        return count;
    }

    public void increment() {
      //  count++;  // Non-atomic operation
    	 synchronized (this) {
             count++; // Atomic operation within the synchronized block
         }
    }
}

public class MainVolatile {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter.increment();
                System.out.println("t1 -- i "+i +" - " +counter.getCount());
            }
          
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter.increment();
                System.out.println("t2 -- i "+i +" - " +counter.getCount());
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}
