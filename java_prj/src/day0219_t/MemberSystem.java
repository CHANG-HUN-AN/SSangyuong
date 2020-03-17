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
	String[] namelist = {"ȫ�浿","����"};
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
		System.out.println("** ȸ����� : 1��  **");
		System.out.println("** ȸ������Ʈ : 2��  **");
		System.out.println("** ȸ���˻� : 3��  **");
		System.out.println("** ȸ������ : 4��  **");
		System.out.println("** ���� : 0��  **");
		System.out.println("**********************");		
	}
	
	public void choiceMenu() {
		System.out.print("�޴��� �������ּ���(��ȣ)>");		
		switch(scan.nextInt()) {
			case 1 :  register(); break;
			case 2 :  list(); break;
			case 3 :  search(); break;
			case 4 : remove();break;
			case 0 :  exit(); break;
			default :  System.out.println("�غ��� �Դϴ�."); break;
		}
	}
	
	public void choiceMenu(Member member) {
		System.out.print("�޴��� �������ּ���(��ȣ)>");		
		switch(scan.nextInt()) {
			case 1 :  register(member); break;
			case 2 :  list(member); break;
			case 3 :  search(); break;
			case 0 :  exit(); break;
			default :  System.out.println("�غ��� �Դϴ�."); break;
		}
	}
	
	public void register() {
		//if(count <memberList.length) {
			//memberList[count] = new Member(namelist[count]).input(scan);
			memberList.add(new Member().input(scan));
			System.out.println("��� �Ϸ�~");		
			//count++;
			
			System.out.print("��� �����ұ��(y/n)?>");
			String check = scan.next();
			if(check.equals("y")) {
				register();
			}
			
//			if(check.equals("y") && count == memberList.length) {
//				System.out.println("���� ���� ����~");
//			}else if(check.equals("y")) {
//				register();
//			}
//		}else {
//			System.out.println("���� ���� ����~");
//		}		
		choiceMenu();
	}
	
	public void register(Member member) {
		this.vo = member.input(scan);		
		System.out.println("���");
		choiceMenu(member);
	}
	
	public void list() {		
		if(memberList.isEmpty()) {
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			System.out.println("---------------------------------------");
			System.out.println("��ȣ\t�̸�\t�ּ�\t����");
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
		System.out.println("��ȣ\t�̸�\t�ּ�\t����");
		System.out.println("---------------------------------------");
		System.out.print("1\t"+vo.getName()+"\t");
		System.out.print(vo.getAddr()+"\t");
		System.out.print(vo.getAge()+"\n");
		System.out.println("---------------------------------------");
		choiceMenu(member);
	}
	
	public void search() {
		if(memberList.isEmpty()) {
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			System.out.print("�˻�>");	
			String name = scan.next();
			MemberVO svo = null;

			for(MemberVO vo : memberList) {
				if(vo.getName().equals(name)) svo = vo;		
			}

			if(svo != null) {
				System.out.println("---------------------------------------");
				System.out.println("�̸�\t�ּ�\t����");
				System.out.println("---------------------------------------");	
				System.out.print(svo.getName() + "\t");
				System.out.print(svo.getAddr()+"\t");
				System.out.print(svo.getAge()+"\n");
				System.out.println("---------------------------------------");
			}else {
				System.out.println("�˻��� �����Ͱ� �����ϴ�.");
			}
		}
		choiceMenu();
	}
	//arraylist �� ������ ������ 1���ǵ����͸� �����ְ� ������û�� �����߻�
	//2���ǵ����� ���޾� ������
	//������ ���������� �����ʹ� ������ �����ִ�>>db�����̶� Ʈ����ǽô� �����߻��ȵ�
	public void remove() {
		if(memberList.isEmpty()) {
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
		}else {
			System.out.println("����>> ");
			String name = scan.next();

			//		for(MemberVO vo : memberList) {
			//			if(vo.getName().equals(name)) {
			//				memberList.remove(vo);
			//			}
			//		}
			ListIterator<MemberVO>iterator = memberList.listIterator(); //����� ��� ����
			while(iterator.hasNext()) {
				MemberVO vo = iterator.next();
				if(vo.getName().equals(name)) {
					iterator.remove();
				}
			}
			System.out.println("�����Ϸ�");
		}
		choiceMenu();
	}

	public void exit() {
		System.out.println("����");
		System.exit(0);
	}
}



















