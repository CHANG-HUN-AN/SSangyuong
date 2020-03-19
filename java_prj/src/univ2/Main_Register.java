package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * ������ ȸ������ ���
 * @author user
 */
public class Main_Register extends JFrame {
	StdUI main;

	JFrame jf_join;
	JPanel joinPane, titlePane, idPane, pwPane, namePane, majorPane, phonePane, genderPane, birthPane, buttonPane;
	JLabel jl_title, jl_id, jl_pw, jl_name, jl_major, jl_phone, jl_gender, jl_birth;
	JButton jb_join, jb_reset;
	JComboBox<String> jcb;
	JRadioButton jrb_female, jrb_male;
	JTextField jt_id, jt_pw, jt_name, jt_phone, jt_birth;

	public static Font font = new Font("���� ���", Font.BOLD, 12);

	public Main_Register() {
		setVisible(true);
		join();
	}

	public Main_Register(StdUI main) {
		this.main = main;
		this.joinPane = main.JoinPane;
	}

	public void join() {
		setTitle("ȸ �� �� ��");
		jf_join = new JFrame();
		joinPane = new JPanel();
		titlePane = new JPanel();
		idPane = new JPanel();
		pwPane = new JPanel();
		namePane = new JPanel();
		majorPane = new JPanel();
		phonePane = new JPanel();
		genderPane = new JPanel();
		birthPane = new JPanel();
		buttonPane = new JPanel();

		jl_title = new JLabel("ȸ �� �� ��");
		jl_id = new JLabel("���̵�: ");
		jl_pw = new JLabel("��й�ȣ: ");
		jl_name = new JLabel("�̸�: ");
		jl_major = new JLabel("����: ");
		jl_phone = new JLabel("��ȭ��ȣ: ");
		jl_gender = new JLabel("����: ");
		jl_birth = new JLabel("�������: ");

		jrb_female = new JRadioButton("����");
		jrb_male = new JRadioButton("����");
		ButtonGroup gr_gender = new ButtonGroup();

		jt_id = new JTextField(20);
		jt_pw = new JTextField(20);
		jt_name = new JTextField(20);
		jt_phone = new JTextField(20);
		jt_birth = new JTextField(20);

		jcb = new JComboBox<String>();
		jcb.addItem("�����濵��");
		jcb.addItem("����ƮIT��");
		jcb.addItem("���Ʊ�����");

		jb_join = new JButton("����");
		jb_reset = new JButton("���");

		titlePane.add(jl_title);

		idPane.add(jl_id);
		idPane.add(jt_id);

		pwPane.add(jl_pw);
		pwPane.add(jt_pw);
		namePane.add(jl_name);
		namePane.add(jt_name);
		majorPane.add(jl_major);
		majorPane.add(jcb);
		phonePane.add(jl_phone);
		phonePane.add(jt_phone);

		gr_gender.add(jrb_female);
		gr_gender.add(jrb_male);
		genderPane.add(jl_gender);
		genderPane.add(jrb_female);
		genderPane.add(jrb_male);

		birthPane.add(jl_birth);
		birthPane.add(jt_birth);

		add(buttonPane, BorderLayout.SOUTH);
		buttonPane.add(jb_join);
		buttonPane.add(jb_reset);

		joinPane.add(titlePane);
		joinPane.add(idPane);
		joinPane.add(pwPane);
		joinPane.add(namePane);
		joinPane.add(majorPane);
		joinPane.add(phonePane);
		joinPane.add(genderPane);
		joinPane.add(birthPane);
		joinPane.add(buttonPane);

		joinPane.setLayout(new GridLayout(9, 1));

		jf_join.add(joinPane);
		
		jf_join.setSize(450, 600);
		
		// location center
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
		
		jf_join.setLocation(width, height);
		jf_join.setVisible(true);
	}
}
