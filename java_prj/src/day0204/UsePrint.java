package day0204;

public class UsePrint{	//print();�� println(); �� ����
	public static void main(String[] args){
		System.out.println("�ȳ� �ڹ�.");
		System.out.println("o(^^o)(p^^)p");
		
		//������
		System.out.println(2020); //�������
		System.out.println(2.3); //�Ǽ����
		System.out.println('j');//���ڻ�� Ȭ����ǥ�� ���� �Ѱ���
		System.out.println(true); //�Ҹ��Լ� t/f ����
		System.out.println("���ڿ��Դϴ�");//�� ���� �޼����� �����ϴ�.
		
		//������� :������ ������ �ִ� ���� ����մϴ�.
		int i=32;
		System.out.println(i);

		//��ü��� : ��ü�� �ּҰ� ��µ˴ϴ�.
		UsePrint up = new UsePrint();
		System.out.println(up);
		
		//����� : ����� ������� ��µ˴ϴ�.
		System.out.println(2+3);
		
		//���ڿ��� ���� �����Ͽ�(+) ����� �Ұ��Դϴ�. ������� 23 
		//���ڿ��� ���ϱ⿬���ڸ� ����ϸ� ������ �ƴ� ������ �ǹ̸� ������.
		System.out.println("2+3="+(2+3));
		System.out.println("--------------------------");

	}
}