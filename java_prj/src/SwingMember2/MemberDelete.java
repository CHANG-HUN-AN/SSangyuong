package SwingMember2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberDelete {
	MemberMgmUI main;
	
	//Field
	JPanel deletePane;
	JPanel jp_deltetSearch;
	JLabel jl_deleteSearchName;
	JTextField jt_deleteSearch;
	//Consturctor
	public MemberDelete() {
		// TODO Auto-generated constructor stub
	}
	public MemberDelete(MemberMgmUI main) {
		this.main = main;
		this.deletePane = main.deletePane;
	}
	//Method
	public void delete() {
//		switchPane("delete");
		main.switchPane(MemberMgmUI.DELETE);
		// object
		jp_deltetSearch = new JPanel();
		jl_deleteSearchName = new JLabel("삭제명>>");
		jt_deleteSearch = new JTextField(20);
		// font_set
		jl_deleteSearchName.setFont(main.font);
		// component_add
		jp_deltetSearch.add(jl_deleteSearchName);
		jp_deltetSearch.add(jt_deleteSearch);
		// panel_add
		deletePane.add(jp_deltetSearch);

		main.add(deletePane);
		main.setVisible(true);

		jt_deleteSearch.addActionListener(new MemberDeleteEvent());
	}// delete_Method//**
	
	/**
	 * listener 에 등록이 필요한 inner Class _Event 객체; 
	 * @author user
	 */
	public class MemberDeleteEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(! jt_deleteSearch.getText().equals("")) {
				String name =jt_deleteSearch.getText().trim();
				if (deleteDataCheck(name)) {
					int flag = JOptionPane.showConfirmDialog(null, main.getMsg("정말 삭제하시겠습니까?"), "확인", 0);
					if (flag == 0) {
						deleteProc(name);
					}
				}else {
					JOptionPane.showMessageDialog(null, main.getMsg("삭제할 데이터가 존재하지않습니다."));
				}
			}else {
				JOptionPane.showMessageDialog(null, main.getMsg("삭제할 이름을 입력해주세요."));
				jt_deleteSearch.requestFocus();
			}
		}
	}//inner_class
	
	public boolean deleteDataCheck(String name) {
		boolean result = false;		
		for (MemberVO vo : MemberMgmUI.list) {
			if (vo.getName().equals(name)) {
				result = true;
			}
		}
		return result;
	}//deleteDataCheck()**//
	
//	public boolean deleteFormCheck() {
//		boolean flag =false;
//		if(jt_deleteSearch.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, main.getMsg("삭제할 이름을 입력해주세요."));
//			jt_deleteSearch.requestFocus();
//		}else {
//			flag=true;
//		}
//		return flag;
//	}//deleteDateCheck();;**/
	
	public void deleteProc(String name) {//Error -> ArrayList 의 데이터 한개남았을때 지우면 오류발생 처리:Iterator 로 해결
//		String name = jt_deleteSearch.getText();
		Iterator<MemberVO> it = MemberMgmUI.list.iterator();
		while(it.hasNext()) {
			MemberVO vo = it.next();
			if(vo.getName().equals(name)) {
				it.remove(); 
				JOptionPane.showMessageDialog(null, main.getMsg("삭제완료"));
			}
		}
//		for (MemberVO vo : MemberMgmUI.list) {
//			if (vo.getName().equals(dname)) {
//				if (MemberMgmUI.list.remove(vo)) {
//					JOptionPane.showMessageDialog(null, main.getMsg("삭제완료"));
//				}
//			}
//		}
	}// Proc**//
}//class
