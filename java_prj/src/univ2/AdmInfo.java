package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;


/**
 * 0330 dao.close �� �ֻ��� ������(AdmUI)�� ���������� �������� ��ü������ �� �гο� ����
 * 
 * @author user
 */
public class AdmInfo extends JPanel{
	//Field
	JPanel topPane,titlePane,jp_search;
	JLabel jl_title;
	JTabbedPane adminPane;
	JLabel jl_search;
	JComboBox<String> jcb_search;
	JTextField jt_search;
	JButton btn_search,btn_list;
	JScrollPane sp_stdInfo;
	JTable table;
	DefaultTableModel model;
	AdminInfoDAO dao ;
	Vector<Vector<String>> list;
	static Vector<String> VCOLNAMES=new Vector<String>();
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
		UIset uiset = new UIset();
		//�÷��� �߰�
		setVectorColumn();
		//object create
		topPane = new JPanel();
		titlePane = new JPanel();
		jl_title = new JLabel("�л���������");
		jp_search = new JPanel();
		jl_search = new JLabel("�˻�>");
		jcb_search = new JComboBox<String>();
		jt_search = new JTextField(20);
		btn_search = new JButton("�˻�");
		btn_list = new JButton("��ü���");
		dao = new AdminInfoDAO();
		
		
		//��Ʈ ����
		jl_search.setFont(AdmUI.FONT);jcb_search.setFont(AdmUI.FONT);jt_search.setFont(AdmUI.FONT);btn_search.setFont(AdmUI.FONT);btn_list.setFont(AdmUI.FONT);
		//title�� border�ֱ�
//		titlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		this.setEditable(0);//�̰ſܿ� ��������� ����.
		
		//sql ������ �ҷ�����********
		String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO";
//		AdminInfoDAO dao = new AdminInfoDAO();
		list = dao.getResultVectorList(sql);
		
		for(Vector<String> vo :list) {
			model.addRow(vo); //vector ���¸� ���� �� �޾Ƶ帱���ִ�.(���������� ������ʿ䰡 ����)
		}
		
		table = new JTable(model);
		sp_stdInfo = new JScrollPane(table); //scrollPanel add table;
		table.getTableHeader().setReorderingAllowed(false); // �÷��� �̵� �Ұ�
        table.getTableHeader().setResizingAllowed(false); // �÷� ũ�� ���� �Ұ�
		//�޺��ڽ� ��� �߰�
		jcb_search.addItem("�й�");
		jcb_search.addItem("�̸�");
		jcb_search.addItem("�а�");

		
		//�˻��гο� �ΰ����ΰ� �߰�
		jp_search.add(jl_search);jp_search.add(jcb_search);jp_search.add(jt_search);
		jp_search.add(btn_search);jp_search.add(btn_list);
		//�ڽ����̾ƿ����� ���α�
		BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS);
		topPane.setLayout(boxLayout);
		
		//Ŭ������ �����θ��� title������ ����
		titlePane = (JPanel)uiset.title(titlePane,jl_title,sp_stdInfo);
		
		topPane.add(titlePane,new BorderLayout().NORTH);
		add(topPane,new BorderLayout().CENTER);
		add(jp_search);

		//JFrame visible
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
		btn_list.addActionListener(eventObj);
		jt_search.addActionListener(eventObj);
		jcb_search.addActionListener(eventObj);
		
	}
	
	public void setEditable(int zero) {
//		String[] colNames = new String[] { "�й�", "�̸�", "�а�", "����","�������" };
		//table ���� �Ұ�(�����ε�)
		model = new DefaultTableModel(VCOLNAMES, zero) {
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
	
	//static ���� ������ �÷�vector��  �÷����߰�
	public void setVectorColumn() {
		VCOLNAMES.add("�й�");
		VCOLNAMES.add("�̸�");
		VCOLNAMES.add("�а�");
		VCOLNAMES.add("����");
		VCOLNAMES.add("�������");
	}
	
	//inner	class
	public class MgmSystemUIEvent extends WindowAdapter implements ActionListener,MouseListener{
		//�̺�Ʈ�߿� ���̵��� dao .close �ʿ�
		public void windowClosing(WindowEvent we) {
			System.out.println("����");
			dao.close();
			System.exit(0);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			
			if(obj == btn_search || obj == jt_search) {
				int item = jcb_search.getSelectedIndex();
				//�˻���� ������ �����ִ� ���뵥����
				Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();
				
				if(item==0) {//�й�
					String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO "
							+ "AND STDNO = ? ";
					//vector<StudentVo>���·� ������ ǥ���̾ȵǼ� -->2�����迭 Vector<Vector<String>>������ �ٽ� �־���
					Vector<Vector<String>> searchData = replaceRow(sql);
//					for(StudentVO vo:replaceData) {
//						vRowDataes.add(vo.getStdno());
//						vRowDataes.add(vo.getSname());
//						vRowDataes.add(vo.getMname());
//						vRowDataes.add(vo.getGender());
//						vRowDataes.add(vo.getBirth());
//					}
					if (vaildationCheck() == 1) {
						if (searchData.size() != 0) {
							model.setDataVector(searchData, VCOLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
							model.setDataVector(tempDataes, VCOLNAMES);
						}
					}else {
						JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
					}
				}else if (item ==1) {//�̸�
					String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO "
							+ "AND SNAME = ?";
					//vector<StudentVo>���·� ������ ǥ���̾ȵǼ� -->2�����迭 Vector<Vector<String>>������ �ٽ� �־���
					Vector<Vector<String>> searchData = replaceRow(sql);
					if (vaildationCheck() == 1) {
						if (searchData.size() != 0) {
							model.setDataVector(searchData, VCOLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
							model.setDataVector(tempDataes, VCOLNAMES);
						}
					}else {
						JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
					}
				}else if(item ==2) {//�а�
					String sql = "SELECT STDNO,SNAME,MNAME,GENDER,BIRTH FROM STUDENT std,MAJOR maj where std.majorno = maj.MAJORNO "
							+ "AND MAJ.MNAME = ?";
					//vector<StudentVo>���·� ������ ǥ���̾ȵǼ� -->2�����迭 Vector<Vector<String>>������ �ٽ� �־���
					Vector<Vector<String>> searchData = replaceRow(sql);
					if (vaildationCheck() == 1) {
						if (searchData.size() != 0) {
							model.setDataVector(searchData, VCOLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
							model.setDataVector(tempDataes, VCOLNAMES);
						}
					}else {
						JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
					}
				}else{
					System.out.println("�׸����");
				}
			}else if(obj ==btn_list) {
				model.setDataVector(list,VCOLNAMES);
			}
		}
		//mouseListener
		@Override
		public void mouseClicked(MouseEvent me) { 
			Object obj = me.getSource();
			JTable jtobj = (JTable)obj;
			int erow = jtobj.getSelectedRow();
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if(erow == row) {
				Object detailData = table.getValueAt(row, 0);
				new AdmInfoList(detailData,dao);
			}
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
	}
	//--�˻����--
	//method �ߺ��Ǵ� �ڵ� -- sql�Է¹޾Ƽ� VOlist�޼ҵ忡 �� �Է°����� �� db�� �����Ͽ� �˻��Ѱ���� �ٽ� ���� 
	public Vector<Vector<String>> replaceRow(String sql) {
		
		String where = jt_search.getText().trim();
		Vector<Vector<String>> searchlist = dao.getResultVOList(sql,where);
		
		return searchlist;
	}
	//��ȿ���˻�
	public int vaildationCheck() {
		int result = 1;
		if(jt_search.getText().equals("")) {
			result = 0;
		}
		return result;
	}

	
}
