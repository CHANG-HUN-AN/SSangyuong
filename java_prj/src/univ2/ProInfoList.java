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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProInfoList extends JFrame{
	//Field
	JPanel	FormPane,labelBoxPane,tfBoxPane;
	JPanel titlePane,idPane,pwPane,namePane,majorPane,phonePane,genderPane,birthPane,buttonPane;
	JPanel titlePane2,idPane2,pwPane2,namePane2,majorPane2,phonePane2,genderPane2,birthPane2;
	JLabel jl_title,jl_id,jl_pw,jl_name,jl_major,jl_phone,jl_gender,jl_birth;
	JTextField jt_id,jt_pw,jt_name,jt_major,jt_phone,jt_birth;
	JButton btn_delete,btn_cancel;
	ButtonGroup bg_gender;
	JRadioButton male,female;
	
	String detailData;
	ProInfoDAO dao;
	//Constructor
	public ProInfoList() {
		formStart();
	}
	public ProInfoList(Object detailData,ProInfoDAO dao) {
		this.detailData = (String)detailData;
		this.dao = dao;
		formStart();
	}
	//Method
	public void formStart() {
		//default set
		setTitle("학생정보수정");
		setAlwaysOnTop(true);
		//object create
		FormPane = new JPanel(new GridLayout(7,1));
//		int boxcount = 1;
//		ArrayList<String> list = new ArrayList<String>();
		labelBoxPane = new JPanel();
		tfBoxPane = new JPanel();
		titlePane = new JPanel(); idPane = new JPanel(); pwPane = new JPanel(); namePane = new JPanel();majorPane = new JPanel();
		phonePane = new JPanel(); genderPane = new JPanel(); buttonPane = new JPanel(); birthPane = new JPanel();
		titlePane2 = new JPanel(); idPane2 = new JPanel(); pwPane2 = new JPanel(); namePane2 = new JPanel();majorPane2 = new JPanel();
		phonePane2 = new JPanel(); genderPane2 = new JPanel(); birthPane2 = new JPanel();
		jl_title = new JLabel("학생 정보 수정"); jl_id = new JLabel("아이디"); jl_pw = new JLabel("비밀번호");
		jl_name = new JLabel("이름"); jl_major = new JLabel("학과"); jl_phone = new JLabel("H.P");
		jl_gender = new JLabel("성별"); jl_birth = new JLabel("생년월일");
		jt_id = new JTextField(20); jt_pw = new JTextField(20); jt_name = new JTextField(20);
		jt_major = new JTextField(20); jt_phone = new JTextField(20);jt_birth = new JTextField(20);
		btn_delete = new JButton("삭제");btn_cancel = new JButton("취소");
		male = new JRadioButton("남성");female = new JRadioButton("여성");
		bg_gender = new ButtonGroup(); 
		bg_gender.add(female);bg_gender.add(male);
		
		//set font
		jl_title.setFont(ProUI.FONTTITLE);
		jl_id.setFont(ProUI.FONT); jl_pw.setFont(ProUI.FONT); jl_name.setFont(ProUI.FONT); jl_major.setFont(ProUI.FONT);
		jl_phone.setFont(ProUI.FONT); jl_gender.setFont(ProUI.FONT); btn_delete.setFont(ProUI.FONT);btn_cancel.setFont(ProUI.FONT);
		male.setFont(ProUI.FONT);female.setFont(ProUI.FONT);jl_birth.setFont(ProUI.FONT);
		//box레이아웃으로 수직정렬
		labelBoxPane.setLayout(new BoxLayout(labelBoxPane, BoxLayout.Y_AXIS));
		tfBoxPane.setLayout(new BoxLayout(tfBoxPane, BoxLayout.Y_AXIS));
		//container add
		titlePane.add(jl_title);
//		list = {jl_title,jl_id,jl_pw,jl_name,jl_major,jl_phone,jl_gender};
		idPane.add(jl_id);idPane2.add(jt_id);
		pwPane.add(jl_pw);pwPane2.add(jt_pw);
		namePane.add(jl_name);namePane2.add(jt_name);
		majorPane.add(jl_major);majorPane2.add(jt_major);
		phonePane.add(jl_phone);phonePane2.add(jt_phone);
		birthPane.add(jl_birth);birthPane2.add(jt_birth);
		genderPane.add(jl_gender);
		genderPane2.add(female);genderPane2.add(male);
		buttonPane.add(btn_delete);buttonPane.add(btn_cancel);
		
		titlePane.add(jl_title);
		labelBoxPane.add(idPane);tfBoxPane.add(idPane2);
		labelBoxPane.add(pwPane);tfBoxPane.add(pwPane2);
		labelBoxPane.add(namePane);tfBoxPane.add(namePane2);
		labelBoxPane.add(majorPane);tfBoxPane.add(majorPane2);
		labelBoxPane.add(phonePane);tfBoxPane.add(phonePane2);
		labelBoxPane.add(birthPane);tfBoxPane.add(birthPane2);
		//라디오옵션팬
		labelBoxPane.add(genderPane);
		genderPane2.add(female);genderPane2.add(male);
		tfBoxPane.add(genderPane2);
		buttonPane.add(btn_delete);buttonPane.add(btn_cancel);
		
		//layout 깨져서 패널하나 더 생성
//		FormPane.add(titlePane);
//		FormPane.add(idPane); FormPane.add(pwPane); FormPane.add(namePane); FormPane.add(majorPane);
//		FormPane.add(phonePane); FormPane.add(genderPane);
		FormPane.setLayout(new BorderLayout());
		FormPane.add(labelBoxPane,BorderLayout.WEST);
		FormPane.add(tfBoxPane,BorderLayout.CENTER);
		add(FormPane,BorderLayout.CENTER);
//		setLayout(new GridLayout(7,1));
//		add(titlePanel); add(idPane); add(pwPane); add(namePane); add(majorPane);
//		add(phonePane); add(genderPane);
//		add(buttonPane);
		//입력제한
		jt_id.setEditable(false);
		jt_pw.setEditable(false);
		jt_name.setEditable(false);
		jt_major.setEditable(false);
		jt_phone.setEditable(false);
		jt_birth.setEditable(false);
		//db에있는 개인데이터 컴포넌트에 추가
		detailList();
		
		//JFrame visible
		setSize(400,500);
		setVisible(true);
		//location center
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		
		//핸들러 메소드
		BtnEvent eventObj = new BtnEvent();
		
		
	}
	//내부객체(이벤트객체)
	public class BtnEvent extends WindowAdapter implements ActionListener{
		@Override
		public void windowClosing(WindowEvent we) {
			dispose(); //새로운프레임종료
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			
			if(obj == btn_cancel) {
				System.out.println("취소합니다");
				dispose();
			}else if(obj == btn_delete) {
				System.out.println("삭제합니다.");
			}
		}
	}
	
	public void detailList() {
		Vector<AdminStdVO> list = new Vector<AdminStdVO>();
		list = dao.getDetailSearch(detailData);
		for(AdminStdVO vo : list) {
			jt_id.setText(vo.getStdno());
			jt_pw.setText(vo.getPw());
			jt_name.setText(vo.getSname());
			jt_major.setText(vo.getMname());
			jt_phone.setText(vo.getPh());
			jt_birth.setText(vo.getBirth());
			
			if(vo.getGender().equals("M")) {
				male.setSelected(true);
			}else {
				female.setSelected(true);
			}
		}
	}
	
}
