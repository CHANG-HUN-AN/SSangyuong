package day0221;

public class �簢�� implements ����{
	//Field
	String color;
	//Constructor 
	public �簢��() {
//		super("�簢��");
		System.out.println("�簢�� ������ ȣ��");
	}
	//Method
	public void getColor() {
		System.out.println(color+" �簢��");
	}
	public void getColor(String color) {
		this.color = color;
		System.out.println(color+" �簢��");
	}
	public void draw() {
		System.out.println("\'�簢��\'�� �׸���");
	}
}
