package day0212;

/**
 * 2������ �迭�� ���� ��������(3*3)�� �밢�� ���ڿ� ���������ְ�
 * �밢������ �հ� ���
 * @author user
 */
public class MultiArrayTest {

	public static void main(String[] args) {
		//1) 2���� �迭����
		//2) ������ ����
		//3)	�밢�� ������ �� ���ϱ�
		int [][] bingo = new int [3][3];
//		int count =0;
		int sum =0;//�������� �� count������� �Ѵ�.
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(i==j) {
					bingo[i][j] = (int) (Math.random() * 10);
					sum += bingo[i][j];
				}//if
				System.out.print("bingo["+i+"]["+j+"] : "+bingo[i][j]+"\t");
			}//inner for
			System.out.println();
//			count++;
		}//outer for \t 6ĭ���� 
		System.out.println("\t\t\t\t    �밢�������� ���� = "+sum);
	}//main

}//class
