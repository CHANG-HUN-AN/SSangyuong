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
 * 디자인적 요소를 가미하기위해 만든 클래스
 * title ->타이틀을 균일하게 만들기 위한 작업
 * @author dksck
 */
public class UIset {
	//field
	JPanel subPane;
	//constructor
	public UIset() {
		// TODO Auto-generated constructor stub
	}

	//method
	//타이틀과 jlabel을 넘겨받아서 균일하게 통일시키는 메소드
	public Object title(JPanel titlePane,JLabel jl_title,JScrollPane subPane) {
		Object obj;
		jl_title.setFont(StdUI.TITLEFONT);
		jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		
		titlePane.setLayout(new BorderLayout());
		titlePane.add(jl_title,new BorderLayout().NORTH);
		titlePane.add(subPane,new BorderLayout().CENTER);
		obj = titlePane;
		return obj;
	}
	//수정본
	public Object title(JPanel titlePane,JPanel subPanel,JLabel jl_title) {
		Object obj;
		jl_title.setFont(StdUI.TITLEFONT);
		titlePane.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		
		titlePane.setLayout(new BorderLayout());
		titlePane.add(jl_title,new BorderLayout().WEST);
		titlePane.add(subPanel,new BorderLayout().EAST);
		obj = titlePane;
		return obj;
	}
	
	public Object title(JPanel titlePane,JLabel jl_title,Container subPane) {
		Object obj;
		this.subPane = (JPanel)subPane; 
		jl_title.setFont(StdUI.TITLEFONT);
		jl_title.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new MatteBorder(0, 0, 1, 0, Color.BLACK)));
		
		titlePane.setLayout(new BorderLayout());
		titlePane.add(jl_title,new BorderLayout().NORTH);
		titlePane.add(this.subPane,new BorderLayout().CENTER);
		obj = titlePane;
		return obj;
	}

}
