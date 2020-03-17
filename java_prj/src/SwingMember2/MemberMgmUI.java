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
	static Font font = new Font("맑은 고딕", Font.BOLD, 12);
//	//회원등록 필드
	JPanel totPane = new JPanel();
	//리스트 필드
	JPanel listPane = new JPanel();
	//서치 필드
	JPanel searchPane= new JPanel();
	//업데이트 필드
	JPanel updatePanel= new JPanel();
	//딜리트 필드
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
		jl_title = new JLabel("\n== 회원등록 시스템에 오신것을 환영합니다 ==");
		jl_img = new JLabel(new ImageIcon("src/day0226_t/main.png"));
		
		btnReg = new JButton("회원등록");
		btnList = new JButton("회원리스트");
		btnSearch = new JButton("회원검색");
		btnUpdate = new JButton("회원수정");
		btnDelete = new JButton("회원삭제");
		btnExit = new JButton("종료");
		
		jl_title.setFont(new Font("맑은 고딕",Font.BOLD,16));
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
		btnLogin=new JButton("로그인");btnJoin=new JButton("회원가입");;
		jl_title = new JLabel("\n== 회원등록 시스템에 오신것을 환영합니다 ==");
		jl_img = new JLabel(new ImageIcon("src/day0226_t/main.png"));
		
		//font_set
		jl_title.setFont(new Font("맑은 고딕",Font.BOLD,16));
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
	 *event처리
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
			JOptionPane.showMessageDialog(null, getMsg("프로그램 종료!!"));
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
				int result = JOptionPane.showConfirmDialog(null, getMsg("프로그램을 종료하시겠습니까?"));//예 0 아니요 1 취소 2
				if(result == 0) {
				System.exit(0);
				}
			}
		}
	}// inner_class
	
	//메시지를 입력받아 JLabel을 생성하고 폰트를 수정하여 리턴
	public JLabel getMsg(String msg) {
		JLabel msgLabel = new JLabel(msg);
		msgLabel.setFont(font);
		return msgLabel;
	}
	
	/**
	 * 패널이동시 중복문제를 해결하기위해 스위칭으로 꺼준다 
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
	//공통되는 부분을 메소드로 만든다!!
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
