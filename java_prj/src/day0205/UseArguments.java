package day0205;
/**
main method �� �ܺ� �� �Է�
*/
public class UseArguments {
	public static void main(String[] args) 	{
	System.out.println(args[0]);
	System.out.println(args[1]);
	System.out.println(args[2]);
	//string ���̶� ������ ���� �ʴ´�
	System.out.println(args[1]+args[2]);
	//int  i = (int) args[1]; //������ ��������(String)�� �⺻��(int)�� ���� �� �� ����.
	//��������ȯ �ɼ� ����.
	
	//wrapper class �� ����ϸ� ���ڿ��� �⺻�������������� �߶� ��ȯ�Ҽ� �ִ�.
	int i = Integer.parseInt(args[1]);
	int j = Integer.parseInt(args[2]);
	System.out.println(i+j);
	
	double d = Double.parseDouble(args[3]);
	System.out.println(d);

	}//main
}//class
