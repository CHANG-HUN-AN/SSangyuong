package univ2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * �������� ��Ҹ� �����ϱ����� ���� Ŭ����
 * title ->Ÿ��Ʋ�� �����ϰ� ����� ���� �۾�
 * @author dksck
 */
public class UIset {
	//field
	static Font titleFont = new Font("���� ���", Font.BOLD, 16);
	JPanel subPane;
	//constructor
	public UIset() {
		// TODO Auto-generated constructor stub
	}

	//method
	//Ÿ��Ʋ�� jlabel�� �Ѱܹ޾Ƽ� �����ϰ� ���Ͻ�Ű�� �޼ҵ�
	public Object title(JPanel titlePane,JLabel jl_title,JScrollPane subPane) {
		Object obj;
		jl_title.setFont(titleFont);
		jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		
		titlePane.setLayout(new BorderLayout());
		titlePane.add(jl_title,new BorderLayout().NORTH);
		titlePane.add(subPane,new BorderLayout().CENTER);
		obj = titlePane;
		return obj;
	}
	
	public Object title(JPanel titlePane,JLabel jl_title,Container subPane) {
		Object obj;
		this.subPane = (JPanel)subPane; 
		jl_title.setFont(titleFont);
		jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		
		titlePane.setLayout(new BorderLayout());
		titlePane.add(jl_title,new BorderLayout().NORTH);
		titlePane.add(this.subPane,new BorderLayout().CENTER);
		obj = titlePane;
		return obj;
	}
	public void boxLayout(JComponent panel,JComponent jlabel1,JComponent jlabel2,JComponent jlabel3,
			JComponent jlabel4,JComponent jlabel5,JComponent jlabel6,JComponent jlabel7) {
		
	}
}
