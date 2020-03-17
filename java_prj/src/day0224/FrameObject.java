package day0224;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *Container: window , Frame, Panel, Dialog , ...
 *Component : Button, Radio , TextArea, TextField;...
 *+add ~~~ Listener 메소드를 통해 UI와 Event 연결!!:
 *Event : 이벤트 인터페이스 (~~Listener)를 이용하여 구현
 * @author user
 */
public class FrameObject {
	// Field
	Frame f;

	// Constructor
	public FrameObject() {
		f = new Frame("프레임 테스트");
		
		f.setLayout(new GridLayout(3,2));
		Button btn1 = new Button("1!");
		Button btn2 = new Button("2!");
		Button btn3 = new Button("3!");
		Button btn4 = new Button("4!");
		Button btn5 = new Button("5!");
		Button btn6 = new Button("6!");
		f.add(btn1);f.add(btn2);f.add(btn3);f.add(btn4);f.add(btn5);f.add(btn6);
		
		f.setVisible(true);
		f.setSize(300, 200);
		
		f.addWindowListener(new FrameObjectEvent());
	}
	// Method

	//이벤트 처리를 위한 inner class
	class FrameObjectEvent implements WindowListener{

		@Override
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
	}
//	class Test{
//		
//	}//inner class
//	//만들어진 클래스 메소드자리에 클래스를 넣는것
}//class

//하나의 java파일에 public class 제외하고 여러개의 class 선언가능 
//바이트코드 생성시 별도의 class 파일로 생성된다. 
//class Test{
//	
//}//class <-- 내부클래스 아님
