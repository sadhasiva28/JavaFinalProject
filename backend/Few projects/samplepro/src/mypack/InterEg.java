package mypack;

interface Birdd {
	// int weight;
	int height = 45; // public static final

	public void eat(); // public abstract

}

class Parrott implements Birdd {
	public void eat() {
		System.out.println("Parrot eating");
	}
}

 class Lion  implements Birdd{
	 public void eat() {
			System.out.println("Parrot eating");
		}
	
}

public class InterEg {

	public static void main(String[] args) {

		Parrot p = new Parrot();
		p.eat();

		Birdd b = new Parrott();
	}

}