package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *2.Echo System 실습
 *클라이언트가 서버에게 Echo한다 메아리 내가 보낸것이 나한테 돌아오도록
 * @author user
 */
public class EchoServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("=========서버 생성============");
			ServerSocket server = new ServerSocket(7000);
			Socket s= server.accept();
			System.out.println("================클라이언트 접속완료==========");
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
//			//2.클라이언트에서 넘어온 데이터 수신
//			String data = dis.readUTF();
//			//3.클라이언트데이터를 받아서 다시 클라이언트에게 전송
//			dos.writeUTF(data);
			//2.3 클라이언트데이터 수신후 송신
			dos.writeUTF(dis.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
