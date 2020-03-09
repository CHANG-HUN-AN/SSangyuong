package day0309;

public class DrinkMahcineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrinkMachine dm =  new DrinkMachine();
		Product pd = new Product("È«±æµ¿",dm);
		Customer ct = new Customer("ºÀ¼øµ¿",dm);
		
		pd.start();
		ct.start();
	}

}
