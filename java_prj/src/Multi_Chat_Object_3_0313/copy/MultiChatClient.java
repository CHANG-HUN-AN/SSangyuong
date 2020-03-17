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
	//3.13object������ ����������
//	DataInputStream dis;
//	DataOutputStream dos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	JFrame jf;
	JTextArea jta;
	JTextField jtf;
	String name ;
	// Constructor
	public MultiChatClient() { // UI������ ������ �Ǵ� �޼ҵ�� ���°��� ����
		this("211.63.89.213", "ȫ�浿");
//		3.13 �⺻�������̴��� �ڽ��� ip �� ȫ�浿���� �����ε��� ������ ȣ��
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
			this.name = name; //������ �̸��� �޴°�
			init();
			s = new Socket(ip, 7000);
			//Object�� ���̱�ȯ
//			dis = new DataInputStream(s.getInputStream());
//			dos = new DataOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			
//			dos.writeUTF(name+"����");
			oos.writeObject(new MessageVO(name,"",MessageVO.CONNECT));
			new ChatClientThread(ois,jta,jtf).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Method

	public void init() {
		jf = new JFrame("���� Ŭ���̾�Ʈ");
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
				//��ȿ���˻�
				if(jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "������ �Է� �䱸");
					jtf.requestFocus();
				}else {
					try {
						//1.���� �۽�
						MessageVO msg = new MessageVO(name,jtf.getText(),MessageVO.TALKING);
						oos.writeObject(msg);
						
//						3.13 �ټ���ä���� Ŭ���̾�Ʈ�� �ޱ����ؼ� ������ �����尡 �ʿ��ϴ�
//						//�������� ������ ������ textarea�� ���
//						jta.append("���� : "+dis.readUTF()+"\n");
//						jtf.setText("");
//						jtf.requestFocus();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}//in class
	
	//���� �۾��� �����ϴ� ������ Thread ���� ->
	//���׸��� �Ը��̱⿡ �̳�Ŭ������ �̳�Ŭ������ �۾��ص��ȴ�
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
			//Thread ��ӹ޾� ����Ϸ��� run�޼ҵ尡 �ʿ�
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
