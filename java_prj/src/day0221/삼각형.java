package day0221;

public class »ï°¢Çü implements µµÇü{
	//Field
		String color="³ë¶û»ö";
		String name = "»ï°¢Çü";
	//Constructor 
	public »ï°¢Çü() {
//		super("»ï°¢Çü");
		System.out.println("»ï°¢Çü »ý¼ºÀÚ È£Ãâ");
	}
	//Method
	public void getColor() {
		System.out.println(color+" »ï°¢Çü");
	}
	
	public void getColor(String color) {
		this.color = color;
		System.out.println(color+" »ç°¢Çü");
	}
	
	public void draw() {
		System.out.println("\'»ï°¢Çü\'À» ±×¸°´Ù");
	}
}
