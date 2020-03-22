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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdmScore extends JPanel {

	//Field
//	JPanel contentPane = new JPanel(new GridLayout(8, 1)); 
	JPanel mainPane;
	JPanel titlePane;
	JPanel jp_info, jp_result;
	
	JLabel jl_title;
	JLabel jl_search;
	
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
	public AdmScore() {
		mainFrame();
	}

	// Method
	public void mainFrame() {
		UIset uiset = new UIset();
		mainPane = new JPanel();
		
		titlePane = new JPanel();
		
		jp_info = new JPanel();
		jp_result = new JPanel();
		
		jl_title = new JLabel("�л���������");
		jl_search = new JLabel("�˻�>");
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] { "�̸�", "�й�" }));
		jp_result.add(jl_search);
		jp_result.add(combo);

		jt_search = new JTextField();
		jp_result.add(jt_search);
		jt_search.setColumns(10);

		JButton btn_search = new JButton("�� ��");
		jp_result.add(btn_search);

		jtf_name = new JTextField(5);
		jtf_major = new JTextField(8);
		
		//��Ʈ ����
		jl_search.setFont(AdmUI.FONT);btn_search.setFont(AdmUI.FONT); 
		String[] colNames = new String[] { "�� ��", "�� ��", "�� ��", "�� ��" };
		
		String rowData[][] = {
				{ "001", "ȫ�浿", "��ǻ�Ͱ���", "300" }, 
				{ "002", "��浿", "��ǻ�Ͱ���", "260" },
				{ "003", "�ӱ浿", "��ǻ�Ͱ���", "180" }, 
				{ "004", "���浿", "�������", "200" }, 
				{ "005", "�ֱ浿", "�������", "340" } };
		
		DefaultTableModel model = new DefaultTableModel(rowData,colNames){
			@Override
			public boolean isCellEditable(int row, int column) {  //����, �Է� �Ұ�
				return false;
			}
		};
		
		table = new JTable(model);
		scoll = new JScrollPane(table);
		
		titlePane.add(jl_title);
		titlePane = (JPanel)uiset.title(titlePane,jl_title,scoll);
		
		mainPane.add(titlePane,BorderLayout.CENTER);

		add(mainPane,BorderLayout.CENTER);
		add(jp_result);
		setSize(600, 600);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		setVisible(true);
		
		//�̺�Ʈ ������ ����
		StudentScoreMainEvent eventObj = new StudentScoreMainEvent();
//		addWindowListener(eventObj);
		table.addMouseListener(eventObj);
		
		btn_search.addActionListener(eventObj);
		jt_search.addActionListener(eventObj);
	}

	//�׼� ������ ����
	class StudentScoreMainEvent extends WindowAdapter implements ActionListener, MouseListener {
		public void windowClosing(WindowEvent we) {
			JOptionPane.showMessageDialog(null, "���α׷� ����");
			System.exit(0);
		}

		public StudentScoreMainEvent() {
		
		}

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == btn_search || obj == jt_search) {
				System.out.println("�˻����");
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
				System.out.println(erow +"��°");
				new AdmScoreList();
			}
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { } 
		
		
	} //End Action
} //End Class 
