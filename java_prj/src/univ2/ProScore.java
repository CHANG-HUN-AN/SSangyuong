package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class ProScore extends JPanel {

	//Field
//	JPanel contentPane = new JPanel(new GridLayout(8, 1)); 
	JPanel mainPane;
//	JPanel jp_main, jp_stu, jp_score;
	JPanel jp_info, jp_result;
	
	JLabel jl_info, jl_sname, jl_smajor;
	
	JTextField jtf_name, jtf_major, jt_search;
	JTextField Combobox_textField;

	JTable scoreTable;
	JTable table;

//	JTabbedPane tabPane;
	JComboBox combo;
	JScrollPane scoll;
	JButton btn_search;

	DefaultTableModel model;
	
	// Constructor
	public ProScore() {
		mainFrame();
	}

	// Method
	public void mainFrame() {
		
		mainPane = new JPanel();

		jp_info = new JPanel();
		jp_result = new JPanel();

		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] { "이름", "학번" }));
		jp_result.add(combo);

		jt_search = new JTextField();
		jp_result.add(jt_search);
		jt_search.setColumns(10);

		JButton btn_search = new JButton("검 색");
		jp_result.add(btn_search);

		jtf_name = new JTextField(5);
		jtf_major = new JTextField(8);

		String[] colNames = new String[] { "학 번", "이 름", "학 과", "총 점" };
		
		String rowData[][] = {
				{ "001", "홍길동", "컴퓨터공학", "300" }, 
				{ "002", "김길동", "컴퓨터공학", "260" },
				{ "003", "임길동", "컴퓨터공학", "180" }, 
				{ "004", "성길동", "생명공학", "200" }, 
				{ "005", "주길동", "생명공학", "340" } };
		
		DefaultTableModel model = new DefaultTableModel(rowData,colNames){
			@Override
			public boolean isCellEditable(int row, int column) {  //수정, 입력 불가
				return false;
			}
		};
		
		table = new JTable(model);
		scoll = new JScrollPane(table);
		
		mainPane.setLayout(new GridLayout(2, 1));
		mainPane.add(scoll,BorderLayout.CENTER);
		mainPane.add(jp_result);

		add(mainPane, BorderLayout.CENTER);
		setSize(600, 600);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		setVisible(true);
		
		//이벤트 리스너 선언
		StudentScoreMainEvent eventObj = new StudentScoreMainEvent();
//		addWindowListener(eventObj);
		table.addMouseListener(eventObj);
		
		btn_search.addActionListener(eventObj);
		jt_search.addActionListener(eventObj);
	}

	//액션 리스너 선언
	class StudentScoreMainEvent extends WindowAdapter implements ActionListener, MouseListener {
		public void windowClosing(WindowEvent we) {
			JOptionPane.showMessageDialog(null, "프로그램 종료");
			System.exit(0);
		}

		public StudentScoreMainEvent() {
		
		}

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == btn_search || obj == jt_search) {
				System.out.println("검색기능");
			}
		}
		
		public void mouseClicked(MouseEvent me) {
			Object obj = me.getSource();
			JTable jt_obj = (JTable)obj;
			int erow = jt_obj.getSelectedRow();
			int row = table.getSelectedRow();
			System.out.println(erow);
			System.out.println(row);
			if(erow == row) {
				System.out.println(erow +"번째");
				new ProScoreList();
			}
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { } 
		
		
	} //End Action
} //End Class 
