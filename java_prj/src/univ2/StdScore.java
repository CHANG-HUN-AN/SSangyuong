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
   JPanel jp_stuInfo, jp_result; // 학생정보, 총 점수 패널
   JLabel jl_stuName, jl_stuMajor, jl_total, jl_avg;
   JTextField jtf_stuName, jtf_stuMajor, jtf_total, jtf_avg;
   JTable scoreTable;
   JScrollPane scoll;
   
   public static Font font = new Font("맑은 고딕", Font.BOLD, 12);
   
   // Constructor
   public StdScore() {
      scoreStart();
   }
   
   // Method
   public void scoreStart() {
      jp_stuInfo = new JPanel();
      jp_result = new JPanel();
      jl_stuName = new JLabel("이름");
      jl_stuMajor = new JLabel("학과");
      jl_total = new JLabel("총점");
      jl_avg = new JLabel("평균");
      jtf_stuName = new JTextField(5);
      jtf_stuMajor = new JTextField(5);
      jtf_total = new JTextField(5);
      jtf_avg = new JTextField(5);
      
      String header[] = { "과목명", "성적", "등급", "담당교수" };
      String contents[][] = { { "과목1", "80", "B", "" }, { "과목2", "80", "B", "" }, { "과목3", "80", "B", "" },
            { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" },
            { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" },
            { "과목4", "80", "B", "" } };
      scoreTable = new JTable(contents, header);
      scoll = new JScrollPane(scoreTable);
      
      // 학생 정보 패널
      jp_stuInfo.add(jl_stuName);
      jp_stuInfo.add(jtf_stuName);
      jp_stuInfo.add(jl_stuMajor);
      jp_stuInfo.add(jtf_stuMajor);
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
      
   }
   
}