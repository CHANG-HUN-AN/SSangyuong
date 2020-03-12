package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Echo System �ǽ�
 * Ŭ���̾�Ʈ�� �������� Echo�Ѵ� �޾Ƹ� ���� �������� ������ ���ƿ�����
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
			
			//1.������ ������ ����
			System.out.print("Ŭ���̾�Ʈ >> \t");
			dos.writeUTF(scan.nextLine());
			//4.�������� �Ѿ�� ������ ����
			System.out.println("���� : "+dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
