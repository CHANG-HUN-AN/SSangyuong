package day0219;

import java.util.Scanner;

public class GuestTest {
	Scanner scanner = new Scanner(System.in);
	MemberVO_s vo;

	public MemberVO_s input() {
		vo = new MemberVO_s();
		System.out.println("�̸��� �Է����ּ���");
		vo.setName(scanner.next()); 

		System.out.println("�ּ��� �Է����ּ���");
		vo.setAddress(scanner.next()); 

		System.out.println("������ �Է����ּ���");
		vo.setAge(scanner.nextInt());
		return vo;
	}
}
