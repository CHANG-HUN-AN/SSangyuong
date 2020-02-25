package day0210;

import java.util.Scanner;
/**
 * java.util에 있는 Scanner의 사용법
 * @author user
 */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // heap 에 생성
		System.out.print("ㅇㄹㅇ입력하시오>");
		String str = scanner.next(); //stack 에 생성
		System.out.println(str);
		
		//임의의 두수를 입력받아 화면에 출력하시오
		System.out.println("숫자1;");
		int num1 = scanner.nextInt();
		
		System.out.println("숫자2");
		int num2 = scanner.nextInt();
		
		System.out.println(num1 +num2);
		
	}

}
