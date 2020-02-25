package day0224;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *Container: window , Frame, Panel, Dialog , ...
 *Component : Button, Radio , TextArea, TextField;...
 *+add ~~~ Listener 메소드를 통해 UI와 Event 연결!!:
 *Event : 이벤트 인터페이스 (~~Listener)를 이용하여 구현
 * @author user
 */
//자기자신을 Frame 으로 상속받은경우 
public class FrameObject3 extends Frame {
	// Field
	//	Frame f;
	// Constructor
	public FrameObject3() {
//		f = new Frame("프레임 테스트");
		setTitle("상속받은 프레임생성");
		//button 생성
		Button btn1 = new Button("North!");
		Button btn2 = new Button("Center!");
		Button btn3 = new Button("East!");
		Button btn4 = new Button("West!");
		Button btn5 = new Button("South!");
		
		add(btn1,BorderLayout.NORTH);
		add(btn2,BorderLayout.CENTER);
		add(btn3,BorderLayout.EAST);
		add(btn4,BorderLayout.WEST);
		add(btn5,BorderLayout.SOUTH);
		
		setSize(300, 300);
		setVisible(true);
		
		////FrameObject3Event이름의 inner class 를 생성하여 이벤트 처리 
		addWindowListener(new FrameObject3Event());
	}
	// Method
	//FrameObject3Event inner class 생성 - 단 , 어댑터 클래스를 사용하시요
	class FrameObject3Event extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("==프레임을 종료합니다.==");
			System.exit(0);
		}
	}//inner class
}//class
