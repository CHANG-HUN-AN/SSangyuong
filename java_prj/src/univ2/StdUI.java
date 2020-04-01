package univ2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
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
import javax.swing.UIManager.LookAndFeelInfo;

public class StdUI extends JFrame {
	// Field
	private static final int MAX = 5;
	
	static String uid;

	JPanel mainPane, menuPane, imgPane, showPane;
	JButton btnInfo, btnScore, btnExit;

	JPanel jp_logo, jp_title, jp_check, jp_id, jp_pass, jp_button;
	JLabel jl_limg, jl_title, jl_id, jl_pass;
	JTextField tid;
	JPasswordField tpass;
	JRadioButton jr_stu, jr_staff;
	JButton btnLogin, btnJoin;

	JFrame jf_main;
	JPanel jp_main;
	JTabbedPane tabPane;
	StdInfo tab_stuInfo;
	StdScore tab_stuScore;
	StdRegCourse tab_stuReg;
	public static Font FONT = new Font("맑은 고딕", Font.BOLD, 12);
	public static Font TITLEFONT = new Font("맑은 고딕", Font.BOLD, 12);
	JPanel JoinPane = new JPanel(new GridLayout(9, 1));

	// Constructor
//	public StdUI() {//0401(n) 테스트용도 
//		mainStart();
//	}
	public StdUI(String uid) {
		try {
			this.uid = uid;
//			System.out.println("확인222" + uid);
			// 메탈
//			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

			// Nimbus
//		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//		        if ("Nimbus".equals(info.getName())) {
//		            UIManager.setLookAndFeel(info.getClassName());
//		            break;
//		        }
//		    }
			// 윈도우
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			mainStart();
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

	}

	// Method
//	public void mainStart(String uid) {
//		
//	}
	public void mainStart() {
		// jf_main = new JFrame(); // 메인
//		System.out.println("확인111" + uid);
		tab_stuInfo = new StdInfo();
		tab_stuScore = new StdScore();
		tab_stuReg = new StdRegCourse();
		
		jp_main = new JPanel();

		tabPane = new JTabbedPane();

		tabPane.addTab("HOME", jp_main);
		tabPane.addTab("정보 조회", tab_stuInfo);
		tabPane.addTab("성적 조회", tab_stuScore);
		tabPane.addTab("수강신청", tab_stuReg);
		tabPane.setFont(FONT);

		// tabPane.setSelectedIndex(1); // 실행될 때 기본으로 보여지는 탭

		tabPane.setForeground(new Color(93, 93, 93)); // 탭 글자 색
		tabPane.setBackground(Color.WHITE); // 탭 기본 색
		// tabPane.setForegroundAt(2, Color.RED); // 탭 글자 색상 개별 설정
		// tabPane.setBackgroundAt(2, Color.LIGHT_GRAY); // 탭 색상 개별 설정

		// tab_stuInfo.setBackground(new Color(255, 0, 0, 0));

		add(tabPane);
		setSize(600, 600);
		// location center
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		setVisible(true);

		StdMainEvent eventObj = new StdMainEvent();
		addWindowListener(eventObj);
	}

	class StdMainEvent extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			JOptionPane.showMessageDialog(null, "프로그램 종료");
			System.exit(0);
		}
	}
}