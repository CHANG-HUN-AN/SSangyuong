package Multi_echo_chat_1_0313;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiEchoChatServer {
	//Field
	ServerSocket server;
	Socket s; 
	DataInputStream dis;
	DataOutputStream dos;
	//Constructor
	public MultiEchoChatServer() {
		this(7000);
	}
	public MultiEchoChatServer(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("===���� ������===");
			int count = 1;
			while(true) {
				s = server.accept();
				System.out.println(count+" ��° Ŭ���̾�Ʈ ����");
				count ++;
				ServiceThread st = new ServiceThread(s);
				st.start();
			}
				/*
				 * 3.13 ����accept�� thread���������� 1��° Ŭ���̾�Ʈ accept�� 1��°Ŭ���̾�Ʈ�� write���������� 
				 * while�� ��ܿ��ִ� accept�� �ö��� ���ϴ� ����
				 */
//				dis = new DataInputStream(s.getInputStream());
//				dos = new DataOutputStream(s.getOutputStream());
//				boolean flag = true;
//				// while(flag) {
//				// 2.����
//				String str = dis.readUTF(); // SocketException - > Ŭ���̾�Ʈ���� ���� x �޴��ʿ��� socket�� ã�����ؼ� Error
//				System.out.println("str===>"+str);
//				// 3.�۽�
//				dos.writeUTF(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	
}
