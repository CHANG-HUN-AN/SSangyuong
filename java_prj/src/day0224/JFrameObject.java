package day0224;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Toolkit;

public class JFrameObject {

	//Field
	JFrame jf;
	JTextField tid;
	JTextField tpass;
	//Constructor
	public JFrameObject() {
		Font font = new Font("���� ���",Font.BOLD,12);
		jf = new JFrame("�α���������");
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pass = new JPanel();
		JPanel jp_button = new JPanel();
		
		JLabel title = new JLabel("�α�����");
		JLabel id = new JLabel("���̵�");
		JTextField tid = new JTextField(15);
		this.tid =tid; 
		JLabel pass = new JLabel("��й�ȣ");
		JTextField tpass= new JTextField(15);
		this.tpass = tpass;
		JButton btnLogin = new JButton("�α���");
		JButton btnReset = new JButton("���");
		JButton btnExit = new JButton("����");
		//font ����
		title.setFont(font);
		id.setFont(font);
		pass.setFont(font);
//		jf.add(title,BorderLayout.NORTH);
		//�α�����
		jf.setLayout(new GridLayout(4,1));
		jp_title.add(title);
		//���̵�
		jp_id.add(id);
		jp_id.add(tid);
		//��й�ȣ
		jp_pass.add(pass);
		jp_pass.add(tpass);
		//��ư
		jp_button.add(btnLogin);
		jp_button.add(btnReset);
		jp_button.add(btnExit);
		
		jf.add(jp_title);
		jf.add(jp_id);
		jf.add(jp_pass);
		jf.add(jp_button);
		
		jf.setSize(300,350);
		jf.setVisible(true);
		//����ͻ���� ���� ������� ���缭 ����
		Dimension fsize = jf.getSize(); //jframe ���̵� setsizeũ��
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); //toolkit.getDefaultToolkit ���� tookit�� ȣ�� 
		//getScreensize DimensionŸ�Թ�ȯ ->������ ����� ������ũ�⸦ ������
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2; //����� - ������ũ�� /2 
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		
		jf.setLocation(width,height);
//		Toolkit t = new Toolkit() ;//toolkit ��ü ���� �ȵ� ����ó�� ��getDefaultToolkit �� ���� static ��ü�� ����� ����ؾ���
		
//		System.out.println("width ="+fsize.getWidth() +"height"+ fsize.getHeight());
		
		//event handler �޼ҵ� ȣ�� (=add~listener �޼ҵ�ȣ��) 
		JFrameObjectEvent eventObject = new JFrameObjectEvent();
		jf.addWindowListener(eventObject);
		btnLogin.addActionListener(eventObject);
		btnReset.addActionListener(eventObject);
		btnExit.addActionListener(eventObject);
		tpass.addActionListener(eventObject);
		//add~Listener �� ���� ui�� event �� ���� 
		//WindowAdapter �� event ó�� ��ü(listener �������̽� ��ӹ���)
//		jf.addWindowListener(new WindowAdapter() {
//			public void  windowClosing(WindowEvent e) {
//				System.out.println("==========���α׷�����=========");
//				System.exit(0);
//			}
//		});
	}
	//�̺�Ʈ�� ó���ϴ� inner class =scope �� �޼ҵ������� ����ȴ�.
	class JFrameObjectEvent extends WindowAdapter implements ActionListener{
		public void  windowClosing(WindowEvent e) {
			System.out.println("==========���α׷�����=========");
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String bname = e.getActionCommand();
			if(bname.equals("�α���")) {
				String did = "test";
				String dpass ="1234";
				String uid = tid.getText().trim();
				String upass = tpass.getText().trim();
				if(uid.equals(did) ) {
					if(upass.equals(dpass)) {
						JOptionPane.showMessageDialog(null, "�α��� ����");
					}else {
						JOptionPane.showMessageDialog(null, "�α��� ����,��й�ȣ �����Դϴ�.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "�α��� ����,���̵� �ٽ��Է��Ͻʽÿ�","����",2);
				}
			}else if(bname.equals("���")) {
				tid.setText("");
				tpass.setText("");
			}else if(bname.equals("����")){
				System.out.println("�����ư�� Ŭ���Ǿ����ϴ�.");
				System.exit(0);
			}else if(tpass == e.getSource()) {//�α��� ���ͷ� Ȯ���ϱ�
				if(bname.equals("�α���")) {
					String did = "test";
					String dpass ="1234";
					String uid = tid.getText().trim();
					String upass = tpass.getText().trim();
					if(uid.equals(did) ) {
						if(upass.equals(dpass)) {
							JOptionPane.showMessageDialog(null, "�α��� ����");
						}else {
							JOptionPane.showMessageDialog(null, "�α��� ����,��й�ȣ �����Դϴ�.");
						}
					}else {
						JOptionPane.showMessageDialog(null, "�α��� ����,���̵� �ٽ��Է��Ͻʽÿ�","����",2);
					}
				}else if(bname.equals("���")) {
					tid.setText("");
					tpass.setText("");
				}else if(bname.equals("����")){
					System.out.println("�����ư�� Ŭ���Ǿ����ϴ�.");
					System.exit(0);
				}
		}
	}
	}
	//Method
	
}
