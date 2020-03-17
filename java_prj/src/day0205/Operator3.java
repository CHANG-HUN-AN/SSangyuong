package day0205;
/**
	shift 연산자
	<<,>>,>>>(unsigned right shift
	<<:비트를 왼쪽으로 밀고 밀은값은 0으로 채움 밀린값은 자바의경우 다시돌아옴
	>>:비트를 오른쪽으로 밀고 밀은값은 부호에따라 0(1)로 채운다 밀린값은 쓰레기값
	>>>:비트를 오른쪽으로 밀지만 부호가 없다 그래서 0으로 채운다 (음수를 표현하지 않는다)
*/
public class Operator3 {
	public static void main(String[] args) 	{
	int i = 9;
	System.out.println(i+" << 4 = " + (i << 4));	
	
	 i =27;
	System.out.println(i+" >> 3  = " + (i >> 3));	
	
	 i = 100;
	System.out.println(i+" >>> 2 = " + (i >>> 2));	
	
	i = 1;
	System.out.println(i+" >> 1 = " + (i >> 32));
	
	i = 1;
	System.out.println(i+" >> 1 = " + (i >>> 32));
	
	
	}//main
}//class


