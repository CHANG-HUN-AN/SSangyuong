package Form;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame{
	public LoginForm() {
		JPanel panel = new JPanel();
		JLabel jlabel = new JLabel("�α��� ��");
		setLayout(new GridLayout(4,1));
		panel.add(jlabel);
		add(panel);
		add(new id_form());
		add(new pass_form());
		add(new check_form());
		setSize(300,300);
		setVisible(true);
		
		add(new windowadapter() extends WindowAdapter{
			public void windowClosing(WindowEvent e){
				System.out.print("=====����======");
				System.exit(0);
			}
		});
	}//constructor
	//Method

	class id_form extends JPanel {
		public id_form() {
			JLabel jlabel = new JLabel("���̵� ");
			JTextField jtext = new JTextField(15);
			add(jlabel);
			add(jtext);
		}
	}
	class pass_form extends JPanel {
		public pass_form() {
			JLabel jlabel = new JLabel("��й�ȣ");
			JTextField jtext = new JTextField(15);
			add(jlabel);
			add(jtext);
		}
	}
	class check_form extends JPanel{
		public check_form() {
			JButton btn1 = new JButton("�α���");
			JButton btn2 = new JButton("���");
		}
	}
	
}//class
