package day0309;

import java.util.StringTokenizer;

/**
 *  Runtime Exception �߻� �� ó�� 2 ->NullPointerException �ǰ��
 *  ��Ģ: try~catch ������ ������ ����
 *  ����: try~catch�ε� ������ �ִ� ��찡 �ֱ�� ������ �ǹ̰� ����.
 * @author user
 */
public class ExceptionTest2 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("�ڹ� ���� �Դϴ�."); //[��ǻ�� ����] ���� �м� �̶�� ���� ������ �ִ�
		int tokens = st.countTokens();
		System.out.println(tokens);
		System.out.println("����ó�� �Ϸ�");
	}

}
