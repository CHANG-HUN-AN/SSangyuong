package h_day0211;

import java.util.Scanner;

/**
 * 회원관리 프로그램
 * 3번째로 만드는 프로그램
 * 이름 주소를 입력받아 저장을 한다
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
			System.out.println("==종료(0)>\t==");
			System.out.println("==회원 등록 (1) > ==");
			System.out.println("==회원 리스트 (2) > ==");
			System.out.println("==회원 검색(3) >== ");
			System.out.println("***************************");
			System.out.print("메뉴 입력>\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				for (int i = 0; i < memberlist.length; i++) {
					for (int j = 0; j < memberlist[i].length; j++) {
						System.out.print("이름입력>");
						memberlist[i][j] = scanner.next();
						System.out.print("주소입력>");
						memberlist[i][j+1] = scanner.next();
						System.out.print("나이입력>");
						memberlist[i][j+2] = scanner.next();
						j=memberlist.length;
						}
						System.out.print("등록을 계속 입력 하시겠습니까? y/n>");
						String exit = scanner.next();
						if (exit == "n" || exit.equals("n")) {
							System.out.println("회원등록을 종료합니다.");
							i = memberlist.length;
						} // end if
				} // end  m for
				flag = true;
			} else if (menu == 2) {
				if (memberlist[0][0]== null) {
					System.out.println("등록된 회원이 없습니다 \n회원등록을 해주세요.");
				} else {
					System.out.println("----------------------------------------------------------");
					System.out.println("번호\t\t이름[나이]\t\t주소");
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
				System.out.println("종료합니다");
				flag = false;
			} else if(menu==3){
				if (memberlist[0]== null) {
					System.out.println("등록된 회원이 없습니다 \n회원등록을 해주세요.");
				} else {
					System.out.println("----------------------------------------------------------");
					System.out.println("번호\t\t이름[나이]\t\t주소");
					for (int i = 0; i < memberlist.length; i++) {
						for (int j = 0; j < memberlist[i].length; j++) {
							if (memberlist[i][j] == null) {
								j = memberlist[i].length;
								i = memberlist.length;
							} else {
								System.out.println("----------------------------------------------------------");
								System.out.println("번호\t\t이름[나이]\t\t주소");
								System.out.println((i+1) + "\t\t" + memberlist[i][j] + "[" + memberlist[i][j+1] + "] " + "\t\t" + memberlist[i][j+2]);
								System.out.println("----------------------------------------------------------");
							} // end if~else
						}//end inner for
					} // end outer for
				}//end if~else
			} else {
				System.out.println("없는 메뉴입니다.");
			} // end else~if
		} // end while
		
		System.out.println("회원관리프로그램 종료..");
	}// end main
}// end class
