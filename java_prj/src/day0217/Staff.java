package day0217;

import java.util.Scanner;

public class Staff {
	//Filed
	String isbn,name,author;
	int price ;
	Scanner scanner = new Scanner(System.in);
	//Constructor
	//Method
	public String[] input() {//���������� �����Ͱ��� �ѱ�� ��ü(VO)�������ʾƵ���
		String[] book = new String[4];
		
		System.out.print("���� : ISBN > \t");
		book[0] = scanner.next();
		System.out.print("���� : ������ > \t");
		book[1] = scanner.next();
		System.out.print("���� : ����> \t");
		book[2]= scanner.next();
		System.out.print("���� : ����> \t");
		book[3]= scanner.next();
		return book;
	}
	public BookVO inputObject() {//���������� �����Ͱ��� �ѱ�� (VO)��ü �������ʾƵ��� �ּҰ��� �ѱ��
		BookVO vo = new BookVO();
		
		System.out.print("���� : ISBN > \t");
		vo.setIsbn(scanner.next()); 
		System.out.print("���� : ������ > \t");
		vo.setName(scanner.next());
		System.out.print("���� : ����> \t");
		vo.setAuthor(scanner.next());
		System.out.print("���� : ����> \t");
		vo.setPrice(scanner.nextInt());
		
		return vo;
	}
}
