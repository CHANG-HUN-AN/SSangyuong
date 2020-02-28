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

		jl_searchName = new JLabel("검색명>>");
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
	//searchProc -데이터검색

	public void searchProc() {
		// 1.검색명 가져오기
		String name = jt_search.getText().trim();
		MemberVO rvo = null ;
		// 2.ArrayList에 담겨진 MemberVO 객체에서 getName()
		sta.setText("");
		for (MemberVO vo : MemberMgmUI.list) {
			if (vo.getName().equals(name)) {
				rvo = vo;
			}
		}
		//3.검색결과에 따라 JOption~
		if(rvo != null) {//nullPointError ---> rvo.getText().equal("")
			sta.append(rvo.getName()+"\t");
			sta.append(rvo.getAddr()+"\t");
		}else {
			sta.append("데이터가 존재하지 않습니다.");
		}
	}//searchProc()
	
	class MemberSearchEvent implements  ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			searchProc();
		}
	}//in_class
}//class