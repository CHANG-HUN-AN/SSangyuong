package day0224;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *Container: window , Frame, Panel, Dialog , ...
 *Component : Button, Radio , TextArea, TextField;...
 *+add ~~~ Listener 메소드를 통해 UI와 Event 연결!!:
 *Event : 이벤트 인터페이스 (~~Listener)를 이용하여 구현
 * @author user
 */
//자기자신을 Frame 으로 상속받은경우 
public class FrameObject2 extends Frame {
	// Field
//	Frame f;

	// Constructor
	public FrameObject2() {
//		f = new Frame("프레임 테스트");
		setTitle("상속받은 프레임생성");
	
		Button btn1 = new Button("North!");
		Button btn2 = new Button("Center!");
		Button btn3 = new Button("East!");
		Button btn4 = new Button("West!");
		Button btn5 = new Button("South!");
		
		setLayout(new FlowLayout());
		add(btn1);add(btn2);add(btn3);add(btn4);add(btn5);
		
//		add(btn2,FlowLayout.LEFT);
//		add(btn3,BorderLayout.EAST);
//		add(btn4,BorderLayout.WEST);
//		add(btn5,BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(300, 200);
		
		////Anoymous inner class 를 생성하여 이벤트 처리 ->호출되는 위치에 생성
		addWindowListener(new WindowListener(){
			public void windowActivated(WindowEvent e) {
				
			}
			public void windowClosed(WindowEvent e) {
				
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("==프레임을 종료합니다.==");
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent e) {
				
			}
			public void windowDeiconified(WindowEvent e) {
				
			}
			public void windowIconified(WindowEvent e) {
				
			}
			
			public void windowOpened(WindowEvent e) {
				
			}
		});
	}
	// Method
	

}
