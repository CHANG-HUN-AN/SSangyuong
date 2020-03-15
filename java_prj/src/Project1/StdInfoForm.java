package Project1;

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

public class StdInfoForm extends JFrame{
	//Field
	JPanel FormPanel,jp_title,jp_id,jp_pw,jp_name,jp_major,jp_phone,jp_gender,jp_birth,jp_button;
	JLabel jl_title,jl_id,jl_pw,jl_name,jl_major,jl_phone,jl_gender,jl_birth;
	JTextField jt_id,jt_pw,jt_name,jt_major,jt_phone,jt_brith;
	JButton btn_delete,btn_cancel;
	ButtonGroup bg_gender;
	JRadioButton male,female;
	Font fontTitle = new Font("���� ���", Font.BOLD, 16);
	Font font= new Font("���� ���", Font.BOLD, 12);
	//Constructor
	public StdInfoForm() {
		formStart();
	}
	//Method
	public void formStart() {
		//default set
		setTitle("�л���������");
		setAlwaysOnTop(true);
		//object create
		FormPanel = new JPanel(new GridLayout(7,1));
		jp_title = new JPanel(); jp_id = new JPanel(); jp_pw = new JPanel(); jp_name = new JPanel();jp_major = new JPanel();
		jp_phone = new JPanel(); jp_gender = new JPanel(); jp_button = new JPanel(); 
		jl_title = new JLabel("�л� ���� ����"); jl_id = new JLabel("���̵�"); jl_pw = new JLabel("��й�ȣ");
		jl_name = new JLabel("�̸�"); jl_major = new JLabel("�а�"); jl_phone = new JLabel("H.P");
		jl_gender = new JLabel("����"); 
		jt_id = new JTextField(20); jt_pw = new JTextField(20); jt_name = new JTextField(20);
		jt_major = new JTextField(20); jt_phone = new JTextField(20);
		btn_delete = new JButton("����");btn_cancel = new JButton("���");
		male = new JRadioButton("����");female = new JRadioButton("����");
		bg_gender = new ButtonGroup(); 
		bg_gender.add(female);bg_gender.add(male);
		
		//set font
		jl_title.setFont(fontTitle);
		jl_id.setFont(font); jl_pw.setFont(font); jl_name.setFont(font); jl_major.setFont(font);
		jl_phone.setFont(font); jl_gender.setFont(font); btn_delete.setFont(font);btn_cancel.setFont(font);
		male.setFont(font);female.setFont(font);
		//container add
		jp_title.add(jl_title);
		jp_id.add(jl_id);jp_id.add(jt_id);
		jp_pw.add(jl_pw);jp_pw.add(jt_pw);
		jp_name.add(jl_name);jp_name.add(jt_name);
		jp_major.add(jl_major);jp_major.add(jt_major);
		jp_phone.add(jl_phone);jp_phone.add(jt_phone);
		jp_gender.add(jl_gender);
		jp_gender.add(female);jp_gender.add(male);
		jp_button.add(btn_delete);jp_button.add(btn_cancel);
		
		//layout ������ �г��ϳ� �� ����
		FormPanel.add(jp_title);
		FormPanel.add(jp_id); FormPanel.add(jp_pw); FormPanel.add(jp_name); FormPanel.add(jp_major);
		FormPanel.add(jp_phone); FormPanel.add(jp_gender); 
		
		add(FormPanel,BorderLayout.CENTER);
		add(jp_button,BorderLayout.SOUTH);
//		setLayout(new GridLayout(7,1));
//		add(jp_title); add(jp_id); add(jp_pw); add(jp_name); add(jp_major);
//		add(jp_phone); add(jp_gender);
//		add(jp_button);
		
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
