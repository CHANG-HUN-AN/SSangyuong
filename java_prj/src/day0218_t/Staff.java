package day0218_t;

import java.util.Scanner;

public class Staff {
	Scanner scanner = new Scanner(System.in);
	ScoreVO vo = null;
	
	//������ �����ͺ��̽��� �ִ��۾�
	public ScoreVO input() {
		  vo = new ScoreVO();
		  System.out.print("�й�>>>>");
		  vo.setStuno(scanner.next());
		  System.out.print("�̸�>>>>");
		  vo.setName(scanner.next());
		  System.out.print("��������>>>>");
		  vo.setKor(scanner.nextInt());
		  System.out.print("��������>>>>");
		  
		  vo.setEng(scanner.nextInt());
		  System.out.print("��������>>>>");
		  vo.setMath(scanner.nextInt());
		  return vo;
	}
	//�����ϴ� ���� input�� ScoreVO vo ������ �޸𸮿��� vo�� �ΰ����� ��������vo �������� vo
//	public void sahowAddress() {
//		System.out.println(vo);
//	}
}
