package SwingMember2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberSearch {
	MemberMgmUI main;
	// Field
	JPanel searchPane;
	JPanel jp_search, jp_serarchResult;;
	JLabel jl_searchName;
	JTextField jt_search;
	TextArea sta;

	// Constructor
	public MemberSearch() {
	}
	public MemberSearch(MemberMgmUI main) {
		this.main = main;
		searchPane = main.searchPane;
	}

	// Method

	public void search() {
//			switchPane("search");
		main.switchPane(MemberMgmUI.SEARCH);

		// object
		jp_search = new JPanel();
		jp_serarchResult = new JPanel();

		jl_searchName = new JLabel("�˻���>>");
		jt_search = new JTextField(20);
		sta = new TextArea(70, 75);
		sta.setEditable(false);	
		// sub_panel add
		jp_search.add(jl_searchName);
		jp_search.add(jt_search);
		jp_serarchResult.add(sta);

		searchPane.add(jp_search);
		searchPane.add(jp_serarchResult);
		
		main.add(searchPane, BorderLayout.CENTER);
		main.setVisible(true);
		
		jt_search.addActionListener(new MemberSearchEvent());
	}//search()
	//searchProc -�����Ͱ˻�

	public void searchProc() {
		// 1.�˻��� ��������
		String name = jt_search.getText().trim();
		MemberVO rvo = null ;
		// 2.ArrayList�� ����� MemberVO ��ü���� getName()
		sta.setText("");
		for (MemberVO vo : MemberMgmUI.list) {
			if (vo.getName().equals(name)) {
				rvo = vo;
			}
		}
		//3.�˻������ ���� JOption~
		if(rvo != null) {//nullPointError ---> rvo.getText().equal("")
			sta.append(rvo.getName()+"\t");
			sta.append(rvo.getAddr()+"\t");
		}else {
			sta.append("�����Ͱ� �������� �ʽ��ϴ�.");
		}
	}//searchProc()
	
	class MemberSearchEvent implements  ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			searchProc();
		}
	}//in_class
}//class