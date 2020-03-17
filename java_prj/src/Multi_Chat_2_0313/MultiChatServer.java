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
			System.out.println("===서버 실행중===");
			int count = 1;
			while(true) {
				s = server.accept();
				System.out.println(count+" 번째 클라이언트 접속");
				count ++;
				ServiceThread st = new ServiceThread(s);
				st.start();
				sList.add(st);
				System.out.println("접속자수"+sList.size());
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
