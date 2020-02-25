package day0220;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class LottoSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	String[] menuList= {"수동","자동","번호확인","당첨확인","종료"};
	ArrayList<Integer> myLotto = new ArrayList<Integer>();
	ArrayList<Integer> winLotto = new ArrayList<Integer>() ;//사이즌는 자동생성이라 별의미 없다.
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
//		System.out.println("==\t\t수동(1)\t\t==");
//		System.out.println("==\t\t자동(2)\t\t==");
//		System.out.println("==\t\t확인(3)\t\t==");
//		System.out.println("==\t\t당첨번호생성(4)\t\t==");
//		System.out.println("==\t\t당첨번호추첨(5)\t\t==");
//		System.out.println("==\t\t종료(0)\t\t==");
		for(int i = 0 ;i<menuList.length;i++) {
			System.out.println((i+1)+"번 "+menuList[i]);
		}
		System.out.println("---------------------------------");
	}
	public void choiceMenu() {
		System.out.print("메뉴를 입력(번호)해주세요 > \t");
		
		switch(scan.nextInt()) {
		case 1:manual();break;
		case 2:auto();break;
		case 3:check();break;
		case 4:winning();break;
		case 5:exit();break;
		default:System.out.println("메뉴준비중");
		}
	}//choiceMenu
	
	public void exit() {
		System.out.println("종료");
		System.exit(0);
		choiceMenu();
	}
	
	public void manual() {
		if (myLotto.size() < 6) {
			boolean flag = true;
			while (flag) {
				System.out.println("번호입력");
				int number = scan.nextInt();

				if (number > 0 && number < 46) {
					myLotto.add(number);
					System.out.println(myLotto.size());
		
					// lotooTest()옛날 로또생성프로그램처럼 하면 arraylist의 성질에의해 취소됨
					if (myLotto.size() == 6) {
						System.out.println("===번호 입력 종료");
						flag = false;
					}else {
						System.out.println("더 입력 하시겠습니까?y/n>> ");
						if(!scan.next().equals("y")) {
							flag =false;
						}
					}
				}
			} 
		}else {
				System.out.println("이미 입력이 완료되었습니다.");
		}
		choiceMenu();
		}//	Manual


	public void auto() {
//		Math.random()*45
//		Random().nextInt(45) + 1;
		int size= 6-myLotto.size();
		for (int i = 0; i < size; i++) { //tip 반복문 같은 조건식에 계산이 들어가면 그때그때 많은 계산을하여 정확한 값이 나오기 힘들다.
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
		//기존에 생성된 winLotto데이터 삭제후 new값 받아오기
		//winLotto = new ArrayList<Integer>();
		ListIterator<Integer> it = winLotto.listIterator();
	
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		
		System.out.println("win size================>"+ winLotto.size());
		System.out.println("당첨번호 생성");
		for (int i = 0; i < myLotto.size(); i++) {
			winLotto.add(new Random().nextInt(45+1));
			System.out.print(winLotto.get(i)+" ");
		}
		System.out.println();
		System.out.print("당첨 번호: ");
		int wincount=0;
		for(int no : myLotto) {
			if(winLotto.contains(no)) { //no에있는 숫자 10을 winlotto전부와비교
				System.out.print( no+" ");
				wincount++;
			}
		}//for
		
		System.out.println("당첨 갯수: "+wincount);
		winLotto.clear();
		choiceMenu();
	}// winning
}//class
