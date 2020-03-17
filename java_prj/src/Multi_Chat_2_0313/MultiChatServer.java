package Multi_Chat_2_0313;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer {
	//Field
	ServerSocket server;
	Socket s; 
	DataInputStream dis;
	DataOutputStream dos;
	static ArrayList<ServiceThread> sList = new ArrayList<ServiceThread>();
	
	//Constructor
	public MultiChatServer() {
		this(7000);
	}
	public MultiChatServer(int port) {
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
				sList.add(st);
				System.out.println("�����ڼ�"+sList.size());
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
