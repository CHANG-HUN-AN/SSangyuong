package day0217_t;


import java.util.Scanner;

public class Staff {
	//Field
	String isbn, name, author;
	int price;
	Scanner scan = new Scanner(System.in);
	
	//Constructor
	//Method
	public String[] input() {
		String[] book = new String[4];	
		
		System.out.print("���� : ISBN>");
		book[0] = scan.next();
		System.out.print("���� : ������>");
		book[1] = scan.next();
		System.out.print("���� : ����>");
		book[2] = scan.next();
		System.out.print("���� : ����>");
		book[3] = scan.next();
		
		return book;
	}
	
	public BookVO inputObject() {
		BookVO vo = new BookVO();	
		
		System.out.print("���� : ISBN>");
		vo.setIsbn(scan.next());
		System.out.print("���� : ������>");
		vo.setName(scan.next());
		System.out.print("���� : ����>");
		vo.setAuthor(scan.next());
		System.out.print("���� : ����>");
		vo.setPrice(scan.nextInt());		
		
		return vo;
	}
}











