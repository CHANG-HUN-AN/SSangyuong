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

			System.out.println("더입력하시겠습니까(y/n)?>>  ");
			String exit = scanner.next();
			if (exit.equals("y") && count == list.length) {
				System.out.println("저장범위를 초과하였습니다.");
			} else if (exit.equals("y")) {
				flag = true;
			}
		}
		return flag;
	}

	public void Menu() {
		System.out.println("**********menu************");
		System.out.println("==종료(0)>\t==");
		System.out.println("==회원 등록 (1) > ==");
		System.out.println("==회원 리스트 (2) > ==");
		System.out.println("==회원 검색(3) >== ");
		System.out.println("***************************");
	}

	public int menuchoice() {
		System.out.println("메뉴입력 >>");
		int menu = scanner.nextInt();
		return menu;
	}

	public void ShowRegisterList() {
		System.out.println("======회원 리스트======");
		System.out.println("이름  주소  성별 ");
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
			System.out.println("회원등록이 필요합니다.");
		} else {
			System.out.println("찾으실 회원 입력>>");
			String sname = scanner.next();
			System.out.println("======회원 리스트======");
			System.out.println("이름  주소  성별 ");

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
