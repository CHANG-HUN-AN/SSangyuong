package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 * 0331 ���Ǽ��������� ������ȸ�������� ������ ���������� ��ġ����
 * @author user
 */
public class StdMyRegCourse extends JFrame{
		// Field
//		JPanel jp_search;
//		Font font = new Font("���� ���", Font.BOLD, 12);
//		Font titleFont = new Font("���� ���", Font.BOLD, 16);
		JPanel topPane;
		JScrollPane coursePane;
		JPanel titlePane,btnPane;
		JLabel jl_title;
		JTable table;
		JButton btn_del,btn_allDel,btn_cancel;
		DefaultTableModel data;
		static Vector<String> COLNAMES = new Vector<String>();
		String uid;
		//@0318 ������û
		// Constructor
		public StdMyRegCourse(String uid) {
			setTitle("���� ������û ���");
			this.uid =uid;
			start();
		}

		// Method
		public void start() {
		// default set
//			setDefaultCloseOperation(EXIT_ON_CLOSE);		
//			setAlwaysOnTop(true);
		// ��ü ����
		// object create @@ DefaultTableModel -->�޼ҵ�� �����Ͽ� ��ü����
		/** table��ü��DefaultTableModel ������ ���� **/
			topPane = new JPanel();
			titlePane = new JPanel();
			btnPane = new JPanel();
			jl_title = new JLabel("���� ���� ����");
			//��ư�гο� �� ������Ʈ
			btn_del = new JButton("����");
			btn_allDel = new JButton("��ü����");
			btn_cancel = new JButton("���");
			getColNames();
			// ǥ�� �� �����͵�.. ���̺� �� ����(table)
			// table ���� �Ұ�
			this.setEditable(0);
			// delete ���� ����(�ӽõ�����)
			StdRegCourseListDAO dao = new StdRegCourseListDAO(uid); 
			Vector<Vector<String>>list = dao.getMyRegisterList();
			
//			String[] rowData = new String[] { "1", "�����ͺ��̽�", "2",  "�̺���" };
//			String[] rowData2 = new String[] { "2", "�ڹٱ���", "2",  "���̸�" };
			for(Vector<String> vo : list) {
				data.addRow(vo);
			}

			//
			//��Ʈ ����
			jl_title.setFont(StdUI.TITLEFONT); 
			btn_del.setFont(StdUI.FONT); btn_allDel.setFont(StdUI.FONT);btn_cancel.setFont(StdUI.FONT); 
		
			//������ ���̺� border �۾��ֱ�
			jl_title.setLayout(new BorderLayout());
			jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
			
			//j���̺� ������ ���� jtable.add(model) �� ������ �ȵ� 
			//JScrollPane ���� �ʱ�ȭ�� �ٿ������
			table = new JTable(data);
			coursePane=new JScrollPane(table);
			
			//�гο� ������Ʈ ���� !! �гξȿ� �гγ����� �г��� ���̾ƿ� ���������ָ� ���߿� ���ƾƿ��� �����ѵ��� ����������
			titlePane.setLayout(new BorderLayout());
			titlePane.add(jl_title,new BorderLayout().NORTH);
//			myTitlePane.add(jl_mytitle,new BorderLayout().NORTH);
			titlePane.add(coursePane,new BorderLayout().CENTER);
//			myTitlePane.add(myCoursePane,new BorderLayout().CENTER);
			//��ư�г�
			btnPane.add(btn_del);btnPane.add(btn_allDel);btnPane.add(btn_cancel);
			
			//�ڽ����̾ƿ����� �г��� �ڽ����̾ƿ����·� ���                     //�Ű����� �������� �����ϰ�setLayout���� �� ��������ߵǴ°� �̻������� ���۸���� �̷��Ի��ī����...
			BoxLayout boxLayout =new BoxLayout(topPane, BoxLayout.Y_AXIS); //�ڽ����̾ƿ� �Ű�����(������ �г�, �߽���)
			topPane.setLayout(boxLayout);
			//�г��� ��ܰ� �ϴ����� ������ ���̱�
//			topPane.setLayout(new BorderLayout());
			topPane.add(titlePane);
			topPane.add(btnPane);

			//Panel�� ���� �г� ���̱�
			this.setLayout(new GridLayout(1,1));
			
			add(topPane);
			// JFrame visible
			setSize(500, 600);
			setVisible(true);
		
			// ������ �߾ӿ� ����
			Dimension fsize = getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
			int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
			setLocation(width, height);
			// eventListener
			MgmSystemUIEvent eventObj = new MgmSystemUIEvent();
//			addWindowListener(eventObj);
			table.addMouseListener(eventObj);
		}
		public void getColNames() {
			COLNAMES.add("�����ȣ");
			COLNAMES.add("�����̸�");
			COLNAMES.add("����");
			COLNAMES.add("��米��");
		}
		
		// inner class
		class MgmSystemUIEvent extends WindowAdapter implements ActionListener, MouseListener {

			public void windowClosing(WindowEvent we) {
				System.out.println("����");
				dispose();
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
	
				if (obj == table) {
					int ta_row = table.getSelectedRow();
					if (erow == ta_row) {
						System.out.println("������̺���" + erow + " °�� ���Ƚ��ϴ�");
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
			
			//������û �� ���� �Ұ�
			data = new DefaultTableModel(COLNAMES, zero) {
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

