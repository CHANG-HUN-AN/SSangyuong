package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Echo System 실습
 * 클라이언트가 서버에게 Echo한다 메아리 내가 보낸것이 나한테 돌아오도록
 * @author user
 */
public class EchoClientTest {
	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("localhost",7000);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			Scanner scan = new Scanner(System.in);
			
			//1.서버로 데이터 전송
			System.out.print("클라이언트 >> \t");
			dos.writeUTF(scan.nextLine());
			//4.서버에서 넘어온 데이터 수신
			System.out.println("수신 : "+dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
