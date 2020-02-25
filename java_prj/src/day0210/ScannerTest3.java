package day0210;

import java.util.Scanner;

/**
 * 임의의 구구단 단수를 입력받아 구구단을 출력해주세요. 3단 입력시 구구단 3단 출력 
 * 로직에 대한 공부
 * @author user
 */
public class ScannerTest3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("구구단을 입력해주세요 >");
			int dan = scanner.nextInt();

			if (dan > 0) {
				for (int j = 1; j < 10; j++) {
					System.out.println(dan + " * " + j + " = " + dan * j);
				} // end for
				flag = false;
			} else {
				System.out.println("다시 입력해주세요.");
			} // end else
		} // end while

	}// end main
}// end class
