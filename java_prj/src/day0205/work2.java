package day0205;
/**
	���� 2. ���̸� main method�� arguments�� �Է¹޾Ƽ� �¾ �ظ� ����ϼ���.
     ��� :   �Է� ���� xx��  xxxx���

*/
public class work2 {
	public static final int year = 2020;
	public static void main(String[] args) 	{
	 int myYear=Integer.parseInt(args[0]);
	 
	int	result = year -myYear +1;

	System.out.println("�Է� ���� " +result + "�� "+ myYear+"���");
	}//main
}//class