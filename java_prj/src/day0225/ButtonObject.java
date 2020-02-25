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
		Button btn1 = new Button("�α���");
		Button btn2 = new Button("���");
		
		btn_panel.add(btn1);
		btn_panel.add(btn2);
		
		add(btn_panel);
		
		setSize(500,500);
		setVisible(true);
		
		//�̺�Ʈ ������
		ButtonObjectEvent event = new ButtonObjectEvent(); //���־��̴� ��ü�� �Ź� �����ϴ°ͺ��� �ߺ��Ǵ� ������ ���´�.
		addWindowListener(event);
		btn1.addActionListener(event);
		btn2.addActionListener(event);
	}
	// Method
	//�̺�Ʈ ó���� ���� inner Class
	class ButtonObjectEvent extends WindowAdapter implements ActionListener{
		@Override//������ ���� �̺�Ʈ ó��
		public void windowClosing(WindowEvent e) {
			System.out.println("�ý�������!");
			System.exit(0);
		}
		//��ư�� �׼� �̺�Ʈ ó��
		public void actionPerformed(ActionEvent e) {
			String bname = e.getActionCommand();
			if(bname.equals("�α���")) {
				System.out.println("�α���");
			}else if(bname.equals("���")) {
				System.out.println("���");
			}
		}
	}
	
	
}//class
