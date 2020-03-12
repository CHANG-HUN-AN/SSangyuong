package day0312;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Echo System �ǽ�
 * Ŭ���̾�Ʈ�� �������� Echo�Ѵ� �޾Ƹ� ���� �������� ������ ���ƿ����� ����
 * _2 : scanner �� ���� ä���� ���� (1��) ->>���� �ݺ������� ä���̵ǵ��ϱ���
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
				//1.������ ������ ����
				System.out.print("Ŭ���̾�Ʈ >> \t");
				dos.writeUTF(scan.nextLine());
				// 4.�������� �Ѿ�� ������ ����
				String str = dis.readUTF();
				if(!str.equals("quit")) {
					System.out.println("���� : " + str);
				}else {
					flag =false;
				}
			}
			System.out.println("ä���� ���������ϴ�(Ŭ���̾�Ʈ ����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
