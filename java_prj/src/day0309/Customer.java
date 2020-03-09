package day0309;

public class Customer extends Thread{
	DrinkMachine dm;
	String name;
	
	public Customer() { }
	public Customer(String name ,DrinkMachine dm) { 
		this.name = name;
		this.dm=dm;
	}
	public void run() {
		dm.getDrink(name);
	}
}
