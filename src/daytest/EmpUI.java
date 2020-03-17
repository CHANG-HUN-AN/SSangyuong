package daytest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import daytest.EmpUITest.EmpUIEvent;

public class EmpUI {
	//Field
		JFrame jf;
		JTextField jtf_sql;
		JTextArea jta_rs;
		
		//Consturcutor
		public EmpUI() {
			jf = new JFrame();
			jtf_sql = new JTextField(20);
			jta_rs = new JTextArea(50,50);
			
			jf.add(jtf_sql);
			jf.add(jta_rs);
			
			EmpUIEvent eventObj = new EmpUIEvent();
			jf.addWindowListener(eventObj);
			jtf_sql.addActionListener(eventObj);
		}
		//Method
		//inner class
		class EmpUIEvent extends WindowAdapter implements ActionListener{

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = jtf_sql.getText().trim();
				
			}
		}
	}
