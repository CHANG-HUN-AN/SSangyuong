package day0210;

public class CastingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 =10;
		int i1 = b1; //4byte ¥�� ����ȯ��(byte->int)�ڵ�����ȯ
		
		int i2 = 987654;
		byte b2 = (byte)i2; //���� ����ȯ�� �����Ͱ� ���ǵɼ��� ����
		
		System.out.println(b1);
		System.out.println(i1);
		
		System.out.println(b2);//�����Ͱ� ���ǵ�
		System.out.println(i2);
	}//end main

}//end class
