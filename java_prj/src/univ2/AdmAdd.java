package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AdmAdd  extends JPanel {

	//Field 
	JPanel mainPane, jp_img , jp_btn ,img_panel,btn_panel ,jp_major,major_panel  ;
	
	JLabel jl_img,jl_major;
	JButton btn_add;
	
	AdmScoreDAO dao = new AdmScoreDAO();
	JComboBox<String> combo, jcb_major;
	static JTextField jt_major;
	
	//Constructor
	public AdmAdd() {
		mainFrame();
	}
	
	
	//Method
	public void mainFrame() {
		mainPane = new JPanel(new GridLayout(2,1));
		//jp_main = new JPanel();
		jp_img = new JPanel();
		jp_btn = new JPanel();
		jp_major = new JPanel();
		
		img_panel = new JPanel();
		btn_panel = new JPanel();
		major_panel = new JPanel();
		
		String imgPath = "src/univ2/stdadd.png";
		ImageIcon originIcon = new ImageIcon(imgPath);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(370, 380, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		
		jl_img = new JLabel(Icon);
		btn_add = new JButton("학생계정 추가 등록");
	
		
		jcb_major = new JComboBox<String>();
		
		jl_major = new JLabel("학과 >");
		jt_major = new JTextField();
		jt_major.add(jcb_major);
		jt_major.setColumns(4);
		jt_major.setEnabled(false);

		
		jp_img.setLayout(new BoxLayout(jp_img, BoxLayout.Y_AXIS));
		jp_major.setLayout(new BoxLayout(jp_major, BoxLayout.Y_AXIS));
		jp_btn.setLayout(new BoxLayout(jp_btn, BoxLayout.Y_AXIS));
		
		
		img_panel.add(jl_img);
		btn_panel.add(btn_add);
		major_panel.add(jl_major);
		major_panel.add(jcb_major);
		//major_panel.add(jt_major);
		
		jp_major.add(major_panel);
		jp_img.add(img_panel);
		jp_btn.add(btn_panel);
		
		btn_add.setFont(AdmUI.FONTTITLE);
		jl_major.setFont(AdmUI.add1_FONT);
		jcb_major.setFont(AdmUI.add2_FONT);
		
		mainPane.setLayout(new BorderLayout());
		mainPane.add(jp_img,BorderLayout.NORTH);
		mainPane.add(jp_major,BorderLayout.CENTER);
		mainPane.add(jp_btn,BorderLayout.SOUTH);
		
		add(mainPane, BorderLayout.CENTER);
		
		// 콤보박스 목록 추가
		jcb_major.addItem("컴퓨터공학과");
		jcb_major.addItem("경영학과");
		jcb_major.addItem("간호학과");
		
		
		setSize(400,500);
		setVisible(true);
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		
		BtnEvent eventObj = new BtnEvent();
		btn_add.addActionListener(eventObj);
		
	}//End mainFrame
	
	public void Std_add_db (int index_0) {
		String index = String.valueOf(index_0);
		AdminStdVO avo = new AdminStdVO();
		avo.setMajorno(jt_major.getText());
		int result = dao.adminAdd(avo,index);
		
			System.out.println("학생 추가");
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "학번 생성 완료");
			}
	}
	
	
	public class BtnEvent extends WindowAdapter implements ActionListener{
		@Override
		public void windowClosing(WindowEvent we) {
			
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			int index_0 = jcb_major.getSelectedIndex();
			int index = 0;
			
			if(obj == btn_add) {
				if( index_0 == 0 ) {
					index = 11;
				
				}else if (index_0 == 1) {
					index = 12;
					
				}else if (index_0 == 2) {
					index = 13;
					
				}
				
				Std_add_db(index);
				System.out.println("학번 생성");
			}
		}
	}
	
}//End class
