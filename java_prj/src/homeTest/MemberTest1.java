package homeTest;

import java.util.Scanner;

/**
 * 회원 관리 프로그램 복습
 * 
 * @author dksck
 */
public class MemberTest1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] namelist = new String[2];
		String[] addrlist = new String[2];
		int[] agelist= new int[2];
		
		boolean flag =true;
		boolean menuFlag_1 =true;
		
		int index = 0;
		int searchIndex =0;
		int addCount=0;
		while(flag) {

			System.out.println("--------------------");
			System.out.println("---------종료 0--------");
			System.out.println("---------회원 등록 1--------");
			System.out.println("---------회원 리스트 2--------");
			System.out.println("---------회원 검색 3--------");
			System.out.println("--------------------");

			System.out.println("메뉴 선택 >\t");
			int menu = scanner.nextInt();

			if (menu == 1) {
				System.out.println("회원을 등록 하시 겠습니까?> y/n \t");
				String menu1_1 = scanner.next();

				if (menu1_1.equals("y")) {
					menuFlag_1=true;
					while(menuFlag_1) {
						System.out.println("몇명의 회원을 등록하시겠습니까?>>");
						int member_1 = scanner.nextInt();
						
						if (member_1 > 0) {//회원 등록
							if(addCount<namelist.length) { //회원수 초과시 
								if(addCount==0) {
									for (int i = 0; i < member_1; i++) {
										System.out.print("이름입력>\t");
										namelist[i] = scanner.next();
										System.out.print("주소입력>\t");
										addrlist[i] = scanner.next();
										System.out.print("나이입력>\t");
										agelist[i] = scanner.nextInt();
										System.out.println("=======");
										addCount ++;
									}//for
								}else {//회원 추가
									for (int i = 0; i < member_1; i++) {
										System.out.print("이름입력>\t");
										namelist[addCount] = scanner.next();
										System.out.print("주소입력>\t");
										addrlist[addCount] = scanner.next();
										System.out.print("나이입력>\t");
										agelist[addCount] = scanner.nextInt();
										System.out.println("=======");
										addCount ++;
									}//for
								}
							}else {
								System.out.println("회원수 초과! \n"+namelist.length+" 를 넘길수 없습니다.");
							}
							System.out.println("메뉴로 돌아갑니다");
							menuFlag_1 = false;
						} else {
							System.out.println("음수는 입력할수 없습니다.");
						} // if~else
					}//while
				} else {
					System.out.println("메뉴로 돌아갑니다");
				}//if~else
				
			}else if (menu == 2) {
				if(namelist[0]==null) {
					System.out.println("회원등록이 되어있지 않습니다\n등록이 필요합니다.");
				}else {
					System.out.println("---------------------------");
					System.out.println("번호\t이름\t주소\t나이");
					for (int i = 0; i < namelist.length; i++) {
						
						if(namelist[i]!=null) {
							System.out.println((index + i) + "\t" + namelist[i] + "\t" 
												+ addrlist[i] + "\t" + agelist[i]);
						}else {
							i= namelist.length;
						}//if~else
					}//for
					System.out.println("---------------------------");
				}//if~else
			}else if (menu == 3) {
				System.out.println("검색할 이름을 입력하세요");
				String searchName = scanner.next();
				String sName = new String();
				String saddr = new String();
				int age = 0;
				
				if(namelist[0]==null) {
					System.out.println("회원등록이 되어있지 않습니다\n등록이 필요합니다.");
				} else {
					System.out.println("---------------------------");
					System.out.println("번호\t이름\t주소\t나이");
					for (int i = 0; i < namelist.length; i++) {

						if (namelist[i] != null) {
							System.out.println((searchIndex) + "\t" + 
										sName + "\t" + saddr + "\t" + age);
						} else {
							i = namelist.length;
						} // if~else
					} // for
					System.out.println("---------------------------");
				}//if~else
			}else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				flag =false;
			}else {
				System.out.println("메뉴에 없는 선택입니다 \n 다시 선택해주세요.");
			}
			
			
		}//while
		
	}//main

}//class
