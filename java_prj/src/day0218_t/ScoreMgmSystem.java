package day0218_t;

import java.util.Scanner;

public class ScoreMgmSystem {
//	ScoreVO vo;
	ScoreVO[] volist = new ScoreVO[3];
	int count = 0;
//	Scanner scanner = new Scanner(System.in);
//	scanner ��ü ���� ���������� �������ʰ� main����� �Ű����������� �Ѱ��ټ��ִ�
	
	boolean flag = true;

	// �����ͺ��̽��� ������ ó���� ����
	public void scoreRegister(Staff staff) {
		if (count < volist.length) {
			volist[count] = staff.input();
			count++;
		
				System.out.println("��� ����ϰڽ��ϱ�? (y/n)>>  ");
				String exit = staff.scanner.next();
				
				if (exit.equals("y") && count == volist.length) {
					System.out.println("��������� �����մϴ�.");
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
				System.out.println("��� ����ϰڽ��ϱ�? (y/n)>>  ");
				String exit = scanner.next();

				if (exit.equals("y") && count == volist.length) {
					System.out.println("��������� �����մϴ�.");
					flag = false;
					 reset=false;
				} else if (exit.equals("y")) {
					flag = true;
					 reset =false;
				} else if (exit.equals("n")) {
					flag = false;
					 reset=false;
				} else {
					System.out.println("�ٽ� �Է����ֽʽÿ�.");
					reset=true;
				}
			}
		}
		return flag;
	}

	// �����ͺ��̽��� �ִ� ������ ���
	public void showScoreList() {
		System.out.println("============Score List=================");
		for (ScoreVO vo : volist) {
			if (vo != null) {
				System.out.println("�й�: " + vo.getStuno());
				System.out.println("�̸�: " + vo.getName());
				System.out.println("����: " + vo.getKor());
				System.out.println("����: " + vo.getEng());
				System.out.println("����: " + vo.getMath());
				System.out.println("����: " + vo.getTot());
				System.out.println("���: " + vo.getAvg());			
				System.out.println("=================================");
			}
		}
	}
}
