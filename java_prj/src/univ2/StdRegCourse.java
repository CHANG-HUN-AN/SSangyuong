package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 * 4/1 �����˻��� ��ü�˻��� �ϴ����̺�κ��� �����ͱ��� ���� ������ ����(�ߺ�������)
 * @author user
 */
public class StdRegCourse extends JPanel {
	// Field
//		JPanel jp_search;
//		Font font = new Font("���� ���", Font.BOLD, 12);
//		Font titleFont = new Font("���� ���", Font.BOLD, 16);
	JPanel topPane, bottomPane;
	JScrollPane coursePane, myCoursePane;
	JPanel titlePane, myTitlePane;
	JPanel searchPane, btnPane;
	JLabel jl_title, jl_mytitle;
	JTable table, myTable;
	JTextField jtf_search;
	JButton btn_reg, btn_allDel, btn_myCourse; // ,btn_del
	JButton btn_search, btn_allSearch;
	JComboBox<String> jcb_search;
	DefaultTableModel data, myData;
	StdRegCourseDAO dao;
	Vector<Vector<String>> list;
	Object DupliDataNO = null;
	
	public static final Vector<String> COLNAMES = new Vector<String>();

	// @0318 ������û
	// Constructor
	public StdRegCourse() {
		start();
	}

	// Method
	public void start() {
		// default set
//			setTitle("������û");
//			setDefaultCloseOperation(EXIT_ON_CLOSE);		
//			setAlwaysOnTop(true);
		// ��ü ����
		// object create @@ DefaultTableModel -->�޼ҵ�� �����Ͽ� ��ü����
		/** table��ü��DefaultTableModel ������ ���� **/
		topPane = new JPanel();
		bottomPane = new JPanel();
		titlePane = new JPanel();
		myTitlePane = new JPanel();
		searchPane = new JPanel();
		btnPane = new JPanel();
		jl_title = new JLabel("������ȸ");
		jl_mytitle = new JLabel("���� ��û ����");
		// ��ư�гο� �� ������Ʈ
		btn_reg = new JButton("������û");
//			btn_del = new JButton("����");
		btn_allDel = new JButton("��ü����");
		btn_myCourse = new JButton("���Ǽ�������");
		// �˻��гο� �� ������Ʈ
		jcb_search = new JComboBox<String>();
		jtf_search = new JTextField(15);
		btn_search = new JButton("�˻�");
		btn_allSearch = new JButton("��ü�˻�");
		dao = new StdRegCourseDAO();
		// �޺��ڽ��� ����Ʈ �߰�
		jcb_search.addItem("�����ȣ");
		jcb_search.addItem("����");
		jcb_search.addItem("��米��");
		// COLUMN�� ������ �߰�
		setVectorColumn();

		// ǥ�� �� �����͵�.. ���̺� �� ����(table)
		// table ���� �Ұ�
		this.setEditable(0);
		this.setEditable(0);

		list = dao.getResultVector();
		for (Vector<String> vo : list) {
			data.addRow(vo);
		}
//			data.addRow(rowData);
//			data.addRow(rowData2);
//			myData.addRow(rowData);
//			myData.addRow(rowData2);
		//
		// ��Ʈ ���� btn_del.setFont(StdUI.FONT);
		jl_title.setFont(StdUI.TITLEFONT);
		jl_mytitle.setFont(StdUI.TITLEFONT);
		btn_reg.setFont(StdUI.FONT);
		btn_allDel.setFont(StdUI.FONT);
		btn_myCourse.setFont(StdUI.FONT);
		btn_search.setFont(StdUI.FONT);
		btn_allSearch.setFont(StdUI.FONT);
		// ������ ���̺� border �۾��ֱ�
		jl_title.setLayout(new BorderLayout());
		jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		jl_mytitle.setLayout(new BorderLayout());
		jl_mytitle.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));

		// j���̺� ������ ���� jtable.add(model) �� ������ �ȵ�
		// JScrollPane ���� �ʱ�ȭ�� �ٿ������
		table = new JTable(data);
		myTable = new JTable(myData);
		coursePane = new JScrollPane(table);
		myCoursePane = new JScrollPane(myTable);

		// �гο� ������Ʈ ���� !! �гξȿ� �гγ����� �г��� ���̾ƿ� ���������ָ� ���߿� ���ƾƿ��� �����ѵ��� ����������
		titlePane.setLayout(new BorderLayout());
		myTitlePane.setLayout(new BorderLayout());
		titlePane.add(jl_title, new BorderLayout().NORTH);
		myTitlePane.add(jl_mytitle, new BorderLayout().NORTH);
		titlePane.add(coursePane, new BorderLayout().CENTER);
		myTitlePane.add(myCoursePane, new BorderLayout().CENTER);
		// ��ư�г� btnPane.add(btn_del);
		btnPane.add(btn_reg);
		btnPane.add(btn_allDel);
		btnPane.add(btn_myCourse);
		// �˻�����Ʈ ��ư�г�
		searchPane.add(jcb_search);
		searchPane.add(jtf_search);
		searchPane.add(btn_search);
		searchPane.add(btn_allSearch);

		// �ڽ����̾ƿ����� �г��� �ڽ����̾ƿ����·� ��� //�Ű����� �������� �����ϰ�setLayout���� �� ��������ߵǴ°� �̻������� ���۸����
		// �̷��Ի��ī����...
		BoxLayout boxLayout = new BoxLayout(topPane, BoxLayout.Y_AXIS); // �ڽ����̾ƿ� �Ű�����(������ �г�, �߽���)
		BoxLayout boxLayout2 = new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
