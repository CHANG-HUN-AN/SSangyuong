package Multi_Chat_Object_3_0313.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MultiChatClient {
	// Field
	Socket s;
	//3.13object형으로 데이터전송
//	DataInputStream dis;
//	DataOutputStream dos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	JFrame jf;
	JTextArea jta;
	JTextField jtf;
	String name ;
	// Constructor
	public MultiChatClient() { // UI구성은 생성자 또는 메소드로 빼는것이 좋다
		this("211.63.89.213", "홍길동");
//		3.13 기본생성자이더라도 자신의 ip 와 홍길동으로 오버로딩된 생성자 호출
//		try {
//			init();
//			s = new Socket("211.63.89.213", 7000);
//			dis = new DataInputStream(s.getInputStream());
//			dos = new DataOutputStream(s.getOutputStream());
//			
//			new ChatClientThread(dis,jta,jtf).start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public MultiChatClient(String ip ,String name) {
		try {
			this.name = name; //접속자 이름을 받는것
			init();
			s = new Socket(ip, 7000);
			//Object로 데이교환
//			dis = new DataInputStream(s.getInputStream());
//			dos = new DataOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			
//			dos.writeUTF(name+"입장");
			oos.writeObject(new MessageVO(name,"",MessageVO.CONNECT));
			new ChatClientThread(ois,jta,jtf).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Method

	public void init() {
		jf = new JFrame("에코 클라이언트");
		jta = new JTextArea(30, 30);
		jtf = new JTextField(20);

		jta.setBackground(Color.LIGHT_GRAY);
		jta.setEditable(false);
		
		jf.add(jta, BorderLayout.CENTER);
		jf.add(jtf, BorderLayout.SOUTH);

		jf.setSize(300, 300);
		jf.setVisible(true);
		
		jtf.requestFocus();
		
		ClientEvent eventObj = new ClientEvent();
		jf.addWindowListener(eventObj);
		jtf.addActionListener(eventObj);

	}

	public class ClientEvent extends WindowAdapter implements ActionListener {
		//Method
		@Override
		public void windowClosing(WindowEvent we) {
			try {
//				dos.writeUTF("quit");
				oos.writeObject(new MessageVO(name,"",MessageVO.EXIT));
				System.exit(0);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (obj == jtf) {
				//유효성검사
				if(jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "데이터 입력 요구");
					jtf.requestFocus();
				}else {
					try {
						//1.서버 송신
						MessageVO msg = new MessageVO(name,jtf.getText(),MessageVO.TALKING);
						oos.writeObject(msg);
						
//						3.13 다수의채팅을 클라이언트가 받기위해서 별도의 쓰레드가 필요하다
//						//서버에서 데이터 수신후 textarea에 출력
//						jta.append("수신 : "+dis.readUTF()+"\n");
//						jtf.setText("");
//						jtf.requestFocus();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}//in class
	
	//수신 작업을 진행하는 별도의 Thread 생성 ->
	//조그만한 규모이기에 이너클래스의 이너클래스로 작업해도된다
	 class ChatClientThread extends Thread{ 
			//Field
			ObjectInputStream ois;
			JTextArea jta;
			JTextField jtf;
			//Constructor
			public ChatClientThread() { }
			public ChatClientThread(ObjectInputStream ois, JTextArea jta , JTextField jtf) {
				this.ois = ois;
				this.jta = jta;
				this.jtf = jtf;
			}
			//Method 
			//Thread 상속받아 사용하려면 run메소드가 필요
			public void run() {
				try {
					while (true) {
						MessageVO msg = (MessageVO)ois.readObject();
						jta.append(msg.name+"" +msg.content+ "\n");
						jtf.setText("");
						jtf.requestFocus();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}//class
