package day0204;
/**
	다른 클래스에 존재하는 Constant 사용 하는클래스

*/

public class  TestConstnant{
	public static void main(String[] args) {
		System.out.print(Constant.MAX_SCORE);
		System.out.println("byte 의 최소값: " + Byte.MIN_VALUE+
							",Byte의 최대값:" + Byte.MAX_VALUE);
		//진수
		int i = 10;
		int j = 017;
		int k = 0xf1;
		System.out.print(k+"="+(i+j+k));

		int  t= 48;
		System.out.println("="+Integer.toBinaryString(t));
	}
}
