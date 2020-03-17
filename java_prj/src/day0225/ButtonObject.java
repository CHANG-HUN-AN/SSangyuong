package day0225;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ButtonObject extends Frame {
	//Field
	//Constructor
	public ButtonObject() {
		Panel btnPanel = new Panel();
		Button btn1 = new Button("로그인");
		Button btn2 = new Button("취소");
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		add(btnPanel);
		setSize(300,300);
		setVisible(true);
		
		//이벤트 리스너
		ButtonObjectEvent eventObject = new ButtonObjectEvent();
		addWindowListener(eventObject);
		btn1.addActionListener(eventObject);
		btn2.addActionListener(eventObject);
	}
	
	//이벤트 처리를 위한 inner class
	class ButtonObjectEvent extends WindowAdapter
								implements ActionListener{
		
		/**  프레임 종료 이벤트 처리 **/
		public void windowClosing(WindowEvent e) {
			System.out.println("-- 프로그램을 종료합니다. ---");
			System.exit(0);
		}
		
		/** 버튼의 액션 이벤트 처리 **/
		public void actionPerformed(ActionEvent e)  {
			String bname = e.getActionCommand();
			
			if(bname.equals("로그인")) {
				System.out.println("로그인");
			}else if(bname.equals("취소")) {
				System.out.println("취소");
			}
		}
	} 
	
}//class














