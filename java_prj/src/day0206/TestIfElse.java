package day0206;

/**
 * if~else ���: ���� �ϳ��� �ڵ带 �ݵ�� ����ؾ� �Ҷ�<br>
 * ����)if (���ǽ�){<br>
 * ���ǿ� ������ ������ ����<br>
 * }else{<br>
 * ���ǿ� ���������� ������ ����<br>
 * }<br>
 * 
 * @author user
 */
public class TestIfElse {

	public static void main(String[] args) {
		// �Էµ� ���� Ȧ������ ¦������ ����ϴ�method
		int i = Integer.parseInt(args[0]);
		System.out.print(i + "��(��) ");

		if (i % 2 == 0) {
			System.out.println("¦���Դϴ�");
		} else {
			System.out.println("Ȧ���Դϴ�");
		} // end else

		/*
		 * //�Է¹��� ���� 0~100���̶�� "��ȿ����" �� ����ϰ� 
		 * //������ "����" ������ �Ǵ��Ͽ� ������ ����Ѵ�.
		 * //�׷���������"��ȿ ����"�� ����Ѵ�
		 */
		
		System.out.print("�Է¹��� �� " + i + "��(��) ");
		if (i >-1 && i < 101) { //ũ�ų� ���ٴ� �ѹ��� 2���� ��� ->�� 5������ //�ٲ۰������ϸ� 3���������γ�(�����ڵ�)
			System.out.println(" ��ȿ����");
			if (i < 40) {
				System.out.println("������ ����");
			} // end if
		} else {
			System.out.println("��ȿ����");
		} // end else
		
		/*
		 * �ι�° �Է°��� �� ����Դϴ�. ����° �Է°��� ��ǰ�����Դϴ�. 
		 * ������� "�Ϲ�","Ư��"�ΰ�쿡�� "�Ϲ�"�� ��ǰ���� 10%����
		 * "Ư��"�� ��ǰ������ 30%���� �Ͽ�, �Ʒ��Ͱ��� ��� 
		 * ����� "�Ϲ�|Ư��" ��ǰ����: XXX�� ���ΰ��� XX�� �Դϴ�.
		 * ������� �Ϲݰ� Ư���� �ƴ϶�� "�߸��Է��ϼ̽��ϴ�."�� ����մϴ�
		 */
		int price = Integer.parseInt(args[2]);
		
		if(args[1].equals("�Ϲ�")||args[1].equals("Ư��")) {
			int discount = (int)(price*0.9);
			if(args[1].equals("Ư��")) {
				 discount = (int)(price*0.7);
			}//end if
				System.out.println("����� \""+args[1]+"\" ��ǰ���� :"+price+",���ΰ��� :"+discount+"�� �Դϴ�.");
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}//end else
	}// main

}// class
