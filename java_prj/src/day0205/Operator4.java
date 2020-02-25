package day0205;
/**
	관계연산자
	>, < , >= , <= , == , !=
*/
public class Operator4 {
	public static void main(String[] args) 	{
		//연산자의 우선순위에따라 산술연산이 먼저 일어나서 String 형이 된다 String 형은 boolean형을 사용하는 관계연산자에 쓸수없다
		//== > 두개의 값이 같을경우 t / 다르면 f
		System.out.println( "== "+ (10 == 10));
		System.out.println( "== "+ (12 == 7));
		System.out.println();
		//!= > 두개의 값이 다를경우 t / 같으면 t
		
		System.out.println( "!= "+ (10 != 10));
		System.out.println( "!= "+ (12 != 7));
	}//main
}//class

