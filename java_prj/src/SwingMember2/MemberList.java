package SwingMember2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MemberList {
	// Field
	JPanel listPane;
	JTextArea ta;
	MemberMgmUI main;
	
	// Constructors
	public MemberList() {
	}
	public MemberList(MemberMgmUI main) {
		this.main = main;
		this.listPane = main.listPane;
	}
	// Method
	public void list() {
		//	switchPane("list");
		main.switchPane(MemberMgmUI.LIST);
		// object
		ta = new JTextArea(25, 40);
		
		listProc();
		ta.setEditable(false);
		
		listPane.add(ta);
		main.add(listPane,BorderLayout.CENTER);
		main.setVisible(true);
	}// list Method
	
	public void listProc() {
//		ta.setVisible(false);//�ؿ� ta.append �� �����Ͱ� �������ʰ� �Ҽ��ִ�
		if (MemberMgmUI.list.size() == 0) {
			JOptionPane.showMessageDialog(null, main.getMsg("ȸ������� ���� �������ּ���"));
			ta.append("��ϵ� ����Ʈ�� �����ϴ�.");
		}
		else {
			ta.append("================����Ʈ���=================\n");
			ta.append("��ȣ\t�̸�\t�ּ�\t\n");
			ta.append("========================================\n");
			for (MemberVO vo : MemberMgmUI.list) {
//				ta.setVisible(true);
				int no = 1;
				ta.append(no+"\t");
				ta.append(vo.getName() + "\t");
				ta.append(vo.getAddr() + "\n");
				no++;
			}//for
		}
	}//listProc
}//class
