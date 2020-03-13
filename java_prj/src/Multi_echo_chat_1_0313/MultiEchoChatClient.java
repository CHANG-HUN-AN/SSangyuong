package Multi_echo_chat_1_0313;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * multi echo 채팅을위한 클라이언트 코드
 * @author user
 */
public class MultiEchoChatClient {
	// Field
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	JFrame jf;
	JTextArea jta;
	JTextField jtf;

	// Constructor
	public MultiEchoChatClient() { // UI구성은 생성자 또는 메소드로 빼는것이 좋다
		init();
		try {
			s = new Socket("localhost", 7000);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
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

		@Override
		public void windowClosing(WindowEvent we) {
			try {
				dos.writeUTF("quit");
				System.exit(0);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (obj == jtf) {
				if(jtf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "데이터 입력 요구");
					jtf.requestFocus();
					
				}else {
					try {
						//서버 송신
						String str = jtf.getText();
						dos.writeUTF(str);
						//서버에서 데이터 수신후 textarea에 출력
						jta.append("수신 : "+dis.readUTF()+"\n");
						jtf.setText("");
						jtf.requestFocus();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}//in class
}//class
