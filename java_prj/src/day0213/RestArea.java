package day0213;

/**
 *커피자판기와 고객의 객체의 사용
 * @author user
 */
public class RestArea {

	public static void main(String[] args) {
		//커피자판기 객체 생성:객체참조 변수 생성
		//클래스명 참조변수명 = new 클래스의 생성자();
		System.out.println("==평창 휴게소에 오신걸 환영합니다==");
//		CoffeeMachine.showMenu();//스태틱 메모리참조라 클래스.메소드로 사용가능
		
		CoffeeMachine maximMachine = new CoffeeMachine();
		Person bo = new Person();
		//(사람)보검 객체 생성
//		int money = bo.input();
//		maximMachine.check(money);
		
		boolean flag = true;
		while(flag) {
			if(maximMachine.check(bo.input())) {
				maximMachine.make(bo.choice());
				maximMachine.response();
				flag =false;
			}//if
		}//end  while
	}// main

}// class
