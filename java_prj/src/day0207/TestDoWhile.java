package day0207;

/**
 * do -while 문의 사용을 알아본다(while과 동일 method 가 많이이용) 
 * 현재 for 문처럼 사용하겠다.
 * @author user
 */
public class TestDoWhile {

	public static void main(String[] args) {
		int i =0;
		//은행의 atm기의 메뉴같은 것
		do {
		System.out.println(i);
		i++;
		}while(i<10);
		
	}//main
}//class
