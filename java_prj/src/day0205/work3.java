package day0205;
/**
	����3. arguments�� �Է¹޾� �Է¹��� ���� "Ȧ��"���� "¦��"������ ����ϼ���.
     ��� :   �Է� �� : xx Ȧ��       
*/
public class work3 {
	public static void main(String[] args) 	{
	int i = Integer.parseInt(args[0]);
	System.out.println("�Է� �� : " + (i%2 == 0?"¦��":"Ȧ��"));
	}//main
}//class