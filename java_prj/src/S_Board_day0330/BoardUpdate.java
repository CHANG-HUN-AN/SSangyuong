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
		//(UI�� �����ѱ�)
		//1.��ü����� ���
		ArrayList<BoardVO> list = dao.getResultList();
		System.out.println("---------------------������Ʈ ���----------------");
		for(BoardVO vo :list) {
			System.out.print(vo.getRno()+"\t");
			System.out.print(vo.getBtitle()+"\t");
			System.out.print(vo.getBcontent()+"\t");
			System.out.print(vo.getBdate()+"\t");
			System.out.print(vo.getBhits()+"\n");
		}
		System.out.println("---------------------------------------------------");
		
//		//������ ���ȣ ���� �� ������ ������ �Է�
		BoardVO uvo =new BoardVO();
		System.out.println("������ ��ȣ�� �Է����ּ��� >>>>");
		uvo.setRno(scan.nextInt());
		//�ڡڡڡڡڡڡڡڡڡڼ����� ��ȣ�� ���� list ���� bid�� ã�� uvo�� �߰��ϱ�!!�ڡڡڡڡڡڡڡڡ�(update���� �����߿�)
		for(BoardVO vo : list) {
			if(vo.getRno() == uvo.getRno()) {//���� �����Ͱ� �������ִٸ� ����//�ƴϸ� ����x
				uvo.setBid(vo.getBid());
			}
		}
		//�ٲܵ����� �Է�
		System.out.println("����>>");
		uvo.setBtitle(scan.next());
	
		System.out.println("����>>");
		uvo.setBcontent(scan.next());
		
//		BoardVO uvo =new BoardVO();
//		uvo.setRno(uno);
//		uvo.setBtitle(utitle);
//		uvo.setBcontent(ucontent);
		
//		 ���� ������ ���� �� ��� ����
		int result =dao.getresultUpdate(uvo);
//		 ��������� ���
		if(result != 0 ) {
			System.out.println("��������");
		}else {
			System.out.println("����");
		}
		
	}
}
