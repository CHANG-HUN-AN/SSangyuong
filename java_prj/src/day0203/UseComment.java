package day0203;
/**
Java API Document 주석 :클래스의 설명
*/

public class UseComment{	
	/**
	Java Application 을 만들기 위한 메인 메소드 입니다.
	*/
	int a=2;
	public static void main(String[] args){
		int age=0;//초기화된 지역변수의 선언...... 나이를 저장하기위한 변수
		age = 25;// 현재 나이를 할당했습니다.
		age++; //내년의 나이를 계산하기위해서 쓴 증가연산자
		System.out.println(age);
		/* 여러줄의 코드실행을 한번에 묶어서 막을때
		System.out.println(++age);
		System.out.println(++age);
		System.out.println(++age);
		*/
	}//main

}//Class
