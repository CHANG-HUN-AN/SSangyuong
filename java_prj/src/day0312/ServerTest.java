package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7000); //new ServerSocket(int port); ��Ʈ��ȣ �Է� 
			System.out.println("============����������================");
			Socket s = server.accept(); //������ Ŭ���̾�Ʈ�� �ޱ����� ����� server.accept() ->return Socket
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			//1.����:Ŭ���̾�Ʈ�� ȯ���޼��� ����
			dos.writeUTF("ȯ���մϴ�~~~");
			System.out.println("1.���� :�޼�������");
			//4.����:Ŭ���̾�Ʈ �޼��� ����
			System.out.println("4.Ŭ���̾�Ʈ:"+dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
