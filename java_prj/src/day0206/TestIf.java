package day0206;

/**
 *���� if�� ���:���ǿ� ���������� �ڵ带 ����<br>
 *(html)�±� ��밡��,<br>
 *����)if(���ǽ�){<br>
 *			���ǿ� ���� �� ������ ����....;<br>
 *		 }
 * @author user
 */
public class TestIf {

	public static void main(String[] args) {
		//�ԷµǴ� ���� ���밪 ���ϱ�
		int tempNum= Integer.parseInt(args[0]);
		if(tempNum<=0) {
			tempNum = -tempNum;//���� �ΰ��� �ʼ��ڵ����� ���ڵ�� ������ �°Ծ��ڵ�
		}//end if
		System.out.println(args[0]+"������ ���� ="+ tempNum);
		
		//�Էµ� ���� 0~100���� �϶��� "��ȿ����"�� ���.
		if(tempNum>=0&& tempNum<=100) {
			System.out.println(args[0]+"�� ��ȿ���� �Դϴ�");
		}//end if 
		
		//���ڿ� �� ==(�ּҺ�), equals(�����) �� ����
		//equals �� ��������� ������� �񱳰���
		//�ι�° �Է°��� �̸��� �޴µ� �̸��� "James Gosling"�̶��
		//�̸��տ� "�ڹ��� �ƹ���"�� ��� �ϰ� �׷��� �ʴٸ� �̸��� ��� 
		
		if(args[1].equals("James_Gosling")) {
			System.out.print("�ڹ��� �ƹ���");
		}//end if
			System.out.println(args[1]);
			
		
	}//main

}//class
