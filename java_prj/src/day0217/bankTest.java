package day0217;


public class bankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banker bank1 = new Banker();
		Customer customer1 = new Customer();
		
//		bank1.accountCheck(customer1.getName(),customer1.getAccountNO(),customer1.getMoney());
		bank1.accountCheck(customer1.getPaper());
//		bank1.accountCheck(customer1.getAccountinfo());
		bank1.askAccountInfo();
		bank1.askMoney(100);
		bank1.askPass(customer1.getPass());
		bank1.success();
	}//main

}

