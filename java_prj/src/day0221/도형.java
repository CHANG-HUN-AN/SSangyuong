package day0221;

public interface 도형 {
	// Field
//	String color = "검정색";
//	String name = "도형";

	// Constructor
//	public 도형() {
//		System.out.println("도형 생성자 호출");
//	}
//
//	public 도형(String name) {
//		System.out.println("도형 에서 오버로딩된 " + name + " 생성자 호출");
//	}

	// Method
	public  void getColor();
	public  void getColor(String color);
	

//	{System.out.println(color + " 도형");}
	public  void draw();
//	{System.out.println("\'도형\'을 그린다");}
}
