package StructuralPattern.adapter;

interface Bird {
	public void makeSound();
}

class Duck implements Bird {

	@Override
	public void makeSound() {
		System.out.println("Duck says quack quack");
	}                                           
}

class BirdAdapter implements Bird {

	private WhiteDuck whiteDuck;

	public BirdAdapter(WhiteDuck duck) {
		this.whiteDuck =duck;
	}

	@Override
	public void makeSound() {
		this.whiteDuck.squeak();
	}

}

//Adaptee
class WhiteDuck {
	public void squeak() {
		System.out.println("Squeaking");
	}
}

//Client
public class AdapterClient {

	public static void main(String[] args) {
		Bird duck = new Duck();
		duck.makeSound();

		Bird toyBird = new BirdAdapter(new WhiteDuck());
		toyBird.makeSound();
	}

}
