package day0210;

import java.util.Scanner;

/**
 * �̸��� �ּҸ� �Է¹޾� ����Ͻÿ� 
 * $Scanner �� �޼ҵ���� ����$
 * ��ȿ���˻�
 * @author user
 */
public class ScannerTest2 {
	// field
	// constructor
	// Method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		boolean flag2 = true;
		while (flag) {
			System.out.print("�̸� �Է�");
			String name = scanner.nextLine();
			// validation üũ ��ȿ��üũ
			if (name == "" || name.equals("")) { // ���������� Scanner ��ü�� �޼ҵ����� ���������� �Ѿ�ö��� �ְ� �⺻������ �Ѿ�ö����־� �Ѵٽ��ش�
				System.out.println("�Է°��� �����ϴ�."); // ������� ���������� �����Ͱ� �Ѿ������
			}
			// next�� ���⿡�� �Է°��� �������� , nextLine �޼ҵ�� ���� �����ؼ� �Ѷ����� �� �о��ش�
			// �ڹٹ��� next �� nextLine �� ���ÿ� ���̾��� next���� ��µǰ� Line���� ������.
			else {
				while (flag2) {
					System.out.print("�ּ� �Է�");
					String address = scanner.nextLine();

					if (address == "" || address.equals("")) {
						System.out.println("�ּҰ��� �����ϴ�.");
					} else {
						System.out.println(name + "��(��)" + address + "�� ����ֽ��ϴ�.");
						flag = false;
						flag2 =false;
					} // end else
				} // end while
					// while�̳� do-while�� flag�� �������ִ°� ���� break�� ���������°��� ��������.
			} // end else
		} // end while
	}

}
