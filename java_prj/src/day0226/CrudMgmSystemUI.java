package day0226;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CrudMgmSystemUI {
	//***Field
	JFrame jf;
	JPanel jp_wp,jp_ep;
	JButton  jb_create,jb_list,jb_read,jb_search,jb_update,jb_delete,jb_exit;
	JLabel jl_main,jl_img;
	//*ȸ�����
	//***Constructor///
	public CrudMgmSystemUI() {
		start();
	}
	//***Method///
	//inner class**(EventClass)
	class CrudMgmEvent extends WindowAdapter implements ActionListener{
		public void  windowClosing(WindowEvent e) {
			System.out.println("==========���α׷�����=========");
			System.exit(0);
		}
		public void actionPerformed(ActionEvent e) {
			String bname = e.getActionCommand();
			
			if(bname.equals("ȸ������")) {
				JOptionPane.showMessageDialog(null, "ȸ������");
			}else if(bname.equals("ȸ������Ʈ")) {
				JOptionPane.showMessageDialog(null, "ȸ������Ʈ");
			}else if(bname.equals("ȸ���˻�")){
				JOptionPane.showMessageDialog(null, "ȸ���˻�");
			}else if(bname.equals("ȸ������")){
				JOptionPane.showMessageDialog(null, "ȸ������");
			}else if(bname.equals("ȸ������")){
				JOptionPane.showMessageDialog(null, "ȸ������");
			}else if(bname.equals("�ý�������")){
				JOptionPane.showMessageDialog(null, "�ý�������");
				System.exit(0);
			}
		}
	}
	
	public void start() {
		//��ü ����
		jf=new JFrame();
		 jp_wp=new JPanel();jp_ep=new JPanel();
		 jb_create=new JButton("ȸ������");jb_list=new JButton("ȸ������Ʈ");jb_search=new JButton("ȸ���˻�");
		 jb_update=new JButton("ȸ������");jb_delete=new JButton("ȸ������");jb_exit=new JButton("�ý�������");
		 jl_main=new JLabel("============ȸ������ ���α׷��� �����Ͽ����ϴ�===========");
		 jl_img = new JLabel(new ImageIcon("src/day0226/main.png"));
		 //layout ����
		 jp_wp.setLayout(new GridLayout(6,1));
		 jf.setLayout(new BorderLayout());
		
		 //�гο� add
		 jp_wp.add(jb_create); jp_wp.add(jb_list);jp_wp.add(jb_search);
		 jp_wp.add(jb_update);jp_wp.add(jb_delete);jp_wp.add(jb_exit);
		 jp_ep.add(jl_main);jp_ep.add(jl_img);
		 jf.add(jp_wp,BorderLayout.WEST);jf.add(jp_ep,BorderLayout.CENTER);
		 System.out.println(BorderLayout.WEST);
		 
		 //Frame���� �� �������
		 jf.setSize(600,500);
		 jf.setVisible(true);
		 Dimension jf_size = jf.getSize();
		 Dimension wi_size = Toolkit.getDefaultToolkit().getScreenSize();
		 int width = (wi_size.width - jf_size.width)/2;
		 int height = (wi_size.height - jf_size.height)/2;
		 jf.setLocation(width,height);
		 
		 //add~Listner (handler �޼ҵ� ���)
		 CrudMgmEvent cmEvent = new CrudMgmEvent();
		 jf.addWindowListener(cmEvent);
		 jb_create.addActionListener(cmEvent);
		 jb_list.addActionListener(cmEvent);
		 jb_search.addActionListener(cmEvent);
		 jb_update.addActionListener(cmEvent);
		 jb_delete.addActionListener(cmEvent);
		 jb_exit.addActionListener(cmEvent);
		 
		 
	}
	
}
