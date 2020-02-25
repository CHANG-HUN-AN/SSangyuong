package day0221;

public class 사각형 implements 도형{
	//Field
	String color;
	//Constructor 
	public 사각형() {
//		super("사각형");
		System.out.println("사각형 생성자 호출");
	}
	//Method
	public void getColor() {
		System.out.println(color+" 사각형");
	}
	public void getColor(String color) {
		this.color = color;
		System.out.println(color+" 사각형");
	}
	public void draw() {
		System.out.println("\'사각형\'을 그린다");
	}
}
