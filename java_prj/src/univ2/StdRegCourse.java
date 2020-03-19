package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class StdRegCourse extends JPanel{
		// Field
//		JPanel jp_search;
		Font font = new Font("���� ���", Font.BOLD, 12);
		Font titleFont = new Font("���� ���", Font.BOLD, 16);
		JPanel topPane,bottomPane;
		JScrollPane coursePane,myCoursePane;
		JPanel titlePane,myTitlePane;
		JPanel searchPane,btnPane;
		JLabel jl_title, jl_mytitle;
		JTable table,myTable;
		JTextField jtf_search;
		JButton btn_reg,btn_del,btn_allDel,btn_myCourse; 
		JButton btn_search,btn_allSearch;
		JComboBox<String> jcb_search;
		DefaultTableModel data,myData;

		//@0318 ������û
		// Constructor
		public StdRegCourse() {
			start();
		}

		// Method
		public void start() {
		// default set
//			setTitle("ȸ�� ��� ���� ���α׷�");
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
			jl_title = new JLabel("������û");
			jl_mytitle = new JLabel("���� ������û ���");
			//��ư�гο� �� ������Ʈ
			btn_reg = new JButton("������û");
			btn_del = new JButton("����");
			btn_allDel = new JButton("��ü����");
			btn_myCourse = new JButton("���Ǽ�������");
			//�˻��гο� �� ������Ʈ
			jcb_search = new JComboBox<String>();
			jtf_search = new JTextField(15);
			btn_search = new JButton("�˻�");
			btn_allSearch = new JButton("��ü�˻�");
			
			//�޺��ڽ��� ����Ʈ �߰�
			jcb_search.addItem("�����ȣ");
			jcb_search.addItem("����");
			
			// ǥ�� �� �����͵�.. ���̺� �� ����(table)
			String[] colNames = new String[] { "�����ȣ", "�����̸�", "����", "��米��" };
			// table ���� �Ұ�
			this.setEditable(colNames, 0);
			this.setEditable(colNames,0);
			// delete ���� ����(�ӽõ�����)
			String[] rowData = new String[] { "1", "�����ͺ��̽�", "2",  "�̺���" };
			String[] rowData2 = new String[] { "2", "�ڹٱ���", "2",  "���̸�" };
			data.addRow(rowData);
			data.addRow(rowData2);
			myData.addRow(rowData);
			myData.addRow(rowData2);
			//
			//��Ʈ ����
			jl_title.setFont(titleFont); jl_mytitle.setFont(titleFont);
			btn_reg.setFont(font); btn_del.setFont(font); btn_allDel.setFont(font); btn_myCourse.setFont(font);
			btn_search.setFont(font);btn_allSearch.setFont(font);
			//������ ���̺� border �۾��ֱ�
			jl_title.setLayout(new BorderLayout());
			jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			jl_mytitle.setLayout(new BorderLayout());
			jl_mytitle.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j���̺� ������ ���� jtable.add(model) �� ������ �ȵ� 
			//JScrollPane ���� �ʱ�ȭ�� �ٿ������
			table = new JTable(data);
			myTable = new JTable(myData);
			coursePane=new JScrollPane(table);
			myCoursePane = new JScrollPane(myTable);
			
			//�гο� ������Ʈ ���� !! �гξȿ� �гγ����� �г��� ���̾ƿ� ���������ָ� ���߿� ���ƾƿ��� �����ѵ��� ����������
			titlePane.setLayout(new BorderLayout());
			myTitlePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().NORTH);myTitlePane.add(jl_mytitle,new BorderLayout().NORTH);
			titlePane.add(coursePane,new BorderLayout().CENTER);myTitlePane.add(myCoursePane,new BorderLayout().CENTER);
			//��ư�г�
			btnPane.add(btn_reg);btnPane.add(btn_del);btnPane.add(btn_allDel);btnPane.add(btn_myCourse);
			//�˻�����Ʈ ��ư�г�
			searchPane.add(jcb_search);searchPane.add(jtf_search);
			searchPane.add(btn_search);searchPane.add(btn_allSearch);
			
			//�ڽ����̾ƿ����� �г��� �ڽ����̾ƿ����·� ���                     //�Ű����� �������� �����ϰ�setLayout���� �� ��������ߵǴ°� �̻������� ���۸���� �̷��Ի��ī����...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //�ڽ����̾ƿ� �Ű�����(������ �г�, �߽���)
			BoxLayout boxLayout2 =new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
//			BoxLayout boxLayout3 = new BoxLayout(btnPane, BoxLayout.X_AXIS);
			topPane.setLayout(boxLayout);
			bottomPane.setLayout(boxLayout2);
			//�г��� ��ܰ� �ϴ����� ������ ���̱�
			topPane.setLayout(new BorderLayout());
			topPane.add(searchPane,BorderLayout.NORTH);
			topPane.add(titlePane,BorderLayout.CENTER);
			bottomPane.add(myTitlePane);
			bottomPane.add(btnPane);
			// this �� ���� �г� ���̱�
			this.setLayout(new GridLayout(2,1));
			
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
//				if (obj == btn_search || obj == jt_search) {
//					System.out.println("�˻����");
//				}
			}

			// mouseListener
			@Override
			public void mouseClicked(MouseEvent me) {
				Object obj = me.getSource();
				JTable jtobj = (JTable) obj;
				int erow = jtobj.getSelectedRow();
				
				if( obj == table ) {
					int ta_row = table.getSelectedRow();
					if (erow == ta_row) {
						System.out.println("������̺���"+erow + " °�� ���Ƚ��ϴ�");
						table.clearSelection();
						myTable.clearSelection();
					}
				}else if( obj == myTable ) {
					int mt_row = myTable.getSelectedRow();
					if (erow == mt_row) {
						System.out.println("�ϴ����̺���"+erow + " °�� ���Ƚ��ϴ�");
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
		public void setEditable(String colNames[], int zero) {
			
			//������û �� ���� �Ұ�
			data = new DefaultTableModel(colNames, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					if (column >= 0) {
						return false;
					} else {
						return true;
					}
				}
			};
			//���� ������û ��� ���� �Ұ�
			myData= new DefaultTableModel(colNames, 0) {
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

