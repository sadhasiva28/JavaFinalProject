package mypack2;

public class MainJ8Class {

	public static void main(String[] args) {

		// Method-1
		// MyTaskThread mtt = new MyTaskThread();
		// Thread t = new Thread(mtt);
		// t.start();

		// Method-2
		/*
		 * Runnable r = new Runnable() {
		 * 
		 * @Override public void run() { MyTask t = new MyTask(); t.print();
		 * 
		 * } }; Thread t = new Thread(r); t.start();
		 */

		// Method 3 - J8
		/*
		 * Runnable r=()-> { MyTask t = new MyTask(); t.print();
		 * 
		 * };
		 * 
		 * Thread t = new Thread(r); t.start();
		 */
		// Method 4 -J8
		/*
		 * Thread t = new Thread(()-> { MyTask mt = new MyTask(); mt.print();
		 * 
		 * }); t.start();
		 */
		// Method -5
		/*
		 * new Thread(()-> { MyTask mt = new MyTask(); mt.print();
		 * 
		 * }).start();
		 */
		// Method -6
		new Thread(() -> {
			new MyTask().print();
		}).start();
		// Method Reference
		new Thread(new MyTask()::print).start();
	}

}



