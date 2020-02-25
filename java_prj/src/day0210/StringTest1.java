package day0210;

/**
 *일반형 String 과 참조형 String 의 차이
 * @author user
 */
public class StringTest1 {
	public static void main(String[] args) {
		String str = "안녕하세요";
		String str2 = new String("안녕하세요");
		System.out.println(str);
		System.out.println(str2);
		
		System.out.println(str==str2);
		System.out.println(str2.equals(str));
	}//end main
}