//			BoxLayout boxLayout3 = new BoxLayout(btnPane, BoxLayout.X_AXIS);
		topPane.setLayout(boxLayout);
		bottomPane.setLayout(boxLayout2);
		// �г��� ��ܰ� �ϴ����� ������ ���̱�
//			topPane.setLayout(new BorderLayout());
		topPane.add(searchPane);
		topPane.add(titlePane);
		bottomPane.add(myTitlePane);
		bottomPane.add(btnPane);

		// Panel�� ���� �г� ���̱�
		this.setLayout(new GridLayout(2, 1));

		add(topPane);
		add(bottomPane);
		// JFrame visible
		setSize(500, 600);
		setVisible(true);
		// ������ �߾ӿ� ����
//			Dimension fsize = getSize();
//			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
//			int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
//			int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
//			setLocation(width, height);
		// eventListener
		MgmSystemUIEvent eventObj = new MgmSystemUIEvent();
//			addWindowListener(eventObj);
		table.addMouseListener(eventObj);
		myTable.addMouseListener(eventObj);
		btn_search.addActionListener(eventObj);
		btn_allSearch.addActionListener(eventObj);
		btn_allDel.addActionListener(eventObj);
		jtf_search.addActionListener(eventObj);
		btn_myCourse.addActionListener(eventObj);
	}

	public void setVectorColumn() {
		COLNAMES.add("�����ȣ");
		COLNAMES.add("�����̸�");
		COLNAMES.add("����");
		COLNAMES.add("��米��");
	}

	// inner class
	class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {

		public void windowClosing(WindowEvent we) {
			System.out.println("����");
			System.exit(0);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (obj == btn_search || obj == jtf_search) {
				int item = jcb_search.getSelectedIndex();
				Vector<Vector<String>> tempDataes = new Vector<Vector<String>>(); //�ӽõ�����
				if (item == 0) {// �����ȣ
					String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
							" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
							" WHERE Q.SUBNO = SUB.SUBNO AND Q.SUBNO = ?";
					if (vaildationCheck() == 1) { //��ȿ���˻��� ������ ��������
						Vector<Vector<String>> searchData = replaceRow(sql);
						if (searchData.size() != 0) {
							data.setDataVector(searchData, COLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
							data.setDataVector(tempDataes, COLNAMES);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
					}
				}else if(item ==1) { //����
					String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
							" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
							" WHERE Q.SUBNO = SUB.SUBNO AND SUB.SUBNAME = ?";
					if (vaildationCheck() == 1) { //��ȿ���˻��� ������ ��������
						Vector<Vector<String>> searchData = replaceRow(sql);
						if (searchData.size() != 0) {
							data.setDataVector(searchData, COLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
							data.setDataVector(tempDataes, COLNAMES);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
					}
				}else if(item ==2 ) {//��米��
					String sql = "SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME" + 
							" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB" + 
							" WHERE Q.SUBNO = SUB.SUBNO AND PNAME = ?";
					if (vaildationCheck() == 1) { //��ȿ���˻��� ������ ��������
						Vector<Vector<String>> searchData = replaceRow(sql);
						if (searchData.size() != 0) {
							data.setDataVector(searchData, COLNAMES);
						} else if (searchData.size() == 0) {
							JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
							data.setDataVector(tempDataes, COLNAMES);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
					}
				}
			} else if (obj == btn_allSearch) {
				System.out.println("��ü�˻����");
				data.setDataVector(list, COLNAMES);
			} else if (obj == btn_myCourse) {
				new StdMyRegCourse();
			} else if (obj == btn_allDel) {// ��ü ����
				int rowCount = myData.getRowCount();
				for (int row = 0; row < rowCount; row++) {
					myData.removeRow(0);
				}
			}
		}

		// mouseListener
		@Override
		// mouse double Ŭ���� �־������
		public void mouseClicked(MouseEvent me) {
			Object obj = me.getSource();
			JTable jtobj = (JTable) obj;
			int click_row = jtobj.getSelectedRow();
			int ta_row = table.getSelectedRow();
			
			
			if (obj == table) { // �ּҰ˻� 0331 ���콺Ŭ���� �̹���� ���� �����Ű���(adminInfo����)
				if (click_row == ta_row) {
					System.out.println("������̺���" + click_row + " °�� ���Ƚ��ϴ�");
					Object inputDataNO = data.getValueAt(click_row,0);
					int mdCount =myData.getRowCount();
					Vector<Object> vo = new Vector<Object>(); //�ϴܿ� �ѱ浥���� ����
					Vector<Object > vo2 = new Vector<Object>(); //�ߺ��������ϱ����� �ӽõ����Ͱ���
					System.out.println(mdCount+"   "+DupliDataNO);
					
					if(mdCount != 0) {
					
					}else {
						
					}		
					System.out.println(DupliDataNO+"����");
					for (int i = 0; i < 4; i++) {
						vo.add(data.getValueAt(click_row, i));
					}
					for(int row = 0; row<mdCount;row++) {
						vo2.add(myData.getValueAt(row,0));
					}
					for(Object duVO : vo2) {
						if(duVO.equals(inputDataNO)) {
							JOptionPane.showMessageDialog(null, "������ �ߺ��˴ϴ�!!");
						}else {
							myData.addRow(vo);
							data.removeRow(click_row);
							table.clearSelection(); // �ϳ�Ŭ���� ��������
							myTable.clearSelection();
						}
					}
				}
			} else if (obj == myTable) {
				int mt_row = myTable.getSelectedRow();
				if (click_row == mt_row) {
					System.out.println("�ϴ����̺���" + click_row + " °�� ���Ƚ��ϴ�");
					myTable.clearSelection();
					table.clearSelection();
				}
			}
			
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}

	// Method
	public void setEditable(int zero) {

		// ������û �� ���� �Ұ�
		data = new DefaultTableModel(COLNAMES, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};
		// ���� ������û ��� ���� �Ұ�
		myData = new DefaultTableModel(COLNAMES, 0) {
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

	// ��ȿ���˻�
	public int vaildationCheck() {
		int result = 1;
		if (jtf_search.getText().equals("")) {
			result = 0;
		}
		return result;
	}

	// �˻���ɿ����� �ٸ� ���̺����ֱ�
	public Vector<Vector<String>> replaceRow(String sql) {

		String where = jtf_search.getText();
		Vector<Vector<String>> searchlist = dao.getResultVector(sql, where);

		return searchlist;
	}

}
