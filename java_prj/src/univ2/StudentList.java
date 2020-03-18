package univ2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StudentList {
   // Field
   JPanel listPane;

   // 학생 정보
   JPanel jp_stu;
   JPanel mainPane, menuPane;
   JButton btnInfo, btnScore, btnExit;

   JPanel infoPane, imgPane, namePane, majorPane, noPane, phonePane, genderPane, emailPane, birthPane, buttonPane;
   JTabbedPane infoTab, scoreTab;
   JLabel jl_img, jl_name, jl_major, jl_no, jl_phone, jl_gender, jl_email, jl_birth;
   JTextField jt_name, jt_major, jt_no, jt_phone, jt_email, jt_birth;
   JRadioButton jrb_female, jrb_male;
   JButton jb_save, jb_reset;

   public static Font font = new Font("맑은 고딕", Font.BOLD, 12);

   // 학생 성적
   JPanel jp_main, jp_score, jp_info, jp_result;
   JLabel jl_main, jl_info, jl_sname, jl_smajor, jl_total, jl_avg;
   JTextField jtf_name, jtf_major, jtf_total, jtf_avg;
   JTabbedPane tapPane;
   JTable scoreTable;
   JScrollPane scoll;
   SYUnivMgmUI main;

   // Constructor
   public StudentList() {
   }

   public StudentList(SYUnivMgmUI main) {
      this.main = main;
      this.mainPane = main.mainPane;
   }

   // Method
   public void list() {
//      main.switchPane(SYUnivMgmUI.INFO);
      
      jp_main = new JPanel();
      jl_main = new JLabel("메인");
    		  
      jp_stu = new JPanel();
//      imgPane = new JPanel();
      namePane = new JPanel();
      majorPane = new JPanel();
      noPane = new JPanel();
      phonePane = new JPanel();
      genderPane = new JPanel();
      emailPane = new JPanel();
      birthPane = new JPanel();
      buttonPane = new JPanel();

//      jl_img = new JLabel(new ImageIcon("src/univ2/sist.jpeg"));
      jl_name = new JLabel("이름: ");
      jl_major = new JLabel("학과: ");
      jl_no = new JLabel("학번: ");
      jl_phone = new JLabel("연락처: ");
      jl_gender = new JLabel("성별: ");
      jl_email = new JLabel("이메일: ");
      jl_birth = new JLabel("생년월일: ");

      jrb_female = new JRadioButton("여자");
      jrb_male = new JRadioButton("남자");
      ButtonGroup gr_gender = new ButtonGroup();

      jt_name = new JTextField(20);
      jt_major = new JTextField(20);
      jt_no = new JTextField(20);
      jt_phone = new JTextField(20);
      jt_email = new JTextField(20);
      jt_birth = new JTextField(20);

      jb_save = new JButton("저장");
      jb_reset = new JButton("취소");

      jl_name.setFont(font);
      jl_major.setFont(font);
      jl_no.setFont(font);
      jl_phone.setFont(font);
      jl_gender.setFont(font);
      jl_email.setFont(font);
      jl_birth.setFont(font);
      
      
      jp_main.add(jl_main);
      

//      imgPane.add(jl_img);
      namePane.add(jl_name);
      namePane.add(jt_name);

      majorPane.add(jl_major);
      majorPane.add(jt_major);

      noPane.add(jl_no);
      noPane.add(jt_no);

      phonePane.add(jl_phone);
      phonePane.add(jt_phone);

      gr_gender.add(jrb_female);
      gr_gender.add(jrb_male);
      genderPane.add(jl_gender);
      genderPane.add(jrb_female);
      genderPane.add(jrb_male);

      emailPane.add(jl_email);
      emailPane.add(jt_email);

      birthPane.add(jl_birth);
      birthPane.add(jt_birth);

      buttonPane.add(jb_save);
      buttonPane.add(jb_reset);

//      jp_stu.add(imgPane);
      jp_stu.add(namePane);
      jp_stu.add(majorPane);
      jp_stu.add(noPane);
      jp_stu.add(phonePane);
      jp_stu.add(genderPane);
      jp_stu.add(emailPane);
      jp_stu.add(birthPane);
      jp_stu.add(buttonPane);
      
     
      jp_score = new JPanel();
      jp_info = new JPanel();
      jp_result = new JPanel();
      jl_sname = new JLabel("이름");
      jl_smajor = new JLabel("학과");
      jl_total = new JLabel("총점");
      jl_avg = new JLabel("평균");
      jtf_name = new JTextField(5);
      jtf_major = new JTextField(8);
      jtf_total = new JTextField(5);
      jtf_avg = new JTextField(5);
      tapPane = new JTabbedPane();
      
      //@0317 데이터 입출력및 테이블 클릭시 코드 수정 불가
      String header[] = { "과목명", "성적", "등급", "비고" };
      String contents[][] = { { "과목1", "80", "B", "" }, { "과목2", "80", "B", "" }, { "과목3", "80", "B", "" },
            { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" },
            { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" }, { "과목3", "80", "B", "" },
            { "과목4", "80", "B", "" } };
      scoreTable = new JTable(contents, header);
      scoll = new JScrollPane(scoreTable);
      
      jp_info.add(jl_sname);
      jp_info.add(jtf_name);
      jp_info.add(jl_smajor);
      jp_info.add(jtf_major);
      jp_result.add(jl_total);
      jp_result.add(jtf_total);
      jp_result.add(jl_avg);
      jp_result.add(jtf_avg);

      jp_stu.setLayout(new GridLayout(10, 1));

      tapPane.addTab("메인", jp_main);
      tapPane.addTab("정보", jp_stu);
      tapPane.addTab("성적", jp_score);
      
      jp_score.add(jp_info);
      jp_score.add(scoll, BorderLayout.CENTER);
      jp_score.add(jp_result);
      // jp_info.add(btn1);
      // jp_info.add(btn2);

      listPane.setLayout(new GridLayout(1, 1));
      listPane.add(tapPane);

      main.add(listPane, BorderLayout.CENTER);

      // jp_info.setSize(500,500);
      main.setVisible(true);
   }

}
