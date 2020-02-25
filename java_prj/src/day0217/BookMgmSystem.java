package day0217;

public class BookMgmSystem {
	
	//Filed
	String isbn="",name="",author="";
	int price ;
	
//	String[] book=null;//주소값의 경우 null로 초기화 현재 전역변수이기에 초기화 안해도가능
	String[] book;
	
	BookVO vo;
	//Constructor
	//Method
	public void register(BookVO vo) {
		this.vo =vo ;
	}
	
	public void register(String isbn,String name,String author,int price) {
		this.isbn=isbn;
		this.name=name;
		this.author=author;
		this.price=price;
	}
	public void register(String[] book) {
		this.book =book; //배열이라고 for 문 돌리지 말고 주소값을 넘겨주면 staff의 배열 주소가 넘어간다
		}
	
	public void showListVO() {
		System.out.println("---------도서 리스트----------");
		System.out.println("ISBN : "+vo.getIsbn());
		System.out.println("NAME : "+vo.getName());
		System.out.println("AUTHOR : "+vo.getAuthor());
		System.out.println("PRICE : "+vo.price);
	}
	
	public void showListArray() {
		System.out.println("---------도서 리스트----------");
		for(String str:book) {//(배열안에 값의 데이터타입 : 배열객체)
			System.out.println(str+" ");
		}
	}
	public void showList() {
		System.out.println("---------도서 리스트----------");
		System.out.println("ISBN : "+isbn);
		System.out.println("NAME : "+name);
		System.out.println("AUTHOR : "+author);
		System.out.println("PRICE : "+price);
	}
	
	
}
