package day0204;

public class UsePrint{	//print();와 println(); 의 차이
	public static void main(String[] args){
		System.out.println("안녕 자바.");
		System.out.println("o(^^o)(p^^)p");
		
		//상수출력
		System.out.println(2020); //정수상수
		System.out.println(2.3); //실수상수
		System.out.println('j');//문자상수 홑따옴표는 문자 한개만
		System.out.println(true); //불린함수 t/f 가능
		System.out.println("문자열입니다");//긴 문자 메세지가 가능하다.
		
		//변수출력 :변수가 가지고 있는 값을 출력합니다.
		int i=32;
		System.out.println(i);

		//객체출력 : 객체의 주소가 출력됩니다.
		UsePrint up = new UsePrint();
		System.out.println(up);
		
		//연산식 : 연산된 결과값이 출력됩니다.
		System.out.println(2+3);
		
		//문자열과 값을 결합하여(+) 출력을 할것입니다. 결과값은 23 
		//문자열의 더하기연산자를 사용하면 연산이 아닌 붙임의 의미를 가진다.
		System.out.println("2+3="+(2+3));
		System.out.println("--------------------------");

	}
}