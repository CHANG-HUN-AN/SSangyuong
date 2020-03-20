package univ2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import univ2.Main_Login.StdUIEvent;

public class StdPass extends JFrame {
   // Field
   JPanel passPane, titlePane, idPane, noPane, buttonPane;
   JLabel jl_title, jl_id, jl_no;
   JTextField jtf_id, jtf_no;
   JButton btnSearch, btnReset;
   
   Font font = new Font("맑은 고딕", Font.BOLD, 12);

   // Constructor
   public StdPass() {
      passStart();
   }

   // Method
   public void passStart() {
	   setTitle("비 밀 번 호 찾 기");
	   
      passPane = new JPanel(new GridLayout(5,1));
      titlePane = new JPanel();
      idPane = new JPanel();
      noPane = new JPanel();
      buttonPane = new JPanel();
      jl_title = new JLabel("비 밀 번 호 찾 기");
      jl_id = new JLabel("ID");
      jl_no = new JLabel("학번");
      jtf_id = new JTextField(15);
      jtf_no = new JTextField(15);
      btnSearch = new JButton("찾기");
      btnReset = new JButton("취소");
      
      jl_title.setFont(font);
      jl_id.setFont(font);
      jl_no.setFont(font);
      btnSearch.setFont(font);
      btnReset.setFont(font);

      titlePane.add(jl_title);
      idPane.add(jl_id);
      idPane.add(jtf_id);
      noPane.add(jl_no);
      noPane.add(jtf_no);
      buttonPane.add(btnSearch);
      buttonPane.add(btnReset);
      
      passPane.add(titlePane);
      passPane.add(idPane);
      passPane.add(noPane);
      passPane.add(buttonPane);
      
      add(passPane);

      setSize(300, 250);

      Dimension fsize = getSize();
      Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
      int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
      int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

      setLocation(width, height);
      setVisible(true);
   }
   
}