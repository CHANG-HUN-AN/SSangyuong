package day0225;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonObject extends Frame {
	// Field
	// Constructor
	public ButtonObject() {
		Panel btn_panel = new Panel();
		Button btn1 = new Button("로그인");
		Button btn2 = new Button("취소");
		
		btn_panel.add(btn1);
		btn_panel.add(btn2);
		
		add(btn_panel);
		
		setSize(500,500);
		setVisible(true);
		
		//이벤트 리스너
		ButtonObjectEvent event = new ButtonObjectEvent(); //자주쓰이는 객체는 매번 생성하는것보다 중복되는 생성을 막는다.
		addWindowListener(event);
		btn1.addActionListener(event);
		btn2.addActionListener(event);
	}
	// Method
	//이벤트 처리를 위한 inner Class
	class ButtonObjectEvent extends WindowAdapter implements ActionListener{
		@Override//프레임 종료 이벤트 처리
		public void windowClosing(WindowEvent e) {
			System.out.println("시스템종료!");
			System.exit(0);
		}
		//버튼의 액션 이벤트 처리
		public void actionPerformed(ActionEvent e) {
			String bname = e.getActionCommand();
			if(bname.equals("로그인")) {
				System.out.println("로그인");
			}else if(bname.equals("취소")) {
				System.out.println("취소");
			}
		}
	}
	
	
}//class
