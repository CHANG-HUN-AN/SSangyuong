package day0206;

/**
 *단일 if의 사용:조건에 맞을때에만 코드를 실행<br>
 *(html)태그 사용가능,<br>
 *문법)if(조건식){<br>
 *			조건에 맞을 때 수행할 문장....;<br>
 *		 }
 * @author user
 */
public class TestIf {

	public static void main(String[] args) {
		//입력되는 수의 절대값 구하기
		int tempNum= Integer.parseInt(args[0]);
		if(tempNum<=0) {
			tempNum = -tempNum;//위에 두개는 필수코드지만 이코드는 조건을 맞게쓸코드
		}//end if
		System.out.println(args[0]+"의절대 값은 ="+ tempNum);
		
		//입력된 수가 0~100사이 일때만 "유효점수"를 출력.
		if(tempNum>=0&& tempNum<=100) {
			System.out.println(args[0]+"는 유효점수 입니다");
		}//end if 
		
		//문자열 비교 ==(주소비교), equals(내용비교) 가 가능
		//equals 는 생성방법에 상관없이 비교가능
		//두번째 입력값이 이름을 받는데 이름이 "James Gosling"이라면
		//이름앞에 "자바의 아버지"를 출력 하고 그렇지 않다면 이름을 출력 
		
		if(args[1].equals("James_Gosling")) {
			System.out.print("자바의 아버지");
		}//end if
			System.out.println(args[1]);
			
		
	}//main

}//class
