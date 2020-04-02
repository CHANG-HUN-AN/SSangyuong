package S_Board_day0330;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardUpdate {
	//Field
	BoardDAO dao;
	Scanner scan;
	//Constructor
	public BoardUpdate() { }
	public BoardUpdate(BoardDAO dao) {
//		this.dao =dao;
		this(null,dao);
	}
	public BoardUpdate(Scanner scan,BoardDAO dao) {
		this.dao =dao;
		this.scan =scan;
	}
	//Method
	public void update() {
		//(UI가 없으닌까)
		//1.전체목록을 출력
		ArrayList<BoardVO> list = dao.getResultList();
		System.out.println("---------------------업데이트 목록----------------");
		for(BoardVO vo :list) {
			System.out.print(vo.getRno()+"\t");
			System.out.print(vo.getBtitle()+"\t");
			System.out.print(vo.getBcontent()+"\t");
			System.out.print(vo.getBdate()+"\t");
			System.out.print(vo.getBhits()+"\n");
		}
		System.out.println("---------------------------------------------------");
		
//		//수정할 행번호 선택 및 수정할 데이터 입력
		BoardVO uvo =new BoardVO();
		System.out.println("수정할 번호를 입력해주세요 >>>>");
		uvo.setRno(scan.nextInt());
		//★★★★★★★★★★수정할 번호를 통해 list 에서 bid를 찾아 uvo에 추가하기!!★★★★★★★★★(update에서 가장중요)
		for(BoardVO vo : list) {
			if(vo.getRno() == uvo.getRno()) {//행의 데이터가 같은게있다면 진행//아니면 진행x
				uvo.setBid(vo.getBid());
			}
		}
		//바꿀데이터 입력
		System.out.println("제목>>");
		uvo.setBtitle(scan.next());
	
		System.out.println("내용>>");
		uvo.setBcontent(scan.next());
		
//		BoardVO uvo =new BoardVO();
//		uvo.setRno(uno);
//		uvo.setBtitle(utitle);
//		uvo.setBcontent(ucontent);
		
//		 수정 데이터 전송 및 결과 수신
		int result =dao.getresultUpdate(uvo);
//		 결과에따른 출력
		if(result != 0 ) {
			System.out.println("수정성공");
		}else {
			System.out.println("실패");
		}
		
	}
}
