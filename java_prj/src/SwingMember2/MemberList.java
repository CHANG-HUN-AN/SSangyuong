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
//		ta.setVisible(false);//밑에 ta.append 로 데이터가 보이지않게 할수있다
		if (MemberMgmUI.list.size() == 0) {
			JOptionPane.showMessageDialog(null, main.getMsg("회원등록을 먼저 진행해주세요"));
			ta.append("등록된 리스트가 없습니다.");
		}
		else {
			ta.append("================리스트출력=================\n");
			ta.append("번호\t이름\t주소\t\n");
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
