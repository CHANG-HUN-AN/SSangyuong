package day0217_t;

import java.util.Scanner;

public class BookMgmSystem {
	//Field
	String isbn, name, author;
	int price;
	String[] book = null;
//	BookVO vo;
	BookVO[] volist = new BookVO[2];
	int count;
	Scanner scanner = new Scanner(System.in);

	
	//Constructor
	//Method
	public boolean register(BookVO vo) {		
//		this.vo = vo;
		boolean flag =false;
		if(count<volist.length) {
			volist[count] = vo;
			count++;
		
			System.out.print("계속 입력받으시겠습니까(y/n)?>>  ");
			String exit  =  scanner.next();
			if(exit.equals("y")&&count==volist.length) {
				System.out.println("저장공간이 초과되었습니다");
			}else if (exit.equals("y")) {
				flag = true;
			}else {
				flag = false;
			}
		}
		return flag;
	}
	
	public void register(String[] book) {
		this.book = book;
	}
	
	public void register(String isbn, String name, String author, int price) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public void showListObject() {
		
		System.out.println("----- 도서 리스트 ---");
		for(BookVO vo :volist) {
			if(vo != null) {
				System.out.println(" ISBN : " + vo.getIsbn());
				System.out.println(" 도서명 : " + vo.getName());
				System.out.println(" 저자 : " + vo.getAuthor());
				System.out.println(" 가격 : " + vo.getPrice());
				System.out.println("------------------------------------");
			}
		}
	}
	
	public void showListArray() {
		System.out.println("----- 도서 리스트 ---");
		for(String str  : book) {
			System.out.println(str);
		}		
	}
	
	public void showList() {
		System.out.println("----- 도서 리스트 ---");
		System.out.println(" ISBN : " + isbn);
		System.out.println(" 도서명 : " + name);
		System.out.println(" 저자 : " + author);
		System.out.println(" 가격 : " + price);
	}
}













