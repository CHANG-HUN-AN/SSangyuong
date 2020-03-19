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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class StdInfo extends JPanel{
	JPanel infoPane, namePane, majorPane, noPane, phonePane, genderPane, emailPane, birthPane, buttonPane;
	JTabbedPane infoTab, scoreTab;
	JLabel jl_img, jl_name, jl_major, jl_no, jl_phone, jl_gender, jl_email, jl_birth;
	JTextField jt_name, jt_major, jt_no, jt_phone, jt_email, jt_birth;
	JRadioButton jrb_female, jrb_male;
	JButton jb_save, jb_reset;

	public static Font font = new Font("���� ���", Font.BOLD, 12);
	
	

	public StdInfo() {
		infoStart();
	}

	public void infoStart() {
		// �л� ����
		infoPane = new JPanel(new GridLayout(10, 1));
		namePane = new JPanel();
		majorPane = new JPanel();
		noPane = new JPanel();
		phonePane = new JPanel();
		genderPane = new JPanel();
		emailPane = new JPanel();
		birthPane = new JPanel();
		buttonPane = new JPanel();

		jl_name = new JLabel("�̸�: ");
		jl_major = new JLabel("�а�: ");
		jl_no = new JLabel("�й�: ");
		jl_phone = new JLabel("����ó: ");
		jl_gender = new JLabel("����: ");
		jl_email = new JLabel("�̸���: ");
		jl_birth = new JLabel("�������: ");

		jrb_female = new JRadioButton("����");
		jrb_male = new JRadioButton("����");
		ButtonGroup gr_gender = new ButtonGroup();

		jt_name = new JTextField(20);
		jt_major = new JTextField(20);
		jt_no = new JTextField(20);
		jt_phone = new JTextField(20);
		jt_email = new JTextField(20);
		jt_birth = new JTextField(20);

		jb_save = new JButton("����");
		jb_reset = new JButton("���");

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

		infoPane.add(namePane);
		infoPane.add(majorPane);
		infoPane.add(noPane);
		infoPane.add(phonePane);
		infoPane.add(genderPane);
		infoPane.add(emailPane);
		infoPane.add(birthPane);
		infoPane.add(buttonPane);

		add(infoPane,BorderLayout.CENTER);
		
		setSize(600, 600);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);
	}
}
