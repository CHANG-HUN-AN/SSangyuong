package day0224;

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

public class JFrameObject {

	//Field
	JFrame jf;
	JTextField tid;
	JTextField tpass;
	//Constructor
	public JFrameObject() {
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		jf = new JFrame("로그인폼생성");
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pass = new JPanel();
		JPanel jp_button = new JPanel();
		
		JLabel title = new JLabel("로그인폼");
		JLabel id = new JLabel("아이디");
		JTextField tid = new JTextField(15);
		this.tid =tid; 
		JLabel pass = new JLabel("비밀번호");
		JTextField tpass= new JTextField(15);
		this.tpass = tpass;
		JButton btnLogin = new JButton("로그인");
		JButton btnReset = new JButton("취소");
		JButton btnExit = new JButton("종료");
		//font 변경
		title.setFont(font);
		id.setFont(font);
		pass.setFont(font);
//		jf.add(title,BorderLayout.NORTH);
		//로그인폼
		jf.setLayout(new GridLayout(4,1));
		jp_title.add(title);
		//아이디
		jp_id.add(id);
		jp_id.add(tid);
		//비밀번호
		jp_pass.add(pass);
		jp_pass.add(tpass);
		//버튼
		jp_button.add(btnLogin);
		jp_button.add(btnReset);
		jp_button.add(btnExit);
		
		jf.add(jp_title);
		jf.add(jp_id);
		jf.add(jp_pass);
		jf.add(jp_button);
		
		jf.setSize(300,350);
		jf.setVisible(true);
		//모니터사이즈에 맞춰 정가운데에 맞춰서 놓기
		Dimension fsize = jf.getSize(); //jframe 사이드 setsize크기
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); //toolkit.getDefaultToolkit 으로 tookit의 호출 
		//getScreensize Dimension타입반환 ->현재의 모니터 사이즈크기를 가져옴
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2; //모니터 - 프레임크기 /2 
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		
		jf.setLocation(width,height);
//		Toolkit t = new Toolkit() ;//toolkit 객체 생성 안됨 위에처럼 해getDefaultToolkit 을 통해 static 객체로 만들어 사용해야함
		
//		System.out.println("width ="+fsize.getWidth() +"height"+ fsize.getHeight());
		
		//event handler 메소드 호출 (=add~listener 메소드호출) 
		JFrameObjectEvent eventObject = new JFrameObjectEvent();
		jf.addWindowListener(eventObject);
		btnLogin.addActionListener(eventObject);
		btnReset.addActionListener(eventObject);
		btnExit.addActionListener(eventObject);
		tpass.addActionListener(eventObject);
		//add~Listener 를 통해 ui와 event 를 연결 
		//WindowAdapter 의 event 처리 객체(listener 인터페이스 상속받음)
//		jf.addWindowListener(new WindowAdapter() {
//			public void  windowClosing(WindowEvent e) {
//				System.out.println("==========프로그램종료=========");
//				System.exit(0);
//			}
//		});
	}
	//이벤트를 처리하는 inner class =scope 은 메소드정도로 보면된다.
	class JFrameObjectEvent extends WindowAdapter implements ActionListener{
		public void  windowClosing(WindowEvent e) {
			System.out.println("==========프로그램종료=========");
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String bname = e.getActionCommand();
			if(bname.equals("로그인")) {
				String did = "test";
				String dpass ="1234";
				String uid = tid.getText().trim();
				String upass = tpass.getText().trim();
				if(uid.equals(did) ) {
					if(upass.equals(dpass)) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패,비밀번호 오류입니다.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패,아이디를 다시입력하십시오","실패",2);
				}
			}else if(bname.equals("취소")) {
				tid.setText("");
				tpass.setText("");
			}else if(bname.equals("종료")){
				System.out.println("종료버튼이 클릭되었습니다.");
				System.exit(0);
			}else if(tpass == e.getSource()) {//로그인 엔터로 확인하기
				if(bname.equals("로그인")) {
					String did = "test";
					String dpass ="1234";
					String uid = tid.getText().trim();
					String upass = tpass.getText().trim();
					if(uid.equals(did) ) {
						if(upass.equals(dpass)) {
							JOptionPane.showMessageDialog(null, "로그인 성공");
						}else {
							JOptionPane.showMessageDialog(null, "로그인 실패,비밀번호 오류입니다.");
						}
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패,아이디를 다시입력하십시오","실패",2);
					}
				}else if(bname.equals("취소")) {
					tid.setText("");
					tpass.setText("");
				}else if(bname.equals("종료")){
					System.out.println("종료버튼이 클릭되었습니다.");
					System.exit(0);
				}
		}
	}
	}
	//Method
	
}
