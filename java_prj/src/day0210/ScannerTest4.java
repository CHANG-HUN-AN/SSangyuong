package day0210;

import java.util.Scanner;

/**
 *커피 주문: 아메리카노 , 라떼 ,모카 , 프라푸치노
 * @author user
 */
public class ScannerTest4 {
	public static final String AMERICANO="아메";
	public static final String LATEE="라뗴는 말이여";
	public static final String MOCA="모카";
	public static final String PRAPOCHINO="프라푸치노";
	public static void main(String[] args) {
		// 커피 메뉴 출력
		Scanner scanner = new Scanner(System.in);
		System.out.println("********************menu**********************");
		System.out.println("1.아메리카노 , 2 라떼, 3 모카 4 ,프라푸치노");
		System.out.println("************************************************");
		boolean flag =true;
		String choiceMenu ="";
		while(flag) {
			System.out.println("메뉴 (번호)주문해주세요>");
			int coffee = scanner.nextInt();
			switch (coffee) {
			case 1:
				choiceMenu =AMERICANO;flag =false;break;
			case 2:
				choiceMenu =LATEE;flag =false;break;
			case 3:
				choiceMenu =MOCA;flag =false;break;
			case 4:
				choiceMenu =PRAPOCHINO;flag =false;break;
			default:
				System.out.println("잘못된 선택입니다");
			}//end case
			if(choiceMenu!="") {
				System.out.println(choiceMenu);
			}//end if
		}//end while
	}//end main
}//end class
