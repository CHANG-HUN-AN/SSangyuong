package S_Board_day0330;

import java.util.Scanner;

/**
 *db와 연결을통해 메뉴 만들기
 * @author user
 */
public class BoardTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		
		System.out.println("----------------------------------------");
		System.out.println("1.글쓰기 2. 읽기 3 . 수정 4 .삭제");
		System.out.println("----------------------------------------");
	
			System.out.print("메뉴를 선택해주세요(번호)>");
			int menu = scan.nextInt();
			
			switch(menu) { //값이 상수인경우 switch 사용
			case 1: new BoardWrite(scan,dao); break;
			case 2: new BoardList(dao);break;
			default:
			}
		
		
		
	}//main
}//class
