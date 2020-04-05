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
import java.util.Vector;

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

import univ2.ProScore.StudentScoreMainEvent;

public class ProScore extends JPanel {

	// Field
		JPanel mainPane, titlePane, jp_info, jp_result;
		JLabel jl_title, jl_search;

		JTextField jtf_name, jtf_major, jt_search;
		JTextField Combobox_textField;

		JTable scoreTable;
		JTable table;

//		JTabbedPane tabPane;
		JComboBox<String> combo, jcb_search;
		JScrollPane scoll;
		JButton btn_search, btn_list;

		DefaultTableModel model;

		ProDAO dao; // DAO
		Vector<Vector<String>> list; // List
		static Vector<String> COLNAME = new Vector<String>(); // Column
		static Vector<String> COLNAME_LIST = new Vector<String>();

		// Constructor
		public ProScore() {
			mainFrame();
		}

		// Method
		public void mainFrame() {
			ColumnList();
			UIset uiset = new UIset();
			mainPane = new JPanel();
			// �÷��� �߰�
			getVectorColumn();

			titlePane = new JPanel();

			jp_info = new JPanel();
			jp_result = new JPanel();

			jl_title = new JLabel("�л���������");
			jl_search = new JLabel("�˻�>");
			jcb_search = new JComboBox<String>();
			jcb_search = new JComboBox<String>();
			jp_result.add(jl_search);
			jp_result.add(jcb_search);

			jt_search = new JTextField();
			jp_result.add(jt_search);
			jt_search.setColumns(10);

			JButton btn_search = new JButton("�� ��");
			jp_result.add(btn_search);
			btn_list = new JButton("��ü����");
			jp_result.add(btn_list);

			jtf_name = new JTextField(5);
			jtf_major = new JTextField(8);

			dao = new ProDAO();

			// ��Ʈ ����
			jl_search.setFont(ProUI.FONT);
			btn_search.setFont(ProUI.FONT);

			// ���� ����
			this.setEditable(0);

			// SQL ȣ��
			String sql = "SELECT STDNO,SNAME,MNAME ,TRUNC(SCORE,1) "
					+ "FROM (SELECT C.STDNO,SNAME,AVG(SCORE) SCORE,MAJORNO " + "FROM SCORE C, STUDENT T "
					+ "  WHERE C.STDNO = T.STDNO " + "  GROUP BY C.STDNO,SNAME,MAJORNO) Q, MAJOR M "
					+ "  WHERE Q.MAJORNO = M.MAJORNO ";
			ProDAO dao = new ProDAO();
			Vector<Vector<String>> list = dao.getResultVectorList(sql);

			for (Vector<String> vo : list) {
				model.addRow(vo);
			}

			table = new JTable(model);
			scoll = new JScrollPane(table);

			// �޺��ڽ� ��� �߰�
			jcb_search.addItem("�й�");
			jcb_search.addItem("�̸�");

			titlePane.add(jl_title);
			titlePane = (JPanel) uiset.title(titlePane, jl_title, scoll);

			mainPane.add(titlePane, BorderLayout.CENTER);

			add(mainPane, BorderLayout.CENTER);
			add(jp_result);
			setSize(600, 600);

			Dimension fsize = getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
			int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
			setLocation(width, height);
			setVisible(true);
			dao.close();

			// �̺�Ʈ ������ ����
			StudentScoreMainEvent eventObj = new StudentScoreMainEvent();
			table.addMouseListener(eventObj);
			btn_search.addActionListener(eventObj);
			jt_search.addActionListener(eventObj);
			btn_list.addActionListener(eventObj);
			jcb_search.addActionListener(eventObj);
		}// End mainFrame

		public void setEditable(int zero) {
			model = new DefaultTableModel(COLNAME, zero) {
				@Override
				public boolean isCellEditable(int row, int column) { // ����, �Է� �Ұ�
					if (column >= 0) {
						return false;
					} else {
						return true;
					}
				}
			};
		}// End setEdit

		public void getVectorColumn() {
			COLNAME.add("�й�");
			COLNAME.add("�̸�");
			COLNAME.add("�а�");
			COLNAME.add("���");
		}// End V_Column

		// ��ü ���� ����
		public void SelectList() {
			String sql = "SELECT STDNO,SNAME,MNAME ,TRUNC(SCORE,1) "
					+ "FROM (SELECT C.STDNO,SNAME,AVG(SCORE) SCORE,MAJORNO " + "FROM SCORE C, STUDENT T "
					+ "  WHERE C.STDNO = T.STDNO " + "  GROUP BY C.STDNO,SNAME,MAJORNO) Q, MAJOR M "
					+ "  WHERE Q.MAJORNO = M.MAJORNO ";
			ProDAO dao = new ProDAO();
			Vector<Vector<String>> list = dao.getResultVectorList(sql);
			model.setDataVector(list, COLNAME);
		}// End SelectList

