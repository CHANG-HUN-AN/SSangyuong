package day0207;

/**
 * switch ~ case:��ġ�� ������ ���Ҷ� ,���ڿ��� �񱳰���<br>
 * switch(������){<br>
 * 		case: ��� [break]<br>
 * 		case: ���<br>
 * 		[default: ���๮��]<br>
 * [  ] �� �ɼ��� �ǹ� �ᵵ�ǰ� �Ƚᵵ�ǰ�<br>
 * }
 * @author user
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		int temp = 4 ;
		switch(temp) {
			case 0:System.out.println("���� 0�̴�");break;
			case 1:System.out.println("���� 1�̴�");break;
			case 2:System.out.println("���� 2�̴�");break;
			case 3:System.out.println("���� 3�̴�");break;
			default:System.out.println("�̵�����x");
		}//end switch
		
		char flag='a';
		switch(flag) {
		//case�� ����� switch�� ������ ���������� �������� ���� �Ҽ� �ִ�.
		case 0: System.out.println("0");break;
		case 97: System.out.println("1");break;
		case 2: System.out.println("2");break;
		default : System.out.println("x");
		}//end switch
		
		//jdk.1.7���� �̻� ���ڿ� �񱳰��� (�� jdk 13.0...)
		String temp1 = "����";
		switch(temp1) {
		case "�ȳ�": System.out.println("�ȳ��Ͻÿ�");break;
		case "�ڹ�": System.out.println("�ڹ��Ͻÿ�");break;
		case "���": System.out.println("����Դϴ�");break;
		default : System.out.println("���غ�");
		}//end switch
	}//end main

}//end class
