package day0213;

/**
 *Ŀ�����Ǳ�� ���� ��ü�� ���
 * @author user
 */
public class RestArea {

	public static void main(String[] args) {
		//Ŀ�����Ǳ� ��ü ����:��ü���� ���� ����
		//Ŭ������ ���������� = new Ŭ������ ������();
		System.out.println("==��â �ްԼҿ� ���Ű� ȯ���մϴ�==");
//		CoffeeMachine.showMenu();//����ƽ �޸������� Ŭ����.�޼ҵ�� ��밡��
		
		CoffeeMachine maximMachine = new CoffeeMachine();
		Person bo = new Person();
		//(���)���� ��ü ����
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
