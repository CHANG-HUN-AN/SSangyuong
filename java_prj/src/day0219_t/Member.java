package day0219_t;

import java.util.Scanner;

public class Member {
	//Field
	//Constructor
	public Member() {}
	public Member(String name) { System.out.println(name + "고객 입장!!");}
	
	//Method
	public MemberVO input(Scanner scan) {
		MemberVO vo = new MemberVO();
		
		System.out.print("이름>");
		vo.setName(scan.next());
		System.out.print("주소>");
		vo.setAddr(scan.next());
		System.out.print("나이>");
		vo.setAge(scan.next());
		
		return vo;
	}
}












