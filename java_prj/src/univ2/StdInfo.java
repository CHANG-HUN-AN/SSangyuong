package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class StdInfo extends JPanel{
	// Field
	JPanel centerPane;
	JPanel infoPane, titlePane, namePane, passPane, majorPane, noPane, phonePane, genderPane, spacePane, birthPane,
			buttonPane;
	JTabbedPane infoTab, scoreTab;
	JLabel jl_title, jl_img, jl_name, jl_pass, jl_major, jl_no, jl_phone, jl_gender, jl_birth;
	JTextField jt_name, jt_major, jt_no, jt_gender, jt_pass, jt_phone, jt_birth;
	JRadioButton jrb_female, jrb_male;
	JButton jb_save, jb_reset;

	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);
	public static Font titleFont = new Font("맑은 고딕", Font.BOLD,20); 
	
	StdDAO dao;
	StdVO vo;
	
	// Constructor
	public StdInfo() {
		dao = new StdDAO();
		vo = new StdVO();
		infoStart();
	}

	// Method
	public void infoStart() {
		// 학생 정보
		centerPane = new JPanel();
		infoPane = new JPanel(new GridLayout(9, 1));
		titlePane = new JPanel();
		namePane = new JPanel();
		passPane = new JPanel();
		majorPane = new JPanel();
		noPane = new JPanel();
		phonePane = new JPanel();
		genderPane = new JPanel();
		spacePane = new JPanel();
		birthPane = new JPanel();
		buttonPane = new JPanel();
		
		jl_title = new JLabel("학생 정보 조회");
		jl_major = new JLabel("학과: ");
		jl_no = new JLabel("학번: ");
		jl_name = new JLabel("이름: ");
		jl_pass = new JLabel("비밀번호: ");
		jl_phone = new JLabel("연락처: ");
		jl_gender = new JLabel("성별: ");
		jl_birth = new JLabel("생년월일: ");

//		jrb_female = new JRadioButton("여자");
//		jrb_male = new JRadioButton("남자");
//		ButtonGroup gr_gender = new ButtonGroup();

		jt_major = new JTextField(20);
		jt_no = new JTextField(20);
		jt_name = new JTextField(20);
		jt_pass = new JTextField(20);
		jt_phone = new JTextField(20);
		jt_gender = new JTextField(15);
		jt_birth = new JTextField(20);
		
		// 출력하기
		vo = dao.stdInfoList(StdUI.uid);
		jt_major.setText(vo.getMname());
		jt_no.setText(vo.getStdno());
		jt_name.setText(vo.getSname());
		jt_pass.setText(vo.getPw());
		jt_phone.setText(vo.getPh());
		jt_gender.setText(vo.getGender());
		jt_birth.setText(vo.getBirth());
		
		jb_save = new JButton("저장");
		jb_reset = new JButton("취소");

		jl_title.setFont(titleFont);
		jl_name.setFont(font);
		jl_major.setFont(font);
		jl_pass.setFont(font);
		jl_no.setFont(font);
		jl_phone.setFont(font);
		jl_gender.setFont(font);
		jl_birth.setFont(font);

		//setborder를 통해 타이틀 생성 compoundBorder( ouside , insideborder에 색주기)
		jl_title.setLayout(new BorderLayout());
		jl_title.setBorder(new CompoundBorder(new EmptyBorder(8, 4, 4, 4), new MatteBorder(0, 0, 0, 0,Color.BLACK)));
		titlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 150, 8, 150), new MatteBorder(1, 1, 1, 1, Color.BLACK)));
		
		titlePane.add(jl_title);
		majorPane.add(jl_major);
		majorPane.add(jt_major);
		noPane.add(jl_no);
		noPane.add(jt_no);
		namePane.add(jl_name);
		namePane.add(jt_name);
		passPane.add(jl_pass);
		passPane.add(jt_pass);
		phonePane.add(jl_phone);
		phonePane.add(jt_phone);
//		genderPane.setBorder(new CompoundBorder(new EmptyBorder(0, 4,0, 60), new MatteBorder(0, 0, 0, 0, Color.BLACK)));
//		gr_gender.add(jrb_female);
//		gr_gender.add(jrb_male);
		genderPane.add(jl_gender);
	    genderPane.add(jt_gender);
//		genderPane.add(spacePane);
//		spacePane.setBorder(new CompoundBorder(new EmptyBorder(0, 35, 0,0 ), new MatteBorder(0, 0, 0, 0, Color.BLACK)));
//		genderPane.add(jrb_female);
//		genderPane.add(jrb_male);
		birthPane.add(jl_birth);
		birthPane.add(jt_birth);
		buttonPane.add(jb_save);
		buttonPane.add(jb_reset);
		
		infoPane.add(titlePane);
		infoPane.add(majorPane);
		infoPane.add(noPane);
		infoPane.add(namePane);
		infoPane.add(passPane);
		infoPane.add(phonePane);
		infoPane.add(genderPane);
		infoPane.add(birthPane);
		infoPane.add(buttonPane);
		
		//박스 레이아웃 을 통해 infopane 패널을 담아서 묶어주고 진행  
		this.setLayout(new BorderLayout());
		BoxLayout boxLayout =new BoxLayout(centerPane, BoxLayout.Y_AXIS);
		centerPane.setLayout(boxLayout);
		centerPane.add(infoPane);
		add(centerPane);
		
		setSize(600, 600);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);
		
		// 이벤트 리스너
		StdInfoEvent eventObj = new StdInfoEvent();
		
	}
	
	class StdInfoEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
		}
	}// StdInfoEvent class
	
	
	
}
