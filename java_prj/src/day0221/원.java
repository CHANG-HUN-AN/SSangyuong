package day0221;

public class �� implements ���� {
	// Field
	String color;

	// Constructor
	public ��() {
//		super("��");
		System.out.println("�� ������ ȣ��");
	}

	// Method
	public void getColor() {
		System.out.println(color + "�� ��");
	}
	public void getColor(String color) {
		this.color = color;
		System.out.println(color+" �簢��");
	}
	public void draw() {
		System.out.println("\'��\'�� �׸���");
	}
}
