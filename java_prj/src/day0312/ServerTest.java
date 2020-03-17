package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7000); //new ServerSocket(int port); 포트번호 입력 
			System.out.println("============서버실행중================");
			Socket s = server.accept(); //서버가 클라이언트를 받기위해 대기중 server.accept() ->return Socket
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			//1.서버:클라이언트에 환영메세지 전송
			dos.writeUTF("환영합니다~~~");
			System.out.println("1.서버 :메세지전송");
			//4.서버:클라이언트 메세지 수신
			System.out.println("4.클라이언트:"+dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
