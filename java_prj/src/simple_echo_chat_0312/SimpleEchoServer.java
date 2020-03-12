package simple_echo_chat_0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
	//Field
	ServerSocket server;
	Socket s ;
	DataInputStream dis;
	DataOutputStream dos;
	public SimpleEchoServer() {
		try {
			server = new ServerSocket(7000);
			System.out.println("============서버 실행중============");
			s = server.accept();
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			boolean flag =true;
			while(flag) {

				String str = dis.readUTF();//2단계 = 서버: 클라이언트 데이터 수신
				if(!str.equals("quit")||str.equals("exit")) {
					dos.writeUTF(str);//3단계 = 서버 :클라이언트 데이터 회신
				}else {
					flag=false;
					System.out.println("===============서버 종료===============");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
