package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 3. Ui와 IO패키지의 클래스를 통해 연결한다.
 * 
 * @author user
 */
public class testUI extends JFrame {
	testUIProc proc = new testUIProc();
	
	JPanel titlepan, bodypan, buttonpan;
	JLabel jl_title;
	JTextField jt_title;
	JTextArea jta_body;
	JButton jb_save, jb_cancel,jb_load;
	JComboBox jc ;
	Font font = new Font("맑은 고딕",Font.BOLD,16);
	public testUI() {
		start();
	}

	public void start() {
		jc = new JComboBox();
		jc.addItem("파일저장");
		jc.addItem("파일 읽기");
		
		titlepan = new JPanel();
		bodypan = new JPanel();
		buttonpan = new JPanel();
		jl_title = new JLabel("파일명>>");
		jt_title = new JTextField(20);
		jta_body = new JTextArea(50, 43);
		jb_save = new JButton("저장");
		jb_cancel = new JButton("리셋");
		jb_load =  new JButton("로드");
		
		jl_title.setFont(font); jb_save.setFont(font);jb_cancel.setFont(font);jb_load.setFont(font);

		jta_body.setBackground(	new Color(149,232,177));
		titlepan.add(jl_title);
		titlepan.add(jt_title);
		bodypan.add(jta_body);
		buttonpan.add(jb_save);
		buttonpan.add(jb_cancel);
		buttonpan.add(jb_load);
		
		add(titlepan, new BorderLayout().NORTH);
		add(bodypan, new BorderLayout().CENTER);
		add(buttonpan, new BorderLayout().SOUTH);

		setSize(500, 500);
		setVisible(true);
		Dimension fsize = getSize();
		Dimension wsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (wsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (wsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		
		MemoUiEvent eventObj = new MemoUiEvent();
		addWindowListener(eventObj);
		jt_title.addActionListener(eventObj);
		jb_save.addActionListener(eventObj);
		jb_cancel.addActionListener(eventObj);
		jb_load.addActionListener(eventObj);
	}

	// Method
	class MemoUiEvent extends WindowAdapter implements ActionListener {
		boolean appendOK = false;
		@Override
		public void windowClosing(WindowEvent e) {
			int confirm = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?","",0);
			if (confirm == 0) {
				System.exit(0);
			}else {
				
			}
		}
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			String fname = jt_title.getText().trim();
			
			//event jb_load 에서 일어났으면
			if (obj == jb_load) { //파일 불러오기
				jta_body.setText("");
				if(proc.fileCheck(fname)) {//file 여부 체크
					String data = proc.fileRead(fname).trim();
					jta_body.append(data);
					jta_body.setBackground(Color.white);
				}else {
					JOptionPane.showMessageDialog(null, "파일이 존재 하지 않습니다");
				}
			} else if (obj == jt_title) {
//				JOptionPane.showMessageDialog(null, "파일체크");

				if(proc.fileCheck(fname)) {
					int confirm =JOptionPane.showConfirmDialog(null, "파일이존재합니다.\n추가 작성을 진행하시겠습니까?");
					if(confirm == 0) {//기존 파일에 이어서 저장
						appendOK=true;
					}else if(confirm == 1) {//새로운 파일 입력
						reset();
					}
				}else {
					int confrimCreate =JOptionPane.showConfirmDialog(null, "파일이존재하지않습니다.\n파일을생성하시겠습니까?", "", 2);
					if(confrimCreate == 0) {
						if(proc.fileCreate(fname)) {
							//파일생성완료
							JOptionPane.showMessageDialog(null, "파일생성완료");
						}else {
							reset();
						}
					}
				}
			}else if (obj == jb_save) {
//				JOptionPane.showMessageDialog(null, "저장");
				String content = ("\t"+jta_body.getText().trim());
				boolean result = proc.fileSave(fname,content,appendOK);
				if(result) {
					JOptionPane.showMessageDialog(null, "파일저장완료");
					jta_body.setBackground(	new Color(149,232,177));
				}//파일저장완료
			}else if (obj == jb_cancel) {
				JOptionPane.showMessageDialog(null, "리셋 완료");
				reset();
			}
		}
	}//event inner class
	
	public void reset() {
		jt_title.setText("");
		jta_body.setText("");
		jt_title.requestFocus();
	}
	public void fileWorking() {
		
	}
	
}// class
