package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StdScore extends JPanel {
   // Field
   JPanel jp_stuInfo, jp_result; // �л�����, �� ���� �г�
   JLabel jl_stuName, jl_stuMajor, jl_total, jl_avg;
   JTextField jtf_stuName, jtf_stuMajor, jtf_total, jtf_avg;
   JTable scoreTable;
   JScrollPane scoll;
   
   public static Font font = new Font("���� ���", Font.BOLD, 12);
   
   // Constructor
   public StdScore() {
      scoreStart();
   }
   
   // Method
   public void scoreStart() {
      jp_stuInfo = new JPanel();
      jp_result = new JPanel();
      jl_stuName = new JLabel("�̸�");
      jl_stuMajor = new JLabel("�а�");
      jl_total = new JLabel("����");
      jl_avg = new JLabel("���");
      jtf_stuName = new JTextField(5);
      jtf_stuMajor = new JTextField(5);
      jtf_total = new JTextField(5);
      jtf_avg = new JTextField(5);
      
      String header[] = { "�����", "����", "���", "��米��" };
      String contents[][] = { { "����1", "80", "B", "" }, { "����2", "80", "B", "" }, { "����3", "80", "B", "" },
            { "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" },
            { "����3", "80", "B", "" }, { "����3", "80", "B", "" }, { "����3", "80", "B", "" },
            { "����4", "80", "B", "" } };
      scoreTable = new JTable(contents, header);
      scoll = new JScrollPane(scoreTable);
      
      // �л� ���� �г�
      jp_stuInfo.add(jl_stuName);
      jp_stuInfo.add(jtf_stuName);
      jp_stuInfo.add(jl_stuMajor);
      jp_stuInfo.add(jtf_stuMajor);
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