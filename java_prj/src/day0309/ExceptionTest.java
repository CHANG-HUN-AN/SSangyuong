package day0309;

import java.io.IOException;
import java.net.ServerSocket;

public class ExceptionTest {

	/**
	 * Runtime Exception �߻� �� ó�� 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] nameList = new String[3];
		nameList[0]="ȫ�浿";
		nameList[1]="ȫ�浿1";
		nameList[2]="ȫ�浿2";
		try {
			ServerSocket server = new ServerSocket(9000);
			for (int i = 0; i < 5; i++) {
				System.out.println(nameList[i]);
			}
		}catch (Exception e) { //->�ʹ���� �ֻ��� ��ü�� Exception���� �������� �ִ�.
			// TODO: handle exception
			System.out.println("����ó�� �Ϸ�~");
		}finally {
			System.out.println("finally");
			//try~catch �� �ݵ�� ����
		}
		

	}

}
