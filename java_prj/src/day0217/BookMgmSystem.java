package day0217;

public class BookMgmSystem {
	
	//Filed
	String isbn="",name="",author="";
	int price ;
	
//	String[] book=null;//�ּҰ��� ��� null�� �ʱ�ȭ ���� ���������̱⿡ �ʱ�ȭ ���ص�����
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
		this.book =book; //�迭�̶�� for �� ������ ���� �ּҰ��� �Ѱ��ָ� staff�� �迭 �ּҰ� �Ѿ��
		}
	
	public void showListVO() {
		System.out.println("---------���� ����Ʈ----------");
		System.out.println("ISBN : "+vo.getIsbn());
		System.out.println("NAME : "+vo.getName());
		System.out.println("AUTHOR : "+vo.getAuthor());
		System.out.println("PRICE : "+vo.price);
	}
	
	public void showListArray() {
		System.out.println("---------���� ����Ʈ----------");
		for(String str:book) {//(�迭�ȿ� ���� ������Ÿ�� : �迭��ü)
			System.out.println(str+" ");
		}
	}
	public void showList() {
		System.out.println("---------���� ����Ʈ----------");
		System.out.println("ISBN : "+isbn);
		System.out.println("NAME : "+name);
		System.out.println("AUTHOR : "+author);
		System.out.println("PRICE : "+price);
	}
	
	
}
