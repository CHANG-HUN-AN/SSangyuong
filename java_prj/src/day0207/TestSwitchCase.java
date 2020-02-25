package day0207;

/**
 * switch ~ case:일치할 정수를 비교할때 ,문자열도 비교가능<br>
 * switch(변수명){<br>
 * 		case: 상수 [break]<br>
 * 		case: 상수<br>
 * 		[default: 실행문장]<br>
 * [  ] 는 옵션을 의미 써도되고 안써도되고<br>
 * }
 * @author user
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		int temp = 4 ;
		switch(temp) {
			case 0:System.out.println("값은 0이다");break;
			case 1:System.out.println("값은 1이다");break;
			case 2:System.out.println("값은 2이다");break;
			case 3:System.out.println("값은 3이다");break;
			default:System.out.println("이도저도x");
		}//end switch
		
		char flag='a';
		switch(flag) {
		//case의 상수는 switch의 변수의 데이터형의 범위까지 정의 할수 있다.
		case 0: System.out.println("0");break;
		case 97: System.out.println("1");break;
		case 2: System.out.println("2");break;
		default : System.out.println("x");
		}//end switch
		
		//jdk.1.7버전 이상 문자열 비교가능 (현 jdk 13.0...)
		String temp1 = "ㄴㄴ";
		switch(temp1) {
		case "안녕": System.out.println("안녕하시오");break;
		case "자바": System.out.println("자바하시오");break;
		case "언어": System.out.println("언어입니다");break;
		default : System.out.println("노준비");
		}//end switch
	}//end main

}//end class
