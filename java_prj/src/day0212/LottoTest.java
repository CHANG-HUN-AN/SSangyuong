package day0212;

import java.util.Random;
import java.util.Scanner;

/**
 * 복권 시스템 만들기 1)수동 2)자동 3)확인 4)번호 추첨 5)당첨확인 0)종료
 * 
 * @author user
 */
public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] mylotto = null;
		int[] winLotto = null;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);

		boolean p_flag = true; // 수동 카운터
		int p_count = 0;
		int num = 1;// 로또 번호 갯수
		boolean check = false;
		boolean winCheck = false;
		int sum = 0;

//		int[] winTemp = new int[6]; 개인적으로 sort할라고 했던거
		System.out.println("---------------Lotto-------------");
		System.out.println("==\t\t수동(1)\t\t==");
		System.out.println("==\t\t자동(2)\t\t==");
		System.out.println("==\t\t확인(3)\t\t==");
		System.out.println("==\t\t당첨번호생성(4)\t\t==");
		System.out.println("==\t\t당첨번호추첨(5)\t\t==");
		System.out.println("==\t\t종료(0)\t\t==");
		System.out.println("---------------------------------");
		System.out.print("메뉴를 입력(번호)해주세요 > \t");
		while (flag) {
			
			int menu = scanner.nextInt();
			System.out.println();
			p_flag = true;
			
			if (menu == 0) {// 종료
				System.out.println("종료하시겠습니까? y/n");
				String exit = scanner.next();
				if (exit.equals("y")) {
					flag = false;
				} // if
			} else if (menu == 1) {// 수동
				mylotto = new int[6];
				check = true;
				// 6자리 입력받기 ,단 범위는 1~45
				while (p_flag) {

					System.out.print(num + "번의 로또 를 입력하시오(1~45) > \t");

					int tempLotto = scanner.nextInt();
					if (tempLotto > 0 && tempLotto < 46) {// 번호저장
						mylotto[p_count] = tempLotto;
						p_count++;
						num++;

						// 입력종료
						if (p_count == mylotto.length) {
							System.out.println("6개 번호입력 완료");
							p_flag = false;
						} // if
					} else {
						System.out.println("1~45사이의 번호에 들어가지 않습니다\n다시 입력해주세요.");
					} // if~else
				} // while
			} else if (menu == 2) {// 자동
				mylotto = new int[6];
				check = true;
				for (int i = 0; i < mylotto.length; i++) {
					mylotto[i] = new Random().nextInt(45) + 1;
				} // for
				System.out.println("=======번호 생성=========\n");
			} else if (menu == 3) {// 번호 출력
				if (check) {
					System.out.println("-----------번호 확인--------------");
					for (int i = 0; i < mylotto.length; i++) {
						System.out.print(mylotto[i] + "\t");
					}
					System.out.println("\n---------------------------------\n");
				} else {
					System.out.println("*!수동 또는 자동 번호 생성 선택!*");
				}
			} else if (menu == 4) {// 당첨 번호 출력
				winLotto = new int[6];
				winCheck = true;
				System.out.println("-----------당첨 번호 확인--------------");
				for (int i = 0; i < winLotto.length; i++) {
					winLotto[i] = new Random().nextInt(45) + 1;
					System.out.print(winLotto[i] + "\t");
				}
				System.out.println("\n---------------------------------\n");
//				for(int i = 0; i< winNumber.length;i++) {
//					if(winNumber[i]>winNumber[i+1]) {//정렬
//						
//					}
//				}
			} else if (menu == 5) {// 당첨 확인
			if(check&&winCheck) {
				for (int i = 0; i < mylotto.length; i++) {
					for (int j = 0; j < winLotto.length; j++) {
						if (mylotto[i] == winLotto[j]) {
							System.out.println("당첨번호= "+ mylotto[i]);
							sum++;
							j=winLotto.length;
						} // if
					} // inner for
				} // end for
				switch (sum) {
				case 0:
					System.out.println("당첨된게 없습니다");
					break;
				case 1:
					System.out.println("1개맞음(당첨된게 없습니다)");
					break;
				case 2:
					System.out.println("2개맞음(당첨된게 없습니다)");
					break;
				case 3:
					System.out.println("3개맞음(4등)");
					break;
				case 4:
					System.out.println("4개맞음(3등)");
					break;
				case 5:
					System.out.println("5개맞음 (2등)");
					break;
				case 6:
					System.out.println("전부 맞음 (1등)");
					break;
				default:
					System.out.println("당첨오류!\n 중복숫자생성,당첨갯수 초과");
				}//end switch
			}else {
				System.out.println("*!번호생성 오류*\"");
			}
			} else {
				System.out.println("메뉴에 없는 선택입니다 ");
				System.out.println("다시선택하세요\n");
			} // end multi~if
		} // end while
		System.out.println("종료 되었습니다.");
	}// main

}// class
