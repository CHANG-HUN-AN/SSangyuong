package day0218_t;

import java.util.Scanner;

public class Staff {
	Scanner scanner = new Scanner(System.in);
	ScoreVO vo = null;
	
	//데이터 데이터베이스에 넣는작업
	public ScoreVO input() {
		  vo = new ScoreVO();
		  System.out.print("학번>>>>");
		  vo.setStuno(scanner.next());
		  System.out.print("이름>>>>");
		  vo.setName(scanner.next());
		  System.out.print("국어점수>>>>");
		  vo.setKor(scanner.nextInt());
		  System.out.print("영어점수>>>>");
		  
		  vo.setEng(scanner.nextInt());
		  System.out.print("수학점수>>>>");
		  vo.setMath(scanner.nextInt());
		  return vo;
	}
	//자주하는 오류 input의 ScoreVO vo 생성시 메모리에는 vo가 두개생김 전역변수vo 지역변수 vo
//	public void sahowAddress() {
//		System.out.println(vo);
//	}
}
