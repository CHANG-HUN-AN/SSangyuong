package h_day0211;

import java.util.Scanner;

/**
 * ȸ������ ���α׷� 3��°�� ����� ���α׷� �̸� �ּҸ� �Է¹޾� ������ �Ѵ�
 * 
 * @author user
 */
public class memberTest3 {

	public static void main(String[] args) {
//		String[][] memberlist = new String[10][3];
		String[][] memberlist = new String[2][];// �����迭�� �޸𸮰��� ȿ���� ����.

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int count = 0;

		while (flag) {
			System.out.println("**********menu************");
			System.out.println("==����(0)>\t==");
			System.out.println("==ȸ�� ��� (1) > ==");
			System.out.println("==ȸ�� ����Ʈ (2) > ==");
			System.out.println("==ȸ�� �˻�(3) >== ");
			System.out.println("***************************");
			System.out.print("�޴� �Է�>\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				if (count == memberlist.length) {
					System.out.println("ȸ�� ����� �ʰ��Ҽ� �����ϴ� .\n�ִ� ��ϼ� :" + count);
				} else {
					for (int i = 0; i < memberlist.length; i++) {
						System.out.print("�̸��Է�>");
						String name = scanner.next();
						System.out.print("�ּ��Է�>");
						String address = scanner.next();
						System.out.print("�����Է�>");
						String age = scanner.next();

						if (count == 0) {// �ʱ���
							memberlist[i] = new String[3];
							for (int j = 0; j < memberlist[i].length; j++) {
								switch (j) {
								case 0:
									memberlist[i][j] = name;
									break;
								case 1:
									memberlist[i][j] = address;
									break;
								case 2:
									memberlist[i][j] = age;
								}// end switch
							} // End_inner for
							count++;
						} else {// �߰����
							memberlist[count] = new String[3];
							for (int j = 0; j < memberlist[i].length; j++) {
								switch (j) {
								case 0:
									memberlist[count][j] = name;
									break;
								case 1:
									memberlist[count][j] = address;
									break;
								case 2:
									memberlist[count][j] = age;
								}// end switch
							} // End_inner for
							count++;
						} // end if~else
						System.out.print("����� ��� �Է� �Ͻðڽ��ϱ�? y/n>");
						String exit = scanner.next();
						if (exit == "n" || exit.equals("n")) {
							System.out.println("ȸ������� �����մϴ�.");
							i = memberlist.length;
						} else {
							if (count == memberlist.length) {
								System.out.println("ȸ�� ����� �ʰ��Ҽ� �����ϴ� .\n�ִ� ��ϼ� :" + count);
								i = memberlist.length;
							} // if
						} // if~else
					} // end outer for
				} // end if~else
			} else if (menu == 2) {// ȸ�� �˻�
				if (memberlist[0] == null) {
					System.out.println("��ϵ� ȸ���� �����ϴ� \nȸ������� ���ּ���.\n");
				} else {
					// ȸ������Ʈ ���
					System.out.println("----------------------------------------------------------");
					System.out.println("��ȣ\t\t�̸�\t\t�ּ�\t\t����");
					System.out.println("----------------------------------------------------------");
					for (int i = 0; i < memberlist.length; i++) {
						if (memberlist[i] == null) {
							i = memberlist.length;
						} else {
							System.out.print(i);
							for (int j = 0; j < memberlist[i].length; j++) {
								System.out.print("\t\t" + memberlist[i][j]);
							} // end inner for
							System.out.println();
						} // end if~else
					} // end outer for
					System.out.println();
				} // end if~else
			} else if (menu == 0) {
				System.out.println("�����մϴ�");
				flag = false;
			} else if (menu == 3) { // ȸ�� �˻�
				if (memberlist[0] == null) {
					System.out.println("��ϵ� ȸ���� �����ϴ� \nȸ������� ���ּ���.\n");
				} else {
					System.out.println("ã���� ȸ�� �̸��� �����ּ���>");
					String sname = scanner.next();
					int index = 10; // ���� ȸ�� �˻�

					// ȸ������Ʈ ���

					for (int i = 0; i < memberlist.length; i++) {
						if (memberlist[i] == null) { // ��ϵ� ȸ���� ������������ �ڿ��� null�� ¥����
							i = memberlist.length;
						} else {
							for (int j = 0; j < memberlist[i].length; j++) {
								if (memberlist[i][j].equals(sname)) {
									index = i;
									j = memberlist[i].length;
								} // end if
							} // inner for
						} // end if~else
					} // end outer for

					if (index == 10) {
						System.out.println("�������� �ʴ� ȸ���Դϴ�.");
					} else {//�˻��� ȸ�� ���
						System.out.println("----------------------------------------------------------");
						System.out.println("��ȣ\t\t�̸�\t\t�ּ�\t\t����");
						System.out.print(index);
						for (int k = 0; k < memberlist[index].length; k++) {
							System.out.print("\t\t" + memberlist[index][k]);
						} // end inner for
						System.out.println("\n----------------------------------------------------------");
					} // end if~else
				} // end if~else
			} else {
				System.out.println("���� �޴��Դϴ�.");
			} // end else~if
		} // end while
		System.out.println("ȸ���������α׷� ����..");
	}// end main
}// end class
