package day0213;

import java.util.Scanner;

public class Person {
	// Field
	private int money = 0;
	Scanner scanner = new Scanner(System.in);
	// Counstructor(�����ڴ� JVM�� �������� ������ش�)

	// Method
	/**
	 * ���������� ����Ÿ�� �޼ҵ��(){ ��ɱ���~ ����Ÿ�Կ� ���� ��� }
	 */
	public int input() {
//		System.out.println("==>1.��� : ����(" + money + ")�� �ִ´�. ");
		System.out.print("!!)���� �󸶳� �����ðڽ��ϱ�?>>>>>>>\t");
//		money = scanner.nextInt();

		return scanner.nextInt();
	}

	public String choice() {
		System.out.println("\n==>3.���: �޴��� �����Ѵ� ");
		System.out.print("!!)�޴��� �������ּ���.>>>>>>>>\t");
		//String menu = scanner.next();
		return scanner.next();
	}
}
