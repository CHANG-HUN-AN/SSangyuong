package day0214;

import day0213.CoffeeMachine;
import day0213.Person;
/**
 *객체의 개념이해,사용법과 import 에대한 연습
 * @author user
 */
public class SistEducationTest {
	int number = 100;
	public static void main(String[] args) {
		//커피자판기 객체 생성:객체참조 변수 생성
		//클래스명 참조변수명 = new 클래스의 생성자();
		CoffeeMachine sistMachine = new CoffeeMachine();
		System.out.println(sistMachine);
		CoffeeMachine sistMachine2 = new CoffeeMachine();
		System.out.println(sistMachine2);
		sistMachine2 = new CoffeeMachine();
		System.out.println(sistMachine2);
		sistMachine2 = new CoffeeMachine();
		System.out.println(sistMachine2);//메모리 번지수를(해쉬값)으로 출력한다.

		//메모리에 만들어지는 객체는 4개이며 최종으로 객체생성은 2개이다
		Person ach = new Person();
		
		
		//(사람) 객체를 생성하여 참조변수 창훈이에 연결한다.
//		int money = bo.input();
//		maximMachine.check(money);
		sistMachine.check(ach.input());
		sistMachine.make(ach.choice());
		sistMachine.response();

		sistMachine2.check(ach.input());
		sistMachine2.make(ach.choice());
		sistMachine2.response();
	}// main

}// class
