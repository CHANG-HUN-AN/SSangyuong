package day0210;

import java.util.Scanner;

/**
 *Ŀ�� �ֹ�: �Ƹ޸�ī�� , �� ,��ī , ����Ǫġ��
 * @author user
 */
public class ScannerTest4 {
	public static final String AMERICANO="�Ƹ�";
	public static final String LATEE="���� ���̿�";
	public static final String MOCA="��ī";
	public static final String PRAPOCHINO="����Ǫġ��";
	public static void main(String[] args) {
		// Ŀ�� �޴� ���
		Scanner scanner = new Scanner(System.in);
		System.out.println("********************menu**********************");
		System.out.println("1.�Ƹ޸�ī�� , 2 ��, 3 ��ī 4 ,����Ǫġ��");
		System.out.println("************************************************");
		boolean flag =true;
		String choiceMenu ="";
		while(flag) {
			System.out.println("�޴� (��ȣ)�ֹ����ּ���>");
			int coffee = scanner.nextInt();
			switch (coffee) {
			case 1:
				choiceMenu =AMERICANO;flag =false;break;
			case 2:
				choiceMenu =LATEE;flag =false;break;
			case 3:
				choiceMenu =MOCA;flag =false;break;
			case 4:
				choiceMenu =PRAPOCHINO;flag =false;break;
			default:
				System.out.println("�߸��� �����Դϴ�");
			}//end case
			if(choiceMenu!="") {
				System.out.println(choiceMenu);
			}//end if
		}//end while
	}//end main
}//end class
