package day0317;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DBConnUI extends WindowAdapter 
											implements ActionListener{
	//Field
	JFrame jf;
	JTextField jtf_sql;
	JTextArea jta_content;
	
	//Constructor
	public DBConnUI() {
		jf = new JFrame("SQL 실습");
		jtf_sql = new JTextField(20);
		jta_content = new JTextArea(10,30);
		
		jf.add(jtf_sql, BorderLayout.NORTH);
		jf.add(jta_content, BorderLayout.CENTER);
		jf.setSize(800,300);
		jf.setVisible(true);
		
		jf.addWindowListener(this);
		jtf_sql.addActionListener(this);		
	}
	
	//Method
	//윈도우 이벤트 처리
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
	
	//액션 이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		String sql = jtf_sql.getText().trim();
	
		//DB연동 객체에 sql 전송 및 결과 리턴
		DBConn db = new DBConn();
		db.getStatement();
		ArrayList<ArrayList<String>> list = db.getResultList(sql);
		db.close();
		
		jta_content.setText("");
		//리턴 결과를 jta_content에 append
		for(ArrayList<String> vo : list) {
			for(String str : vo) {
				jta_content.append(str + "\t");
			}
			jta_content.append("\n");
		}

	}
}//class








