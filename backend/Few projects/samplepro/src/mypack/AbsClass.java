package mypack;

abstract class Bird {
	int weight;
	int height=45;
	
	public abstract void eat() ;
	
	Bird(){
		
	}
	public void fly() {
		
	}
}

class Parrot extends Bird {
	public void eat() {
		System.out.println("Parrot eating");
	}
}

public class AbsClass {

	public static void main(String[] args) {
		
		
			Parrot p =new Parrot();
			p.eat();
			
			Bird b = new Parrot();
	}

}
