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
 *+add ~~~ Listener �޼ҵ带 ���� UI�� Event ����!!:
 *Event : �̺�Ʈ �������̽� (~~Listener)�� �̿��Ͽ� ����
 * @author user
 */
//�ڱ��ڽ��� Frame ���� ��ӹ������ 
public class FrameObject2 extends Frame {
	// Field
//	Frame f;

	// Constructor
	public FrameObject2() {
//		f = new Frame("������ �׽�Ʈ");
		setTitle("��ӹ��� �����ӻ���");
	
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
		
		////Anoymous inner class �� �����Ͽ� �̺�Ʈ ó�� ->ȣ��Ǵ� ��ġ�� ����
		addWindowListener(new WindowListener(){
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
		});
	}
	// Method
	

}
