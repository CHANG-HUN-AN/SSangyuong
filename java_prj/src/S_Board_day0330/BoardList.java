package S_Board_day0330;

import java.util.ArrayList;

public class BoardList {
	//Field
	BoardDAO dao;
	//Constructor
	public BoardList() { 
		list();
	}
	public BoardList(BoardDAO dao) { 
		this.dao = dao;
		list();
	}
	//Method
	public void list() {
		System.out.println("--------------------------------------");
		System.out.println("bid\tbtitle\tbcontent\tbdate"+"\t\t"+"bhits");
		System.out.println("--------------------------------------");
		ArrayList<BoardVO>list =new ArrayList<BoardVO>();
		list = dao.getResultList();
		for(BoardVO vo :list) {
			System.out.print(vo.getRno()+"\t");
			System.out.print(vo.getBtitle()+"\t");
			System.out.print(vo.getBcontent()+"\t\t");
			System.out.print(vo.getBdate()+"\t");
			System.out.print(vo.getBhits()+"\n");
		}
	}
}
