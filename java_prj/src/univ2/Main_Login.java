package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import univ2.Main_Register;

public class Main_Login extends JFrame {
	// Field
	JPanel mainPane, menuPane, imgPane, showPane;
	// JButton btnInfo, btnScore, btnExit;

	JPanel jp_logo, jp_title, jp_check, jp_id, jp_pass, jp_button, jp_find;
	JLabel jl_limg, jl_title, jl_id, jl_pass, jl_sid, jl_spass;
	JTextField tid;
	JPasswordField tpass;
	JRadioButton jr_stu, jr_staff, jr_profe;
	JButton btnLogin, btnInfo;

	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);

	JPanel JoinPane = new JPanel(new GridLayout(9, 1));

	StdDAO sdao;
	ProDAO pdao;

	// Constructor
	public Main_Login() {
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//			JFrame.setDefaultLookAndFeelDecorated(true);
//			showLogin();
//		} catch (Exception e) {
//		}
		showLogin();
		sdao = new StdDAO();
		pdao = new ProDAO();
	}

	// Method
	public void showLogin() {
		imgPane = new JPanel();
		showPane = new JPanel(new GridLayout(6, 1));
		jp_logo = new JPanel();
		jp_title = new JPanel();
		jp_check = new JPanel();
		jp_id = new JPanel();
		jp_pass = new JPanel();
		jp_button = new JPanel();
		jp_find = new JPanel();

		jl_limg = new JLabel(new ImageIcon("src/univ2/sist.jpg"));
		jl_title = new JLabel("\n쌍용대학교 학사관리 시스템");
		jl_title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jl_id = new JLabel("ID(학번) ");
		jl_pass = new JLabel("비밀번호");
		jl_sid = new JLabel("아이디찾기");
		jl_spass = new JLabel("| 비밀번호찾기");

		tid = new JTextField(15);
		tpass = new JPasswordField(15);

		jr_stu = new JRadioButton("학생");
		jr_staff = new JRadioButton("관리자");
		jr_profe = new JRadioButton("교수");
		ButtonGroup user = new ButtonGroup();

		btnLogin = new JButton("로그인");
		btnInfo = new JButton("도움말");

		btnLogin.setBorderPainted(false); // 버튼 테두리
		btnLogin.setFocusPainted(false); // 버튼 클릭시 테두리
		btnLogin.setBackground(new Color(126, 126, 126)); // 버튼 색
		btnLogin.setForeground(Color.white); // 버튼 글자색
		btnInfo.setBorderPainted(false);
		btnInfo.setFocusPainted(false);
		btnInfo.setBackground(new Color(126, 126, 126));
		btnInfo.setForeground(Color.white);

		jl_id.setFont(font);
		jl_pass.setFont(font);
		jl_sid.setFont(font);
		jl_spass.setFont(font);
		btnLogin.setFont(font);
		btnInfo.setFont(font);
		jr_stu.setFont(font);
		jr_profe.setFont(font);
		jr_staff.setFont(font);

		// 패널에 라벨넣기
		user.add(jr_stu);
		user.add(jr_staff);
		user.add(jr_profe);
		jp_logo.add(jl_limg);
		jp_title.add(jl_title);
		jp_check.add(jr_stu);
		jp_check.add(jr_profe);
		jp_check.add(jr_staff);
		jp_id.add(jl_id);
		jp_id.add(tid);
		jp_pass.add(jl_pass);
		jp_pass.add(tpass);
		jp_button.add(btnLogin);
		jp_button.add(btnInfo);
		jp_find.add(jl_sid);
		jp_find.add(jl_spass);

		// 쇼패널에 패널넣기
		imgPane.add(jp_logo);
		showPane.add(jp_title);
		showPane.add(jp_check);
		showPane.add(jp_id);
		showPane.add(jp_pass);
		showPane.add(jp_button);
		showPane.add(jp_find);

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
		StdUIEvent eventObj = new StdUIEvent();
		addWindowListener(eventObj);
		btnLogin.addActionListener(eventObj);
		btnInfo.addActionListener(eventObj);
		jl_sid.addMouseListener(eventObj);
		jl_spass.addMouseListener(eventObj);
		jr_stu.addActionListener(eventObj);
		jr_profe.addActionListener(eventObj);
		jr_staff.addActionListener(eventObj);
	}

	class StdUIEvent extends WindowAdapter implements ActionListener, MouseListener {
		Main_Login main;

		public StdUIEvent() {
		}

		public StdUIEvent(Main_Login main) {
			this.main = main;
		}

		public void windowClosing(WindowEvent we) {
			JOptionPane.showMessageDialog(null, "프로그램 종료");
			System.exit(0);
		}

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (jr_stu.isSelected()) { // 학생
				if (btnLogin == obj) {
					String bname = ae.getActionCommand();
					if (bname.equals("로그인") || tpass == ae.getSource()) {
						if (validationCheck())
							stdLoginCheck();
					} else if (bname.equals("취소")) {
						tid.setText("");
						tpass.setText("");
					}
				} else if (btnInfo == obj) {
					new Main_Info();
				}
			} else if (jr_profe.isSelected()) { // 교수
				if (btnLogin == obj) {
					String bname = ae.getActionCommand();
					if (bname.equals("로그인") || tpass == ae.getSource()) {
						if (validationCheck())
							proLoginCheck();
					} else if (bname.equals("취소")) {
						tid.setText("");
						tpass.setText("");
					}
				} else if (btnInfo == obj) {
					new Main_Info();
				}
			} else if (jr_staff.isSelected()) { // 관리자
				if (btnLogin == obj) {
					String bname = ae.getActionCommand();
					if (bname.equals("로그인") || tpass == ae.getSource()) {
						if (validationCheck())
							adminLoginCheck();
					} else if (bname.equals("취소")) {
						tid.setText("");
						tpass.setText("");
					}
				} else if (btnInfo == obj) {
					new Main_Info();
				}
			} else if (btnLogin == obj) {
				JOptionPane.showMessageDialog(null, "학생 / 교수 / 관리자 선택");
			} else if (btnInfo == obj) {
				new Main_Info();
			}

		}

		public void mouseClicked(MouseEvent me) {
			Object obj = me.getSource();
			if (jl_sid == obj) {
				new StdId();
			} else if (jl_spass == obj) {
				new StdPass();
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

	}// StdUIEvent class

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

	/**
	 * 학생 로그인
	 */
	public void stdLoginCheck() {
		String uid = tid.getText().trim();
		String upass = tpass.getText().trim();
		int result = sdao.stdLogin(uid, upass);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "로그인 성공");
			setVisible(false);
			new StdUI(uid).mainStart();

		} else if (result == 0) {
			JOptionPane.showMessageDialog(null, "로그인 실패, 패스워드가 다름");

		} else if (result == -1) {
			JOptionPane.showMessageDialog(null, "로그인 실패, 아이디 다름");
		}
	}

	/**
	 * 교수 로그인
	 */
	public void proLoginCheck() {
		String uid = tid.getText().trim();
		String upass = tpass.getText().trim();
		int result = pdao.proLogin(uid, upass);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "로그인 성공");
			setVisible(false);
			new ProUI().mainFrame();

		} else if (result == 0) {
			JOptionPane.showMessageDialog(null, "로그인 실패, 패스워드가 다름");

		} else if (result == -1) {
			JOptionPane.showMessageDialog(null, "로그인 실패, 아이디 다름");
		}
	}

	/**
	 * 관리자 로그인
	 */
	public void adminLoginCheck() {
		String did = "admin";
		String dpass = "0000";
		String uid = tid.getText().trim();
		String upass = tpass.getText().trim();

		if (did.equals(uid)) {
			if (dpass.equals(upass)) {
				// 로그인성공 : id,pass 동일
				JOptionPane.showMessageDialog(null, "로그인 성공");
				setVisible(false);
				new AdmUI().mainFrame();
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