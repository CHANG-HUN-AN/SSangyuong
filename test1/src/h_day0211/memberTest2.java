package h_day0211;

import java.util.Scanner;

/**
 * ȸ������ ���α׷�
 * 3��°�� ����� ���α׷�
 * �̸� �ּҸ� �Է¹޾� ������ �Ѵ�
 * 
 * @author user
 */
public class memberTest2 {

	public static void main(String[] args) {
		String[][] memberlist= new String[3][3];

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
				for (int i = 0; i < memberlist.length; i++) {
					for (int j = 0; j < memberlist[i].length; j++) {
						System.out.print("�̸��Է�>");
						memberlist[i][j] = scanner.next();
						System.out.print("�ּ��Է�>");
						memberlist[i][j+1] = scanner.next();
						System.out.print("�����Է�>");
						memberlist[i][j+2] = scanner.next();
						j=memberlist.length;
						}
						System.out.print("����� ��� �Է� �Ͻðڽ��ϱ�? y/n>");
						String exit = scanner.next();
						if (exit == "n" || exit.equals("n")) {
							System.out.println("ȸ������� �����մϴ�.");
							i = memberlist.length;
						} // end if
				} // end  m for
				flag = true;
			} else if (menu == 2) {
				if (memberlist[0][0]== null) {
					System.out.println("��ϵ� ȸ���� �����ϴ� \nȸ������� ���ּ���.");
				} else {
					System.out.println("----------------------------------------------------------");
					System.out.println("��ȣ\t\t�̸�[����]\t\t�ּ�");
					for (int i = 0; i < memberlist.length; i++) {
						for (int j = 0; j < memberlist[i].length; j++) {
							if (memberlist[i][j] == null) {
								i = memberlist.length;
							} else {
								System.out.println((i+1) + "\t\t" + memberlist[i][j] + "[" + memberlist[i][j+1] + "] " + "\t\t" + memberlist[i][j+2]);
								System.out.println("----------------------------------------------------------");
							} // end if~else
						}//end inner for
					} // end outer for
				} // end if~else
			} else if (menu == 0) {
				System.out.println("�����մϴ�");
				flag = false;
			} else if(menu==3){
				if (memberlist[0]== null) {
					System.out.println("��ϵ� ȸ���� �����ϴ� \nȸ������� ���ּ���.");
				} else {
					System.out.println("----------------------------------------------------------");
					System.out.println("��ȣ\t\t�̸�[����]\t\t�ּ�");
					for (int i = 0; i < memberlist.length; i++) {
						for (int j = 0; j < memberlist[i].length; j++) {
							if (memberlist[i][j] == null) {
								j = memberlist[i].length;
								i = memberlist.length;
							} else {
								System.out.println("----------------------------------------------------------");
								System.out.println("��ȣ\t\t�̸�[����]\t\t�ּ�");
								System.out.println((i+1) + "\t\t" + memberlist[i][j] + "[" + memberlist[i][j+1] + "] " + "\t\t" + memberlist[i][j+2]);
								System.out.println("----------------------------------------------------------");
							} // end if~else
						}//end inner for
					} // end outer for
				}//end if~else
			} else {
				System.out.println("���� �޴��Դϴ�.");
			} // end else~if
		} // end while
		
		System.out.println("ȸ���������α׷� ����..");
	}// end main
}// end class
