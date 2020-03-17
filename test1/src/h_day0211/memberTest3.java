package h_day0211;

import java.util.Scanner;

/**
 * 회원관리 프로그램 3번째로 만드는 프로그램 이름 주소를 입력받아 저장을 한다
 * 
 * @author user
 */
public class memberTest3 {

	public static void main(String[] args) {
//		String[][] memberlist = new String[10][3];
		String[][] memberlist = new String[2][];// 가변배열이 메모리공간 효율이 좋다.

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int count = 0;

		while (flag) {
			System.out.println("**********menu************");
			System.out.println("==종료(0)>\t==");
			System.out.println("==회원 등록 (1) > ==");
			System.out.println("==회원 리스트 (2) > ==");
			System.out.println("==회원 검색(3) >== ");
			System.out.println("***************************");
			System.out.print("메뉴 입력>\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				if (count == memberlist.length) {
					System.out.println("회원 등록을 초과할수 없습니다 .\n최대 등록수 :" + count);
				} else {
					for (int i = 0; i < memberlist.length; i++) {
						System.out.print("이름입력>");
						String name = scanner.next();
						System.out.print("주소입력>");
						String address = scanner.next();
						System.out.print("나이입력>");
						String age = scanner.next();

						if (count == 0) {// 초기등록
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
						} else {// 추가등록
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
						System.out.print("등록을 계속 입력 하시겠습니까? y/n>");
						String exit = scanner.next();
						if (exit == "n" || exit.equals("n")) {
							System.out.println("회원등록을 종료합니다.");
							i = memberlist.length;
						} else {
							if (count == memberlist.length) {
								System.out.println("회원 등록을 초과할수 없습니다 .\n최대 등록수 :" + count);
								i = memberlist.length;
							} // if
						} // if~else
					} // end outer for
				} // end if~else
			} else if (menu == 2) {// 회원 검색
				if (memberlist[0] == null) {
					System.out.println("등록된 회원이 없습니다 \n회원등록을 해주세요.\n");
				} else {
					// 회원리스트 출력
					System.out.println("----------------------------------------------------------");
					System.out.println("번호\t\t이름\t\t주소\t\t나이");
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
				System.out.println("종료합니다");
				flag = false;
			} else if (menu == 3) { // 회원 검색
				if (memberlist[0] == null) {
					System.out.println("등록된 회원이 없습니다 \n회원등록을 해주세요.\n");
				} else {
					System.out.println("찾으실 회원 이름을 적어주세요>");
					String sname = scanner.next();
					int index = 10; // 없는 회원 검색

					// 회원리스트 출력

					for (int i = 0; i < memberlist.length; i++) {
						if (memberlist[i] == null) { // 등록된 회원이 가변변수여서 뒤에값 null은 짜른다
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
						System.out.println("존재하지 않는 회원입니다.");
					} else {//검색된 회원 출력
						System.out.println("----------------------------------------------------------");
						System.out.println("번호\t\t이름\t\t주소\t\t나이");
						System.out.print(index);
						for (int k = 0; k < memberlist[index].length; k++) {
							System.out.print("\t\t" + memberlist[index][k]);
						} // end inner for
						System.out.println("\n----------------------------------------------------------");
					} // end if~else
				} // end if~else
			} else {
				System.out.println("없는 메뉴입니다.");
			} // end else~if
		} // end while
		System.out.println("회원관리프로그램 종료..");
	}// end main
}// end class
