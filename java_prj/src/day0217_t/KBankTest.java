package day0217_t;


public class KBankTest {

	public static void main(String[] args) {
		Banker 직원 = new Banker();
		Customer 고객 = new Customer();
		
//		직원.accountCheck(고객.getName(),고객.getAccountno(),고객.getMoney());
		직원.accountCheck(고객.getAccountinfo());
//		직원.accountCheck(고객.getPaper());
		직원.askAccountInfo();//금액이 빠져있고
		직원.askMoney(100); //인출할 금액을 입력한다.
		직원.askPass(고객.getPass());
		직원.success();
	}

}








