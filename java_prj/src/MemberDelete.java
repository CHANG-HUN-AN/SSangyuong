package member2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberDelete {
	//Field
	JPanel jp_deleteSearch;
	JLabel jl_deleteSearchName;
	JTextField jt_deleteSearch;
	MemberMgmUI main;
	JPanel deletePane;
	
	//Constructor
	public MemberDelete() {}
	public MemberDelete(MemberMgmUI main) {
		this.main = main;
		this.deletePane = main.deletePane;		
	}
	
	//Method
	//delete
	public void delete() {
		//switchPane("delete");
		System.out.println("---------->> delete()");
		main.switchPane(MemberMgmUI.DELETE);
		
		jp_deleteSearch = new JPanel();
		jl_deleteSearchName = new JLabel("������>>");
		jt_deleteSearch = new JTextField(20);
		jl_deleteSearchName.setFont(MemberMgmUI.font);
		
		jp_deleteSearch.add(jl_deleteSearchName);
		jp_deleteSearch.add(jt_deleteSearch);
		deletePane.add(jp_deleteSearch);
		
		main.add(deletePane, BorderLayout.CENTER);
		main.setVisible(true);
		
		jt_deleteSearch.addActionListener(new MemberDeleteEvent());		

	}//delete method
	
	//deleteDataCheck
	public boolean deleteDataCheck() {
		boolean result = false;		
		String name = jt_deleteSearch.getText();
		for(MemberVO vo : MemberMgmUI.list) {
			if(vo.getName().equals(name)) result = true;
		}
		return result;
	}
	
	//deleteProc
	public void deleteProc() {
		String name = jt_deleteSearch.getText();
		for(MemberVO vo : MemberMgmUI.list) {
			if(vo.getName().equals(name)) 
				if(MemberMgmUI.list.remove(vo)) {
					JOptionPane.showMessageDialog(null,
							main.getMsg("������ �Ϸ�Ǿ����ϴ�."));
				}					
		}		
	}//deleteProc
	
	//�̺�Ʈ ó�� Ŭ����
	class MemberDeleteEvent implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			if(deleteDataCheck()) {
				int result = JOptionPane.showConfirmDialog(null,
						main.getMsg("������ �����Ͻðڽ��ϱ�?"));
				
				if(result == 0)  deleteProc();
			}else {
				//������ ������ ����
				JOptionPane.showMessageDialog(null,
						main.getMsg("������ �����Ͱ� �������� �ʽ��ϴ�."));
			}
		}
	}
	
}//class














