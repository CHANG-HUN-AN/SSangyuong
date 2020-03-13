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
			System.out.println("===서버 실행중===");
			int count = 1;
			while(true) {
				s = server.accept();
				System.out.println(count+" 번째 클라이언트 접속");
				count ++;
				ServiceThread st = new ServiceThread(s);
				st.start();
			}
				/*
				 * 3.13 다중accept시 thread쓰지않으면 1번째 클라이언트 accept후 1번째클라이언트가 write하지않으면 
				 * while문 상단에있는 accept로 올라가지 못하는 문제
				 */
//				dis = new DataInputStream(s.getInputStream());
//				dos = new DataOutputStream(s.getOutputStream());
//				boolean flag = true;
//				// while(flag) {
//				// 2.수신
//				String str = dis.readUTF(); // SocketException - > 클라이언트에서 오류 x 받는쪽에서 socket을 찾지못해서 Error
//				System.out.println("str===>"+str);
//				// 3.송신
//				dos.writeUTF(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	
}
