package day0205;
/**
	���׿�����
	~, ! , +, - ,++, --
*/

public class Operator1 {
	public static void main(String[] args) 	{
		System.out.println("Hello World!");
		//~(tilde)
		int i = 10;
		int j = -10;
		System.out.println("i�� ����: ~"+i+"=" + ~i);// -11
		System.out.println("j�� ����: ~"+j+"=" + ~j);//-9

		//! (not)->*boolean �տ��� �����ִٴ°� �� �������!! ��� �տ� ��� �Ұ�
		boolean b = true, c = false;
		System.out.println("b�� ����: !"+b+"=" + !b);
		System.out.println("c�� ����: 1"+c+"=" + !c);
		System.out.println(!(3>2));

		//+:�������� ����(���� ��ȭ�� ����)
		System.out.println("i�� ����: "+i+"=" + +i);
		System.out.println("j�� ����: "+j+"=" + +j);
		
		//-:2�Ǻ��� ����,��ȣ�ٲ޿���(���� �״���̸� ��ȣ�� �ٲ�� Operator)
		System.out.println("i�� ����: "+i+"=" + -i);
		System.out.println("j�� ����: "+j+"=" + -j);

		//++ : ���� ������ (���ü�� ���� 1�� �����Ѵ�)
		//-- : ���� ������ (���ü�� ���� 1�� �����Ѵ�)
		i = 0;
		j = 10;

		//���� : �����ڴ� ���ü �տ� �´�
		++i;
		--j;
		System.out.println("���� i�� ����: " + i);
		System.out.println("���� j�� ����: " + j);

		//���� : �����ڴ� ���ü �ڿ� �´�.
		i++;
		j--;
		System.out.println("���� i�� ����: " + i);
		System.out.println("���� j�� ����: " + j);
		
		//���������ڴ� �ܵ����� ���϶��� ����x , ���Կ����ڿ� ���� ���Ǹ� ��,������ �ٸ����� �����Ѵ�
		//����: (�������)���͸��� (��, ��������� ����)
		int result = ++i;
		System.out.println("���� i�� ����: " + i +", ���Թ��� result�� ��: "+result);
		//����: ���ǰ� ����(��, ������ ������ ����)
		result = 0;
		result = i++;
		System.out.println("���� i�� ����: " + i +", ���Թ��� result�� ��: "+result);
		int  k = ++10; //����� ���� ����x

	}//main
}//class
