package h_day0211;

import java.util.Scanner;

/**
 * 회원관리 프로그램 3번째로 만드는 프로그램 이름 주소를 입력받아 저장을 한다
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
			System.out.println("==종료(0)>\t==");
			System.out.println("==회원 등록 (1) > ==");
			System.out.println("==회원 리스트 (2) > ==");
			System.out.println("==회원 검색(3) >== ");
			System.out.println("***************************");
			System.out.print("메뉴 입력>\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				for (int i = 0; i < ageList.length; i++) {
					System.out.print("이름입력>");
					nameList[i] = scanner.next();
					System.out.print("주소입력>");
					addList[i] = scanner.next();
					System.out.print("나이입력>");
					ageList[i] = scanner.nextInt();

					System.out.print("등록을 계속 입력 하시겠습니까? y/n>");
					String exit = scanner.next();
					if (exit == "n" || exit.equals("n")) {
						System.out.println("회원등록을 종료합니다.");
						i = ageList.length;
					} // end if
				} // end for
				flag = true;
			} else if (menu == 2) {
				if (nameList[0] == null) {
					System.out.println("등록이 필요합니다.");
				} else {
					System.out.println("----------------------------------------------------------");
					System.out.println("번호\t\t이름\t\t나이\t\t주소");
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
				System.out.println("종료합니다");
				flag = false;
			} else if (menu == 3) {
				if (nameList[0] == null) {
					System.out.println("등록된 회원이 없습니다 \n회원등록을 해주세요.");
				} else {
					System.out.println("검색할 이름을 입력해주세요");
					System.out.print("검색 >\t ");

					String sname = scanner.nextLine();
					int index = 0;
					for (int i = 0; i < nameList.length; i++) {
						if (sname.equals(nameList[i])) {
							System.out.println("검색결과 " + sname + "님이 존재합니다");
							index = i;
						} else {
							i = nameList.length;
						} // end if ~ else
					} // end for
					System.out.println("----------------------------------------------------------");
					System.out.println("번호\t\t이름\t\t주소\t\t나이");
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
				System.out.println("없는 메뉴입니다.");
			} // end else~if
		} // end while

		System.out.println("회원관리프로그램 종료..");
	}// end main
}// end class
