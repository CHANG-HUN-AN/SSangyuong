package univ2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import univ2.Main_Register;

public class StdUI extends JFrame {
   // Field
   JPanel mainPane, menuPane, imgPane, showPane;
   JButton btnInfo, btnScore, btnExit;

   JPanel jp_logo, jp_title, jp_check, jp_id, jp_pass, jp_button;
   JLabel jl_limg, jl_title, jl_id, jl_pass;
   JTextField tid;
   JPasswordField tpass;
   JRadioButton jr_stu, jr_staff;
   JButton btnLogin, btnJoin;

   JFrame jf_main;
   JPanel jp_main;
   JTabbedPane tabPane;
   StdInfo tab_stuInfo;
   StdScore tab_stuScore;
   StdRegCourse tab_stuRegCourse;

   public static Font font = new Font("���� ���", Font.BOLD, 12);
   
   JPanel JoinPane = new JPanel(new GridLayout(9,1));
   
   // Constructor
   public StdUI() {
      showLogin();
   }

   // Method
   public void showLogin() {
      imgPane = new JPanel();
      showPane = new JPanel(new GridLayout(6, 1));
      jp_logo = new JPanel();
      jp_title = new JPanel();
      jp_check = new JPanel();
      jp_id = new JPanel();
      jp_pass = new JPanel();
      jp_button = new JPanel();

      jl_limg = new JLabel(new ImageIcon("src/univ2/sist.jpg"));
      jl_title = new JLabel("\n�ֿ���б� �л���� �ý���");
      jl_title.setFont(new Font("���� ���", Font.BOLD, 20));
      jl_id = new JLabel("���̵�");
      jl_pass = new JLabel("��й�ȣ");

      tid = new JTextField(15);
      tpass = new JPasswordField(15);

      jr_stu = new JRadioButton("�л�");
      jr_staff = new JRadioButton("������");

      btnLogin = new JButton("�α���");
      btnJoin = new JButton("ȸ������");

      jl_id.setFont(font);
      jl_pass.setFont(font);
      btnLogin.setFont(font);
      btnJoin.setFont(font);
      jr_stu.setFont(font);
      jr_staff.setFont(font);

      // �гο� �󺧳ֱ�
      jp_logo.add(jl_limg);
      jp_title.add(jl_title);
      jp_check.add(jr_stu);
      jp_check.add(jr_staff);
      jp_id.add(jl_id);
      jp_id.add(tid);
      jp_pass.add(jl_pass);
      jp_pass.add(tpass);
      jp_button.add(btnLogin);
      jp_button.add(btnJoin);

      // ���гο� �гγֱ�
      imgPane.add(jp_logo);
      showPane.add(jp_title);
      showPane.add(jp_check);
      showPane.add(jp_id);
      showPane.add(jp_pass);
      showPane.add(jp_button);

      // �����ӿ� �гγֱ�
      add(imgPane, BorderLayout.NORTH);
      add(showPane, BorderLayout.CENTER);

      setSize(600, 600);

      Dimension fsize = getSize();
      Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
      int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
      int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

      setLocation(width, height);
      setVisible(true);

      // �̺�Ʈ ������
      StdUIEvent eventObj = new StdUIEvent();
      addWindowListener(eventObj);
      btnLogin.addActionListener(eventObj);
      btnJoin.addActionListener(eventObj);
   }

   public void start() {
      jf_main = new JFrame(); // ����
      tab_stuInfo = new StdInfo();
      tab_stuScore = new StdScore();
      tab_stuRegCourse = new StdRegCourse();
      jp_main = new JPanel();

      tabPane = new JTabbedPane();

      tabPane.addTab("HOME", jp_main);
      tabPane.addTab("���� ��ȸ", tab_stuInfo);
      tabPane.addTab("���� ��ȸ", tab_stuScore);
      tabPane.addTab("������û", tab_stuRegCourse);

      jf_main.add(tabPane);
      jf_main.setSize(600, 600);
      // location center
      Dimension fsize = getSize();
      Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
      int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
      int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
      jf_main.setLocation(width, height);
      jf_main.setVisible(true);

      StdUIEvent eventObj = new StdUIEvent();
      jf_main.addWindowListener(eventObj);
   }

   class StdUIEvent extends WindowAdapter implements ActionListener {
      StdUI main;

      public StdUIEvent() {
      }

      public StdUIEvent(StdUI main) {
         this.main = main;
      }

      public void windowClosing(WindowEvent we) {
         JOptionPane.showMessageDialog(null, "���α׷� ����");
         System.exit(0);
      }

      public void actionPerformed(ActionEvent ae) {
         Object obj = ae.getSource(); // ��ư ������ �� String ��ȯ
         if (btnLogin == obj) {
            String bname = ae.getActionCommand();
            if (bname.equals("�α���") || tpass == ae.getSource()) {
               if (validationCheck())
                  loginCheck();

            } else if (bname.equals("���")) {
               tid.setText("");
               tpass.setText("");
            }
         } else if (btnJoin == obj) {
        	 new Main_Register();
         }
      }

   }

   // Method
   /** ������ ��ȿ�� üũ **/
   public boolean validationCheck() {
      boolean result = false;
      // tid, tpass�� ���� ������ �޽����� ���
      if (tid.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
         tid.requestFocus();
      } else if (tpass.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "�н����带 �Է����ּ���");
         tpass.requestFocus();
      } else {
         result = true;
      }

      return result;
   }

   /** �α��� üũ **/
   public void loginCheck() {
      String did = "test";
      String dpass = "1234";
      String uid = tid.getText().trim();
      String upass = tpass.getText().trim();

      if (did.equals(uid)) {
         if (dpass.equals(upass)) {
            // �α��μ��� : id,pass ����
            JOptionPane.showMessageDialog(null, "�α��� ����");
            System.out.println("1111");
            setVisible(false);
            System.out.println("2222");
            start();
            System.out.println("3333");
         } else {
            // �α��� ���� : id ����, pass �ٸ�
            JOptionPane.showMessageDialog(null, "�α��� ����, �н����尡 �ٸ�");
         }
      } else {
         // System.out.println("�α��� ����");
         JOptionPane.showMessageDialog(null, "�α��� ����, ���̵� �ٸ�");
      }
   }
}