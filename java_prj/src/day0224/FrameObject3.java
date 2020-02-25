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
 *+add ~~~ Listener �޼ҵ带 ���� UI�� Event ����!!:
 *Event : �̺�Ʈ �������̽� (~~Listener)�� �̿��Ͽ� ����
 * @author user
 */
//�ڱ��ڽ��� Frame ���� ��ӹ������ 
public class FrameObject3 extends Frame {
	// Field
	//	Frame f;
	// Constructor
	public FrameObject3() {
//		f = new Frame("������ �׽�Ʈ");
		setTitle("��ӹ��� �����ӻ���");
		//button ����
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
		
		////FrameObject3Event�̸��� inner class �� �����Ͽ� �̺�Ʈ ó�� 
		addWindowListener(new FrameObject3Event());
	}
	// Method
	//FrameObject3Event inner class ���� - �� , ����� Ŭ������ ����Ͻÿ�
	class FrameObject3Event extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("==�������� �����մϴ�.==");
			System.exit(0);
		}
	}//inner class
}//class
