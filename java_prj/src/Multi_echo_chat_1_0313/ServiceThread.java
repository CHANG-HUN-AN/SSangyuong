package Multi_echo_chat_1_0313;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * ��Ƽ ����ä���� ���� 
 * �������� accept�� �ޱ����� ������� ������ Ŭ����
 * @author user
 */
public class ServiceThread extends Thread{
	// Field
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	//Constructor
	public ServiceThread() {
	}

	public ServiceThread(Socket socket) { 
		try {
			System.out.println("----->ServiceThread ����");
			this.socket = socket;
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	public void run() { 
			boolean flag = true;
			try {
				while (flag) {
					// 2.����
					String str = dis.readUTF(); // SocketException - > Ŭ���̾�Ʈ���� ���� x �޴��ʿ��� socket�� ã�����ؼ� Error
					if(!str.equals("quit")) {
						// 3.�۽�
						dos.writeUTF(str);
					}else {
						flag  = false;
					}
				}
				System.out.println("------> ServiceThread ����!!");
			}catch (Exception e) {
			}
	}
	
}//class
