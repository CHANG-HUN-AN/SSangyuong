package day0213;

import java.util.ArrayList;

public class CoffeeMachine {
	// Filed

//	public static final String ICEAMERICANO = "���̽��Ƹ޸�ī��";
//	// static ������ �����̰����ϴ� ��ü���� �ʿ����;
//	// final ������� �����̵Ǹ� �ȵȴ�.
//	public static final String MILKCOFFEE = "��ũĿ��";
//	public static final String AMERICANO = "�Ƹ޸�ī��";
//	public static final String MILK = "����";
//
	//2.18 �����ڸ� ���Ͽ� ��������� ���� �޴�����Ʈ�� ������ ���ǽ� ȣ��

	public  void CoffeeMachine() {
		this.showMenu();
	}
	/**
	 *�޴� ����Ʈ ��� 
	 */
	//2.18 showMenu��ü�� �����ڸ� ���Ͽ� ȣ����
	public static void showMenu() {
		System.out.println("==�޴�����Ʈ==");
		for (int i = 0; i < menuList.length; i++) {
			System.out.println(menuList[i]+" �ݾ�: "+menuList_Price[i]);
		}
		System.out.println("===========");
	}
//	public static final int ICEAMERICANO_PRICE = 500;
//	public static final int MILKCOFFEE_PRICE = 300;
//	public static final int AMERICANO_PRICE = 700;
//	public static final int MILK_PRICE = 400;

	// ��� ���¸� �迭�� �����ϰ� ����� �۾�;
	// ��������(Filed)
	private int money;
	public static final String[] menuList = { "���̽��Ƹ޸�ī��", "��ũĿ��", "�Ƹ޸�ī��", "����" };
	public static final int[] menuList_Price = { 500, 300, 700, 400 };

	String[] choiceMenu = new String[menuList.length];
	int choiceMenuPrice = 0;
	private String menu="";

	// Constructer
	// Method
	

	
	/**
	 * Person�� ���� �޾� �޴� ���ù����� �˷��ش�. 
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

		// ���б�ȣ
		ArrayList<String> cMenu = new ArrayList<String>();
		for (String str : choiceMenu) {
			if (str != null) {
				cMenu.add(str);
			} // if
		} // for 
		
		//�޴�����ǥ��
		System.out.println("==>2.���Ǳ� :������ üũ�Ѵ�. \n");
		if(count==0) {
			System.out.println("�ݾ��� �����մϴ�.");
		}else {
		// String.join(",", cMenu);
		System.out.print("=======������ ���ִ� �޴�======= \n "
								+ String.join(",", cMenu)+"\n");// charSequenceŸ������ ��µ�
		check = true;
		}//if~else
		return check;
	}// end method_check()

	public void make(String menu) {
		// ������ �޴����� choiceMenuPrice�� �ֱ�
		this.menu = menu;
		
		for (int i = 0; i < menuList.length; i++) {
			if (menuList[i].equals(menu)) {
				choiceMenuPrice = menuList_Price[i];
				i = menuList_Price.length;
			}
		} // for
		// ���� ����
		System.out.println("==>4.���Ǳ� : "+menu + "���Ḧ �����");
	}// end method_make()

	public int change_cal() {
		// ���� �Է��� �� - ������ �޴��� ���� �ܵ����
		int charge = money - choiceMenuPrice;
		return charge;
	}// end method_change_cal()

	public void response() {
		// ���� ����
		System.out.println("==>5.���Ǳ� : ���Ḧ �����Ѵ�. ");
		System.out.println(menu+" �� �ܵ� " + change_cal() + " �����մϴ�");
	}// end method_response()

}// class
