package day0205;
/**
	shift ������
	<<,>>,>>>(unsigned right shift
	<<:��Ʈ�� �������� �а� �������� 0���� ä�� �и����� �ڹ��ǰ�� �ٽõ��ƿ�
	>>:��Ʈ�� ���������� �а� �������� ��ȣ������ 0(1)�� ä��� �и����� �����Ⱚ
	>>>:��Ʈ�� ���������� ������ ��ȣ�� ���� �׷��� 0���� ä��� (������ ǥ������ �ʴ´�)
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


