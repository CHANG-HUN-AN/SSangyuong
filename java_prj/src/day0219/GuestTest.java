package day0219;

import java.util.Scanner;

public class GuestTest {
	Scanner scanner = new Scanner(System.in);
	MemberVO_s vo;

	public MemberVO_s input() {
		vo = new MemberVO_s();
		System.out.println("이름을 입력해주세요");
		vo.setName(scanner.next()); 

		System.out.println("주소을 입력해주세요");
		vo.setAddress(scanner.next()); 

		System.out.println("나이을 입력해주세요");
		vo.setAge(scanner.nextInt());
		return vo;
	}
}
