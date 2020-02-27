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
* swing 메소드로 만들어진 기능 분리하기 1 등록부분
 * @author user
 */
public class MemberRegister {
	//Field
	MemberMgmUI main;
	
	//회원등록 필드
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
			jl_name = new JLabel("이름");jl_addr = new JLabel("주소");jl_title= new JLabel("회원등록폼");
			jt_name = new JTextField(20);jt_addr = new JTextField(20);
			jb_register = new JButton("등록");jb_cancel = new JButton("리셋");
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
			
			//UI에 있는JFrame 의 totPane 위에 올리는것
			//main 자체가 JFrame 을 상속받았기때문에 JFrame으로 생각하면됨
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
//					JOptionPane.showMessageDialog(null, "등록완료");
				if (regFormcheck()) {
					registerProc();
				}
			} else if (jb_cancel == obj) {
				reset();
			}
		}
	}// end class

	// 버튼누르면 textField 초기화
	public void reset() {
		jt_name.setText("");
		jt_addr.setText("");
		jt_name.requestFocus();
	}
	/**
	 * 유효성체크
	 * @return
	 */
	public boolean regFormcheck() {
		boolean flag = false;
		if (jt_name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("이름을 입력해주세요"));
			jt_name.requestFocus();
		} else if (jt_addr.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("주소를 입력해주세요"));
			jt_name.requestFocus();
		} else {
			flag = true;
		}
		return flag;
	}
	/**
	 * ArrayList<MemberVO> 객체에 add
	 */
	public void registerProc() {
		MemberVO vo = new MemberVO();
		vo.setName(jt_name.getText());
		vo.setAddr(jt_addr.getText());

		if (MemberMgmUI.list.add(vo)) {
			JOptionPane.showMessageDialog(null, main.getMsg("등록성공"));
		}
	}
}//class
