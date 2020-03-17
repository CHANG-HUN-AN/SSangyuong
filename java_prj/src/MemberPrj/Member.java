package MemberPrj;

import java.util.Scanner;

public class Member {
	MemberVO vo =null;
	Scanner scanner = new Scanner(System.in);
	
	public MemberVO input() {
		vo = new MemberVO();
		
		System.out.println("아이디입력");
		vo.setId(scanner.next());
		System.out.println("비밀번호입력");
		vo.setPassword(scanner.next());
		System.out.println("이름입력");
		vo.setName(scanner.next());
		System.out.println("생년월일입력");
		vo.setBrith(scanner.next());
		System.out.println("성별입력");
		vo.setSex(scanner.next());
		System.out.println("이메일입력");
		vo.setEmail(scanner.next());
		System.out.println("휴대폰번호입력");
		vo.setPhone(scanner.next());
		return vo;
	}//Input
}//class
