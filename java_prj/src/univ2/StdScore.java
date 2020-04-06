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
	JPanel jp_stuInfo, jp_result; // �л�����, �� ���� �г�
	JLabel jl_stuName, jl_stuMajor, jl_total, jl_avg, jl_term;
	JTextField jtf_stuName, jtf_stuMajor, jtf_total, jtf_avg;
	JButton btnClick;
	JComboBox<String> jcb;
	String[] header = { "�����", "����", "���", "������" };
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
		jl_stuName = new JLabel("�̸�");
		jl_stuMajor = new JLabel("�а�");
		jl_term = new JLabel("�б�");
		jl_total = new JLabel("���");
		jl_avg = new JLabel("�������");
		jtf_stuName = new JTextField(5);
		jtf_stuMajor = new JTextField(10);
		jtf_total = new JTextField(5);
		jtf_avg = new JTextField(5);
		btnClick = new JButton("��ȸ");

		jl_stuName.setFont(StdUI.FONT);
		jl_stuMajor.setFont(StdUI.FONT);
		jl_total.setFont(StdUI.FONT);
		jl_avg.setFont(StdUI.FONT);

		// �Է� ����
		jtf_stuName.setEditable(false);
		jtf_stuMajor.setEditable(false);
		jtf_total.setEditable(false);
		jtf_avg.setEditable(false);

		jcb = new JComboBox<String>();
		jcb.addItem("��ü");
		jcb.addItem("1�г�1�б�");
		jcb.addItem("1�г�2�б�");
		jcb.addItem("2�г�1�б�");
		jcb.addItem("2�г�2�б�");
		jcb.addItem("3�г�1�б�");
		jcb.addItem("3�г�2�б�");
		jcb.addItem("4�г�1�б�");
		jcb.addItem("4�г�2�б�");

		// ���̺�
		tableModel = new DefaultTableModel(header, 0);
		scoreTable = new JTable(tableModel);
		scoll = new JScrollPane(scoreTable);
		scoreTable.setRowHeight(20);

		// ���� ��ȸ - �л� ���� ���
		vo = dao.stdScore(StdUI.uid);
		jtf_stuName.setText(vo.getSname());
		jtf_stuMajor.setText(vo.getMname());

		// �л� ���� �г�
		jp_stuInfo.add(jl_stuName);
		jp_stuInfo.add(jtf_stuName);
		jp_stuInfo.add(jl_stuMajor);
		jp_stuInfo.add(jtf_stuMajor);
		jp_stuInfo.add(jl_term);
		jp_stuInfo.add(jcb);
		jp_stuInfo.add(btnClick);
		// �� ���� �г�
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

		// �̺�Ʈ ������
		StdScoreEvent eventObj = new StdScoreEvent();
		jcb.addActionListener(eventObj);
		btnClick.addActionListener(eventObj);
	}

	public void ResultList() {
		// ������� = (���� �� * ������ ����)�� �հ� / ������û ������
		int sum = 0; // ����
		int subCnt = 0; // �����
		int creditSum = 0; // ���� ����
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
		jtf_total.setText(String.valueOf((double) sum / subCnt)); // ���
		jtf_avg.setText(String.valueOf((double) allSum / creditSum)); // ������� | �Ҽ��� �Ʒ� ���ڸ����� ǥ���ϰ� ������ ��� ��ã��
	}

	class StdScoreEvent implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			int index = jcb.getSelectedIndex();

			if (btnClick == obj) {
				tableModel.setNumRows(0); // ���̺� �ʱ�ȭ
				if (index == 0) {// ��ü
					list = dao.stdSubjectList(StdUI.uid);
					ResultList();
				} else if (index == 1) {// 1�г� 1�б�
					list = dao.stdSubjectList(StdUI.uid, "S11");
					ResultList();
				} else if (index == 2) {// 1�г� 2�б�
					list = dao.stdSubjectList(StdUI.uid, "S12");
					ResultList();
				} else if (index == 3) {// 2�г� 1�б�
					list = dao.stdSubjectList(StdUI.uid, "S21");
					ResultList();
				} else if (index == 4) {// 2�г� 2�б�
					list = dao.stdSubjectList(StdUI.uid, "S22");
					ResultList();
				} else if (index == 5) {// 3�г� 1�б�
					list = dao.stdSubjectList(StdUI.uid, "S31");
					ResultList();
				} else if (index == 6) {// 3�г� 2�б�
					list = dao.stdSubjectList(StdUI.uid, "S32");
					ResultList();
				} else if (index == 7) {// 4�г� 1�б�
					list = dao.stdSubjectList(StdUI.uid, "S41");
					ResultList();
				} else if (index == 8) {// 4�г� 2�б�
					list = dao.stdSubjectList(StdUI.uid, "S42");
					ResultList();
				}
			}
		}// actionPerformed method
	}// inner class

}