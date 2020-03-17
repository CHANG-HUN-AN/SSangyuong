package Multi_Chat_Object_3_0313.copy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * ��Ƽ ����ä���� ���� 
 * �������� accept�� �ޱ����� ������� ������ Ŭ����
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
			System.out.println("----->ServiceThread ����");
			this.socket = socket;
//			dis = new DataInputStream(socket.getInputStream());
//			dos = new DataOutputStream(socket.getOutputStream());
			oos = new ObjectOutputStream(socket.getOutputStream()); //java.net.SocketException: Connection reset ����oos�� ��
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) { e.printStackTrace(); }
	}
	//Method
	public void run() { 
			boolean flag = true;
			try {
				while (flag) {
					// 2.����
//					String str = dis.readUTF(); // SocketException - > Ŭ���̾�Ʈ���� ���� x �޴��ʿ��� socket�� ã�����ؼ� Error
					MessageVO msg = (MessageVO)ois.readObject();
					if(msg.status==MessageVO.CONNECT) {//ó������
						broadCasting(new MessageVO(msg.name,"�� ����~")); //���ӵǾ��ִ� ��� Ŭ���̾�Ʈ���� �۽�
					}else if(msg.status == MessageVO.TALKING) { //������
						broadCasting(new MessageVO(msg.name,msg.content)); //���ӵǾ��ִ� ��� Ŭ���̾�Ʈ���� �۽�
					}else if(msg.status == MessageVO.EXIT) {//��������
						broadCasting(new MessageVO(msg.name,"�� ����")); //���ӵǾ��ִ� ��� Ŭ���̾�Ʈ���� �۽�
						flag =false;
					}
				}
				System.out.println("------> ServiceThread ����!!");
			}catch (Exception e) {e.printStackTrace(); }
	}//run
	
	/**
	 * @param str
	 * ���ӵǾ��ִ� ��� Ŭ���̾�Ʈ���� �޼��� ����
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
