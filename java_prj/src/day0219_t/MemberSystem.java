package day0219_t;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class MemberSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	MemberVO vo;
	Member member;
	String[] namelist = {"홍길동","공유"};
	int count=0;
	//MemberVO[] memberList = new MemberVO[2];
	ArrayList<MemberVO> memberList = new ArrayList<MemberVO>(2);
	
	//Constructor
	public MemberSystem() {
		showMenu();
		choiceMenu();
	}
	
	public MemberSystem(Member member) {
		this.member = member;
		showMenu();		
		choiceMenu(member);
	}
	
	//Method
	public void showMenu() {
		System.out.println("**********************");
		System.out.println("** 회원등록 : 1번  **");
		System.out.println("** 회원리스트 : 2번  **");
		System.out.println("** 회원검색 : 3번  **");
		System.out.println("** 회원삭제 : 4번  **");
		System.out.println("** 종료 : 0번  **");
		System.out.println("**********************");		
	}
	
	public void choiceMenu() {
		System.out.print("메뉴를 선택해주세요(번호)>");		
		switch(scan.nextInt()) {
			case 1 :  register(); break;
			case 2 :  list(); break;
			case 3 :  search(); break;
			case 4 : remove();break;
			case 0 :  exit(); break;
			default :  System.out.println("준비중 입니다."); break;
		}
	}
	
	public void choiceMenu(Member member) {
		System.out.print("메뉴를 선택해주세요(번호)>");		
		switch(scan.nextInt()) {
			case 1 :  register(member); break;
			case 2 :  list(member); break;
			case 3 :  search(); break;
			case 0 :  exit(); break;
			default :  System.out.println("준비중 입니다."); break;
		}
	}
	
	public void register() {
		//if(count <memberList.length) {
			//memberList[count] = new Member(namelist[count]).input(scan);
			memberList.add(new Member().input(scan));
			System.out.println("등록 완료~");		
			//count++;
			
			System.out.print("계속 진행할까요(y/n)?>");
			String check = scan.next();
			if(check.equals("y")) {
				register();
			}
			
//			if(check.equals("y") && count == memberList.length) {
//				System.out.println("저장 공간 부족~");
//			}else if(check.equals("y")) {
//				register();
//			}
//		}else {
//			System.out.println("저장 공간 부족~");
//		}		
		choiceMenu();
	}
	
	public void register(Member member) {
		this.vo = member.input(scan);		
		System.out.println("등록");
		choiceMenu(member);
	}
	
	public void list() {		
		if(memberList.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
		}else {
			System.out.println("---------------------------------------");
			System.out.println("번호\t이름\t주소\t나이");
			System.out.println("---------------------------------------");		
			int ncount = 1;
			for(MemberVO vo : memberList) {
				if(vo != null) {
					System.out.print(ncount+"\t");	
					System.out.print(vo.getName()+"\t");
					System.out.print(vo.getAddr()+"\t");
					System.out.print(vo.getAge()+"\n");
				}
				ncount++;
			}
			System.out.println("---------------------------------------");
			
		}
		choiceMenu();
	}
	
	public void list(Member member) {		
		System.out.println("---------------------------------------");
		System.out.println("번호\t이름\t주소\t나이");
		System.out.println("---------------------------------------");
		System.out.print("1\t"+vo.getName()+"\t");
		System.out.print(vo.getAddr()+"\t");
		System.out.print(vo.getAge()+"\n");
		System.out.println("---------------------------------------");
		choiceMenu(member);
	}
	
	public void search() {
		if(memberList.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
		}else {
			System.out.print("검색>");	
			String name = scan.next();
			MemberVO svo = null;

			for(MemberVO vo : memberList) {
				if(vo.getName().equals(name)) svo = vo;		
			}

			if(svo != null) {
				System.out.println("---------------------------------------");
				System.out.println("이름\t주소\t나이");
				System.out.println("---------------------------------------");	
				System.out.print(svo.getName() + "\t");
				System.out.print(svo.getAddr()+"\t");
				System.out.print(svo.getAge()+"\n");
				System.out.println("---------------------------------------");
			}else {
				System.out.println("검색된 데이터가 없습니다.");
			}
		}
		choiceMenu();
	}
	//arraylist 의 구조적 문제로 1개의데이터만 남아있고 삭제요청시 에러발생
	//2개의데이터 연달아 삭제시
	//내부의 구조적으로 데이터는 지워도 남아있다>>db연동이랑 트랜잭션시는 문제발생안됨
	public void remove() {
		if(memberList.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
		}else {
			System.out.println("삭제>> ");
			String name = scan.next();

			//		for(MemberVO vo : memberList) {
			//			if(vo.getName().equals(name)) {
			//				memberList.remove(vo);
			//			}
			//		}
			ListIterator<MemberVO>iterator = memberList.listIterator(); //저장소 모양 변경
			while(iterator.hasNext()) {
				MemberVO vo = iterator.next();
				if(vo.getName().equals(name)) {
					iterator.remove();
				}
			}
			System.out.println("삭제완료");
		}
		choiceMenu();
	}

	public void exit() {
		System.out.println("종료");
		System.exit(0);
	}
}



















