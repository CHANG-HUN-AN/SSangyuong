package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost",7000); //접속하고자하는 서버 주소를 적어준다.
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			//2.클라이언트: 서버 데이터를 수신(받는다)
			System.out.println("2.클라이언트 : 서버데이터 수신\n"+"서버 : "+dis.readUTF());
			
			//3.클라이언트: 서버에 데이터 전송
			dos.writeUTF("안녕하세요 서버님아");
			System.out.println("3.클라이언트 : 데이터 전송");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
