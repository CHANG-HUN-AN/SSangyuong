package day0204;
/**
	�⺻������������ ���
	����:byte,short,int,long
	����:char
	�Ǽ�:float,double
	�Ҹ�:boolean
	//���ٿ� 80�� �̻� ���°��� ���� �Ѵ�.
*/

public class  UsePrimitiveType{
	public static void main(String[] args) {
		//�������� ������� �����Ҽ��ִ� .{�̰��� singed value ����}
		//����� �����ϴ� ����{unsigned value}
		byte b = -128; //���ͷ� 4byte (byte �� short �� �ڵ�����ȯ�̵Ǿ� �ڵ���� )
		short s = 20;
		int i =10;

		//���ͷ��� ���� 4byte�� �Ѿ�� ���/�ƴѰ��
		long d = 2147483647; //long ���� literal �� 4byte�̳���� ����ø� �����Ҽ� �ִ�
		long f = 2147483648l; //�������� 4byte�̻��ΰ�� ����� L(l)�� {��ҹ��� ����x}�ڿ� �����־�� �Ѵ�
		
		//.�� �ڿ�  +�����ȣ�� �ڿ��� ���� ����
		System.
			out.
			println("byte:"+
			b);
		System.out.println("short:"+s);
		System.out.println("int:"+i);
		System.out.println("long:"+d+"\n"+"long:"+f);

		//������
		//char ������ Unicode�� ���� �Ҵ�{�� �����δ� ���ڰ� ���ִٴ� �Ҹ���
		//unicode�� �ش��ϴ� ���ڰ��� �־��־ ��°��� ���ڰ� ���´�}
		//���� �빮�� A -65 a-97 0 -48
		//char g= -1;	//������ �������� ���Ѵ�.{unsigned value}
		char h= 44032; //unicode ���� 
		char c = 48;
		System.out.println("char:"+" "+"char:"+h+" "+"char:"+c);


		//�Ǽ���
		float z = 3.14f;  //����� �ʼ� �Ǽ��� ���ͷ� 8byte float ũ��� 4byte�� ���� ���� ��ũ�� {����ʿ�}
		double dou = 3.14d; //����� ��������
		System.out.println("float:"+z+" "+"double:"+dou);

		//boolean ��
		boolean boo = true;
		boolean boon  = false;
		System.out.println("boolean:"+boo+" "+"boolean:"+boon);

		//**************************�ڵ�����ȯ**********************************************
		byte b1=10;
		byte b2 = 20;
		byte result = (byte)(b1+b2);
		System.out.println("result:"+result);
	}//main	
}//class




