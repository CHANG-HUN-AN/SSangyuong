package Multi_echo_chat_1_0313;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 멀티 에코채팅을 위해 
 * 서버에서 accept를 받기위해 쓰레드로 빼놓은 클래스
 * @author user
 */
public class ServiceThread extends Thread{
	// Field
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	//Constructor
	public ServiceThread() {
	}

	public ServiceThread(Socket socket) { 
		try {
			System.out.println("----->ServiceThread 생성");
			this.socket = socket;
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	public void run() { 
			boolean flag = true;
			try {
				while (flag) {
					// 2.수신
					String str = dis.readUTF(); // SocketException - > 클라이언트에서 오류 x 받는쪽에서 socket을 찾지못해서 Error
					if(!str.equals("quit")) {
						// 3.송신
						dos.writeUTF(str);
					}else {
						flag  = false;
					}
				}
				System.out.println("------> ServiceThread 종료!!");
			}catch (Exception e) {
			}
	}
	
}//class
