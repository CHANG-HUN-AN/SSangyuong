package day0219;

import java.util.Scanner;

public class MemberMgmSystem {
	// Field
	MemberVO_s[] list = new MemberVO_s[10];
	int count;
	Scanner scanner = new Scanner(System.in);

//	Scanner scanner = new Scanner(System.in);
	// Constructor
	public MemberMgmSystem() {
		this.Menu();
	}

	public boolean MbRegister(GuestTest guesttest) {
		boolean flag = false;
		if (count < list.length) {
			list[count] = guesttest.input();
			count++;

			System.out.println("���Է��Ͻðڽ��ϱ�(y/n)?>>  ");
			String exit = scanner.next();
			if (exit.equals("y") && count == list.length) {
				System.out.println("��������� �ʰ��Ͽ����ϴ�.");
			} else if (exit.equals("y")) {
				flag = true;
			}
		}
		return flag;
	}

	public void Menu() {
		System.out.println("**********menu************");
		System.out.println("==����(0)>\t==");
		System.out.println("==ȸ�� ��� (1) > ==");
		System.out.println("==ȸ�� ����Ʈ (2) > ==");
		System.out.println("==ȸ�� �˻�(3) >== ");
		System.out.println("***************************");
	}

	public int menuchoice() {
		System.out.println("�޴��Է� >>");
		int menu = scanner.nextInt();
		return menu;
	}

	public void ShowRegisterList() {
		System.out.println("======ȸ�� ����Ʈ======");
		System.out.println("�̸�  �ּ�  ���� ");
		for (MemberVO_s vo : list) {
			if (vo != null) {
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getName() + "\t\n");
			}
		}
		System.out.println("==================");
	}

	public void listSearch() {
		if (list == null) {
			System.out.println("ȸ������� �ʿ��մϴ�.");
		} else {
			System.out.println("ã���� ȸ�� �Է�>>");
			String sname = scanner.next();
			System.out.println("======ȸ�� ����Ʈ======");
			System.out.println("�̸�  �ּ�  ���� ");

			for (MemberVO_s vo : list) {
				if (vo != null) {
					if (vo.getName().equals(sname)) {
						System.out.print(vo.getName() + "\t");
						System.out.print(vo.getName() + "\t");
						System.out.println(vo.getName() + "\t");
					}
				}
			}
		}
		System.out.println("==================");
	}
}// class
