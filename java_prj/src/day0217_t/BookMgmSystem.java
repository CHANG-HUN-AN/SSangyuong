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
		
			System.out.print("��� �Է¹����ðڽ��ϱ�(y/n)?>>  ");
			String exit  =  scanner.next();
			if(exit.equals("y")&&count==volist.length) {
				System.out.println("��������� �ʰ��Ǿ����ϴ�");
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
		
		System.out.println("----- ���� ����Ʈ ---");
		for(BookVO vo :volist) {
			if(vo != null) {
				System.out.println(" ISBN : " + vo.getIsbn());
				System.out.println(" ������ : " + vo.getName());
				System.out.println(" ���� : " + vo.getAuthor());
				System.out.println(" ���� : " + vo.getPrice());
				System.out.println("------------------------------------");
			}
		}
	}
	
	public void showListArray() {
		System.out.println("----- ���� ����Ʈ ---");
		for(String str  : book) {
			System.out.println(str);
		}		
	}
	
	public void showList() {
		System.out.println("----- ���� ����Ʈ ---");
		System.out.println(" ISBN : " + isbn);
		System.out.println(" ������ : " + name);
		System.out.println(" ���� : " + author);
		System.out.println(" ���� : " + price);
	}
}













