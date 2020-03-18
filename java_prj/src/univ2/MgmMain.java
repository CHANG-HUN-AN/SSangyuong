package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MgmMain extends JFrame {
	//@@0318(ach) jpanel 에 수강신청탭 추가
	StdRegCourse jp_couse;
	// Field
	JPanel JoinPane = new JPanel(new GridLayout(8, 1));
	JPanel jp_main, jp_stu, jp_score;
	JTabbedPane tabPane;

	// 로그인
	JPanel mainPane, menuPane, imgPane, showPane;
	JButton btnInfo, btnScore, btnExit;

	JPanel jp_logo, jp_title, jp_check, jp_id, jp_pass, jp_button;
	JLabel jl_limg, jl_title, jl_id, jl_pass;
	JTextField tid;
	JPasswordField tpass;
	JRadioButton jr_stu, jr_staff;
	JButton btnLogin, btnJoin;

	// 학생 성적
	JFrame jf_main;
	JPanel jp_info, jp_result;
	JLabel jl_info, jl_sname, jl_smajor, jl_total, jl_avg;
	JTextField jtf_name, jtf_major, jtf_total, jtf_avg;
	JTabbedPane tapPane;
	JTable scoreTable;
	JScrollPane scoll;
	// StudentMgmUI main;

	// 학생 정보
	JPanel infoPane, namePane, majorPane, noPane, phonePane, genderPane, emailPane, birthPane, buttonPane;
	JTabbedPane infoTab, scoreTab;
	JLabel jl_img, jl_name, jl_major, jl_no, jl_phone, jl_gender, jl_email, jl_birth;
	JTextField jt_name, jt_major, jt_no, jt_phone, jt_email, jt_birth;
	JRadioButton jrb_female, jrb_male;
	JButton jb_save, jb_reset;

	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);

	// Constructor
	public MgmMain() {
		login();
	}

	// Method
	public void login() {
		imgPane = new JPanel();
		showPane = new JPanel(new GridLayout(6, 1));
		jp_logo = new JPanel();
		jp_title = new JPanel();
		jp_check = new JPanel();
		jp_id = new JPanel();
		jp_pass = new JPanel();
		jp_button = new JPanel();

		jl_limg = new JLabel(new ImageIcon("src/univ2/sist.jpg"));
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
		jp_logo.add(jl_limg);
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

	public void showMain() {
		//@@0318(ach) tab에 수강신청 추가
		jp_couse = new StdRegCourse();
		
		jf_main = new JFrame();
		mainPane = new JPanel();
		jp_main = new JPanel();
		jp_stu = new JPanel();
		jp_score = new JPanel();
		tabPane = new JTabbedPane();

		// 학생 정보
		jp_stu = new JPanel();
		namePane = new JPanel();
		majorPane = new JPanel();
		noPane = new JPanel();
		phonePane = new JPanel();
		genderPane = new JPanel();
		emailPane = new JPanel();
		birthPane = new JPanel();
		buttonPane = new JPanel();

		jl_name = new JLabel("이름: ");
		jl_major = new JLabel("학과: ");
		jl_no = new JLabel("학번: ");
		jl_phone = new JLabel("연락처: ");
		jl_gender = new JLabel("성별: ");
		jl_email = new JLabel("이메일: ");
		jl_birth = new JLabel("생년월일: ");

		jrb_female = new JRadioButton("여자");
		jrb_male = new JRadioButton("남자");
		ButtonGroup gr_gender = new ButtonGroup();

		jt_name = new JTextField(20);
		jt_major = new JTextField(20);
		jt_no = new JTextField(20);
		jt_phone = new JTextField(20);
		jt_email = new JTextField(20);
		jt_birth = new JTextField(20);

		jb_save = new JButton("저장");
		jb_reset = new JButton("취소");

		jl_name.setFont(font);
		jl_major.setFont(font);
		jl_no.setFont(font);
		jl_phone.setFont(font);
		jl_gender.setFont(font);
		jl_email.setFont(font);
		jl_birth.setFont(font);

		namePane.add(jl_name);
		namePane.add(jt_name);

		majorPane.add(jl_major);
		majorPane.add(jt_major);

		noPane.add(jl_no);
		noPane.add(jt_no);

		phonePane.add(jl_phone);
		phonePane.add(jt_phone);

		gr_gender.add(jrb_female);
		gr_gender.add(jrb_male);
		genderPane.add(jl_gender);
		genderPane.add(jrb_female);
		genderPane.add(jrb_male);

		emailPane.add(jl_email);
		emailPane.add(jt_email);

		birthPane.add(jl_birth);
		birthPane.add(jt_birth);

		buttonPane.add(jb_save);
		buttonPane.add(jb_reset);

		jp_stu.add(namePane);
		jp_stu.add(majorPane);
		jp_stu.add(noPane);
		jp_stu.add(phonePane);
		jp_stu.add(genderPane);
		jp_stu.add(emailPane);
		jp_stu.add(birthPane);
		jp_stu.add(buttonPane);

		jp_stu.setLayout(new GridLayout(10, 1));

		// 학생 성적
		jp_info = new JPanel();
		jp_result = new JPanel();
		jl_sname = new JLabel("이름");
		jl_smajor = new JLabel("학과");
		jl_total = new JLabel("총점");
		jl_avg = new JLabel("평균");
		jtf_name = new JTextField(5);
		jtf_major = new JTextField(8);
		jtf_total = new JTextField(5);
		jtf_avg = new JTextField(5);
		tapPane = new JTabbedPane();

		String header[] = { "과목명", "성적", "등급", "담당교수" };
		String contents[][] = { { "과목1", "80", "B", "" }, { "과목2", "80", "B", "" }, { "과목3", "80", "B", "" },
				{ "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" },
				{ "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" },
				{ "과목4", "80", "B", "" } };
		scoreTable = new JTable(contents, header);
		scoll = new JScrollPane(scoreTable);

		jp_info.add(jl_sname);
		jp_info.add(jtf_name);
		jp_info.add(jl_smajor);
		jp_info.add(jtf_major);
		jp_result.add(jl_total);
		jp_result.add(jtf_total);
		jp_result.add(jl_avg);
		jp_result.add(jtf_avg);

		tabPane.addTab("메인", jp_main);
		tabPane.addTab("정보조회", jp_stu);
		tabPane.addTab("성적조회", jp_score);
		tabPane.addTab("수강신청", jp_couse);

		jp_score.add(jp_info);
		jp_score.add(scoll, BorderLayout.CENTER);
		jp_score.add(jp_result);

		mainPane.setLayout(new GridLayout(1, 1));
		mainPane.add(tabPane);
		
		

		// 프레임에 패널넣기
		jf_main.add(mainPane, BorderLayout.CENTER);

		// 프레임
		jf_main.setSize(600, 600);
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		SYUnivMgmUIEvent eventObj = new SYUnivMgmUIEvent(this);
		jf_main.setLocation(width, height);
		jf_main.setVisible(true);
		jf_main.addWindowListener(eventObj);
	}

	class SYUnivMgmUIEvent extends WindowAdapter implements ActionListener {
		MgmMain main;

		public SYUnivMgmUIEvent(MgmMain main) {
			this.main = main;
		}

		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (btnLogin == obj) {
				String bname = ae.getActionCommand();
				if (bname.equals("로그인") || tpass == ae.getSource()) {
					if (validationCheck())
						loginCheck();
				} else if (bname.equals("취소")) {
					tid.setText("");
					tpass.setText("");
				}
			} else if (btnJoin == obj) {
				new StdRegister(main).join();
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
				System.out.println("1111");
				setVisible(false);
				System.out.println("2222");
				showMain();
				System.out.println("3333");
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
