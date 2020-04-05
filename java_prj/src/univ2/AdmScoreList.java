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
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 관리자 로그인시 탭의 점수검색 > 상세정보
 */
public class AdmScoreList extends JFrame {
	// Field
	JPanel mainPane = new JPanel();// new GridLayout(8,1)
	JPanel nonamePane = new JPanel(new GridLayout(1, 4));
	JPanel objectPane = new JPanel();// new GridLayout(1,3)
	JPanel tablePane = new JPanel(new GridLayout(1, 3));
	JPanel topPane, bottomPane;
	JPanel jp_score;
	JPanel titlePane, namePane, noPane, majorPane, subPane, scorePane, gradePane, buttonPane, sub2Pane;
	JButton btn_rename, btn_cancel;
	JTextField Num_textField, Name_textField, major_textField, Subject_textField, Score_textField, Grade_textField,
			Scoreid_textField;
	JLabel Title_Label, Label_name, Label_no, Label_major, Subject_Label, Score_Label, Grade_Label, Scoreid_Label;
	String detailData;
	DefaultTableModel model;
	JTable scoreTable;
	JScrollPane scoll;

	// 리스트
	// AdmScoreDAO dao;
	AdmScoreDAO dao = new AdmScoreDAO();
	Vector<Vector<String>> list; // List
	static Vector<String> COLNAME;// Column

	// Constructor
	public AdmScoreList() {
		scoreFrame();
	}

	// 오버로딩
	public AdmScoreList(Object detailData, Vector<String> COLNAME) {
		this.detailData = (String) detailData;
		this.COLNAME = COLNAME;
		scoreFrame();
	}

	// Method
	public void scoreFrame() {
		// contentPane = new JPanel(new GridLayout(10, 1));

		setTitle("SIST 대학교 학생 관리 프로그램 - 상세 성적");
		topPane = new JPanel();
		bottomPane = new JPanel();

		jp_score = new JPanel();
		titlePane = new JPanel();
		namePane = new JPanel();
		noPane = new JPanel();
		majorPane = new JPanel();
		subPane = new JPanel();
		scorePane = new JPanel();
		gradePane = new JPanel();
		buttonPane = new JPanel();
		sub2Pane = new JPanel();

		Title_Label = new JLabel("학생 성적 상세조회 및 수정 - [관리자 권한]");
		Label_name = new JLabel("이 름");
		Label_no = new JLabel("학 번");
		Label_major = new JLabel("학 과");
		Subject_Label = new JLabel("과목명");
		Score_Label = new JLabel("성적");
		Grade_Label = new JLabel("등급");

		Scoreid_Label = new JLabel("성적코드");

		Num_textField = new JTextField(8);
		Name_textField = new JTextField(8);
		major_textField = new JTextField(20);
		Subject_textField = new JTextField(15);
		Score_textField = new JTextField(5);
		Grade_textField = new JTextField(5);
		Scoreid_textField = new JTextField(5);

		btn_rename = new JButton("수 정");
		btn_cancel = new JButton("종 료"); // 전역
		// JButton btn_rename = new JButton("수 정"); //지역
		// JButton btn_cancel = new JButton("취 소");

		Label_name.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Label_no.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Label_major.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btn_rename.setFont(new Font("나눔고딕", Font.BOLD, 18));
		btn_cancel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		Subject_Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Score_Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Grade_Label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Title_Label.setFont(new Font("맑은 고딕", Font.BOLD, 24));

		Title_Label.setForeground(Color.ORANGE);
		titlePane.add(Title_Label);
		noPane.add(Label_no);
		noPane.add(Num_textField);
		namePane.add(Label_name);
		namePane.add(Name_textField);
		majorPane.add(Label_major);
		majorPane.add(major_textField);

		Num_textField.setEnabled(false);
		Name_textField.setEnabled(false);
		major_textField.setEnabled(false);
		Subject_textField.setEnabled(false);
		Scoreid_textField.setEnabled(false);

		sub2Pane.add(Subject_Label);
		sub2Pane.add(Subject_textField);

		sub2Pane.add(Scoreid_Label);
		sub2Pane.add(Scoreid_textField);

		scorePane.add(Score_Label);
		scorePane.add(Score_textField);
		gradePane.add(Grade_Label);
		gradePane.add(Grade_textField);

		nonamePane.add(noPane);// 0319
		nonamePane.add(namePane);// 0319 위치변경

		// 상단패널 박스레이아웃
		BoxLayout boxLayout = new BoxLayout(topPane, BoxLayout.Y_AXIS);
		topPane.setLayout(boxLayout);
		topPane.add(titlePane);
		topPane.add(nonamePane);
		topPane.add(majorPane);

		this.setEditable(0);
		String sql = "SELECT SCOREID,SUBNAME,SCORE,GRADE,PNAME "
				+ "FROM SUBJECT E,SCORE C,LECTURE L,PROFESSOR P,STUDENT T " + "WHERE E.SUBNO = C.SUBNO "
				+ "AND L.PRONO = P.PRONO " + "AND E.SUBNO = L.SUBNO " + "AND T.STDNO = C.STDNO " + "AND T.STDNO = ? ";
		Vector<Vector<String>> list = dao.getResultVectorList(sql, detailData);
		for (Vector<String> vo : list) {
			model.addRow(vo);
			System.out.println("리스트 출력");
		}

		scoreTable = new JTable(model);
		scoll = new JScrollPane(scoreTable);

		mainPane.add(scoll, BorderLayout.CENTER);
		objectPane.add(subPane); // 0319 위치변경 sub2Pane
		objectPane.add(scorePane);
		objectPane.add(gradePane);

		buttonPane.add(btn_rename);
		buttonPane.add(btn_cancel);

		// 하단패널 박스패널로 변경 세로로 2개
		BoxLayout boxLayout2 = new BoxLayout(bottomPane, BoxLayout.Y_AXIS);
		bottomPane.setLayout(boxLayout2);
		bottomPane.add(objectPane);
		bottomPane.add(sub2Pane);
		bottomPane.add(buttonPane); // 0319 위치변경

		setLayout(new GridLayout(3, 1));
		add(topPane);
		add(mainPane);
		add(bottomPane);
		scoreInfo();
		setSize(500, 750);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);

