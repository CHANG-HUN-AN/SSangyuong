package Project1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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


public class MgmSystemUI extends JFrame{
	//Field
	JPanel jp_main,jp_stdInfo,jp_grade,jp_search;
	Font font = new Font("���� ���", Font.BOLD, 12);
	JTabbedPane jtp_admin;
	JLabel jl_search;
	JComboBox<String> jcb_search;
	JTextField jt_search;
	JButton btn_search;
	JScrollPane sp_stdInfo;
	JTable table;
	DefaultTableModel model;
	//Constructor
	public MgmSystemUI() { 
		start();
	}
	//Method
	public void start() {
		//default set
		setTitle("ȸ�� ��� ���� ���α׷�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setAlwaysOnTop(true);
		
		//object create
		jtp_admin = new JTabbedPane();
		jp_main = new JPanel();
		jp_stdInfo = new JPanel();
		jp_grade = new JPanel();
		jp_search = new JPanel();
		jl_search = new JLabel("�˻�>");
		jcb_search = new JComboBox<String>();
		jt_search = new JTextField(20);
		btn_search = new JButton("�˻�");
		//font add
		jl_search.setFont(font);jcb_search.setFont(font);jt_search.setFont(font);btn_search.setFont(font);
		//ǥ�� �� �����͵�.. ���̺� �� ����(table)
		String[] colNames = new String[] {"�й�", "�̸�", "�а�","����","�������"};
		model = new DefaultTableModel(colNames, 0);
		//delete ���� ����
		String[] rowData = new String[]{"1", "ach", "cc","m","940813"};
		String[] rowData2 = new String[]{"2", "aaa", "bb","f","970728"};
		model.addRow(rowData);
		model.addRow(rowData2);
		//
		table = new JTable(model);
//		table.set(false);
		sp_stdInfo = new JScrollPane(table); //scrollPanel add table;
		//JComboBox Item list 
		jcb_search.addItem("�̸�");
		jcb_search.addItem("�а�");
		//searchPanel add (jlable,jComboBox,jtextField,JButoon) SOUTH location
		jp_search.add(jl_search);jp_search.add(jcb_search);jp_search.add(jt_search);jp_search.add(btn_search);
		//jpanel add scrollPanel,SearchPanel  @@CH 
		jp_stdInfo.add(sp_stdInfo,new BorderLayout().CENTER);
		jp_stdInfo.add(jp_search,new BorderLayout().SOUTH);
		
		//jtapPane tab add
		jtp_admin.addTab("����", jp_main);
		jtp_admin.addTab("�л� ���� ��ȸ", jp_stdInfo);
		jtp_admin.addTab("���� ��ȸ", jp_grade);
		//JFrame visible
		add(jtp_admin);
		setSize(500,600);
		setVisible(true);
		//location center
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
		setLocation(width,height);
		//eventListener 
		MgmSystemUIEvent eventObj = new MgmSystemUIEvent();
		addWindowListener(eventObj);
		table.addMouseListener(eventObj);
		btn_search.addActionListener(eventObj);
		jt_search.addActionListener(eventObj);
	}
	
	//inner	class
	class MgmSystemUIEvent extends WindowAdapter implements ActionListener,MouseListener{

		public void windowClosing(WindowEvent we) {
			System.out.println("����");
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			
			if(obj == btn_search || obj == jt_search) {
				System.out.println("�˻����");
			}
			
		}
		//mouseListener
		@Override
		public void mouseClicked(MouseEvent me) { 
			Object obj = me.getSource();
			JTable jtobj = (JTable)obj;
			int erow = jtobj.getSelectedRow();
			int row = table.getSelectedRow();
			System.out.println(erow);
			System.out.println(row);
			if(erow == row) {
				System.out.println(erow+" °�� ���Ƚ��ϴ�");
				new StdInfoForm();
			}
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		
	}
}
