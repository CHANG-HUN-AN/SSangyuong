package simple_echo_chat_0312;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SimpleEchoCilent extends JFrame implements ActionListener{
	//Field
	Socket s ;
	DataInputStream dis;
	DataOutputStream dos;
	JTextArea ja_content;
	JTextField jt_input;
	
	//Constructor
	public SimpleEchoCilent() {
		try {
			s= new Socket("localhost",7000);
			ja_content = new JTextArea(50,50);
			jt_input = new JTextField(20);
			
			ja_content.setEditable(false);
			ja_content.setBackground(Color.cyan);
			
			add(ja_content,BorderLayout.CENTER);
			add(jt_input,BorderLayout.SOUTH);
			
			setTitle("echo client");
			setSize(300,300);
			setVisible(true);
			
			jt_input.requestFocus();
			jt_input.addActionListener(this);
		}catch (Exception e) {
		}
	}
	//Method
	/**
	 * actionPerformed  event 메소드
	 */
	@Override
	public void actionPerformed(ActionEvent e) {  
		Object obj = e.getSource();
		try {
			if (obj == jt_input) {
				String str = jt_input.getText().trim();
				if (str.length() != 0) {
					dis = new DataInputStream(s.getInputStream());
					dos = new DataOutputStream(s.getOutputStream());

					// 1.서버로 데이터 전송
					dos.writeUTF(str);
					jt_input.setText("");
					jt_input.requestFocus();
					// 4.서버에서 수신 -->ja_content
					if(!str.equals("quit")) {
						ja_content.append(dis.readUTF()+"\n");
					}else {
						JOptionPane.showMessageDialog(null, "종료");
						System.exit(0);
					}
				}
			}
		} catch (Exception e1) { e1.printStackTrace();
		}
	}
}
