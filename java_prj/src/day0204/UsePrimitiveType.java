package day0204;
/**
	기본형데이터형의 사용
	정수:byte,short,int,long
	문자:char
	실수:float,double
	불린:boolean
	//한줄에 80자 이상 쓰는것을 권장 한다.
*/

public class  UsePrimitiveType{
	public static void main(String[] args) {
		//음수에서 양수까지 저장할수있다 .{이것을 singed value 라함}
		//양수만 저장하는 값은{unsigned value}
		byte b = -128; //리터럴 4byte (byte 와 short 는 자동형변환이되어 자동축소 )
		short s = 20;
		int i =10;

		//리터럴의 문제 4byte가 넘어가는 경우/아닌경우
		long d = 2147483647; //long 형은 literal 이 4byte이내라면 형명시를 생략할수 있다
		long f = 2147483648l; //넣을값이 4byte이상인경우 형명시 L(l)을 {대소문자 구분x}뒤에 적어주어야 한다
		
		//.의 뒤와  +연산기호의 뒤에서 띄어쓰기 가능
		System.
			out.
			println("byte:"+
			b);
		System.out.println("short:"+s);
		System.out.println("int:"+i);
		System.out.println("long:"+d+"\n"+"long:"+f);

		//문자형
		//char 형에는 Unicode의 값이 할당{즉 실제로는 숫자가 들어가있다는 소리지
		//unicode에 해당하는 숫자값을 넣어주어도 출력값은 문자가 나온다}
		//영어 대문자 A -65 a-97 0 -48
		//char g= -1;	//음수는 저장하지 못한다.{unsigned value}
		char h= 44032; //unicode 가형 
		char c = 48;
		System.out.println("char:"+" "+"char:"+h+" "+"char:"+c);


		//실수형
		float z = 3.14f;  //형명시 필수 실수형 리터럴 8byte float 크기는 4byte로 넣을 값이 더크다 {축소필요}
		double dou = 3.14d; //형명시 생략가능
		System.out.println("float:"+z+" "+"double:"+dou);

		//boolean 형
		boolean boo = true;
		boolean boon  = false;
		System.out.println("boolean:"+boo+" "+"boolean:"+boon);

		//**************************자동형변환**********************************************
		byte b1=10;
		byte b2 = 20;
		byte result = (byte)(b1+b2);
		System.out.println("result:"+result);
	}//main	
}//class




