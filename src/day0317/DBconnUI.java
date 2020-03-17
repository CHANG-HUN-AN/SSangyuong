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

/**
 * java swing 으로 db 연동하고 swing에값을 출력하기
 * @author user
 */
public class DBconnUI extends WindowAdapter implements ActionListener{
	//Field
	JFrame jf ;
	JTextField jtf_sql;
	JTextArea jta_content;
	//Constructor
	public DBconnUI() { 
		jf = new JFrame("SQL 실습");
		jtf_sql = new JTextField(20);
		jta_content = new JTextArea(50,50);
		
		jf.add(jtf_sql,BorderLayout.NORTH);jf.add(jta_content,BorderLayout.CENTER);
		jf.setSize(300,300); jf.setVisible(true);
		
		jf.addWindowListener(this);
		jtf_sql.addActionListener(this);
	}
	
	//Method
	//윈도우 이벤트 처리
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	} 
	@Override
	//액션 이벤트 처리
	public void actionPerformed(ActionEvent ae) {
		String sql = jtf_sql.getText();
		//DB연동 객체에 sql 전송 및 결과 리턴
		DBConn db = new DBConn();
		db.getStatement();
		ArrayList<EmpVO> list = db.getResult(sql);
		db.close();
		//리턴 결과를 jta_content에 append
		jta_content.setText("");
		for(EmpVO vo : list) {
			jta_content.append(String.valueOf(vo.getEmpno())+"\t");
			jta_content.append(vo.getEname()+"\t");
			jta_content.append(vo.getJob()+"\t");
			jta_content.append(String.valueOf(vo.getMgr())+"\t");
			jta_content.append(vo.getHiredate()+"\t");
			jta_content.append(String.valueOf(vo.getSal())+"\t");
			jta_content.append(String.valueOf(vo.getComm())+"\t");
			jta_content.append(String.valueOf(vo.getDeptno())+"\n"
					+ "");
		}
	}
}
