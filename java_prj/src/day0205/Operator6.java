package day0205;
/**
	����(����) ������
	���ǽ�?��1[true] :��2[false]

*/
public class Operator6 {
	public static void main(String[] args) 	{
	//���׿�����
	int i = -10;
	
	System.out.println(i+" ��(��)" + (i>=0?"�罴����":"��������"));

	int year = 2020;
	int brith = 1994;

	int result = (year-brith+1);
	System.out.println("���� ��(��)" + (result >= 20?"����":"�̼���") + result);
	}//main
}//class
