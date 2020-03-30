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
		// 제목,내용,파일첨부
		System.out.print("제목을 입력해주세요 >");
		String title = scan.next();
		
		System.out.print("내용을 입력해주세요 >");
		String content = scan.next();

		//DB저장
		BoardVO vo =new BoardVO();
		vo.setBtitle(title);
		vo.setBcontent(content);
		
		int result = dao.getResultInsert(vo);
		if(result !=0)System.out.println("성공");
		else System.out.println("실패");
		
	}
}
