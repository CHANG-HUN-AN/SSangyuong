package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Main_Info extends JFrame {
   Main_Login main;

   JFrame jf_join;

   public static Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 12);

   public Main_Info() {
//      try {
//         UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//         JFrame.setDefaultLookAndFeelDecorated(true);
//         join();
//      } catch (Exception e) {
//      }
      info();
   }

   public void info() {
      setTitle("È¸ ¿ø °¡ ÀÔ");
      jf_join = new JFrame();
      
      jf_join.setSize(450, 600);
      
      // location center
      Dimension fsize = getSize();
      Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
      int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
      int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
      
      jf_join.setLocation(width, height);
      jf_join.setVisible(true);
   }
}