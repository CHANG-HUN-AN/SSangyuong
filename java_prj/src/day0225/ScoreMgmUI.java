package day0225;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreMgmUI {
	//Field
	JFrame jf ;
	ArrayList<ScoreVO> vo = new ArrayList<ScoreVO>();
	JLabel mainLabel,stdLabel,naLabel,koLabel,engLabel,maLabel;
	JTextField stdText,naText,koText,engText,maText;
	JButton btnRegister,btnCancel,btnList,btnExit;
	JPanel jp_stdno,jp_name,jp_kor,jp_eng,jp_math,jp_button;
	
	//Constructor
	public ScoreMgmUI() {
		start();

	}//con
	
	//Method
	//inner class �� �̺�Ʈ ��ü ����
	class ScoreMgmUIEvent extends WindowAdapter implements ActionListener {
		public void windowClosing(WindowEvent e) {
			System.out.println("==========���α׷�����=========");
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(btnRegister ==obj||maText == obj) {
				System.out.println("���");
			}else if (btnCancel == obj) {
				System.out.println("���");
			}else if(btnList == obj ) {
				System.out.println("����Ʈ");
			}else if(btnExit == obj) {
				System.out.println("==========���α׷�����=========");
				System.exit(0);
			}
		}
	}//event
	public void start() {
		 jf = new JFrame("���� ��� �ý���");
		 jf.setLayout(new GridLayout(6,1));
		 mainLabel = new JLabel("Score Mgm System");
			
		 stdLabel = new JLabel("�й�");
		 naLabel = new JLabel("�̸�");
		 koLabel = new JLabel("����");
		 engLabel = new JLabel("����");
		 maLabel = new JLabel("����");
		
		 stdText = new JTextField(20);
		 naText = new JTextField(20);
		 koText = new JTextField(20);
		 engText = new JTextField(20);
		 maText = new JTextField(20);

		 btnRegister = new JButton("���");
		 btnCancel = new JButton("���");
		 btnList = new JButton("����Ʈ");
		 btnExit = new JButton("���");
		 
		 jp_stdno = new JPanel();
		 jp_name = new JPanel();
		 jp_kor = new JPanel();
		 jp_eng = new JPanel();
		 jp_math = new JPanel();
		 jp_button = new JPanel();
		 
		 jp_stdno.add(stdLabel);jp_stdno.add(stdText);
		 jp_name.add(naLabel);jp_name.add(naText);
		 jp_kor.add(koLabel);jp_kor.add(koText);
		 jp_eng.add(engLabel);jp_eng.add(engText);
		 jp_math.add(maLabel);jp_math.add(maText);
		 jp_button.add(btnRegister);jp_button.add(btnCancel);jp_button.add(btnList);jp_button.add(btnExit);
		 
		 jf.add(jp_stdno);jf.add(jp_name);jf.add(jp_kor);jf.add(jp_eng);jf.add(jp_math);
		 jf.add(jp_button);
		 
		 jf.setSize(300,350);
		Dimension gsize = jf.getSize();
		Dimension wsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (wsize.width - gsize.width) / 2;
		int height = (wsize.height - gsize.height) / 2;
		 jf.setLocation(width, height);
		 jf.setVisible(true);
		 
//		handler listener
		ScoreMgmUIEvent eventObj = new ScoreMgmUIEvent();
		jf.addWindowListener(eventObj);
		btnRegister.addActionListener(eventObj);
		btnCancel.addActionListener(eventObj);
		btnList.addActionListener(eventObj);
		btnExit.addActionListener(eventObj);
		maText.addActionListener(eventObj);
	}
}//class
