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
	//*회원등록
	//***Constructor///
	public CrudMgmSystemUI() {
		start();
	}
	//***Method///
	//inner class**(EventClass)
	class CrudMgmEvent extends WindowAdapter implements ActionListener{
		public void  windowClosing(WindowEvent e) {
			System.out.println("==========프로그램종료=========");
			System.exit(0);
		}
		public void actionPerformed(ActionEvent e) {
			String bname = e.getActionCommand();
			
			if(bname.equals("회원생성")) {
				JOptionPane.showMessageDialog(null, "회원생성");
			}else if(bname.equals("회원리스트")) {
				JOptionPane.showMessageDialog(null, "회원리스트");
			}else if(bname.equals("회원검색")){
				JOptionPane.showMessageDialog(null, "회원검색");
			}else if(bname.equals("회원수정")){
				JOptionPane.showMessageDialog(null, "회원수정");
			}else if(bname.equals("회원삭제")){
				JOptionPane.showMessageDialog(null, "회원삭제");
			}else if(bname.equals("시스템종료")){
				JOptionPane.showMessageDialog(null, "시스템종료");
				System.exit(0);
			}
		}
	}
	
	public void start() {
		//객체 생성
		jf=new JFrame();
		 jp_wp=new JPanel();jp_ep=new JPanel();
		 jb_create=new JButton("회원생성");jb_list=new JButton("회원리스트");jb_search=new JButton("회원검색");
		 jb_update=new JButton("회원수정");jb_delete=new JButton("회원삭제");jb_exit=new JButton("시스템종료");
		 jl_main=new JLabel("============회원관리 프로그램에 접속하였습니다===========");
		 jl_img = new JLabel(new ImageIcon("src/day0226/main.png"));
		 //layout 설정
		 jp_wp.setLayout(new GridLayout(6,1));
		 jf.setLayout(new BorderLayout());
		
		 //패널에 add
		 jp_wp.add(jb_create); jp_wp.add(jb_list);jp_wp.add(jb_search);
		 jp_wp.add(jb_update);jp_wp.add(jb_delete);jp_wp.add(jb_exit);
		 jp_ep.add(jl_main);jp_ep.add(jl_img);
		 jf.add(jp_wp,BorderLayout.WEST);jf.add(jp_ep,BorderLayout.CENTER);
		 System.out.println(BorderLayout.WEST);
		 
		 //Frame생성 및 가운데정렬
		 jf.setSize(600,500);
		 jf.setVisible(true);
		 Dimension jf_size = jf.getSize();
		 Dimension wi_size = Toolkit.getDefaultToolkit().getScreenSize();
		 int width = (wi_size.width - jf_size.width)/2;
		 int height = (wi_size.height - jf_size.height)/2;
		 jf.setLocation(width,height);
		 
		 //add~Listner (handler 메소드 등록)
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
