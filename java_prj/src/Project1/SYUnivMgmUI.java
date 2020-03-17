package Project1;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SYUnivMgmUI extends JFrame {
	public static final int INFO = 1;

	JPanel mainPane, menuPane, imgPane, showPane;
	JButton btnInfo, btnScore, btnExit;

	JPanel jp_logo, jp_title, jp_check, jp_id, jp_pass, jp_button;
	JLabel jl_img, jl_title, jl_id, jl_pass;
	JTextField tid;
	JPasswordField tpass;
	JRadioButton jr_stu, jr_staff;
	JButton btnLogin, btnJoin;

	JPanel infoPane = new JPanel(new GridLayout(10, 1));
	JPanel joinPane = new JPanel(new GridLayout(10, 1));
	JPanel listPane = new JPanel();

	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);

	public SYUnivMgmUI() {
		showMain();
	}

	public void showMain() {
		imgPane = new JPanel();
		showPane = new JPanel(new GridLayout(6, 1));
		jp_logo = new JPanel();
		jp_title = new JPanel();
		jp_check = new JPanel();
		jp_id = new JPanel();
		jp_pass = new JPanel();
		jp_button = new JPanel();

		jl_img = new JLabel(new ImageIcon("src/Project1/sist.jpg"));
		jl_title = new JLabel("\n쌍용대학교 학사관리 시스템");
		jl_title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jl_id = new JLabel("아이디");
		jl_pass = new JLabel("비밀번호");

		tid = new JTextField(15);
		tpass = new JPasswordField(15);

		jr_stu = new JRadioButton("학생");
		jr_staff = new JRadioButton("관리자");

		btnLogin = new JButton("로그인");
		btnJoin = new JButton("회원가입");

		jl_id.setFont(font);
		jl_pass.setFont(font);
		btnLogin.setFont(font);
		btnJoin.setFont(font);
		jr_stu.setFont(font);
		jr_staff.setFont(font);

		// 패널에 라벨넣기
		jp_logo.add(jl_img);
		jp_title.add(jl_title);
		jp_check.add(jr_stu);
		jp_check.add(jr_staff);
		jp_id.add(jl_id);
		jp_id.add(tid);
		jp_pass.add(jl_pass);
		jp_pass.add(tpass);
		jp_button.add(btnLogin);
		jp_button.add(btnJoin);

		// 쇼패널에 패널넣기
		imgPane.add(jp_logo);
		showPane.add(jp_title);
		showPane.add(jp_check);
		showPane.add(jp_id);
		showPane.add(jp_pass);
		showPane.add(jp_button);

		// 프레임에 패널넣기
		add(imgPane, BorderLayout.NORTH);
		add(showPane, BorderLayout.CENTER);

		setSize(600, 600);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);

		// 이벤트 리스너
		SYUnivMgmUIEvent eventObject = new SYUnivMgmUIEvent(this);
		addWindowListener(eventObject);
		btnLogin.addActionListener(eventObject);
		btnJoin.addActionListener(eventObject);

	}

	public void studentStart() {
		showPane.setVisible(false);
		imgPane.setVisible(false);
		jp_button.setVisible(false);

		mainPane = new JPanel();
		menuPane = new JPanel(new GridLayout(6, 1));

		jl_img = new JLabel(new ImageIcon("src/Project1/sist.jpeg"));

		btnInfo = new JButton("정보조회");
		btnScore = new JButton("성적조회");
		btnExit = new JButton("종료");

		btnInfo.setFont(font);
		btnScore.setFont(font);
		btnExit.setFont(font);

		mainPane.add(jl_img);

		menuPane.add(btnInfo);
		menuPane.add(btnScore);
		menuPane.add(btnExit);

		add(menuPane, BorderLayout.WEST);
		add(mainPane, BorderLayout.CENTER);

		setSize(600, 600);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);

		SYUnivMgmUIEvent eventObj = new SYUnivMgmUIEvent(this);
		addWindowListener(eventObj);
		btnInfo.addActionListener(eventObj);
		btnExit.addActionListener(eventObj);

	}

	public void resetPane() {
		mainPane.setVisible(false);
	}

	public void switchPane(int menu) {
		resetPane();
		switch (menu) {
		case 1:
			listPane.removeAll();
			listPane.setVisible(true);
			break;
		}
	}

	class SYUnivMgmUIEvent extends WindowAdapter implements ActionListener {
		SYUnivMgmUI main;

		public SYUnivMgmUIEvent(SYUnivMgmUI main) {
			this.main = main;
		}

		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (btnInfo == obj) {
				new StudentList(main).list();
			} else if (btnExit == obj) {
				int result = JOptionPane.showConfirmDialog(null, "프로그램 종료하시겠습니까?");
				if (result == 0) {
					System.exit(0);
				}
			} else if (btnLogin == obj) {
				String bname = ae.getActionCommand();

				if (bname.equals("로그인") || tpass == ae.getSource()) {
					if (validationCheck())
						loginCheck();
				} else if (bname.equals("취소")) {
					tid.setText("");
					tpass.setText("");
					setVisible(true);
				}
			} else if (btnJoin == obj) {
				new SYUJoin(main).join();
			}
		}
	}

	// Method
	/** 데이터 유효성 체크 **/
	public boolean validationCheck() {
		boolean result = false;
		// tid, tpass에 값이 없으면 메시지를 띄움
		if (tid.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
			tid.requestFocus();
		} else if (tpass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요");
			tpass.requestFocus();
		} else {
			result = true;
		}

		return result;
	}

	/** 로그인 체크 **/
	public void loginCheck() {
		String did = "test";
		String dpass = "1234";
		String uid = tid.getText().trim();
		String upass = tpass.getText().trim();

		if (did.equals(uid)) {

			if (dpass.equals(upass)) {
				// 로그인성공 : id,pass 동일
				JOptionPane.showMessageDialog(null, "로그인 성공");
				setVisible(false);
//				studentStart(); 학생 정보 조회
				new MgmSystemUI();

			} else {
				// 로그인 실패 : id 동일, pass 다름
				JOptionPane.showMessageDialog(null, "로그인 실패, 패스워드가 다름");
			}
		} else {
			// System.out.println("로그인 실패");
			JOptionPane.showMessageDialog(null, "로그인 실패, 아이디 다름");
		}
	}

}
