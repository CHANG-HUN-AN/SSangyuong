package MemberPrj;

import java.util.Scanner;

public class Member {
	MemberVO vo =null;
	Scanner scanner = new Scanner(System.in);
	
	public MemberVO input() {
		vo = new MemberVO();
		
		System.out.println("���̵��Է�");
		vo.setId(scanner.next());
		System.out.println("��й�ȣ�Է�");
		vo.setPassword(scanner.next());
		System.out.println("�̸��Է�");
		vo.setName(scanner.next());
		System.out.println("��������Է�");
		vo.setBrith(scanner.next());
		System.out.println("�����Է�");
		vo.setSex(scanner.next());
		System.out.println("�̸����Է�");
		vo.setEmail(scanner.next());
		System.out.println("�޴�����ȣ�Է�");
		vo.setPhone(scanner.next());
		return vo;
	}//Input
}//class
