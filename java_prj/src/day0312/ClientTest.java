package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost",7000); //�����ϰ����ϴ� ���� �ּҸ� �����ش�.
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			//2.Ŭ���̾�Ʈ: ���� �����͸� ����(�޴´�)
			System.out.println("2.Ŭ���̾�Ʈ : ���������� ����\n"+"���� : "+dis.readUTF());
			
			//3.Ŭ���̾�Ʈ: ������ ������ ����
			dos.writeUTF("�ȳ��ϼ��� �����Ծ�");
			System.out.println("3.Ŭ���̾�Ʈ : ������ ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
