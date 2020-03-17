package SwingMember2;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import day0219_t.Member;

public class MemberMgmUI extends JFrame{
	//Field
	public static final int REGISTER =1 ;
	public static final int LIST =2 ;
	public static final int SEARCH =3 ;
	public static final int UPDATE =4 ;
	public static final int DELETE =5 ;
	public static  ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	
	//Duplicate Object
	MemberMgmUIEvent eventObj = new MemberMgmUIEvent(this);
	
	JPanel mainPane, menuPane;
	JButton btnReg, btnList, btnSearch, btnUpdate, btnDelete, btnExit;
	JLabel jl_title,jl_img;
	//First_Form
	JPanel showPane,ShowButtonPane;
	JButton btnLogin,btnJoin;
	//font
	static Font font = new Font("���� ���", Font.BOLD, 12);
//	//ȸ����� �ʵ�
	JPanel totPane = new JPanel();
	//����Ʈ �ʵ�
	JPanel listPane = new JPanel();
	//��ġ �ʵ�
	JPanel searchPane= new JPanel();
	//������Ʈ �ʵ�
	JPanel updatePanel= new JPanel();
	//����Ʈ �ʵ�
	JPanel deletePane= new JPanel();
	
	//Constructor
	public MemberMgmUI() {
//		start();
		showMain();
	}
	
	//Method
	public void start() {
		showPane.setVisible(false);
		ShowButtonPane.setVisible(false);
		
		mainPane = new JPanel();
		
		menuPane = new JPanel(new GridLayout(10,1));
		jl_title = new JLabel("\n== ȸ����� �ý��ۿ� ���Ű��� ȯ���մϴ� ==");
		jl_img = new JLabel(new ImageIcon("src/day0226_t/main.png"));
		
		btnReg = new JButton("ȸ�����");
		btnList = new JButton("ȸ������Ʈ");
		btnSearch = new JButton("ȸ���˻�");
		btnUpdate = new JButton("ȸ������");
		btnDelete = new JButton("ȸ������");
		btnExit = new JButton("����");
		
		jl_title.setFont(new Font("���� ���",Font.BOLD,16));
		btnReg.setFont(font);	btnList.setFont(font);  btnSearch.setFont(font);
		btnUpdate.setFont(font);  btnDelete.setFont(font);  
		btnExit.setFont(font);
		
		mainPane.add(jl_img);
		mainPane.add(jl_title);			
		menuPane.add(btnReg);
		menuPane.add(btnList);
		menuPane.add(btnSearch);
		menuPane.add(btnUpdate);
		menuPane.add(btnDelete);
		menuPane.add(btnExit);

		add(menuPane, BorderLayout.WEST);
		add(mainPane, BorderLayout.CENTER);
		
		setSize(600,500);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
		
		setLocation(width, height);
		setVisible(true);

		addWindowListener(eventObj);
		btnReg.addActionListener(eventObj);
		btnList.addActionListener(eventObj);
		btnSearch.addActionListener(eventObj);
		btnUpdate.addActionListener(eventObj);
		btnDelete.addActionListener(eventObj);
		btnExit.addActionListener(eventObj);
	}//start();
	
	public void showMain() {
		//Object
		showPane=new JPanel();ShowButtonPane=new JPanel();
		btnLogin=new JButton("�α���");btnJoin=new JButton("ȸ������");;
		jl_title = new JLabel("\n== ȸ����� �ý��ۿ� ���Ű��� ȯ���մϴ� ==");
		jl_img = new JLabel(new ImageIcon("src/day0226_t/main.png"));
		
		//font_set
		jl_title.setFont(new Font("���� ���",Font.BOLD,16));
		btnLogin.setFont(font);btnJoin.setFont(font);
		
		//panel_add
		showPane.add(jl_img);
		showPane.add(jl_title);	
		ShowButtonPane.add(btnLogin);ShowButtonPane.add(btnJoin);
		//JPanel add
		add(showPane,BorderLayout.CENTER);
		add(ShowButtonPane,BorderLayout.SOUTH);
		//mid proc **size set
		setSize(600,500);
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
		setLocation(width, height);
		setVisible(true);
		//Listener Handler
		
		btnLogin.addActionListener(eventObj);
		btnJoin.addActionListener(eventObj);
	}
	
	/**
	 *eventó��
	 * @author user
	 */
	class MemberMgmUIEvent extends WindowAdapter implements ActionListener {
		//Field
		MemberMgmUI main;
		//Constructor
		public MemberMgmUIEvent() {
			
		}
		public MemberMgmUIEvent(MemberMgmUI main) {
			this.main = main;
		}
		//Method
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(null, getMsg("���α׷� ����!!"));
			System.exit(0);
		}
		
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(btnLogin == obj) {
				new MemberLogin(main);
			}else if (btnReg == obj ) {
				new MemberRegister(main).register();
			} else if (btnList == obj) {
				new MemberList(main).list();
			} else if (btnSearch == obj) {
				new MemberSearch(main).search();
			} else if (btnUpdate == obj) {
				new MemberUpdate(main).update();
			} else if (btnDelete == obj) {
				new MemberDelete(main).delete();
			} else if (btnExit == obj) {
				int result = JOptionPane.showConfirmDialog(null, getMsg("���α׷��� �����Ͻðڽ��ϱ�?"));//�� 0 �ƴϿ� 1 ��� 2
				if(result == 0) {
				System.exit(0);
				}
			}
		}
	}// inner_class
	
	//�޽����� �Է¹޾� JLabel�� �����ϰ� ��Ʈ�� �����Ͽ� ����
	public JLabel getMsg(String msg) {
		JLabel msgLabel = new JLabel(msg);
		msgLabel.setFont(font);
		return msgLabel;
	}
	
	/**
	 * �г��̵��� �ߺ������� �ذ��ϱ����� ����Ī���� ���ش� 
	 * @param menu
	 */
	public void switchPane(String menu) {
		resetPane();
		if(menu.equals("register")) {
			totPane.removeAll();
			totPane.setVisible(true);
		}else if(menu.equals("list")) {
			listPane.removeAll();
			listPane.setVisible(true);
		}else if(menu.equals("search")) {
			searchPane.removeAll();
			searchPane.setVisible(true);
		}else if(menu.equals("update")) {
			updatePanel.removeAll();
			updatePanel.setVisible(true);
		}else if(menu.equals("delete")) {
			deletePane.removeAll();
			deletePane.setVisible(true);
		}
	}
	//switching overLoding
	public void switchPane(int menu) {
		resetPane();
		//
		switch(menu) {
		case 1: 	totPane.removeAll();totPane.setVisible(true);break;
		case 2: 	listPane.removeAll();listPane.setVisible(true);break;
		case 3: 	searchPane.removeAll();searchPane.setVisible(true);break;
		case 4: 	updatePanel.removeAll();updatePanel.setVisible(true);break;
		case 5: 	deletePane.removeAll();deletePane.setVisible(true);break;
		}
	}
	//����Ǵ� �κ��� �޼ҵ�� �����!!
	public void resetPane() {
		showPane.setVisible(false);
		ShowButtonPane.setVisible(false);
		mainPane.setVisible(false);
		totPane.setVisible(false);
		listPane.setVisible(false);
		searchPane.setVisible(false);
		updatePanel.setVisible(false);
		deletePane.setVisible(false);
	}
}//class
