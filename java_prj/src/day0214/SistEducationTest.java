package day0214;

import day0213.CoffeeMachine;
import day0213.Person;
/**
 *��ü�� ��������,������ import ������ ����
 * @author user
 */
public class SistEducationTest {
	int number = 100;
	public static void main(String[] args) {
		//Ŀ�����Ǳ� ��ü ����:��ü���� ���� ����
		//Ŭ������ ���������� = new Ŭ������ ������();
		CoffeeMachine sistMachine = new CoffeeMachine();
		System.out.println(sistMachine);
		CoffeeMachine sistMachine2 = new CoffeeMachine();
		System.out.println(sistMachine2);
		sistMachine2 = new CoffeeMachine();
		System.out.println(sistMachine2);
		sistMachine2 = new CoffeeMachine();
		System.out.println(sistMachine2);//�޸� ��������(�ؽ���)���� ����Ѵ�.

		//�޸𸮿� ��������� ��ü�� 4���̸� �������� ��ü������ 2���̴�
		Person ach = new Person();
		
		
		//(���) ��ü�� �����Ͽ� �������� â���̿� �����Ѵ�.
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
