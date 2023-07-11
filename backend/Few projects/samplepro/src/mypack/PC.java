package mypack;

class CommonClass{
	int num;
	boolean available=false; 
	public synchronized int put(int num) {
		if(available)  
		try {
			wait();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("Producer put " + num);
		this.num=num;
		//System.out.println(num);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		available=true;
		notify();
		return num;
	}
	public synchronized int get() {
		if(!available) 
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Consumer get "+ num);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		available=false;
		notify();
		return num;
	}
}

class Producer implements Runnable
{
	CommonClass cc;
	public Producer(CommonClass cc) {
		this.cc =cc;
		new Thread(this,"Producer").start();
	}

	@Override
	public void run() {
		int i=1, x=1;
		while(x<=10) {
			cc.put(i++);
			x++;
		}
		
	}
	
}
class Consumer implements Runnable{

	CommonClass cc;
	public Consumer(CommonClass cc) {
		this.cc =cc;
		new Thread(this,"Consumer").start();
	}

	@Override
	public void run() {
	
		int x=1;
		while(x<=10) {
			cc.get();
			x++;
		}
	}
	
	
}
public class PC {

	public static void main(String[] args) {
		CommonClass cc = new CommonClass();
		new Producer(cc);
		new Consumer(cc);
	}

}
