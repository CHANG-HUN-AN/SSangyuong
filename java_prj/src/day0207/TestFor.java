package day0207;

/**
 * for��:�����ڰ� ó���� ���� �˶� ����� ���� <br>
 * for(�ʱⰪ;���ǽ�;������){<br>
 * ���๮<br>
 * }<br>
 * 
 * @author user
 */
public class TestFor {

	public static void main(String[] args) {
//		for (int i = 1; i < 101; i += 2) {
//			System.out.println(i + "�ȳ��ϼ���?");
//		} // END FOR
//
//		for (int i = 1; i < 101; i++) {
//			if (i % 2 == 0)
//				System.out.println(i + "�ȳ��ϼ���?");
//		} // END FOR
//
//		// 1~100���� �Ʒ��� ���� ���
//		// 1 2 ¦ ! 4 5 ¦! 7 8 ¦!10 11 ¦!(���ڸ������̳� ¦���������̳�)
//		// �����ϳ��̱⿡ if~else����
//		for (int i = 1; i < 101; i++) {
//			if (i % 3 == 0) {
//				System.out.print("¦! ");
//			} else {
//				System.out.print(i + " ");
//			} // end else
//		} // END FOR
//		System.out.println("");
//		// 1���� 100������ �������� ��� 1+2+3+4....=5050;
//		int sum = 0;
//		for (int i = 1; i < 101; i++) {
//			sum = sum + i;
//		} // END FOR
//		System.out.println(sum);
//		// review: �������� i�� ��� ��������� �������� �������� �Ű澲�� ����
//
//		// 1~9���� ����ض�
//		for (int i = 1; i < 10; i++) {
//			System.out.println("2 * " + i + "= " + i * 2 + " ");
//		} // end for
//
//		// ���� args �Է¹޾� �������� ����Ͻÿ�(��,�������� 2~9�ܱ���)
//		int dan = Integer.parseInt(args[0]);
//		if (dan > 1 && dan < 10) {
//			for (int i = 1; i < 10; i++) {
//				System.out.println(dan + "*" + i + "= " + dan * i + " ");
//			} // end for
//		} else {
//			System.out.println("�������� 2~9�ܱ����Դϴ�");
//		} // end else
//		
//		//�빮�� A~Z ���� ����϶�
//		for(char c = 65; c <91;c++) {
//			System.out.print(c+" ");
//		}//Z91 a98 0 48

		// 0���� ���� 65535 �ݺ���Ű�鼭 ���� 0 ~ 9 ,������ �ҹ��� ����, ������ �빮�� ���� ���
		for (char i = 0; i < 65536; i++) {
			if ((i > 47 && i < 58) || (i > 64 && i < 91) || (i > 96 && i < 123)) {
				System.out.print(i + " ");
			} // end for
		} // end for
	}// End main

}// End main
