package day0204;
/**
��������ȯ:(������ ��������) ����or���;

*/
public class  Casting{
	public static void main(String[] args) {
			byte b1 = 0;
			byte b2 = 20;
			byte res = (byte)(b1 + b2);
			System.out.println(b1+" + "+b2+"= "+res);
			

			//ĳ���ýǼ��� ����� �Ǽ� �ΰ��� ������ ����?
			//����� ������ �ؿ��� ���ͷ��� ���ΰ��̰� �������� ���ͷ��� �׳ɵΰ� �Ҵ�� ũ�⸦ ���ΰ�
			float f = (float)2.04;
			float f2 = 2.04F;
			System.out.println("float"+"= "+f+" "+f2);
			
			//******************��������ȯ ���ս��� �߻��ϴ°��*******************************
			int i = (int)f; //�Ҽ����� �������ϴ� �Ҽ��������� ���� ���߸���
			System.out.println("int"+"= "+i);

			//double ���� ���ս� �߻�  �ݿø���

			char c = 'A';
			System.out.println(c+"="+(int)c+1);
			
			//boolean �� ĳ������ ���� �ʴ´�.
			boolean a = true; //�ٸ������� ���� ��ȯ�� ���� �ʴ´�.
			System.out.println((boolean)b1);
	}//main
}//class
