package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AdmInfoList extends JFrame{
	//Field
	JPanel FormPane,titlePane,idPane,pwPane,namePane,majorPane,phonePane,genderPane,birthPane,buttonPane;
	JLabel jl_title,jl_id,jl_pw,jl_name,jl_major,jl_phone,jl_gender,jl_birth;
	JTextField jt_id,jt_pw,jt_name,jt_major,jt_phone,jt_brith;
	JButton btn_delete,btn_cancel;
	ButtonGroup bg_gender;
	JRadioButton male,female;
	Font fontTitle = new Font("맑은 고딕", Font.BOLD, 16);
	Font font= new Font("맑은 고딕", Font.BOLD, 12);
	//Constructor
	public AdmInfoList() {
		formStart();
	}
	//Method
	public void formStart() {
		//default set
		setTitle("학생정보수정");
		setAlwaysOnTop(true);
		//object create
		FormPane = new JPanel(new GridLayout(7,1));
		titlePane = new JPanel(); idPane = new JPanel(); pwPane = new JPanel(); namePane = new JPanel();majorPane = new JPanel();
		phonePane = new JPanel(); genderPane = new JPanel(); buttonPane = new JPanel(); 
		jl_title = new JLabel("학생 정보 수정"); jl_id = new JLabel("아이디"); jl_pw = new JLabel("비밀번호");
		jl_name = new JLabel("이름"); jl_major = new JLabel("학과"); jl_phone = new JLabel("H.P");
		jl_gender = new JLabel("성별"); 
		jt_id = new JTextField(20); jt_pw = new JTextField(20); jt_name = new JTextField(20);
		jt_major = new JTextField(20); jt_phone = new JTextField(20);
		btn_delete = new JButton("삭제");btn_cancel = new JButton("취소");
		male = new JRadioButton("남성");female = new JRadioButton("여성");
		bg_gender = new ButtonGroup(); 
		bg_gender.add(female);bg_gender.add(male);
		
		//set font
		jl_title.setFont(fontTitle);
		jl_id.setFont(font); jl_pw.setFont(font); jl_name.setFont(font); jl_major.setFont(font);
		jl_phone.setFont(font); jl_gender.setFont(font); btn_delete.setFont(font);btn_cancel.setFont(font);
		male.setFont(font);female.setFont(font);
		//container add
		titlePane.add(jl_title);
		idPane.add(jl_id);idPane.add(jt_id);
		pwPane.add(jl_pw);pwPane.add(jt_pw);
		namePane.add(jl_name);namePane.add(jt_name);
		majorPane.add(jl_major);majorPane.add(jt_major);
		phonePane.add(jl_phone);phonePane.add(jt_phone);
		genderPane.add(jl_gender);
		genderPane.add(female);genderPane.add(male);
		buttonPane.add(btn_delete);buttonPane.add(btn_cancel);
		
		//layout 깨져서 패널하나 더 생성
		FormPane.add(titlePane);
		FormPane.add(idPane); FormPane.add(pwPane); FormPane.add(namePane); FormPane.add(majorPane);
		FormPane.add(phonePane); FormPane.add(genderPane); 
		
		add(FormPane,BorderLayout.CENTER);
		add(buttonPane,BorderLayout.SOUTH);
//		setLayout(new GridLayout(7,1));
//		add(titlePanel); add(idPane); add(pwPane); add(namePane); add(majorPane);
//		add(phonePane); add(genderPane);
//		add(buttonPane);
		
		//JFrame visible
		setSize(400,500);
		setVisible(true);
		//location center
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		
	}
	
}
