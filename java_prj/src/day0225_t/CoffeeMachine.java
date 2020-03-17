package day0225_t;

import java.util.ArrayList;

public class CoffeeMachine {
	//Field - ��������(Global Variable)
	private int money =0;
	int choiceMenuPrice = 0;
	String menu="";
	
	public static final String[] menuList 
			= {"�Ƹ޸�ī��","��ũĿ��","���̽��Ƹ޸�ī��","����"};
	public static final int[] menuPrice = {500,300,700,400};
	String[] choiceMenu = new String[menuList.length];
	
	//Constructor
	//Method
	/**
	 * �޴� ����Ʈ ���
	 */
	public static void showMenu() {
		System.out.println("********* ���Ǳ� �޴� ����Ʈ **********");
		for(int i=0;i<menuList.length;i++) {
			System.out.print(menuList[i]+"-"+menuPrice[i]+"��\n");
		}
		System.out.println("***************************************");
	}	
	
	/**
	 * ���� ���� ���� üũ
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
		
		//��ǥ�� �и��Ͽ� ��¸޴� ����
		ArrayList<String> cMenu = new ArrayList<String>();
		for(String str : choiceMenu ) {
			if(str != null) {
				cMenu.add(str);
			}
		}
	
		if(count == 0) {
			System.out.println("�ݾ��� �����մϴ�.");
		}else {	
			System.out.println("���� ������ �޴� : " + String.join(",",cMenu));	
			result = true;
		}
		
		return result;
	}
	
	/**
	 * ���� ������ �޴��� ���� ����
	 * @param menu
	 */
	public void make(String menu) {
		this.menu = menu;
		
		//������ �޴� ���� choiceMenuPrice�� �ֱ�
		for(int i=0;i<menuList.length;i++) {
			if(menuList[i].equals(menu)) {
				choiceMenuPrice = menuPrice[i];
				i = menuList.length;
			}
		}		
		//���� �����		
		System.out.println(menu + " ���Ḧ �������Դϴ�");
	}
	
	/**
	 * �ܵ� ���
	 * @return
	 */
	public int change_cal() {
		//���� �Է��� �� - ������ �޴��� ���� ����
		int change = money - choiceMenuPrice;
		
		return change;
	}
	
	/**
	 * ���� �� �ܵ� ����
	 * @return 
	 */
	public void response() {
		//���� ����		
		System.out.println("�ֹ��Ͻ� "+menu + "�� "+ change_cal() + "�� �Դϴ�.");
	}
	
}//class


















