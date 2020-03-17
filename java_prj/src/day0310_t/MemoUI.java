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
		setTitle("�޸���");
		Font font = new Font("���� ���", Font.BOLD, 12);
		filePanel = new JPanel();
		btnPanel = new JPanel();
		fileLabel = new JLabel("���ϸ�>");

		jt_file = new JTextField(15);
		ja_content = new JTextArea(5,5);
		ja_content.setBackground(new Color(183,240,177));
		btnSave = new JButton("��������");
		btnReset = new JButton("�ٽþ���");
		btnRead = new JButton("�����б�");
		
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
		
	//�̺�Ʈ Ŭ����
	class MemoUIEvent extends WindowAdapter 
					implements ActionListener{
		//Field
		boolean appendOK = false;
		
		//Method

		public void windowClosing(WindowEvent we) {
			//System.out.println("----------------->> ���α׷� ����");
			System.exit(0);			
		}
		
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			String fname = jt_file.getText().trim();
			
			if(obj == jt_file) {				
				if(proc.fileCheck(fname)) {
					int choice = JOptionPane.showConfirmDialog(null,
									"���������մϴ�. \n�̾ �����ұ��?");
					if(choice ==0) { //���� ���Ͽ� �̾ ����
						appendOK = true;
					}else if(choice ==1) { //���ο� ���� �Է�
						jt_file.setText("");
						jt_file.requestFocus();
					}
				}else {
					int createChoice = JOptionPane.showConfirmDialog(null,
							"������������ �ʽ��ϴ�. \n���� �ұ��?");
					if(createChoice ==0) { //���� ����
						if(proc.createFile(fname)) {
							JOptionPane.showMessageDialog(null, "���ϻ��� �Ϸ�!!");
						}
					}else if(createChoice ==1) { //�������� ����
						jt_file.setText("");
						jt_file.requestFocus();
					}
				}
				
			}else if(obj == btnSave) {
				String content = ja_content.getText().trim();
				boolean result = proc.saveFile(fname, content, appendOK);
				
				if(result) JOptionPane.showMessageDialog(null, "���� �Ϸ�!");
				
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
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�.!");
				}
			}
		}
		
	}//MemoUIEvent class
	
}//class













