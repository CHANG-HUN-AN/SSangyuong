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
	//@@0318(ach) jpanel �� ������û�� �߰�
	StdRegCourse jp_couse;
	// Field
	JPanel JoinPane = new JPanel(new GridLayout(8, 1));
	JPanel jp_main, jp_stu, jp_score;
	JTabbedPane tabPane;

	// �α���
	JPanel mainPane, menuPane, imgPane, showPane;
	JButton btnInfo, btnScore, btnExit;

	JPanel jp_logo, jp_title, jp_check, jp_id, jp_pass, jp_button;
	JLabel jl_limg, jl_title, jl_id, jl_pass;
	JTextField tid;
	JPasswordField tpass;
	JRadioButton jr_stu, jr_staff;
	JButton btnLogin, btnJoin;

	// �л� ����
	JFrame jf_main;
	JPanel jp_info, jp_result;
	JLabel jl_info, jl_sname, jl_smajor, jl_total, jl_avg;
	JTextField jtf_name, jtf_major, jtf_total, jtf_avg;
	JTabbedPane tapPane;
	JTable scoreTable;
	JScrollPane scoll;
	// StudentMgmUI main;

	// �л� ����
	JPanel infoPane, namePane, majorPane, noPane, phonePane, genderPane, emailPane, birthPane, buttonPane;
	JTabbedPane infoTab, scoreTab;
	JLabel jl_img, jl_name, jl_major, jl_no, jl_phone, jl_gender, jl_email, jl_birth;
	JTextField jt_name, jt_major, jt_no, jt_phone, jt_email, jt_birth;
	JRadioButton jrb_female, jrb_male;
	JButton jb_save, jb_reset;

	public static Font font = new Font("���� ���", Font.BOLD, 12);

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
		jl_title = new JLabel("\n�ֿ���б� �л���� �ý���");
		jl_title.setFont(new Font("���� ���", Font.BOLD, 20));
		jl_id = new JLabel("���̵�");
		jl_pass = new JLabel("��й�ȣ");

		tid = new JTextField(15);
		tpass = new JPasswordField(15);

		jr_stu = new JRadioButton("�л�");
		jr_staff = new JRadioButton("������");

		btnLogin = new JButton("�α���");
		btnJoin = new JButton("ȸ������");

		jl_id.setFont(font);
		jl_pass.setFont(font);
		btnLogin.setFont(font);
		btnJoin.setFont(font);
		jr_stu.setFont(font);
		jr_staff.setFont(font);

		// �гο� �󺧳ֱ�
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

		// ���гο� �гγֱ�
		imgPane.add(jp_logo);
		showPane.add(jp_title);
		showPane.add(jp_check);
		showPane.add(jp_id);
		showPane.add(jp_pass);
		showPane.add(jp_button);

		// �����ӿ� �гγֱ�
		add(imgPane, BorderLayout.NORTH);
		add(showPane, BorderLayout.CENTER);

		setSize(600, 600);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);

		// �̺�Ʈ ������
		SYUnivMgmUIEvent eventObject = new SYUnivMgmUIEvent(this);
		addWindowListener(eventObject);
		btnLogin.addActionListener(eventObject);
		btnJoin.addActionListener(eventObject);
		
	}

	public void showMain() {
		//@@0318(ach) tab�� ������û �߰�
		jp_couse = new StdRegCourse();
		
		jf_main = new JFrame();
		mainPane = new JPanel();
		jp_main = new JPanel();
		jp_stu = new JPanel();
		jp_score = new JPanel();
		tabPane = new JTabbedPane();

		// �л� ����
		jp_stu = new JPanel();
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

		jp_stu.add(namePane);
		jp_stu.add(majorPane);
		jp_stu.add(noPane);
		jp_stu.add(phonePane);
		jp_stu.add(genderPane);
		jp_stu.add(emailPane);
		jp_stu.add(birthPane);
		jp_stu.add(buttonPane);

		jp_stu.setLayout(new GridLayout(10, 1));

		// �л� ����
		jp_info = new JPanel();
		jp_result = new JPanel();
		jl_sname = new JLabel("�̸�");
		jl_smajor = new JLabel("�а�");
		jl_total = new JLabel("����");
		jl_avg = new JLabel("���");
		jtf_name = new JTextField(5);
		jtf_major = new JTextField(8);
		jtf_total = new JTextField(5);
		jtf_avg = new JTextField(5);
		tapPane = new JTabbedPane();

		String header[] = { "�����", "����", "���", "��米��" };
		String contents[][] = { { "����1", "80", "B", "" }, { "����2", "80", "B", "" }, { "����3", "80", "B", "" },
				{ "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" },
				{ "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" },
				{ "����4", "80", "B", "" } };
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

		tabPane.addTab("����", jp_main);
		tabPane.addTab("������ȸ", jp_stu);
		tabPane.addTab("������ȸ", jp_score);
		tabPane.addTab("������û", jp_couse);

		jp_score.add(jp_info);
		jp_score.add(scoll, BorderLayout.CENTER);
		jp_score.add(jp_result);

		mainPane.setLayout(new GridLayout(1, 1));
		mainPane.add(tabPane);
		
		

		// �����ӿ� �гγֱ�
		jf_main.add(mainPane, BorderLayout.CENTER);

		// ������
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
				if (bname.equals("�α���") || tpass == ae.getSource()) {
					if (validationCheck())
						loginCheck();
				} else if (bname.equals("���")) {
					tid.setText("");
					tpass.setText("");
				}
			} else if (btnJoin == obj) {
				new StdRegister(main).join();
			}
		}
	}

	// Method
	/** ������ ��ȿ�� üũ **/
	public boolean validationCheck() {
		boolean result = false;
		// tid, tpass�� ���� ������ �޽����� ���
		if (tid.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
			tid.requestFocus();
		} else if (tpass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�н����带 �Է����ּ���");
			tpass.requestFocus();
		} else {
			result = true;
		}

		return result;
	}

	/** �α��� üũ **/
	public void loginCheck() {
		String did = "test";
		String dpass = "1234";
		String uid = tid.getText().trim();
		String upass = tpass.getText().trim();

		if (did.equals(uid)) {

			if (dpass.equals(upass)) {
				// �α��μ��� : id,pass ����
				JOptionPane.showMessageDialog(null, "�α��� ����");
				System.out.println("1111");
				setVisible(false);
				System.out.println("2222");
				showMain();
				System.out.println("3333");
			} else {
				// �α��� ���� : id ����, pass �ٸ�
				JOptionPane.showMessageDialog(null, "�α��� ����, �н����尡 �ٸ�");
			}
		} else {
			// System.out.println("�α��� ����");
			JOptionPane.showMessageDialog(null, "�α��� ����, ���̵� �ٸ�");
		}
	}

}
