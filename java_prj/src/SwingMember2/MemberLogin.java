package SwingMember2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Toolkit;

public class MemberLogin {

	MemberMgmUI main;
	//Field
	JFrame jf;
	JTextField jt_id, jt_pass;
	JButton btnLogin,btnReset,btnExit;
	//Constructor
	public MemberLogin(MemberMgmUI main) {
		this.main = main;
		//Object
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		jf = new JFrame("로그인폼생성");
		JPanel jp_title = new JPanel();JPanel jp_id = new JPanel();JPanel jp_pass = new JPanel();JPanel jp_button = new JPanel();
		JLabel jl_title = new JLabel("로그인폼");JLabel jl_id = new JLabel("아이디");JLabel jl_pass = new JLabel("비밀번호");
		jt_id = new JTextField(15); jt_pass= new JTextField(15);
		btnLogin = new JButton("로그인"); btnReset = new JButton("취소"); btnExit = new JButton("종료");
		//Field _declare
//		this.jt_id =jt_id; 
//		this.jt_pass = jt_pass;
		//font 변경
		jl_title.setFont(font);jl_id.setFont(font);jl_pass.setFont(font);
		//로그인폼 panel_add
		jf.setLayout(new GridLayout(4,1));
		jp_title.add(jl_title);
		jp_id.add(jl_id);jp_id.add(jt_id);
		jp_pass.add(jl_pass);jp_pass.add(jt_pass);
		//버튼 panel _add
		jp_button.add(btnLogin);jp_button.add(btnReset);jp_button.add(btnExit);
		//JFrame_panel_add
		jf.add(jp_title);jf.add(jp_id);jf.add(jp_pass);jf.add(jp_button);
		//midScreen_set
		jf.setSize(300,350);
		jf.setVisible(true);
		Dimension fsize = jf.getSize(); //jframe 사이드 setsize크기
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); //toolkit.getDefaultToolkit 으로 tookit의 호출
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2; //모니터 - 프레임크기 /2 
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		jf.setLocation(width,height);
//		Toolkit t = new Toolkit() ;//toolkit 객체 생성 안됨 위에처럼 해getDefaultToolkit 을 통해 static 객체로 만들어 사용해야함
		
		//event handler 메소드 호출 (=add~listener 메소드호출) 
		JFrameObjectEvent eventObject = new JFrameObjectEvent();
		jf.addWindowListener(eventObject);
		btnLogin.addActionListener(eventObject);
		btnReset.addActionListener(eventObject);
		btnExit.addActionListener(eventObject);
		jt_pass.addActionListener(eventObject);
	}
	
	//이벤트를 처리하는 inner class =scope 은 메소드정도로 보면된다.
	class JFrameObjectEvent extends WindowAdapter implements ActionListener{
		public void  windowClosing(WindowEvent e) {
			System.out.println("==========프로그램종료=========");
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == btnLogin || jt_pass == ae.getSource()) {
				System.out.println("로그인됨");
				if(valitdationCheck()) {
					logincheck();
				}
			}else if(obj == btnReset) {
				jt_id.setText("");
				jt_pass.setText("");
			}else if(obj == btnExit){
				System.exit(0);
			}
		}
	}
	
	//Method
	public boolean valitdationCheck() {//데이터 유효성 체크
		//jt_id , jt_pass 의 값이 없으면 메시지 호출
		boolean count = false;
		if (jt_id.getText().equals("") ) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요","실패",2);
			jt_id.requestFocus();
		}else if(jt_pass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요","실패",2);
			jt_pass.requestFocus();
		}else {
			count = true;
		}
		return count;
	}//validation**//
	
	public void logincheck() {
		String did = "test";
		String dpass ="1234";
		String uid = jt_id.getText().trim();
		String upass = jt_pass.getText().trim();
		
		if(uid.equals(did) ) {
			if(upass.equals(dpass)) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				jf.setVisible(false);
				main.start(); //Error  java.lang.NullPointerException ->main값 생성자로 넘겨받을때 오류
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패,비밀번호 오류입니다.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "로그인 실패,아이디를 다시입력하십시오","실패",2);
		}
	}//loginCheck()
	
}//class
