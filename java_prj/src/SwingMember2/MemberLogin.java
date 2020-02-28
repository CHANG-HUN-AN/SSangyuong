package SwingMember2;

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

public class MemberLogin {

	MemberMgmUI main;
	//Field
	JFrame jf;
	JTextField jt_id, jt_pass;
	JButton btnLogin,btnReset,btnExit;
	//Constructor
	public MemberLogin(MemberMgmUI main) {
		this.main = main;
		//Object
		Font font = new Font("���� ���",Font.BOLD,12);
		jf = new JFrame("�α���������");
		JPanel jp_title = new JPanel();JPanel jp_id = new JPanel();JPanel jp_pass = new JPanel();JPanel jp_button = new JPanel();
		JLabel jl_title = new JLabel("�α�����");JLabel jl_id = new JLabel("���̵�");JLabel jl_pass = new JLabel("��й�ȣ");
		jt_id = new JTextField(15); jt_pass= new JTextField(15);
		btnLogin = new JButton("�α���"); btnReset = new JButton("���"); btnExit = new JButton("����");
		//Field _declare
//		this.jt_id =jt_id; 
//		this.jt_pass = jt_pass;
		//font ����
		jl_title.setFont(font);jl_id.setFont(font);jl_pass.setFont(font);
		//�α����� panel_add
		jf.setLayout(new GridLayout(4,1));
		jp_title.add(jl_title);
		jp_id.add(jl_id);jp_id.add(jt_id);
		jp_pass.add(jl_pass);jp_pass.add(jt_pass);
		//��ư panel _add
		jp_button.add(btnLogin);jp_button.add(btnReset);jp_button.add(btnExit);
		//JFrame_panel_add
		jf.add(jp_title);jf.add(jp_id);jf.add(jp_pass);jf.add(jp_button);
		//midScreen_set
		jf.setSize(300,350);
		jf.setVisible(true);
		Dimension fsize = jf.getSize(); //jframe ���̵� setsizeũ��
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); //toolkit.getDefaultToolkit ���� tookit�� ȣ��
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2; //����� - ������ũ�� /2 
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		jf.setLocation(width,height);
//		Toolkit t = new Toolkit() ;//toolkit ��ü ���� �ȵ� ����ó�� ��getDefaultToolkit �� ���� static ��ü�� ����� ����ؾ���
		
		//event handler �޼ҵ� ȣ�� (=add~listener �޼ҵ�ȣ��) 
		JFrameObjectEvent eventObject = new JFrameObjectEvent();
		jf.addWindowListener(eventObject);
		btnLogin.addActionListener(eventObject);
		btnReset.addActionListener(eventObject);
		btnExit.addActionListener(eventObject);
		jt_pass.addActionListener(eventObject);
	}
	
	//�̺�Ʈ�� ó���ϴ� inner class =scope �� �޼ҵ������� ����ȴ�.
	class JFrameObjectEvent extends WindowAdapter implements ActionListener{
		public void  windowClosing(WindowEvent e) {
			System.out.println("==========���α׷�����=========");
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == btnLogin || jt_pass == ae.getSource()) {
				System.out.println("�α��ε�");
				if(valitdationCheck()) {
					logincheck();
				}
			}else if(obj == btnReset) {
				jt_id.setText("");
				jt_pass.setText("");
			}else if(obj == btnExit){
				System.exit(0);
			}
		}
	}
	
	//Method
	public boolean valitdationCheck() {//������ ��ȿ�� üũ
		//jt_id , jt_pass �� ���� ������ �޽��� ȣ��
		boolean count = false;
		if (jt_id.getText().equals("") ) {
			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���","����",2);
			jt_id.requestFocus();
		}else if(jt_pass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���","����",2);
			jt_pass.requestFocus();
		}else {
			count = true;
		}
		return count;
	}//validation**//
	
	public void logincheck() {
		String did = "test";
		String dpass ="1234";
		String uid = jt_id.getText().trim();
		String upass = jt_pass.getText().trim();
		
		if(uid.equals(did) ) {
			if(upass.equals(dpass)) {
				JOptionPane.showMessageDialog(null, "�α��� ����");
				jf.setVisible(false);
				main.start(); //Error  java.lang.NullPointerException ->main�� �����ڷ� �Ѱܹ����� ����
			}else {
				JOptionPane.showMessageDialog(null, "�α��� ����,��й�ȣ �����Դϴ�.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "�α��� ����,���̵� �ٽ��Է��Ͻʽÿ�","����",2);
		}
	}//loginCheck()
	
}//class
