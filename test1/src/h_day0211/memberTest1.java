package h_day0211;

import java.util.Scanner;

/**
 * ȸ������ ���α׷� 3��°�� ����� ���α׷� �̸� �ּҸ� �Է¹޾� ������ �Ѵ�
 * 
 * @author user
 */
public class memberTest1 {

	public static void main(String[] args) {
		String[] nameList = new String[10];
		String[] addList = new String[10];
		int[] ageList = new int[10];

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("***************************");
			System.out.println("==����(0)>\t==");
			System.out.println("==ȸ�� ��� (1) > ==");
			System.out.println("==ȸ�� ����Ʈ (2) > ==");
			System.out.println("==ȸ�� �˻�(3) >== ");
			System.out.println("***************************");
			System.out.print("�޴� �Է�>\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				for (int i = 0; i < ageList.length; i++) {
					System.out.print("�̸��Է�>");
					nameList[i] = scanner.next();
					System.out.print("�ּ��Է�>");
					addList[i] = scanner.next();
					System.out.print("�����Է�>");
					ageList[i] = scanner.nextInt();

					System.out.print("����� ��� �Է� �Ͻðڽ��ϱ�? y/n>");
					String exit = scanner.next();
					if (exit == "n" || exit.equals("n")) {
						System.out.println("ȸ������� �����մϴ�.");
						i = ageList.length;
					} // end if
				} // end for
				flag = true;
			} else if (menu == 2) {
				if (nameList[0] == null) {
					System.out.println("����� �ʿ��մϴ�.");
				} else {
					System.out.println("----------------------------------------------------------");
					System.out.println("��ȣ\t\t�̸�\t\t����\t\t�ּ�");
					for (int i = 0; i < ageList.length; i++) {
						if (nameList[i] == null) {
							i = ageList.length;
						} else {
							System.out.println(
									(i + 1) + "\t\t" + nameList[i] + "\t\t" + ageList[i] + "\t\t "  + addList[i]);
						} // end if~else
					} // end for
					System.out.println("----------------------------------------------------------");
				} // end if~else
			} else if (menu == 0) {
				System.out.println("�����մϴ�");
				flag = false;
			} else if (menu == 3) {
				if (nameList[0] == null) {
					System.out.println("��ϵ� ȸ���� �����ϴ� \nȸ������� ���ּ���.");
				} else {
					System.out.println("�˻��� �̸��� �Է����ּ���");
					System.out.print("�˻� >\t ");

					String sname = scanner.nextLine();
					int index = 0;
					for (int i = 0; i < nameList.length; i++) {
						if (sname.equals(nameList[i])) {
							System.out.println("�˻���� " + sname + "���� �����մϴ�");
							index = i;
						} else {
							i = nameList.length;
						} // end if ~ else
					} // end for
					System.out.println("----------------------------------------------------------");
					System.out.println("��ȣ\t\t�̸�\t\t�ּ�\t\t����");
					for (int i = 0; i < nameList.length; i++) {
						if (nameList[i] == null) {
							i = nameList.length;
						} else {
							System.out.print(index);
							System.out.print("\t\t" + nameList[index] + "\t\t" + addList[index] + "\t\t" + ageList[index]+"\n");
						} // end if~else
					} // end outer for
					System.out.println("----------------------------------------------------------");
				} // end if~else
			} else {
				System.out.println("���� �޴��Դϴ�.");
			} // end else~if
		} // end while

		System.out.println("ȸ���������α׷� ����..");
	}// end main
}// end class
