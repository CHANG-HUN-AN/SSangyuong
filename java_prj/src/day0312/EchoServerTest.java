package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *2.Echo System �ǽ�
 *Ŭ���̾�Ʈ�� �������� Echo�Ѵ� �޾Ƹ� ���� �������� ������ ���ƿ�����
 * @author user
 */
public class EchoServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("=========���� ����============");
			ServerSocket server = new ServerSocket(7000);
			Socket s= server.accept();
			System.out.println("================Ŭ���̾�Ʈ ���ӿϷ�==========");
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
//			//2.Ŭ���̾�Ʈ���� �Ѿ�� ������ ����
//			String data = dis.readUTF();
//			//3.Ŭ���̾�Ʈ�����͸� �޾Ƽ� �ٽ� Ŭ���̾�Ʈ���� ����
//			dos.writeUTF(data);
			//2.3 Ŭ���̾�Ʈ������ ������ �۽�
			dos.writeUTF(dis.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
