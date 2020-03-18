package univ2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class MgmStdScoreList extends JFrame {

	//Field
	JPanel mainPane= new JPanel(new GridLayout(8,1));
	JPanel nonamePane= new JPanel(new GridLayout(1,4));
	JPanel objectPane= new JPanel(new GridLayout(1,3));
	JPanel tablePane= new JPanel(new GridLayout(1,3));
	JPanel jp_score;
	JPanel titlePane,namePane,noPane
	,majorPane,subPane,scorePane,gradePane,buttonPane;
	
	JTextField Num_textField,Name_textField
				,major_textField,Subject_textField
				,Score_textField,Grade_textField;
	
	JTable scoreTable;
	JScrollPane scoll;
	
	//Constructor
	public MgmStdScoreList() {
		scoreFrame();
	}

	//Method
	public void scoreFrame() {
		//contentPane = new JPanel(new GridLayout(10, 1));
		jp_score = new JPanel();
		titlePane= new JPanel();
		namePane = new JPanel();
		noPane = new JPanel();
		majorPane = new JPanel();
		subPane = new JPanel();
		scorePane = new JPanel();
		gradePane = new JPanel();
		buttonPane = new JPanel();
		
		JLabel Title_Label = new JLabel("�л� ���� ����ȸ �� ����");
		JLabel Label_name = new JLabel("�� ��");
		JLabel Label_no = new JLabel("�� ��");
		JLabel Label_major = new JLabel("�� ��");
		JLabel Subject_Label = new JLabel("�����");
		JLabel Score_Label = new JLabel("����");
		JLabel Grade_Label = new JLabel("���");
		
		Num_textField = new JTextField(8);
		Name_textField = new JTextField(8);
		major_textField = new JTextField(20);
		Subject_textField = new JTextField(5);
		Score_textField = new JTextField(5);
		Grade_textField = new JTextField(5);
		
		JButton Change_Button = new JButton("�� ��");
		JButton Cancel_Button = new JButton("�� ��");
		
		Label_name.setFont(new Font("���� ����", Font.BOLD, 16));
		Label_no.setFont(new Font("���� ����", Font.BOLD, 16));
		Label_major.setFont(new Font("���� ����", Font.BOLD, 16));
		Change_Button.setFont(new Font("��������", Font.BOLD, 18));
		Cancel_Button.setFont(new Font("��������", Font.BOLD, 18));
		Subject_Label.setFont(new Font("���� ����", Font.BOLD, 15));
		Score_Label.setFont(new Font("���� ����", Font.BOLD, 15));
		Grade_Label.setFont(new Font("���� ����", Font.BOLD, 15));
		Title_Label.setFont(new Font("���� ����", Font.BOLD, 28));
		
		Title_Label.setForeground(Color.ORANGE);
		titlePane.add(Title_Label);
		
		//contentPane.setLayout(new GridLayout(3,4));
		noPane.add(Label_no);
		noPane.add(Num_textField);
		
		namePane.add(Label_name);
		namePane .add(Name_textField);
		
		majorPane.add(Label_major);
		majorPane.add(major_textField);

		subPane.add(Subject_Label);
		subPane.add(Subject_textField);
		
		scorePane.add(Score_Label);
		scorePane.add(Score_textField);
		
		gradePane.add(Grade_Label);
		gradePane.add(Grade_textField);
	
		mainPane.add(titlePane);
		
		mainPane.add(nonamePane);
		nonamePane.add(noPane);
		nonamePane.add(namePane);
		mainPane.add(majorPane);

		
		String header[] = { "�����", "����", "���" };
		String contents[][] = { 
				{"����", "80", "B"},
				{"����", "50", "C"},
				{"����", "40", "C"},
				{"��ȸ", "80", "B"},
				{"����", "100", "A"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null} };
		scoreTable = new JTable(contents, header);
		scoll = new JScrollPane(scoreTable);
		add(mainPane, BorderLayout.CENTER);
		mainPane.add(scoll, BorderLayout.CENTER);
		
		mainPane.add(objectPane);
		objectPane.add(subPane);
		objectPane.add(scorePane);
		objectPane.add(gradePane);
		
		mainPane.add(buttonPane);
		buttonPane.add(Change_Button);
		buttonPane.add(Cancel_Button);
		
		setTitle("SIST ���б� �л� ���� ���α׷� - �� ����");
		setSize(500,750);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);
		
		setContentPane(mainPane);
		mainPane.setLayout(null);
	
		Change_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