		// Action Listener!
		class StudentScoreMainEvent extends WindowAdapter implements ActionListener, MouseListener {
			public void windowClosing(WindowEvent we) {
				JOptionPane.showMessageDialog(null, "���α׷� ����");
				System.exit(0);
			}

			public StudentScoreMainEvent() {

			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if (obj == btn_search || obj == jt_search) {
					System.out.println("�˻�");
					int item = jcb_search.getSelectedIndex();
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();

					// �й����� �˻� �� ��
					if (item == 0) {
						String sql = "SELECT STDNO,SNAME,MNAME ,TRUNC(SCORE,1) "
								+ "FROM (SELECT C.STDNO,SNAME,AVG(SCORE) SCORE,MAJORNO " + "FROM SCORE C, STUDENT T "
								+ "  WHERE C.STDNO = T.STDNO " + "  GROUP BY C.STDNO,SNAME,MAJORNO) Q, MAJOR M "
								+ "  WHERE Q.MAJORNO = M.MAJORNO " + " AND STDNO = ? ";
						Vector<Vector<String>> replaceData = replaceRow(sql);
						if (vaildationCheck() == 1) {
							if (replaceData.size() != 0) {
								model.setDataVector(replaceData, COLNAME);
							} else if (replaceData.size() == 0) {
								JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
								model.setDataVector(tempDataes, COLNAME);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
						}
						// �̸����� �˻� �� ��
					} else if (item == 1) {
						String sql = "SELECT STDNO,SNAME,MNAME ,TRUNC(SCORE,1) "
								+ "FROM (SELECT C.STDNO,SNAME,AVG(SCORE) SCORE,MAJORNO " + "FROM SCORE C, STUDENT T "
								+ "WHERE C.STDNO = T.STDNO " + "GROUP BY C.STDNO,SNAME,MAJORNO) Q, MAJOR M "
								+ "WHERE Q.MAJORNO = M.MAJORNO " + "AND SNAME = ? ";
						// vector<StudentVo>���·� ������ ǥ���̾ȵǼ� -->2�����迭 Vector<Vector<String>>������ �ٽ� �־���
						Vector<Vector<String>> replaceData = replaceRow(sql);
						if (vaildationCheck() == 1) {
							if (replaceData.size() != 0) {
								model.setDataVector(replaceData, COLNAME);
							} else if (replaceData.size() == 0) {
								JOptionPane.showMessageDialog(null, "�˻���� �����Ͱ� �������� �ʽ��ϴ�");
								model.setDataVector(tempDataes, COLNAME);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�˻��Ͻ� �����͸� �Է����ּ���");
						}
					} else {
						System.out.println("�׸����");
					}
				} else if (obj == btn_list) {
					SelectList();
				} // End If
			}// End Action Performed

			public void mouseClicked(MouseEvent me) {
				Object obj = me.getSource();
				JTable jt_obj = (JTable) obj;
				int erow = jt_obj.getSelectedRow();
				int row = table.getSelectedRow();
				System.out.println(erow);
				System.out.println(row);
				if (erow == row) {
					Object detailData = table.getValueAt(row, 0);
					new ProScoreList(detailData, COLNAME_LIST);
				}
			}// End CLicked

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		} // End Action

		public void ColumnList() {
			for (String str : COLNAME_LIST) {
				System.out.println(str);
			}
			COLNAME_LIST.add("�����ڵ�");
			COLNAME_LIST.add("�����");
			COLNAME_LIST.add("����");
			COLNAME_LIST.add("���");
//			COLNAME_LIST.add("��米��");

		}// End V_Column

		// --�˻����--
		// method �ߺ��Ǵ� �ڵ� -- sql�Է¹޾Ƽ� VOlist�޼ҵ忡 �� �Է°����� �� db�� �����Ͽ� �˻��Ѱ���� �ٽ� ����
		public Vector<Vector<String>> replaceRow(String sql) {
			String where = jt_search.getText().trim();
			Vector<Vector<String>> list = dao.getResultVOList(sql, where);
			return list;
		}

		// ��ȿ���˻�
		public int vaildationCheck() {
			int result = 1;
			if (jt_search.getText().equals("")) {
				result = 0;
			}
			return result;
		}
} // End Class