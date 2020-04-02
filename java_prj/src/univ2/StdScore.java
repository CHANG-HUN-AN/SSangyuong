package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StdScore extends JPanel {
   // Field
   JPanel jp_stuInfo, jp_result; // �л�����, �� ���� �г�
   JLabel jl_stuName, jl_stuMajor, jl_total, jl_avg, jl_term;
   JTextField jtf_stuName, jtf_stuMajor, jtf_total, jtf_avg;
   JTable scoreTable;
   JScrollPane scoll;
   JComboBox<String> jcb;
   
   StdDAO dao;
   StdVO vo;

   // Constructor
   public StdScore() {
      dao = new StdDAO();
      vo = new StdVO();
      scoreStart();
   }

   // Method
   public void scoreStart() {
      jp_stuInfo = new JPanel();
      jp_result = new JPanel();
      jl_stuName = new JLabel("�̸�");
      jl_stuMajor = new JLabel("�а�");
      jl_term = new JLabel("�б�");
      jl_total = new JLabel("����");
      jl_avg = new JLabel("���");
      jtf_stuName = new JTextField(5);
      jtf_stuMajor = new JTextField(10);
      jtf_total = new JTextField(5);
      jtf_avg = new JTextField(5);

      jl_stuName.setFont(StdUI.FONT);
      jl_stuMajor.setFont(StdUI.FONT);
      jl_total.setFont(StdUI.FONT);
      jl_avg.setFont(StdUI.FONT);

      jcb = new JComboBox<String>();
      jcb.addItem("1�г�1�б�");
      jcb.addItem("1�г�2�б�");
      jcb.addItem("2�г�1�б�");
      jcb.addItem("2�г�2�б�");
      jcb.addItem("3�г�1�б�");
      jcb.addItem("3�г�2�б�");
      jcb.addItem("4�г�1�б�");
      jcb.addItem("4�г�2�б�");
      
      
      String header[] = { "�����", "����", "���", "��米��" };
      String contents[][] = { { "����1", "80", "B", "" }, { "����2", "80", "B", "" }, { "����3", "80", "B", "" },
            { "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" },
            { "����4", "80", "B", "" } };
      scoreTable = new JTable(contents, header);
      scoll = new JScrollPane(scoreTable);
      scoreTable.setRowHeight(20);

      //����ϱ�
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

   }
   
   

}