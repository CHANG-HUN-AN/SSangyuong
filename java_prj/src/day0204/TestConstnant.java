package day0204;
/**
	�ٸ� Ŭ������ �����ϴ� Constant ��� �ϴ�Ŭ����

*/

public class  TestConstnant{
	public static void main(String[] args) {
		System.out.print(Constant.MAX_SCORE);
		System.out.println("byte �� �ּҰ�: " + Byte.MIN_VALUE+
							",Byte�� �ִ밪:" + Byte.MAX_VALUE);
		//����
		int i = 10;
		int j = 017;
		int k = 0xf1;
		System.out.print(k+"="+(i+j+k));

		int  t= 48;
		System.out.println("="+Integer.toBinaryString(t));
	}
}
