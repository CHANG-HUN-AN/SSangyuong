package day0225_t;

import java.util.ArrayList;

public class CoffeeMachine {
	//Field - 전역변수(Global Variable)
	private int money =0;
	int choiceMenuPrice = 0;
	String menu="";
	
	public static final String[] menuList 
			= {"아메리카노","밀크커피","아이스아메리카노","우유"};
	public static final int[] menuPrice = {500,300,700,400};
	String[] choiceMenu = new String[menuList.length];
	
	//Constructor
	//Method
	/**
	 * 메뉴 리스트 출력
	 */
	public static void showMenu() {
		System.out.println("********* 자판기 메뉴 리스트 **********");
		for(int i=0;i<menuList.length;i++) {
			System.out.print(menuList[i]+"-"+menuPrice[i]+"원\n");
		}
		System.out.println("***************************************");
	}	
	
	/**
	 * 고객이 넣은 동전 체크
	 * @param money
	 */
	public boolean check(int money) {
		boolean result = false;
		
		this.money = money;
		int count = 0;
		for(int i=0;i<menuPrice.length;i++) {
			if(money >= menuPrice[i] ) {
				choiceMenu[count] = menuList[i];
				count++;
			}
		}			
		
		//쉼표로 분리하여 출력메뉴 생성
		ArrayList<String> cMenu = new ArrayList<String>();
		for(String str : choiceMenu ) {
			if(str != null) {
				cMenu.add(str);
			}
		}
	
		if(count == 0) {
			System.out.println("금액이 부족합니다.");
		}else {	
			System.out.println("선택 가능한 메뉴 : " + String.join(",",cMenu));	
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 고객이 선택한 메뉴의 음료 제조
	 * @param menu
	 */
	public void make(String menu) {
		this.menu = menu;
		
		//선택한 메뉴 가격 choiceMenuPrice에 넣기
		for(int i=0;i<menuList.length;i++) {
			if(menuList[i].equals(menu)) {
				choiceMenuPrice = menuPrice[i];
				i = menuList.length;
			}
		}		
		//음료 만들기		
		System.out.println(menu + " 음료를 제조중입니다");
	}
	
	/**
	 * 잔돈 계산
	 * @return
	 */
	public int change_cal() {
		//고객이 입력한 돈 - 선택한 메뉴의 값을 뺀다
		int change = money - choiceMenuPrice;
		
		return change;
	}
	
	/**
	 * 음료 및 잔돈 전달
	 * @return 
	 */
	public void response() {
		//음료 전달		
		System.out.println("주문하신 "+menu + "와 "+ change_cal() + "원 입니다.");
	}
	
}//class


















