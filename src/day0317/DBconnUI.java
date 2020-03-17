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
 * java swing ���� db �����ϰ� swing������ ����ϱ�
 * @author user
 */
public class DBconnUI extends WindowAdapter implements ActionListener{
	//Field
	JFrame jf ;
	JTextField jtf_sql;
	JTextArea jta_content;
	//Constructor
	public DBconnUI() { 
		jf = new JFrame("SQL �ǽ�");
		jtf_sql = new JTextField(20);
		jta_content = new JTextArea(50,50);
		
		jf.add(jtf_sql,BorderLayout.NORTH);jf.add(jta_content,BorderLayout.CENTER);
		jf.setSize(300,300); jf.setVisible(true);
		
		jf.addWindowListener(this);
		jtf_sql.addActionListener(this);
	}
	
	//Method
	//������ �̺�Ʈ ó��
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	} 
	@Override
	//�׼� �̺�Ʈ ó��
	public void actionPerformed(ActionEvent ae) {
		String sql = jtf_sql.getText();
		//DB���� ��ü�� sql ���� �� ��� ����
		DBConn db = new DBConn();
		db.getStatement();
		ArrayList<EmpVO> list = db.getResult(sql);
		db.close();
		//���� ����� jta_content�� append
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
