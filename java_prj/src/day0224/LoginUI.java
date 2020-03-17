package day0224;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginUI extends JFrame {

	public LoginUI() {
		JLabel loginForm = new JLabel("로그인폼");
		JPanel loginForm_panel = new JPanel();
		setLayout(new GridLayout(4,1));
		loginForm_panel.add(loginForm);
		add(loginForm_panel);
		add(new id());
		add(new ps_panel());
		add(new ok_panel());
		setSize(300,300);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.out.println("==========프로그램종료=========");
				System.exit(0);
				}
			});
	}
	
	class id extends JPanel{
		public id() {
			JLabel id_label = new JLabel("아이디 ");
			JTextField id_textField = new JTextField(15);
			add(id_label);
			add(id_textField);
		}
	}
	
	class ps_panel extends JPanel{
		public ps_panel() {
			JLabel id_label  = new JLabel("비밀번호");
			JTextField id_textField = new JTextField(15);
			add(id_label);
			add(id_textField);
		}
	}
	
	class ok_panel extends JPanel{
		public ok_panel() {
			JButton btn1 = new JButton("로그인");
			JButton btn2 = new JButton("취소");
			add(btn1);
			add(btn2);
		}
	}
}

