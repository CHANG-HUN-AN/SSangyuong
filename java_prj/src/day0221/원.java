package day0221;

public class 원 implements 도형 {
	// Field
	String color;

	// Constructor
	public 원() {
//		super("원");
		System.out.println("원 생성자 호출");
	}

	// Method
	public void getColor() {
		System.out.println(color + "색 원");
	}
	public void getColor(String color) {
		this.color = color;
		System.out.println(color+" 사각형");
	}
	public void draw() {
		System.out.println("\'원\'을 그린다");
	}
}
