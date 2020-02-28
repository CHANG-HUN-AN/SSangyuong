package SwingMember2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberUpdate {
	MemberMgmUI main;

	
	//Field
	JPanel updatePanel;
	JPanel update_subPanel,jp_updateName,jp_updateAddr,jp_updateSearch,jp_updateButton;
	JLabel jl_updateName,jl_updateAddr,jl_updateSearchName;
	JTextField jt_updateName,jt_updateAddr,jt_updateSearch;
	JButton updateButton ,updateReset;
	//Constructor
	public MemberUpdate() {
		// TODO Auto-generated constructor stub
	}
	public MemberUpdate(MemberMgmUI main) {
		this.main = main;
		this.updatePanel = main.updatePanel;
	}
	
	//Method
	/**
	 * updateMethod
	 */
	public void update() {
//		switchPane("update");
		main.switchPane(MemberMgmUI.UPDATE);

		//object 
		update_subPanel=new JPanel();
		 jp_updateName=new JPanel();jp_updateAddr=new JPanel();jp_updateSearch=new JPanel();jp_updateButton = new JPanel();
		 jl_updateName= new JLabel("이름");jl_updateAddr=new JLabel("주소");jl_updateSearchName=new JLabel("수정명>>");
		 jt_updateName=new JTextField(20);jt_updateAddr=new JTextField(20);jt_updateSearch=new JTextField(20);
		 updateButton = new JButton("등록");updateReset = new JButton("취소");
		 //font set
		 jl_updateName.setFont(MemberMgmUI.font);
		 jl_updateAddr.setFont(MemberMgmUI.font);
		 jl_updateSearchName.setFont(MemberMgmUI.font);
		 updateButton.setFont(MemberMgmUI.font); updateReset.setFont(MemberMgmUI.font);
		 //component add
		 jp_updateSearch.add(jl_updateSearchName);jp_updateSearch.add(jt_updateSearch);
		 jp_updateName.add(jl_updateName);jp_updateName.add(jt_updateName);
		 jp_updateAddr.add(jl_updateAddr);jp_updateAddr.add(jt_updateAddr);
		 jp_updateButton.add(updateButton);jp_updateButton.add(updateReset);
		//panel add
		 update_subPanel.setLayout(new GridLayout(4,1));
		 update_subPanel.add(jp_updateSearch);update_subPanel.add(jp_updateName);update_subPanel.add(jp_updateAddr);
		 update_subPanel.add(jp_updateButton);
		 
		 updatePanel.add(update_subPanel);
		 main.add(updatePanel,BorderLayout.CENTER);
		 main.setVisible(true);
		 
		 MemberUpdateEvent updatObj = new MemberUpdateEvent();
		 jt_updateSearch.addActionListener(updatObj);
		 updateButton.addActionListener(updatObj);
		 updateReset.addActionListener(updatObj);
	}//update_Method//**
	
	class MemberUpdateEvent implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj==jt_updateSearch ) {
				updateList();
			}else if(obj==updateButton ) {
				if(updateFormCheck())updateProc();
			}else if(obj==updateReset ) {
				jt_updateSearch.setText("");
				jt_updateName.setText("");
				jt_updateAddr.setText("");
				jt_updateSearch.requestFocus();
			}
		}
	}//inner_class
	
	public void updateList() {
		//1.검색명 가져오기
		String uname = jt_updateSearch.getText().trim();
		MemberVO tvo =null;
		//2ArrayList에 MemberVO 객체에 있는 getName , getAddr
		
			for(MemberVO vo : MemberMgmUI.list) {
				if(vo.getName().equals(uname)) {
					tvo = vo;
				}
			}
			//3.검색결과 JOPtion
			if(tvo != null) {
				jt_updateName.setText(tvo.getName());
				jt_updateAddr.setText(tvo.getAddr());
			}else {
				JOptionPane.showMessageDialog(null, main.getMsg("검색된 회원이 없습니다"));
			}
		}//updateList()**//
	
	public boolean updateFormCheck() {
		boolean flag = false;
		if(jt_updateName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("수정할 아이디를 입력해주세요."));
			jt_updateName.requestFocus();
		}else if(jt_updateAddr.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("수정할 주소를 입력해주세요."));
			jt_updateAddr.requestFocus();
		}else {
			flag=true;
		}
		return flag;
	}//updateFormCheck()**//
	
	/**
	 * 4.수정
	 */
	public void updateProc() {
		String name = jt_updateSearch.getText().trim();
		
		for(MemberVO vo : MemberMgmUI.list) {
			if(vo.getName().equals(name)) {
				vo.setName(jt_updateName.getText());
				vo.setAddr(jt_updateAddr.getText());
				JOptionPane.showMessageDialog(null, main.getMsg("수정완료"));
			}
		}
	}//proc**//
	
}//class

