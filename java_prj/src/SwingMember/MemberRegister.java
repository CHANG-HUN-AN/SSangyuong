package SwingMember;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* swing �޼ҵ�� ������� ��� �и��ϱ� 1 ��Ϻκ�
 * @author user
 */
public class MemberRegister {
	//Field
	MemberMgmUI main;
	
	//ȸ����� �ʵ�
	JPanel totpane;
	JPanel regPanel,titlePanel,jp_name,jp_addr,buttonPanel,totPane;
	JLabel jl_name,jl_addr,jl_title;
	JTextField jt_name,jt_addr;
	JButton jb_register,jb_cancel;
	//**Constructor
	public MemberRegister() {
	}
	public MemberRegister(MemberMgmUI main) {
		this.main = main;
		this.totPane = main.totPane;
	}
		
	//**Method
		public void register() {
//			switchPane("register");
			main.switchPane(MemberMgmUI.REGISTER);
			
			//object 
			regPanel = new JPanel();
			jp_name = new JPanel();jp_addr = new JPanel();
			titlePanel=new JPanel();buttonPanel = new JPanel();
			jl_name = new JLabel("�̸�");jl_addr = new JLabel("�ּ�");jl_title= new JLabel("ȸ�������");
			jt_name = new JTextField(20);jt_addr = new JTextField(20);
			jb_register = new JButton("���");jb_cancel = new JButton("����");
			//font add
			jl_name.setFont(MemberMgmUI.font);jl_addr.setFont(MemberMgmUI.font);
			jl_title.setFont(MemberMgmUI.font);jb_register.setFont(MemberMgmUI.font);jb_cancel.setFont(MemberMgmUI.font);
			//sub panel add
			titlePanel.add(jl_title);
			jp_name.add(jl_name);jp_name.add(jt_name);
			jp_addr.add(jl_addr);jp_addr.add(jt_addr);
			buttonPanel.add(jb_register);buttonPanel.add(jb_cancel);
			//panel add
			regPanel.setLayout(new GridLayout(4,1));
			regPanel.add(titlePanel);
			regPanel.add(jp_name);regPanel.add(jp_addr);
			regPanel.add(buttonPanel);
			
			//UI�� �ִ�JFrame �� totPane ���� �ø��°�
			//main ��ü�� JFrame �� ��ӹ޾ұ⶧���� JFrame���� �����ϸ��
			totPane.add(regPanel);
			main.add(totPane,BorderLayout.CENTER);
			main.setVisible(true);
			
			MemberRegisterEvent regEvent = new MemberRegisterEvent();
			jb_register.addActionListener(regEvent);
			jb_cancel.addActionListener(regEvent);
		}//end register();
		
		//innner class event class
	public class MemberRegisterEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (jb_register == obj) {
//					JOptionPane.showMessageDialog(null, "��ϿϷ�");
				if (regFormcheck()) {
					registerProc();
				}
			} else if (jb_cancel == obj) {
				reset();
			}
		}
	}// end class

	// ��ư������ textField �ʱ�ȭ
	public void reset() {
		jt_name.setText("");
		jt_addr.setText("");
		jt_name.requestFocus();
	}
	/**
	 * ��ȿ��üũ
	 * @return
	 */
	public boolean regFormcheck() {
		boolean flag = false;
		if (jt_name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("�̸��� �Է����ּ���"));
			jt_name.requestFocus();
		} else if (jt_addr.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("�ּҸ� �Է����ּ���"));
			jt_name.requestFocus();
		} else {
			flag = true;
		}
		return flag;
	}
	/**
	 * ArrayList<MemberVO> ��ü�� add
	 */
	public void registerProc() {
		MemberVO vo = new MemberVO();
		vo.setName(jt_name.getText());
		vo.setAddr(jt_addr.getText());

		if (MemberMgmUI.list.add(vo)) {
			JOptionPane.showMessageDialog(null, main.getMsg("��ϼ���"));
		}
	}
}//class
