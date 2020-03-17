package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Echo System 실습
 * 클라이언트가 서버에게 Echo한다 메아리 내가 보낸것이 나한테 돌아오도록 구현
 * _2 : scanner 를 통해 채팅을 구현 (1번) ->>추후 반복문으로 채팅이되도록구현
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
			boolean flag = true;
		
			while(flag) {
				//1.서버로 데이터 전송
				System.out.print("클라이언트 >> \t");
				dos.writeUTF(scan.nextLine());
				// 4.서버에서 넘어온 데이터 수신
				String str = dis.readUTF();
				if(!str.equals("quit")) {
					System.out.println("수신 : " + str);
				}else {
					flag =false;
				}
			}
			System.out.println("채팅이 끊어졌습니다(클라이언트 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
