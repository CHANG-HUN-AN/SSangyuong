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
			// 컬럼명 추가
			getVectorColumn();

			titlePane = new JPanel();

			jp_info = new JPanel();
			jp_result = new JPanel();

			jl_title = new JLabel("학생성적관리");
			jl_search = new JLabel("검색>");
			jcb_search = new JComboBox<String>();
			jcb_search = new JComboBox<String>();
			jp_result.add(jl_search);
			jp_result.add(jcb_search);

			jt_search = new JTextField();
			jp_result.add(jt_search);
			jt_search.setColumns(10);

			JButton btn_search = new JButton("검 색");
			jp_result.add(btn_search);
			btn_list = new JButton("전체성적");
			jp_result.add(btn_list);

			jtf_name = new JTextField(5);
			jtf_major = new JTextField(8);

			dao = new ProDAO();

			// 폰트 설정
			jl_search.setFont(ProUI.FONT);
			btn_search.setFont(ProUI.FONT);

			// 수정 설정
			this.setEditable(0);

			// SQL 호출
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

			// 콤보박스 목록 추가
			jcb_search.addItem("학번");
			jcb_search.addItem("이름");

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

			// 이벤트 리스너 선언
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
				public boolean isCellEditable(int row, int column) { // 수정, 입력 불가
					if (column >= 0) {
						return false;
					} else {
						return true;
					}
				}
			};
		}// End setEdit

		public void getVectorColumn() {
			COLNAME.add("학번");
			COLNAME.add("이름");
			COLNAME.add("학과");
			COLNAME.add("평균");
		}// End V_Column

		// 전체 성적 보기
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
				JOptionPane.showMessageDialog(null, "프로그램 종료");
				System.exit(0);
			}

			public StudentScoreMainEvent() {

			}

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if (obj == btn_search || obj == jt_search) {
					System.out.println("검색");
					int item = jcb_search.getSelectedIndex();
					Vector<Vector<String>> tempDataes = new Vector<Vector<String>>();

					// 학번으로 검색 할 때
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
								JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
								model.setDataVector(tempDataes, COLNAME);
							}
						} else {
							JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
						}
						// 이름으로 검색 할 때
					} else if (item == 1) {
						String sql = "SELECT STDNO,SNAME,MNAME ,TRUNC(SCORE,1) "
								+ "FROM (SELECT C.STDNO,SNAME,AVG(SCORE) SCORE,MAJORNO " + "FROM SCORE C, STUDENT T "
								+ "WHERE C.STDNO = T.STDNO " + "GROUP BY C.STDNO,SNAME,MAJORNO) Q, MAJOR M "
								+ "WHERE Q.MAJORNO = M.MAJORNO " + "AND SNAME = ? ";
						// vector<StudentVo>형태로 데이터 표출이안되서 -->2차원배열 Vector<Vector<String>>형으로 다시 넣어줌
						Vector<Vector<String>> replaceData = replaceRow(sql);
						if (vaildationCheck() == 1) {
							if (replaceData.size() != 0) {
								model.setDataVector(replaceData, COLNAME);
							} else if (replaceData.size() == 0) {
								JOptionPane.showMessageDialog(null, "검색결과 데이터가 존재하지 않습니다");
								model.setDataVector(tempDataes, COLNAME);
							}
						} else {
							JOptionPane.showMessageDialog(null, "검색하실 데이터를 입력해주세요");
						}
					} else {
						System.out.println("항목오류");
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
			COLNAME_LIST.add("성적코드");
			COLNAME_LIST.add("과목명");
			COLNAME_LIST.add("성적");
			COLNAME_LIST.add("등급");
//			COLNAME_LIST.add("담당교수");

		}// End V_Column

		// --검색기능--
		// method 중복되는 코드 -- sql입력받아서 VOlist메소드에 각 입력값전달 후 db에 접속하여 검색한결과를 다시 리턴
		public Vector<Vector<String>> replaceRow(String sql) {
			String where = jt_search.getText().trim();
			Vector<Vector<String>> list = dao.getResultVOList(sql, where);
			return list;
		}

		// 유효성검사
		public int vaildationCheck() {
			int result = 1;
			if (jt_search.getText().equals("")) {
				result = 0;
			}
			return result;
		}
} // End Class