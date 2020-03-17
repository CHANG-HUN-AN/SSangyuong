package day0218_t;

import java.util.Scanner;

public class ScoreMgmSystem {
//	ScoreVO vo;
	ScoreVO[] volist = new ScoreVO[3];
	int count = 0;
//	Scanner scanner = new Scanner(System.in);
//	scanner 객체 또한 전역변수로 만들지않고 main실행시 매개변수값으로 넘겨줄수있다
	
	boolean flag = true;

	// 데이터베이스에 데이터 처리후 저장
	public void scoreRegister(Staff staff) {
		if (count < volist.length) {
			volist[count] = staff.input();
			count++;
		
				System.out.println("계속 등록하겠습니까? (y/n)>>  ");
				String exit = staff.scanner.next();
				
				if (exit.equals("y") && count == volist.length) {
					System.out.println("저장공간이 부족합니다.");
//					flag = false;
				} else if (exit.equals("y")) {
//					flag = true;
					scoreRegister(staff);
				}
		}//if
	}
	

	public boolean scoreRegister(ScoreVO vo,Scanner scanner) {
		if (count < volist.length) {
			volist[count] = vo;
			count++;
			boolean reset = true;
			while (reset) {
				System.out.println("계속 등록하겠습니까? (y/n)>>  ");
				String exit = scanner.next();

				if (exit.equals("y") && count == volist.length) {
					System.out.println("저장공간이 부족합니다.");
					flag = false;
					 reset=false;
				} else if (exit.equals("y")) {
					flag = true;
					 reset =false;
				} else if (exit.equals("n")) {
					flag = false;
					 reset=false;
				} else {
					System.out.println("다시 입력해주십시요.");
					reset=true;
				}
			}
		}
		return flag;
	}

	// 데이터베이스에 있는 데이터 출력
	public void showScoreList() {
		System.out.println("============Score List=================");
		for (ScoreVO vo : volist) {
			if (vo != null) {
				System.out.println("학번: " + vo.getStuno());
				System.out.println("이름: " + vo.getName());
				System.out.println("국어: " + vo.getKor());
				System.out.println("영어: " + vo.getEng());
				System.out.println("수학: " + vo.getMath());
				System.out.println("총점: " + vo.getTot());
				System.out.println("평균: " + vo.getAvg());			
				System.out.println("=================================");
			}
		}
	}
}
