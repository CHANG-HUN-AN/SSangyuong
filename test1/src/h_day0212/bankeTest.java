package h_day0212;


public class bankeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======은행 입장=========");
		customer ach = new customer();
		Banker sistbanker = new Banker();
		boolean flag;
		while(sistbanker.check(ach.withdraw())){
			sistbanker.money_check(ach.money());
			ach.withdraw_com(sistbanker.pass_check(ach.password()));
		}
		
	}

}
