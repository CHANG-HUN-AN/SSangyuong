package day0210;

/**
 *�Ϲ��� String �� ������ String �� ����
 * @author user
 */
public class StringTest1 {
	public static void main(String[] args) {
		String str = "�ȳ��ϼ���";
		String str2 = new String("�ȳ��ϼ���");
		System.out.println(str);
		System.out.println(str2);
		
		System.out.println(str==str2);
		System.out.println(str2.equals(str));
	}//end main
}
