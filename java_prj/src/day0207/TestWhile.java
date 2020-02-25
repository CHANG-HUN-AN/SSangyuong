package day0207;

/**
 *while : 시작과 끝을 잘 모를때 사용하는 반복문
 *주로 클래스의 메소드랑 사용하지만 지금은 배우지않아 
 *for문형식으로 써보겠다.
 * @author user
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
		//while을 사용하여 구구단 5단을 출력해보라
		 i =1;
		while(i<10) {
			System.out.println(" 5 * "+i+"="+i*5);
			i++;
		}
		
	}//end main
}//end class
