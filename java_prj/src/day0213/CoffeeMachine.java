package day0213;

import java.util.ArrayList;

public class CoffeeMachine {
	// Filed

//	public static final String ICEAMERICANO = "아이스아메리카노";
//	// static 누구든 접근이가능하다 객체생성 필요없음;
//	// final 어떤누구든 수정이되면 안된다.
//	public static final String MILKCOFFEE = "밀크커피";
//	public static final String AMERICANO = "아메리카노";
//	public static final String MILK = "우유";
//
	//2.18 생성자를 통하여 상수값으로 받은 메뉴리스트를 생성자 정의시 호출

	public  void CoffeeMachine() {
		this.showMenu();
	}
	/**
	 *메뉴 리스트 출력 
	 */
	//2.18 showMenu대체로 생성자를 통하여 호출함
	public static void showMenu() {
		System.out.println("==메뉴리스트==");
		for (int i = 0; i < menuList.length; i++) {
			System.out.println(menuList[i]+" 금액: "+menuList_Price[i]);
		}
		System.out.println("===========");
	}
//	public static final int ICEAMERICANO_PRICE = 500;
//	public static final int MILKCOFFEE_PRICE = 300;
//	public static final int AMERICANO_PRICE = 700;
//	public static final int MILK_PRICE = 400;

	// 상수 형태를 배열로 간단하게 만드는 작업;
	// 전역변수(Filed)
	private int money;
	public static final String[] menuList = { "아이스아메리카노", "밀크커피", "아메리카노", "우유" };
	public static final int[] menuList_Price = { 500, 300, 700, 400 };

	String[] choiceMenu = new String[menuList.length];
	int choiceMenuPrice = 0;
	private String menu="";

	// Constructer
	// Method
	

	
	/**
	 * Person의 돈을 받아 메뉴 선택범위를 알려준다. 
	 * @return
	 */
	public boolean check(int money) {
		boolean check=false;
		this.money = money;
//		String choicemenu = "";

//		if (money >= ICEAMERICANO_PRICE)
//			choicemenu += ICEAMERICANO + ", ";
//		if (money >= MILKCOFFEE_PRICE)
//			choicemenu += MILKCOFFEE + ", ";
//		if (money >= AMERICANO_PRICE)
//			choicemenu += AMERICANO + ", ";
//		if (money >= MILK_PRICE)
//			choicemenu += MILK + ", " + "";
//		// multi if
		int count = 0;
		for (int i = 0; i < menuList.length; i++) {
			if (money >= menuList_Price[i]) {
				choiceMenu[count] = menuList[i];
				count++;
			}
		} // for

		// 구분기호
		ArrayList<String> cMenu = new ArrayList<String>();
		for (String str : choiceMenu) {
			if (str != null) {
				cMenu.add(str);
			} // if
		} // for 
		
		//메뉴선택표시
		System.out.println("==>2.자판기 :동전을 체크한다. \n");
		if(count==0) {
			System.out.println("금액이 부족합니다.");
		}else {
		// String.join(",", cMenu);
		System.out.print("=======선택할 수있는 메뉴======= \n "
								+ String.join(",", cMenu)+"\n");// charSequence타입으로 출력됨
		check = true;
		}//if~else
		return check;
	}// end method_check()

	public void make(String menu) {
		// 선택한 메뉴가격 choiceMenuPrice에 넣기
		this.menu = menu;
		
		for (int i = 0; i < menuList.length; i++) {
			if (menuList[i].equals(menu)) {
				choiceMenuPrice = menuList_Price[i];
				i = menuList_Price.length;
			}
		} // for
		// 음료 생성
		System.out.println("==>4.자판기 : "+menu + "음료를 만든다");
	}// end method_make()

	public int change_cal() {
		// 고객이 입력한 돈 - 선택한 메뉴의 값을 잔돈계산
		int charge = money - choiceMenuPrice;
		return charge;
	}// end method_change_cal()

	public void response() {
		// 음료 전달
		System.out.println("==>5.자판기 : 음료를 전달한다. ");
		System.out.println(menu+" 와 잔돈 " + change_cal() + " 전달합니다");
	}// end method_response()

}// class
