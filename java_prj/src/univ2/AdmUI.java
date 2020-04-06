package univ2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class AdmUI extends JFrame {

	//Field
	AdmInfo tab_stdInfo;
	AdmScore tab_stdScore;
	static Font FONT = new Font("���� ���", Font.BOLD, 12);
	static Font add1_FONT = new Font("���� ���",Font.BOLD,20);
	static Font add2_FONT = new Font("���� ���",Font.BOLD,20);
	static Font FONTTITLE = new Font("���� ���", Font.BOLD, 12);
//	JPanel mainPane;
	JPanel jp_main;
	JTabbedPane tabPane;
	
	// Constructor
	public AdmUI() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			mainFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mainFrame();
	}
	
	// Method
	public void setTitle() {
		
	}
	public void mainFrame() {
		
//		//Look & Feel 
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//			//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//			//UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
//			JFrame.setDefaultLookAndFeelDecorated(true);
//			} catch (Exception e) {}
		
		String imgPath = "src/univ2/Adm.png";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(370, 380, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		
		//tabPanel �� jPanel ȣ��  
		tab_stdInfo = new AdmInfo();
		tab_stdScore = new AdmScore();
		jp_main = new JPanel();
		
		tabPane = new JTabbedPane();
		
		tabPane.addTab("HOME", jp_main);
		tabPane.addTab("�л� ���� ����", tab_stdInfo);
		tabPane.addTab("�л� ���� ����", tab_stdScore);

		
		add(tabPane);
		setSize(600, 600);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		setVisible(true);
		
		//�̺�Ʈ ������ ����
		StudentScoreMainEvent eventObj = new StudentScoreMainEvent();
		addWindowListener(eventObj);
		addWindowListener(eventObj);

	}

	//�׼� ������ ����
	class StudentScoreMainEvent extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			JOptionPane.showMessageDialog(null, "���α׷� ����");
			System.exit(0);
		}
	} //End Action
} //End Class 
