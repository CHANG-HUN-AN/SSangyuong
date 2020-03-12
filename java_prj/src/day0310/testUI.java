package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * 3. Ui�� IO��Ű���� Ŭ������ ���� �����Ѵ�.
 * 
 * @author user
 */
public class testUI extends JFrame {
	testUIProc proc = new testUIProc();
	
	JPanel titlepan, bodypan, buttonpan;
	JLabel jl_title;
	JTextField jt_title;
	JTextArea jta_body;
	JButton jb_save, jb_cancel,jb_load;
	JComboBox<String> jcb ;
	Font font = new Font("���� ���",Font.BOLD,16);
	
	public testUI() {
		start();
	}

	public void start() {
		//object
		titlepan = new JPanel();
		bodypan = new JPanel();
		buttonpan = new JPanel();
		jl_title = new JLabel("���ϸ�>>");
		jt_title = new JTextField(20);
		jta_body = new JTextArea(50, 43);
		jb_save = new JButton("����");
		jb_cancel = new JButton("����");
		jb_load =  new JButton("�ε�");
		jcb = new JComboBox<String>();
		jcb.addItem("��������");
		jcb.addItem("�����б�");
		//font
		jl_title.setFont(font); jb_save.setFont(font);jb_cancel.setFont(font);jb_load.setFont(font); jcb.setFont(font);
		
		jta_body.setBackground(	new Color(149,232,177));
		titlepan.add(jcb);
		titlepan.add(jt_title);
		bodypan.add(jta_body);
		buttonpan.add(jb_save);
		buttonpan.add(jb_cancel);
		buttonpan.add(jb_load);
		
		add(titlepan, new BorderLayout().NORTH);
		add(bodypan, new BorderLayout().CENTER);
		add(buttonpan, new BorderLayout().SOUTH);

		setSize(500, 500);
		setVisible(true);
		Dimension fsize = getSize();
		Dimension wsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (wsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (wsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		
		MemoUiEvent eventObj = new MemoUiEvent();
		addWindowListener(eventObj);
		jb_save.addActionListener(eventObj);
		jb_load.addActionListener(eventObj);
		jb_cancel.addActionListener(eventObj);
		jcb.addItemListener(eventObj);
	}

	// Method
	class MemoUiEvent extends WindowAdapter implements ActionListener,ItemListener {
		boolean appendOK = false;
		@Override
		public void windowClosing(WindowEvent e) {
			int confirm = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","",0);
			if (confirm == 0) {
				System.exit(0);
			}else {
				
			}
		}
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			String fname = jt_title.getText().trim();
			String content = (jta_body.getText().trim());
			
			//event jb_load ���� �Ͼ����
			if (obj == jb_load) { //���� �ҷ�����
				jta_body.setText("");
				if(proc.fileCheck(fname)) {//file ���� üũ
					String data = proc.fileRead(fname).trim();
					jta_body.append(data);
					jta_body.setBackground(	new Color(255,178,217));
				}else {
					JOptionPane.showMessageDialog(null, "������ ���� ���� �ʽ��ϴ�");
				}
			} else if (obj == jt_title) {
//				JOptionPane.showMessageDialog(null, "����üũ");

				if(proc.fileCheck(fname)) {
					int confirm = JOptionPane.showConfirmDialog(null, "�����������մϴ�.\n�߰� �ۼ��� �����Ͻðڽ��ϱ�?");
					if(confirm == 0) {//���� ���Ͽ� �̾ ����
						appendOK=true;
					}else if(confirm == 1) {//���ο� ���� �Է�
						reset();
					}
				}else {
					int confrimCreate =JOptionPane.showConfirmDialog(null, "���������������ʽ��ϴ�.\n�����������Ͻðڽ��ϱ�?", "", 2);
					if(confrimCreate == 0) {
						if(proc.fileCreate(fname)) {
							//���ϻ����Ϸ�
							JOptionPane.showMessageDialog(null, "���ϻ����Ϸ�");
						}else {
							reset();
						}
					}
				}
			}else if (obj == jb_save) {
				//���� üũ �� ���� ����
				if(proc.fileCheck(fname)) {
					//�̾ ���忩�� ����!!
					int select =JOptionPane.showConfirmDialog(null, "������ �����մϴ�\n�߰��ۼ� �Ͻðڽ��ϱ�?");
					boolean result = false;
					if(select == 0) {
						result = proc.fileSave(fname,content,true);
						//��������Ϸ�
					}else if(select == 1) {
						result = proc.fileSave(fname,content,false);
					}
					if(result)
						JOptionPane.showMessageDialog(null, "����Ϸ�!");
				}else {
					int select = JOptionPane.showConfirmDialog(null, "������ �������� �ʽ��ϴ�.\n���ϻ����� �����ұ��?");
					if( select == 0 ) {
						if(proc.fileCreate(fname)) {
							boolean result = proc.fileSave(fname,content,false);
							if(result)
								JOptionPane.showMessageDialog(null, "����Ϸ�!");
						}
					}
				}
//				JOptionPane.showMessageDialog(null, "����");
			}else if (obj == jb_cancel) {
				JOptionPane.showMessageDialog(null, "���� �Ϸ�");
				reset();
			}
		}
		@Override
		public void itemStateChanged(ItemEvent ie) {
//			System.out.println(ie.getItem());  ->item �� �ٲ�� select unselect �� �׸� �� 2���� �Ѿ�ͼ� �������� �ʴ�
			JComboBox sjcb = (JComboBox)ie.getSource();
			int itemIndex = sjcb.getSelectedIndex();
			
			if(itemIndex==0) {
				jta_body.setText("");
				jta_body.setBackground(	new Color(149,232,177));
				jta_body.setEditable(true);
			}else if (itemIndex==1) {
				jta_body.setText("");
				jta_body.setBackground(	new Color(255,178,217));
				jta_body.setEditable(false);
			}
		}
	}//event inner class
	
	public void reset() {
		jt_title.setText("");
		jta_body.setText("");
		jt_title.requestFocus();
	}
	public void fileWorking() {
		
	}
	
}// class
