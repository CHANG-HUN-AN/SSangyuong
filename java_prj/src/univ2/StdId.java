package univ2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StdId extends JFrame {
	public static Font title = new Font("���� ���", Font.BOLD, 15);
	public static Font font = new Font("���� ���", Font.BOLD, 12);

	JFrame jf_findId;
	JPanel stdIdPane, titlePane, namePane, noPane, btnPane;
	JLabel jl_title, jl_name, jl_no;
	JTextField jtf_name, jtf_no;
	JButton btnFind, btnReset;

	public StdId() {
		findId();
	}

	public void findId() {
		setTitle("�� �� �� ã ��");

		stdIdPane = new JPanel(new GridLayout(5, 1));
		titlePane = new JPanel();
		namePane = new JPanel();
		noPane = new JPanel();
		btnPane = new JPanel();

		jl_title = new JLabel("�� �� �� ã ��");
		jl_name = new JLabel("�̸�");
		jl_no = new JLabel("�й�");

		jtf_name = new JTextField(15);
		jtf_no = new JTextField(15);

		btnFind = new JButton("ã��");
		btnReset = new JButton("���");

		titlePane.add(jl_title);

		namePane.add(jl_name);
		namePane.add(jtf_name);

		noPane.add(jl_no);
		noPane.add(jtf_no);

		btnPane.add(btnFind);
		btnPane.add(btnReset);
		
		btnFind.setBorderPainted(false); // ��ư �׵θ�
		btnFind.setFocusPainted(false); // ��ư Ŭ���� �׵θ�
		btnFind.setBackground(new Color(126, 126, 126)); // ��ư ��
		btnFind.setForeground(Color.white); // ��ư ���ڻ�
		btnReset.setBorderPainted(false);
		btnReset.setFocusPainted(false); 
		btnReset.setBackground(new Color(126, 126, 126)); 
		btnReset.setForeground(Color.white); 

		jl_title.setFont(title);
		jl_name.setFont(font);
		jl_no.setFont(font);
		btnFind.setFont(font);
		btnReset.setFont(font);

		stdIdPane.add(titlePane);
		stdIdPane.add(namePane);
		stdIdPane.add(noPane);
		stdIdPane.add(btnPane);

		add(stdIdPane);

		setSize(300, 250);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);

	}

}