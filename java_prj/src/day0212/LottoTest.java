package day0212;

import java.util.Random;
import java.util.Scanner;

/**
 * ���� �ý��� ����� 1)���� 2)�ڵ� 3)Ȯ�� 4)��ȣ ��÷ 5)��÷Ȯ�� 0)����
 * 
 * @author user
 */
public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] mylotto = null;
		int[] winLotto = null;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);

		boolean p_flag = true; // ���� ī����
		int p_count = 0;
		int num = 1;// �ζ� ��ȣ ����
		boolean check = false;
		boolean winCheck = false;
		int sum = 0;

//		int[] winTemp = new int[6]; ���������� sort�Ҷ�� �ߴ���
		System.out.println("---------------Lotto-------------");
		System.out.println("==\t\t����(1)\t\t==");
		System.out.println("==\t\t�ڵ�(2)\t\t==");
		System.out.println("==\t\tȮ��(3)\t\t==");
		System.out.println("==\t\t��÷��ȣ����(4)\t\t==");
		System.out.println("==\t\t��÷��ȣ��÷(5)\t\t==");
		System.out.println("==\t\t����(0)\t\t==");
		System.out.println("---------------------------------");
		System.out.print("�޴��� �Է�(��ȣ)���ּ��� > \t");
		while (flag) {
			
			int menu = scanner.nextInt();
			System.out.println();
			p_flag = true;
			
			if (menu == 0) {// ����
				System.out.println("�����Ͻðڽ��ϱ�? y/n");
				String exit = scanner.next();
				if (exit.equals("y")) {
					flag = false;
				} // if
			} else if (menu == 1) {// ����
				mylotto = new int[6];
				check = true;
				// 6�ڸ� �Է¹ޱ� ,�� ������ 1~45
				while (p_flag) {

					System.out.print(num + "���� �ζ� �� �Է��Ͻÿ�(1~45) > \t");

					int tempLotto = scanner.nextInt();
					if (tempLotto > 0 && tempLotto < 46) {// ��ȣ����
						mylotto[p_count] = tempLotto;
						p_count++;
						num++;

						// �Է�����
						if (p_count == mylotto.length) {
							System.out.println("6�� ��ȣ�Է� �Ϸ�");
							p_flag = false;
						} // if
					} else {
						System.out.println("1~45������ ��ȣ�� ���� �ʽ��ϴ�\n�ٽ� �Է����ּ���.");
					} // if~else
				} // while
			} else if (menu == 2) {// �ڵ�
				mylotto = new int[6];
				check = true;
				for (int i = 0; i < mylotto.length; i++) {
					mylotto[i] = new Random().nextInt(45) + 1;
				} // for
				System.out.println("=======��ȣ ����=========\n");
			} else if (menu == 3) {// ��ȣ ���
				if (check) {
					System.out.println("-----------��ȣ Ȯ��--------------");
					for (int i = 0; i < mylotto.length; i++) {
						System.out.print(mylotto[i] + "\t");
					}
					System.out.println("\n---------------------------------\n");
				} else {
					System.out.println("*!���� �Ǵ� �ڵ� ��ȣ ���� ����!*");
				}
			} else if (menu == 4) {// ��÷ ��ȣ ���
				winLotto = new int[6];
				winCheck = true;
				System.out.println("-----------��÷ ��ȣ Ȯ��--------------");
				for (int i = 0; i < winLotto.length; i++) {
					winLotto[i] = new Random().nextInt(45) + 1;
					System.out.print(winLotto[i] + "\t");
				}
				System.out.println("\n---------------------------------\n");
//				for(int i = 0; i< winNumber.length;i++) {
//					if(winNumber[i]>winNumber[i+1]) {//����
//						
//					}
//				}
			} else if (menu == 5) {// ��÷ Ȯ��
			if(check&&winCheck) {
				for (int i = 0; i < mylotto.length; i++) {
					for (int j = 0; j < winLotto.length; j++) {
						if (mylotto[i] == winLotto[j]) {
							System.out.println("��÷��ȣ= "+ mylotto[i]);
							sum++;
							j=winLotto.length;
						} // if
					} // inner for
				} // end for
				switch (sum) {
				case 0:
					System.out.println("��÷�Ȱ� �����ϴ�");
					break;
				case 1:
					System.out.println("1������(��÷�Ȱ� �����ϴ�)");
					break;
				case 2:
					System.out.println("2������(��÷�Ȱ� �����ϴ�)");
					break;
				case 3:
					System.out.println("3������(4��)");
					break;
				case 4:
					System.out.println("4������(3��)");
					break;
				case 5:
					System.out.println("5������ (2��)");
					break;
				case 6:
					System.out.println("���� ���� (1��)");
					break;
				default:
					System.out.println("��÷����!\n �ߺ����ڻ���,��÷���� �ʰ�");
				}//end switch
			}else {
				System.out.println("*!��ȣ���� ����*\"");
			}
			} else {
				System.out.println("�޴��� ���� �����Դϴ� ");
				System.out.println("�ٽü����ϼ���\n");
			} // end multi~if
		} // end while
		System.out.println("���� �Ǿ����ϴ�.");
	}// main

}// class
