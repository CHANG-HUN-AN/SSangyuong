package day0224;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *Container: window , Frame, Panel, Dialog , ...
 *Component : Button, Radio , TextArea, TextField;...
 *+add ~~~ Listener �޼ҵ带 ���� UI�� Event ����!!:
 *Event : �̺�Ʈ �������̽� (~~Listener)�� �̿��Ͽ� ����
 * @author user
 */
public class FrameObject {
	// Field
	Frame f;

	// Constructor
	public FrameObject() {
		f = new Frame("������ �׽�Ʈ");
		
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

	//�̺�Ʈ ó���� ���� inner class
	class FrameObjectEvent implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			
		}
		public void windowClosed(WindowEvent e) {
			
		}
		public void windowClosing(WindowEvent e) {
			System.out.println("==�������� �����մϴ�.==");
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
//	//������� Ŭ���� �޼ҵ��ڸ��� Ŭ������ �ִ°�
}//class

//�ϳ��� java���Ͽ� public class �����ϰ� �������� class ���𰡴� 
//����Ʈ�ڵ� ������ ������ class ���Ϸ� �����ȴ�. 
//class Test{
//	
//}//class <-- ����Ŭ���� �ƴ�
