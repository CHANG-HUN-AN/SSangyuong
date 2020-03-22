package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdmUI extends JFrame {

	//Field
	AdmInfo tab_stdInfo;
	AdmScore tab_stdScore;
	static Font FONT = new Font("맑은 고딕", Font.BOLD, 12);
	static Font FONTTITLE = new Font("맑은 고딕", Font.BOLD, 12);
//	JPanel mainPane;
	JPanel jp_main;
	JTabbedPane tabPane;
	
	// Constructor
	public AdmUI() {
		mainFrame();
	}

	// Method
	public void setTitle() {
		
	}
	public void mainFrame() {
		//tabPanel 에 jPanel 호출  
		tab_stdInfo = new AdmInfo();
		tab_stdScore = new AdmScore();
		jp_main = new JPanel();
		
		tabPane = new JTabbedPane();
		
		tabPane.addTab("HOME", jp_main);
		tabPane.addTab("학생 정보 관리", tab_stdInfo);
		tabPane.addTab("학생 성적 관리", tab_stdScore);

		add(tabPane);
		setSize(600, 600);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		setVisible(true);
		
		//이벤트 리스너 선언
		StudentScoreMainEvent eventObj = new StudentScoreMainEvent();
		addWindowListener(eventObj);
//		table.addMouseListener(eventObj);
		addWindowListener(eventObj);
//		btn_search.addActionListener(eventObj);
//		jt_search.addActionListener(eventObj);
	}

	//액션 리스너 선언
	class StudentScoreMainEvent extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			JOptionPane.showMessageDialog(null, "프로그램 종료");
			System.exit(0);
		}
	} //End Action
} //End Class 
