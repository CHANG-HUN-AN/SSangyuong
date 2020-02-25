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
		
		System.out.print("직원 : ISBN>");
		book[0] = scan.next();
		System.out.print("직원 : 도서명>");
		book[1] = scan.next();
		System.out.print("직원 : 저자>");
		book[2] = scan.next();
		System.out.print("직원 : 가격>");
		book[3] = scan.next();
		
		return book;
	}
	
	public BookVO inputObject() {
		BookVO vo = new BookVO();	
		
		System.out.print("직원 : ISBN>");
		vo.setIsbn(scan.next());
		System.out.print("직원 : 도서명>");
		vo.setName(scan.next());
		System.out.print("직원 : 저자>");
		vo.setAuthor(scan.next());
		System.out.print("직원 : 가격>");
		vo.setPrice(scan.nextInt());		
		
		return vo;
	}
}











