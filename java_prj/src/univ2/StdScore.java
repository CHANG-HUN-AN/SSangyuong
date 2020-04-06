package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StdScore extends JPanel {
	// Field
	JPanel jp_stuInfo, jp_result; // 학생정보, 총 점수 패널
	JLabel jl_stuName, jl_stuMajor, jl_total, jl_avg, jl_term;
	JTextField jtf_stuName, jtf_stuMajor, jtf_total, jtf_avg;
	JButton btnClick;
	JComboBox<String> jcb;
	String[] header = { "과목명", "성적", "등급", "교수명" };
	DefaultTableModel tableModel;
	JTable scoreTable;
	JScrollPane scoll;
	ArrayList<StdVO> list;

	StdDAO dao;
	StdVO vo;

	// Constructor
	public StdScore() {
	}

	public StdScore(StdVO vo, StdDAO dao) {
		this.vo = vo;
		this.dao = dao;
		scoreStart();
	}

	// Method
	public void scoreStart() {
		jp_stuInfo = new JPanel();
		jp_result = new JPanel();
		jl_stuName = new JLabel("이름");
		jl_stuMajor = new JLabel("학과");
		jl_term = new JLabel("학기");
		jl_total = new JLabel("평균");
		jl_avg = new JLabel("평균학점");
		jtf_stuName = new JTextField(5);
		jtf_stuMajor = new JTextField(10);
		jtf_total = new JTextField(5);
		jtf_avg = new JTextField(5);
		btnClick = new JButton("조회");

		jl_stuName.setFont(StdUI.FONT);
		jl_stuMajor.setFont(StdUI.FONT);
		jl_total.setFont(StdUI.FONT);
		jl_avg.setFont(StdUI.FONT);

		// 입력 제한
		jtf_stuName.setEditable(false);
		jtf_stuMajor.setEditable(false);
		jtf_total.setEditable(false);
		jtf_avg.setEditable(false);

		jcb = new JComboBox<String>();
		jcb.addItem("전체");
		jcb.addItem("1학년1학기");
		jcb.addItem("1학년2학기");
		jcb.addItem("2학년1학기");
		jcb.addItem("2학년2학기");
		jcb.addItem("3학년1학기");
		jcb.addItem("3학년2학기");
		jcb.addItem("4학년1학기");
		jcb.addItem("4학년2학기");

		// 테이블
		tableModel = new DefaultTableModel(header, 0);
		scoreTable = new JTable(tableModel);
		scoll = new JScrollPane(scoreTable);
		scoreTable.setRowHeight(20);

		// 성적 조회 - 학생 정보 출력
		vo = dao.stdScore(StdUI.uid);
		jtf_stuName.setText(vo.getSname());
		jtf_stuMajor.setText(vo.getMname());

		// 학생 정보 패널
		jp_stuInfo.add(jl_stuName);
		jp_stuInfo.add(jtf_stuName);
		jp_stuInfo.add(jl_stuMajor);
		jp_stuInfo.add(jtf_stuMajor);
		jp_stuInfo.add(jl_term);
		jp_stuInfo.add(jcb);
		jp_stuInfo.add(btnClick);
		// 총 점수 패널
		jp_result.add(jl_total);
		jp_result.add(jtf_total);
		jp_result.add(jl_avg);
		jp_result.add(jtf_avg);

		add(jp_stuInfo);
		add(scoll, BorderLayout.CENTER);
		add(jp_result);

		setSize(600, 600);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		setLocation(width, height);
		setVisible(true);

		// 이벤트 리스너
		StdScoreEvent eventObj = new StdScoreEvent();
		jcb.addActionListener(eventObj);
		btnClick.addActionListener(eventObj);
	}

	public void ResultList() {
		// 평균평점 = (학점 수 * 교과목 평점)의 합계 / 수강신청 총학점
		int sum = 0; // 총점
		int subCnt = 0; // 과목수
		int creditSum = 0; // 수강 학점
		double allSum = 0;
		for (StdVO vo : list) {
			String subname = vo.getSubname();
			int score = vo.getScore();
			String grade = vo.getGrade();
			String pname = vo.getPname();
			int credit = vo.getCredit();

			Object str[] = { subname, score, grade, pname };
			tableModel.addRow(str);

			subCnt++;
			sum += vo.getScore();
			creditSum += vo.getCredit();

			if (grade.equals("A") || grade.equals("a")) {
				allSum += credit * 4.5;
			} else if (grade.equals("B") || grade.equals("b")) {
				allSum += credit * 3.5;
			} else if (grade.equals("C") || grade.equals("c")) {
				allSum += credit * 2.5;
			} else if (grade.equals("D") || grade.equals("d")) {
				allSum += credit * 1.5;
			} else if (grade.equals("F") || grade.equals("f")) {
				allSum += credit * 0;
			}

//			switch (vo.getGrade()) {
//			case "A": allSum += credit * 4.5; break;
//			case "a": allSum += credit * 4.5; break;
//			case "B": allSum += credit * 3.5; break;
//			case "b": allSum += credit * 3.5; break;
//			case "C": allSum += credit * 2.5; break;
//			case "c": allSum += credit * 2.5; break;
//			case "D": allSum += credit * 1.5; break;
//			case "d": allSum += credit * 1.5; break;
//			case "F": allSum += credit * 0; break;
//			case "f": allSum += credit * 0; break;
//			}
		}
		jtf_total.setText(String.valueOf((double) sum / subCnt)); // 평균
		jtf_avg.setText(String.valueOf((double) allSum / creditSum)); // 평균학점 | 소수점 아래 두자리까지 표시하고 싶은데 방법 못찾음
	}

	class StdScoreEvent implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			int index = jcb.getSelectedIndex();

			if (btnClick == obj) {
				tableModel.setNumRows(0); // 테이블 초기화
				if (index == 0) {// 전체
					list = dao.stdSubjectList(StdUI.uid);
					ResultList();
				} else if (index == 1) {// 1학년 1학기
					list = dao.stdSubjectList(StdUI.uid, "S11");
					ResultList();
				} else if (index == 2) {// 1학년 2학기
					list = dao.stdSubjectList(StdUI.uid, "S12");
					ResultList();
				} else if (index == 3) {// 2학년 1학기
					list = dao.stdSubjectList(StdUI.uid, "S21");
					ResultList();
				} else if (index == 4) {// 2학년 2학기
					list = dao.stdSubjectList(StdUI.uid, "S22");
					ResultList();
				} else if (index == 5) {// 3학년 1학기
					list = dao.stdSubjectList(StdUI.uid, "S31");
					ResultList();
				} else if (index == 6) {// 3학년 2학기
					list = dao.stdSubjectList(StdUI.uid, "S32");
					ResultList();
				} else if (index == 7) {// 4학년 1학기
					list = dao.stdSubjectList(StdUI.uid, "S41");
					ResultList();
				} else if (index == 8) {// 4학년 2학기
					list = dao.stdSubjectList(StdUI.uid, "S42");
					ResultList();
				}
			}
		}// actionPerformed method
	}// inner class

}