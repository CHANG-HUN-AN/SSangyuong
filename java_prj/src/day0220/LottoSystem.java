package day0220;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class LottoSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	String[] menuList= {"����","�ڵ�","��ȣȮ��","��÷Ȯ��","����"};
	ArrayList<Integer> myLotto = new ArrayList<Integer>();
	ArrayList<Integer> winLotto = new ArrayList<Integer>() ;//������� �ڵ������̶� ���ǹ� ����.
	int count;
	//Constructor
	//Method
	public LottoSystem() {
		showMenu();
		choiceMenu();
	}
	public void showMenu() {
		System.out.println("------------------------------------");
		System.out.println("---------------Lotto---------------");
//		System.out.println("==\t\t����(1)\t\t==");
//		System.out.println("==\t\t�ڵ�(2)\t\t==");
//		System.out.println("==\t\tȮ��(3)\t\t==");
//		System.out.println("==\t\t��÷��ȣ����(4)\t\t==");
//		System.out.println("==\t\t��÷��ȣ��÷(5)\t\t==");
//		System.out.println("==\t\t����(0)\t\t==");
		for(int i = 0 ;i<menuList.length;i++) {
			System.out.println((i+1)+"�� "+menuList[i]);
		}
		System.out.println("---------------------------------");
	}
	public void choiceMenu() {
		System.out.print("�޴��� �Է�(��ȣ)���ּ��� > \t");
		
		switch(scan.nextInt()) {
		case 1:manual();break;
		case 2:auto();break;
		case 3:check();break;
		case 4:winning();break;
		case 5:exit();break;
		default:System.out.println("�޴��غ���");
		}
	}//choiceMenu
	
	public void exit() {
		System.out.println("����");
		System.exit(0);
		choiceMenu();
	}
	
	public void manual() {
		if (myLotto.size() < 6) {
			boolean flag = true;
			while (flag) {
				System.out.println("��ȣ�Է�");
				int number = scan.nextInt();

				if (number > 0 && number < 46) {
					myLotto.add(number);
					System.out.println(myLotto.size());
		
					// lotooTest()���� �ζǻ������α׷�ó�� �ϸ� arraylist�� ���������� ��ҵ�
					if (myLotto.size() == 6) {
						System.out.println("===��ȣ �Է� ����");
						flag = false;
					}else {
						System.out.println("�� �Է� �Ͻðڽ��ϱ�?y/n>> ");
						if(!scan.next().equals("y")) {
							flag =false;
						}
					}
				}
			} 
		}else {
				System.out.println("�̹� �Է��� �Ϸ�Ǿ����ϴ�.");
		}
		choiceMenu();
		}//	Manual


	public void auto() {
//		Math.random()*45
//		Random().nextInt(45) + 1;
		int size= 6-myLotto.size();
		for (int i = 0; i < size; i++) { //tip �ݺ��� ���� ���ǽĿ� ����� ���� �׶��׶� ���� ������Ͽ� ��Ȯ�� ���� ������ �����.
			myLotto.add(new Random().nextInt(45)+1);
		}
//		for(int no : myLotto) {
//			System.out.print(no+"\t");
//		}
//		System.out.println();
//
		check();
		choiceMenu();
	}
	
	public void check() {
		for(int temp : myLotto) {
			System.out.print(temp+" ");
		}
		System.out.println();
		choiceMenu();
	}
	
	public void winning() {
		//������ ������ winLotto������ ������ new�� �޾ƿ���
		//winLotto = new ArrayList<Integer>();
		ListIterator<Integer> it = winLotto.listIterator();
	
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		
		System.out.println("win size================>"+ winLotto.size());
		System.out.println("��÷��ȣ ����");
		for (int i = 0; i < myLotto.size(); i++) {
			winLotto.add(new Random().nextInt(45+1));
			System.out.print(winLotto.get(i)+" ");
		}
		System.out.println();
		System.out.print("��÷ ��ȣ: ");
		int wincount=0;
		for(int no : myLotto) {
			if(winLotto.contains(no)) { //no���ִ� ���� 10�� winlotto���οͺ�
				System.out.print( no+" ");
				wincount++;
			}
		}//for
		
		System.out.println("��÷ ����: "+wincount);
		winLotto.clear();
		choiceMenu();
	}// winning
}//class
