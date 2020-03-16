package Multi_Chat_Object_3_0313.copy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 멀티 에코채팅을 위해 
 * 서버에서 accept를 받기위해 쓰레드로 빼놓은 클래스
 * @author user
 */
public class ServiceThread extends Thread{
	// Field
	Socket socket;
//	DataInputStream dis;
//	DataOutputStream dos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	//Constructor
	public ServiceThread() {
	}

	public ServiceThread(Socket socket) { 
		try {
			System.out.println("----->ServiceThread 생성");
			this.socket = socket;
//			dis = new DataInputStream(socket.getInputStream());
//			dos = new DataOutputStream(socket.getOutputStream());
			oos = new ObjectOutputStream(socket.getOutputStream()); //java.net.SocketException: Connection reset 순서oos가 ㅇ
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) { e.printStackTrace(); }
	}
	//Method
	public void run() { 
			boolean flag = true;
			try {
				while (flag) {
					// 2.수신
//					String str = dis.readUTF(); // SocketException - > 클라이언트에서 오류 x 받는쪽에서 socket을 찾지못해서 Error
					MessageVO msg = (MessageVO)ois.readObject();
					if(msg.status==MessageVO.CONNECT) {//처음접속
						broadCasting(new MessageVO(msg.name,"님 입장~")); //접속되어있는 모든 클라이언트에게 송신
					}else if(msg.status == MessageVO.TALKING) { //접속중
						broadCasting(new MessageVO(msg.name,msg.content)); //접속되어있는 모든 클라이언트에게 송신
					}else if(msg.status == MessageVO.EXIT) {//접속종료
						broadCasting(new MessageVO(msg.name,"님 퇴장")); //접속되어있는 모든 클라이언트에게 송신
						flag =false;
					}
				}
				System.out.println("------> ServiceThread 종료!!");
			}catch (Exception e) {e.printStackTrace(); }
	}//run
	
	/**
	 * @param str
	 * 접속되어있는 모든 클라이언트에게 메세지 전송
	 */
	synchronized public void  broadCasting(MessageVO msg) {
		try {
			for (ServiceThread st : MultiChatServer.sList) {
				st.oos.writeObject(msg);
				st.oos.flush();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}//class
