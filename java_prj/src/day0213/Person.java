package day0213;

import java.util.Scanner;

public class Person {
	// Field
	private int money = 0;
	Scanner scanner = new Scanner(System.in);
	// Counstructor(생성자는 JVM이 가상으로 만들어준다)

	// Method
	/**
	 * 접근제어자 리턴타입 메소드명(){ 기능구현~ 리턴타입에 따라 출력 }
	 */
	public int input() {
//		System.out.println("==>1.사람 : 동전(" + money + ")을 넣는다. ");
		System.out.print("!!)돈을 얼마나 넣으시겠습니까?>>>>>>>\t");
//		money = scanner.nextInt();

		return scanner.nextInt();
	}

	public String choice() {
		System.out.println("\n==>3.사람: 메뉴를 선택한다 ");
		System.out.print("!!)메뉴를 선택해주세요.>>>>>>>>\t");
		//String menu = scanner.next();
		return scanner.next();
	}
}
