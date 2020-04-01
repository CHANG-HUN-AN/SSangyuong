package univ2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import univ2.AdminInfoDAO;
import univ2.AdminStdVO;
//import univ_0330.AdmInfoList.BtnEvent;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

/**
 * 관리자 로그인시 탭의 점수검색 > 상세정보
 */
public class AdmScoreList extends JFrame {
	//Field
	JPanel mainPane= new JPanel();//new GridLayout(8,1)
	JPanel nonamePane= new JPanel(new GridLayout(1,4));
	JPanel objectPane= new JPanel();//new GridLayout(1,3)
	JPanel tablePane= new JPanel(new GridLayout(1,3));
	JPanel topPane,bottomPane;
	JPanel jp_score;
	JPanel titlePane,namePane,noPane
	,majorPane,subPane,scorePane,gradePane,buttonPane;
	JButton btn_rename, btn_cancel;
	JTextField Num_textField,Name_textField
				,major_textField,Subject_textField
				,Score_textField,Grade_textField;
	
	String detailData;
	
	int column = 0;
	int row = 0;
	
	JTable scoreTable;
	JScrollPane scoll;
	
	//리스트
	AdmScoreDAO dao;
	Vector<Vector<String>> list; // List
	static Vector<String> COLNAME_LIST = new Vector<String>(); // Column
	
	//Constructor
	public AdmScoreList() {
		scoreFrame();
	}
	//오버로딩
		public AdmScoreList(Object detailData,AdmScoreDAO dao) {
			this.detailData = (String)detailData;
			this.dao = dao;
			scoreFrame();
		}
		
	//Method
	public void scoreFrame() {
		//contentPane = new JPanel(new GridLayout(10, 1));
		setTitle("SIST 대학교 학생 관리 프로그램 - 상세 성적");
		topPane = new JPanel(); bottomPane = new JPanel();
		
		jp_score = new JPanel();
		titlePane= new JPanel();
		namePane = new JPanel();
		noPane = new JPanel();
		majorPane = new JPanel();
		subPane = new JPanel();
		scorePane = new JPanel();
		gradePane = new JPanel();
		buttonPane = new JPanel();
		
		JLabel Title_Label = new JLabel("학생 성적 상세조회 및 수정");
		JLabel Label_name = new JLabel("이 름");
		JLabel Label_no = new JLabel("학 번");
		JLabel Label_major = new JLabel("학 과");
		JLabel Subject_Label = new JLabel("과목명");
		JLabel Score_Label = new JLabel("성적");
		JLabel Grade_Label = new JLabel("등급");
		
		Num_textField = new JTextField(8);
		Name_textField = new JTextField(8);
		major_textField = new JTextField(20);
		Subject_textField = new JTextField(5);
		Score_textField = new JTextField(5);
		Grade_textField = new JTextField(5);
		
		JButton btn_rename = new JButton("수 정");
		JButton btn_cancel = new JButton("취 소");
		
		Label_name.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Label_no.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Label_major.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btn_rename.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btn_cancel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		Subject_Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Score_Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Grade_Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Title_Label.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		
		Title_Label.setForeground(Color.ORANGE);
		titlePane.add(Title_Label);
		
		//contentPane.setLayout(new GridLayout(3,4));
		noPane.add(Label_no);
		noPane.add(Num_textField);
		
		namePane.add(Label_name);
		namePane .add(Name_textField);
		
		majorPane.add(Label_major);
		majorPane.add(major_textField);

		subPane.add(Subject_Label);
		subPane.add(Subject_textField);
		
		scorePane.add(Score_Label);
		scorePane.add(Score_textField);
		
		gradePane.add(Grade_Label);
		gradePane.add(Grade_textField);
	
		
		nonamePane.add(noPane);//0319
		nonamePane.add(namePane);//0319 위치변경
		
		//상단패널 박스레이아웃
		BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS);
		topPane.setLayout(boxLayout);
		
		topPane.add(titlePane);
		topPane.add(nonamePane);
		topPane.add(majorPane);
		
		//scoreTable = new JTable(contents, header);
		scoll = new JScrollPane(scoreTable);
		mainPane.add(scoll, BorderLayout.CENTER);
			
		
		objectPane.add(subPane); //0319 위치변경
		objectPane.add(scorePane);
		objectPane.add(gradePane);
		
		buttonPane.add(btn_rename);
		buttonPane.add(btn_cancel);
		
		//하단패널 박스패널로 변경 세로로 2개
		BoxLayout boxLayout2 =new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
		bottomPane.setLayout(boxLayout2);
		
		bottomPane.add(objectPane);
		bottomPane.add(buttonPane); //0319 위치변경
		
		setLayout(new GridLayout(3,1));
		add(topPane);
		add(mainPane);
		add(bottomPane);
		
		// db의 리스트 달기
		scoreInfo();
		scoreList();
		
		setSize(500,750);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);
		
//		setContentPane(mainPane);
//		mainPane.setLayout(null);
		// event 핸들러
		BtnEvent eventObj = new BtnEvent();
		addWindowListener(eventObj);
		btn_cancel.addActionListener(eventObj);
		btn_rename.addActionListener(eventObj);
		
		btn_rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}//End ScoreFrame
	
	
	//개인 정보란
	public void scoreInfo() {
		Vector<AdminStdVO> list = new Vector<AdminStdVO>();
		list = dao.getDetailScoreInfo(detailData);
		for(AdminStdVO vo : list) {
			Num_textField.setText(vo.getStdno());
			Name_textField.setText(vo.getSname());
			major_textField.setText(vo.getMname());
		}
	}
	
	//점수 테이블
	public void scoreList() {
		
	}
	
	
	
	
	public class BtnEvent extends WindowAdapter implements ActionListener {
		@Override
		public void windowClosing(WindowEvent we) {
			dispose(); // 새로운프레임종료
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();

			if (obj == btn_cancel) {
				System.out.println("취소합니다");
				dispose();
			} else if (obj == btn_rename) {
				System.out.println("수정합니다.");
			}
		}

	}
	
	
	
}//End class 