		// event 핸들러
		BtnEvent eventObj = new BtnEvent();
		scoreTable.addMouseListener(eventObj);
		addWindowListener(eventObj);
		btn_cancel.addActionListener(eventObj);
		btn_rename.addActionListener(eventObj);

	}// End ScoreFrame

	// 개인 정보란
	public void scoreInfo() {
		Vector<AdminStdVO> list = new Vector<AdminStdVO>();
		list = dao.getDetailScoreInfo(detailData);
		for (AdminStdVO vo : list) {
			Num_textField.setText(vo.getStdno());
			Name_textField.setText(vo.getSname());
			major_textField.setText(vo.getMname());
		}
	}

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

	public class BtnEvent extends WindowAdapter implements ActionListener, MouseListener {

		public void windowClosing(WindowEvent we) {
			dispose(); // 새로운프레임종료
			System.out.println("종료합니다");
		}

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if (btn_cancel == obj) {
				System.out.println("종료");
				dispose();
			} else if (obj == btn_rename) {
				System.out.println("수정합니다.");
				model.fireTableChanged(null);
				AdmUpdate();
				// JOptionPane.showMessageDialog(null, "수정 완료");
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			scoreTable = (JTable) e.getSource();
			int row = scoreTable.getSelectedRow();
			int col = scoreTable.getSelectedColumn();

			String scoreid = (String) scoreTable.getValueAt(row, 0);
			String subname = (String) scoreTable.getValueAt(row, 1);
			String score = (String) scoreTable.getValueAt(row, 2);
			String grade = (String) scoreTable.getValueAt(row, 3);

			Scoreid_textField.setText(scoreid);
			Subject_textField.setText(subname);
			Score_textField.setText(score);
			Grade_textField.setText(grade);

			System.out.println(model.getValueAt(row, col));

		}

		public void AdmUpdate() {
			System.out.println("List_AdmUpdate 실행 ");
			AdminStdVO avo = new AdminStdVO();
			avo.setScore(Score_textField.getText());
			avo.setGrade(Grade_textField.getText());
			avo.setScoreid(Scoreid_textField.getText());

			int result = dao.adminUpdate(avo);

			if (result != 0) {

//				model.fireTableChanged(null);
				JOptionPane.showMessageDialog(null, "수정 완료");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}// End BtnEvent
}// End class
