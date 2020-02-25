package day0224;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class JFrameObject {

	//Field
	JFrame jf;
	//Constructor
	public JFrameObject() {
		jf = new JFrame("JFrame test~~~~");
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pass = new JPanel();
		JPanel jp_button = new JPanel();
		
		JLabel title = new JLabel("로그인폼");
		JLabel id = new JLabel("아이디 ");
		JTextField tid = new JTextField(15);
		
		JLabel pass = new JLabel("비밀번호");
		JTextField tpass= new JTextField(15);
		
		JButton btn1 = new JButton("로그인");
		JButton btn2 = new JButton("다시쓰기");
		
//		jf.add(title,BorderLayout.NORTH);
		
		jf.setLayout(new GridLayout(4,1));
		jp_title.add(title);
		jp_id.add(id);
		jp_id.add(tid);
		jp_pass.add(pass);
		jp_pass.add(tpass);
		jp_button.add(btn1);
		jp_button.add(btn2);
		
		jf.add(jp_title);
		jf.add(jp_id);
		jf.add(jp_pass);
		jf.add(jp_button);
		
		jf.setSize(300,300);
		jf.setVisible(true);
		//event handler 메소드 호출 (=listener 메소드호출) 
		
		jf.addWindowListener(new WindowAdapter() {
			public void  windowClosing(WindowEvent we) {
				System.out.println("==========프로그램종료=========");
				System.exit(0);
			}
		});
	}
	//Method
	
}
