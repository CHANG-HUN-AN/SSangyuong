package day0226_t;


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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberMgmUI extends JFrame{
	//Field
	public static final int REGISTER =1 ;
	public static final int LIST =2 ;
	public static final int SEARCH =3 ;
	public static final int UPDATE =4 ;
	public static final int DELETE =5 ;
	
	JPanel mainPane, menuPane;
	JButton btnReg, btnList, btnSearch, btnUpdate, btnDelete, btnExit;
	JLabel jl_title,jl_img;
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	//회원등록 필드
	JPanel regPanel,titlePanel,jp_name,jp_addr,buttonPanel,totPane;
	JLabel jl_name,jl_addr,jl_reg_title;
	JTextField jt_name,jt_addr;
	JButton jb_register,jb_cancel;
	//list Field
	JPanel listPane;
	JTextArea ta;
	//search Field
	JPanel searchPane, jp_search,jp_serarchResult;;
	JLabel jl_searchName;
	JTextField jt_search;
	TextArea sta;
	//update_Field
	JPanel updatePanel,update_subPanel,jp_updateName,jp_updateAddr,jp_updateSearch;
	JLabel jl_updateName,jl_updateAddr,jl_updateSearchName;
	JTextField jt_updateName,jt_updateAddr,jt_updateSearch;
	//delete_Field
	JPanel deletePane,jp_deltetSearch;
	JLabel jl_deleteSearchName;
	JTextField jt_deleteSearch;
	
	
	//Constructor
	public MemberMgmUI() {
		start();
	}
	
	//Method
	public void start() {
		mainPane = new JPanel();
		totPane = new JPanel();
		listPane = new JPanel();
		searchPane=new JPanel();
		updatePanel=new JPanel();
		deletePane=new JPanel();
		
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
		
		setSize(700,500);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
		
		setLocation(width, height);
		setVisible(true);

		MemberMgmUIEvent eventobj = new MemberMgmUIEvent();
		addWindowListener(eventobj);
		btnReg.addActionListener(eventobj);
		btnList.addActionListener(eventobj);
		btnSearch.addActionListener(eventobj);
		btnUpdate.addActionListener(eventobj);
		btnDelete.addActionListener(eventobj);
		btnExit.addActionListener(eventobj);
	}
	
	/**
	 * 등록
	 */
	private void register() {
//		switchPane("register");
		switchPane(MemberMgmUI.REGISTER);
		
		//object 
		regPanel = new JPanel();
		jp_name = new JPanel();jp_addr = new JPanel();
		titlePanel=new JPanel();buttonPanel = new JPanel();
		jl_name = new JLabel("이름");jl_addr = new JLabel("주소");jl_reg_title= new JLabel("회원등록폼");
		jt_name = new JTextField(20);jt_addr = new JTextField(20);
		jl_name.setFont(font);jl_addr.setFont(font);
		jb_register = new JButton("등록");jb_cancel = new JButton("취소");
		//sub panel add
		titlePanel.add(jl_reg_title);
		jp_name.add(jl_name);jp_name.add(jt_name);
		jp_addr.add(jl_addr);jp_addr.add(jt_addr);
		buttonPanel.add(jb_register);buttonPanel.add(jb_cancel);
		//panel add
		regPanel.setLayout(new GridLayout(4,1));
		regPanel.add(titlePanel);
		regPanel.add(jp_name);regPanel.add(jp_addr);
		regPanel.add(buttonPanel);
		
		totPane.add(regPanel);
		add(totPane,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	/**
	 *	리스트 output
	 */
	public  void list() {
//		switchPane("list");
		switchPane(MemberMgmUI.LIST);
		//object
		ta = new JTextArea(28,65);
		ta.append("리스트출력");
		ta.setEditable(false);
		
		listPane.add(ta);
		add(listPane,BorderLayout.CENTER);
		mainPane.setVisible(false);
		setVisible(true);
	}//list Method
	
	/**
	 * 검색
	 */
	public void search() {
//		switchPane("search");
		switchPane(MemberMgmUI.SEARCH);

		//object
		 jp_search=new JPanel();jp_serarchResult = new JPanel();
		
		 jl_searchName = new JLabel("검색명>>");
		 jt_search= new JTextField(20);
		 sta= new TextArea(20,20);
		 sta.setEditable(false);
		 //sub_panel add
		 jp_search.add(jl_searchName);
		 jp_search.add(jt_search);
		 jp_serarchResult.add(sta);
		 
		 searchPane.add(jp_search);
		 searchPane.add(jp_serarchResult);
		 
		 add(searchPane,BorderLayout.CENTER);
		 mainPane.setVisible(false);
		 setVisible(true);
	}//search_Method//**
	
	/**
	 * updateMethod
	 */
	public void update() {
//		switchPane("update");
		switchPane(MemberMgmUI.UPDATE);

		//object 
		update_subPanel=new JPanel();
		 jp_updateName=new JPanel();jp_updateAddr=new JPanel();jp_updateSearch=new JPanel();
		 jl_updateName= new JLabel("이름");jl_updateAddr=new JLabel("주소");jl_updateSearchName=new JLabel("수정명>>");
		 jt_updateName=new JTextField(20);jt_updateAddr=new JTextField(20);jt_updateSearch=new JTextField(20);
		 //font set
		 jl_updateName.setFont(font);
		 jl_updateAddr.setFont(font);
		 jl_updateSearchName.setFont(font);
		 //component add
		 jp_updateSearch.add(jl_updateSearchName);jp_updateSearch.add(jt_updateSearch);
		 jp_updateName.add(jl_updateName);jp_updateName.add(jt_updateName);
		 jp_updateAddr.add(jl_updateAddr);jp_updateAddr.add(jt_updateAddr);
		//panel add
		 update_subPanel.setLayout(new GridLayout(3,1));
		 update_subPanel.add(jp_updateSearch);update_subPanel.add(jp_updateName);update_subPanel.add(jp_updateAddr);
		 updatePanel.add(update_subPanel);
		 add(updatePanel,BorderLayout.CENTER);
		 
		 mainPane.setVisible(false);
		 setVisible(true);
	}//update_Method//**
	
	private void delete() {
//		switchPane("delete");
		switchPane(MemberMgmUI.DELETE);
		//object
		 jp_deltetSearch=new JPanel();
		 jl_deleteSearchName=new JLabel("삭제명>>");
		 jt_deleteSearch=new JTextField(20);
		 jl_deleteSearchName.setFont(font);
		 //component_add
		 jp_deltetSearch.add(jl_deleteSearchName);
		 jp_deltetSearch.add(jt_deleteSearch);
		 //panel_add
		 deletePane.add(jp_deltetSearch);
		 add(deletePane);
		 
		 mainPane.setVisible(false);
		 setVisible(true);
	}//delete_Method//**
	
	//메시지를 입력받아 JLabel을 생성하고 폰트를 수정하여 리턴
	public JLabel getMsg(String msg) {
		JLabel msgLabel = new JLabel(msg);
		msgLabel.setFont(font);
		return msgLabel;
	}
	/**
	 *event처리
	 * @author user
	 */
	class MemberMgmUIEvent extends WindowAdapter implements ActionListener {
	
		public void windowClosing(WindowEvent e) {
//			JLabel test = new JLabel("프로그램 종료!!");
//			test.setFont(font);
			JOptionPane.showMessageDialog(null, getMsg("프로그램 종료!!"));
			System.exit(0);
		}

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (btnReg == obj) {
				register();
			} else if (btnList == obj) {
				list();
			} else if (btnSearch == obj) {
				search();
			} else if (btnUpdate == obj) {
				update();
			} else if (btnDelete == obj) {
				delete();
			} else if (btnExit == obj) {
				int result = JOptionPane.showConfirmDialog(null, getMsg("프로그램을 종료하시겠습니까?"));//예 0 아니요 1 취소 2
				if(result == 0) {
				System.exit(0);
				}
			}
		}
	
	}// inner_class
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
	
	//switching overloding
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
		mainPane.setVisible(false);
		totPane.setVisible(false);
		listPane.setVisible(false);
		searchPane.setVisible(false);
		updatePanel.setVisible(false);
		deletePane.setVisible(false);
	}
}//class
