package S_Board_day0330;

import java.util.Scanner;

public class BoardWrite {
	// field
	Scanner scan;
	BoardDAO dao ;
	// constructor
	public BoardWrite() {
		writer();
	}

	public BoardWrite(Scanner scan,BoardDAO dao) {
		this.scan = scan;
		this.dao = dao;
		writer();
	}

	// method
	public void writer() {
		// ����,����,����÷��
		System.out.print("������ �Է����ּ��� >");
		String title = scan.next();
		
		System.out.print("������ �Է����ּ��� >");
		String content = scan.next();

		//DB����
		BoardVO vo =new BoardVO();
		vo.setBtitle(title);
		vo.setBcontent(content);
		
		int result = dao.getResultInsert(vo);
		if(result !=0)System.out.println("����");
		else System.out.println("����");
		
	}
}
