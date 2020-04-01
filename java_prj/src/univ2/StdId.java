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
	public static Font title = new Font("맑은 고딕", Font.BOLD, 15);
	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);

	JFrame jf_findId;
	JPanel stdIdPane, titlePane, namePane, noPane, btnPane;
	JLabel jl_title, jl_name, jl_no;
	JTextField jtf_name, jtf_no;
	JButton btnFind, btnReset;

	public StdId() {
		findId();
	}

	public void findId() {
		setTitle("아 이 디 찾 기");

		stdIdPane = new JPanel(new GridLayout(5, 1));
		titlePane = new JPanel();
		namePane = new JPanel();
		noPane = new JPanel();
		btnPane = new JPanel();

		jl_title = new JLabel("아 이 디 찾 기");
		jl_name = new JLabel("이름");
		jl_no = new JLabel("학번");

		jtf_name = new JTextField(15);
		jtf_no = new JTextField(15);

		btnFind = new JButton("찾기");
		btnReset = new JButton("취소");

		titlePane.add(jl_title);

		namePane.add(jl_name);
		namePane.add(jtf_name);

		noPane.add(jl_no);
		noPane.add(jtf_no);

		btnPane.add(btnFind);
		btnPane.add(btnReset);
		
		btnFind.setBorderPainted(false); // 버튼 테두리
		btnFind.setFocusPainted(false); // 버튼 클릭시 테두리
		btnFind.setBackground(new Color(126, 126, 126)); // 버튼 색
		btnFind.setForeground(Color.white); // 버튼 글자색
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