package day0217;

import java.util.Scanner;

public class Staff {
	//Filed
	String isbn,name,author;
	int price ;
	Scanner scanner = new Scanner(System.in);
	//Constructor
	//Method
	public String[] input() {//같은종류의 데이터값을 넘기면 객체(VO)만들지않아도됨
		String[] book = new String[4];
		
		System.out.print("직원 : ISBN > \t");
		book[0] = scanner.next();
		System.out.print("직원 : 도서명 > \t");
		book[1] = scanner.next();
		System.out.print("직원 : 저자> \t");
		book[2]= scanner.next();
		System.out.print("직원 : 가격> \t");
		book[3]= scanner.next();
		return book;
	}
	public BookVO inputObject() {//같은종류의 데이터값을 넘기면 (VO)객체 만들지않아도됨 주소값만 넘긴다
		BookVO vo = new BookVO();
		
		System.out.print("직원 : ISBN > \t");
		vo.setIsbn(scanner.next()); 
		System.out.print("직원 : 도서명 > \t");
		vo.setName(scanner.next());
		System.out.print("직원 : 저자> \t");
		vo.setAuthor(scanner.next());
		System.out.print("직원 : 가격> \t");
		vo.setPrice(scanner.nextInt());
		
		return vo;
	}
}
