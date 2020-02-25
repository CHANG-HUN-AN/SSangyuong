package day0204;
/**
강제형변환:(변경할 데이터형) 변수or상수;

*/
public class  Casting{
	public static void main(String[] args) {
			byte b1 = 0;
			byte b2 = 20;
			byte res = (byte)(b1 + b2);
			System.out.println(b1+" + "+b2+"= "+res);
			

			//캐스팅실수와 형명시 실수 두개의 문법의 차이?
			//결과는 같지만 밑에는 리터럴을 줄인것이고 위에것은 리터럴을 그냥두고 할당시 크기를 줄인것
			float f = (float)2.04;
			float f2 = 2.04F;
			System.out.println("float"+"= "+f+" "+f2);
			
			//******************강제형변환 갑손실이 발생하는경우*******************************
			int i = (int)f; //소수점을 넣지못하니 소수점이하의 수는 다잘린다
			System.out.println("int"+"= "+i);

			//double 역시 값손실 발생  반올림됨

			char c = 'A';
			System.out.println(c+"="+(int)c+1);
			
			//boolean 은 캐스팅이 되지 않는다.
			boolean a = true; //다른형으로 강제 변환이 되지 않는다.
			System.out.println((boolean)b1);
	}//main
}//class
