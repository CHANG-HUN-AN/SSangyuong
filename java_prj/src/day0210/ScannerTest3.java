package day0210;

import java.util.Scanner;

/**
 * ������ ������ �ܼ��� �Է¹޾� �������� ������ּ���. 3�� �Է½� ������ 3�� ��� 
 * ������ ���� ����
 * @author user
 */
public class ScannerTest3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("�������� �Է����ּ��� >");
			int dan = scanner.nextInt();

			if (dan > 0) {
				for (int j = 1; j < 10; j++) {
					System.out.println(dan + " * " + j + " = " + dan * j);
				} // end for
				flag = false;
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
			} // end else
		} // end while

	}// end main
}// end class
