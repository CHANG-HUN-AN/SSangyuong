package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemoUI extends JFrame{
	JPanel filePanel, btnPanel;
	JTextField jt_file;
	JTextArea ja_content;
	JButton btnSave, btnReset, btnRead;
	JLabel fileLabel;
	
	public MemoUI() {
		startUI();
	}
	
	public void startUI() {
		setTitle("메모장");
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		filePanel = new JPanel();
		btnPanel = new JPanel();
		fileLabel = new JLabel("파일명>");
		jt_file = new JTextField(20);
		ja_content = new JTextArea(5,5);
		ja_content.setBackground(new Color(183,240,177));
		btnSave = new JButton("저장하기");
		btnReset = new JButton("다시쓰기");	
		
		fileLabel.setFont(font);		ja_content.setFont(font);
		btnSave.setFont(font); 		btnReset.setFont(font);
		
		filePanel.add(fileLabel);  filePanel.add(jt_file);
		btnPanel.add(btnSave);	btnPanel.add(btnReset);
				
		add(filePanel, BorderLayout.NORTH);
		add(ja_content, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		
		setSize(300,300);
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
	
		setLocation(width,height);
		setVisible(true);		
	}//startUI
		
	
}//class













