package day0221;

public class �ﰢ�� implements ����{
	//Field
		String color="�����";
		String name = "�ﰢ��";
	//Constructor 
	public �ﰢ��() {
//		super("�ﰢ��");
		System.out.println("�ﰢ�� ������ ȣ��");
	}
	//Method
	public void getColor() {
		System.out.println(color+" �ﰢ��");
	}
	
	public void getColor(String color) {
		this.color = color;
		System.out.println(color+" �簢��");
	}
	
	public void draw() {
		System.out.println("\'�ﰢ��\'�� �׸���");
	}
}
