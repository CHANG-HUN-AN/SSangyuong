package univ2;

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


public class AdmInfo extends JPanel{
	//Field
	JPanel jp_search;
	Font font = new Font("���� ���", Font.BOLD, 12);
	
	JTabbedPane adminPane;
	JLabel jl_search;
	JComboBox<String> jcb_search;
	JTextField jt_search;
	JButton btn_search;
	JScrollPane sp_stdInfo;
	JTable table;
	DefaultTableModel model;
	//Constructor
	public AdmInfo() { 
		start();
	}
	//Method
	public void start() {
		//default set
//		setTitle("ȸ�� ��� ���� ���α׷�");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);		
//		setAlwaysOnTop(true);
		
		//object create
//		adminPane = new JTabbedPane();
//		tab_main = new JPanel();
//		tab_stdInfo = new JPanel();
//		tab_score = new JPanel();
		jp_search = new JPanel();
		jl_search = new JLabel("�˻�>");
		jcb_search = new JComboBox<String>();
		jt_search = new JTextField(20);
		btn_search = new JButton("�˻�");
		//��Ʈ ����
		jl_search.setFont(font);jcb_search.setFont(font);jt_search.setFont(font);btn_search.setFont(font);
		//ǥ�� �� �����͵�.. ���̺� �� ����(table)
		String[] colNames = new String[] {"�й�", "�̸�", "�а�","����","�������"};
		//table ���� �Ұ�
		this.setEditable(colNames, 0);
		
		//delete �ӽ� ������ ���� ����
		String[] rowData = new String[]{"1", "ach", "cc","m","940813"};
		String[] rowData2 = new String[]{"2", "aaa", "bb","f","970728"};
		model.addRow(rowData);
		model.addRow(rowData2);
		//
		table = new JTable(model);
		

//		table.set(false);
		sp_stdInfo = new JScrollPane(table); //scrollPanel add table;
		//�޺��ڽ� ��� �߰�
		jcb_search.addItem("�̸�");
		jcb_search.addItem("�а�");
		//�˻��гο� �ΰ����ΰ� �߰�
//		jp_search.add(jl_search);jp_search.add(jcb_search);jp_search.add(jt_search);jp_search.add(btn_search);
		//jpanel add scrollPanel,SearchPanel  @@CH 
		add(sp_stdInfo,new BorderLayout().CENTER);
		add(jp_search,new BorderLayout().SOUTH);
		
//		//jtapPane tab add
//		adminPane.addTab("����", tab_main);
//		adminPane.addTab("�л� ���� ��ȸ", tab_stdInfo);
//		adminPane.addTab("���� ��ȸ", tab_score);
		//JFrame visible
//		add(adminPane);
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
//		addWindowListener(eventObj);
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
				new AdmInfoList();
			}
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}
	//Method
	public void setEditable(String colNames[], int zero) {
		model = new DefaultTableModel(colNames, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        if (column >= 0) {
		            return false;
		        } else {
		            return true;
		        }
		    }
		};
	}
	
}
