package day0309;

public class DrinkMahcineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrinkMachine dm =  new DrinkMachine();
		Product pd = new Product("ȫ�浿",dm);
		Customer ct = new Customer("������",dm);
		
		pd.start();
		ct.start();
	}

}
