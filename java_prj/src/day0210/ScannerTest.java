package day0210;

import java.util.Scanner;
/**
 * java.util�� �ִ� Scanner�� ����
 * @author user
 */
public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // heap �� ����
		System.out.print("�������Է��Ͻÿ�>");
		String str = scanner.next(); //stack �� ����
		System.out.println(str);
		
		//������ �μ��� �Է¹޾� ȭ�鿡 ����Ͻÿ�
		System.out.println("����1;");
		int num1 = scanner.nextInt();
		
		System.out.println("����2");
		int num2 = scanner.nextInt();
		
		System.out.println(num1 +num2);
		
	}

}
