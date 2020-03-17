package day0310_t;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemoUI extends JFrame{
	MemoProc proc = new MemoProc();
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

		jt_file = new JTextField(15);
		ja_content = new JTextArea(5,5);
		ja_content.setBackground(new Color(183,240,177));
		btnSave = new JButton("파일저장");
		btnReset = new JButton("다시쓰기");
		btnRead = new JButton("파일읽기");
		
		fileLabel.setFont(font);		ja_content.setFont(font);
		btnSave.setFont(font); 		btnReset.setFont(font);
		btnRead.setFont(font);
		
		filePanel.add(fileLabel);  filePanel.add(jt_file);
		btnPanel.add(btnSave);	btnPanel.add(btnReset);
		btnPanel.add(btnRead);
				
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
		
		MemoUIEvent eventObj = new MemoUIEvent();
		addWindowListener(eventObj);
		btnSave.addActionListener(eventObj);
		btnReset.addActionListener(eventObj);
		btnRead.addActionListener(eventObj);
		
	}//startUI
		
	//이벤트 클래스
	class MemoUIEvent extends WindowAdapter 
					implements ActionListener{
		//Field
		boolean appendOK = false;
		
		//Method

		public void windowClosing(WindowEvent we) {
			//System.out.println("----------------->> 프로그램 종료");
			System.exit(0);			
		}
		
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			String fname = jt_file.getText().trim();
			
			if(obj == jt_file) {				
				if(proc.fileCheck(fname)) {
					int choice = JOptionPane.showConfirmDialog(null,
									"파일존재합니다. \n이어서 저장할까요?");
					if(choice ==0) { //기존 파일에 이어서 저장
						appendOK = true;
					}else if(choice ==1) { //새로운 파일 입력
						jt_file.setText("");
						jt_file.requestFocus();
					}
				}else {
					int createChoice = JOptionPane.showConfirmDialog(null,
							"파일존재하지 않습니다. \n생성 할까요?");
					if(createChoice ==0) { //새로 생성
						if(proc.createFile(fname)) {
							JOptionPane.showMessageDialog(null, "파일생성 완료!!");
						}
					}else if(createChoice ==1) { //생성하지 않음
						jt_file.setText("");
						jt_file.requestFocus();
					}
				}
				
			}else if(obj == btnSave) {
				String content = ja_content.getText().trim();
				boolean result = proc.saveFile(fname, content, appendOK);
				
				if(result) JOptionPane.showMessageDialog(null, "저장 완료!");
				
			}else if(obj == btnReset) {
				jt_file.setText("");
				ja_content.setText("");
				jt_file.requestFocus();
			}else if(obj == btnRead) {				
				ja_content.setText("");
				if(proc.fileCheck(fname)) {
					String data = proc.readFile(fname);
					ja_content.setBackground(Color.LIGHT_GRAY);
					ja_content.setText(data);
				}else {
					JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다.!");
				}
			}
		}
		
	}//MemoUIEvent class
	
}//class













