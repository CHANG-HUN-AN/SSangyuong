package day0204;
/**
Constant ������ ���ó�� ����ʹ�.
Constnatn �� ���ذ��̴�.
*/
public class Constant {
	//Constant ����
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;

	public static void main(String[] args) {
//����� ���� �����Ҽ��ִ� ������� MAX)SCORE)=
		System.out.println("�ְ�����: " + MAX_SCORE);
		System.out.println("��������: " + Constant.MIN_SCORE);

		int myScore= 93;
		System.out.println("�ְ�����:" + Constant.MAX_SCORE+",�ְ������� ȹ�������� ��: "+ (Constant.MAX_SCORE - myScore));
		
	}
}
