package Behaviuorpattrn.simplem;

interface ShoppingCartVisitor {
	int visit(Book book);

	int visit(Fruit fruit);
}

interface ItemElement {
	int accept(ShoppingCartVisitor visitor);
}

class Book implements ItemElement {
	private int price;
	private String isbnNumber;

	public Book(int price, String isbnNumber) {
		this.price = price;
		this.isbnNumber = isbnNumber;
	}

	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}

class Fruit implements ItemElement {
	private int pricePerKg;
	private int weight;
	private String name;

	public Fruit(int pricePerKg, int weight, String name) {
		this.pricePerKg = pricePerKg;
		this.weight = weight;
		this.name = name;
	}

	public int getPricePerKg() {
		return pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}

class ShoppingCart implements ShoppingCartVisitor {
	@Override
	public int visit(Book book) {
		int cost = 0;
		if (book.getPrice() > 50) {
			cost = book.getPrice() - 5;
		} else {
			cost = book.getPrice();
		}
		System.out.println("Book ISBN Number: " + book.getIsbnNumber() + " Cost: " + cost);
		return cost;
	}

	@Override
	public int visit(Fruit fruit) {
		int cost = fruit.getPricePerKg() * fruit.getWeight();
		System.out.println(fruit.getName() + " cost = " + cost);
		return cost;
	}
}

public class ShoppingCartExample {
	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[] { 
				new Book(100, "1234"), 
				new Book(40, "5678"),
				new Fruit(10, 2, "Apple"), 
				new Fruit(5, 5, "Banana") 
				};

		int totalCost = calculatePrice(items);
		System.out.println("Total Cost = " + totalCost);
	}

	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new ShoppingCart();
		int totalCost = 0;
		for (ItemElement item : items) {
			totalCost += item.accept(visitor);
		}
		return totalCost;
	}
}
