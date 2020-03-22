package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

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
	JTextField jt_id,jt_pw,jt_name,jt_major,jt_phone,jt_brith;
	JButton btn_delete,btn_cancel;
	ButtonGroup bg_gender;
	JRadioButton male,female;
	//Constructor
	public ProInfoList() {
		formStart();
	}
	//Method
	public void formStart() {
		//default set
		setTitle("�л���������");
		setAlwaysOnTop(true);
		//object create
		FormPane = new JPanel(new GridLayout(7,1));
//		int boxcount = 1;
//		ArrayList<String> list = new ArrayList<String>();
		labelBoxPane = new JPanel();
		tfBoxPane = new JPanel();
		titlePane = new JPanel(); idPane = new JPanel(); pwPane = new JPanel(); namePane = new JPanel();majorPane = new JPanel();
		phonePane = new JPanel(); genderPane = new JPanel(); buttonPane = new JPanel(); 
		titlePane2 = new JPanel(); idPane2 = new JPanel(); pwPane2 = new JPanel(); namePane2 = new JPanel();majorPane2 = new JPanel();
		phonePane2 = new JPanel(); genderPane2 = new JPanel();
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
		jl_title.setFont(AdmUI.FONTTITLE);
		jl_id.setFont(AdmUI.FONT); jl_pw.setFont(AdmUI.FONT); jl_name.setFont(AdmUI.FONT); jl_major.setFont(AdmUI.FONT);
		jl_phone.setFont(AdmUI.FONT); jl_gender.setFont(AdmUI.FONT); btn_delete.setFont(AdmUI.FONT);btn_cancel.setFont(AdmUI.FONT);
		male.setFont(AdmUI.FONT);female.setFont(AdmUI.FONT);
		//box���̾ƿ����� ��������
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
		genderPane.add(jl_gender);
		genderPane2.add(female);genderPane2.add(male);
		buttonPane.add(btn_delete);buttonPane.add(btn_cancel);
		
		titlePane.add(jl_title);
		labelBoxPane.add(idPane);tfBoxPane.add(idPane2);
		labelBoxPane.add(pwPane);tfBoxPane.add(pwPane2);
		labelBoxPane.add(namePane);tfBoxPane.add(namePane2);
		labelBoxPane.add(majorPane);tfBoxPane.add(majorPane2);
		labelBoxPane.add(phonePane);tfBoxPane.add(phonePane2);
		//�����ɼ���
		labelBoxPane.add(genderPane);
		genderPane2.add(female);genderPane2.add(male);
		tfBoxPane.add(genderPane2);
		buttonPane.add(btn_delete);buttonPane.add(btn_cancel);
		
		//layout ������ �г��ϳ� �� ����
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