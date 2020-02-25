package day0217;

/**
 * value object의 약자VO 값만 있어야된다 다양한 데이터형을 넘길때 사용한다 배열은 같은 데이터형을 넘길때 사용
 * 
 * @author user
 */
public class BookVO {

	// Filed
	String isbn, name, author;
	int price;

	// Constructor;
	// Method - Getter/Setter;
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
