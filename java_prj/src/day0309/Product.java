package day0309;

public class Product extends Thread{
	//Field
	DrinkMachine dm;
	String name;
	//Constructor
	public Product() { }
	public Product(String name,DrinkMachine dm) { 
		this.name = name;
		this.dm = dm;
	}
	//Method
	public void run() {
		dm.putDrink(name);
		
	}
}
