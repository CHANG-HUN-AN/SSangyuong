package day0218;

public class ConstructorObject {
	//Feild - ��������
	String name,address;
	int kor,eng,math;
	//Constructor - ������
	//������ ����: public �����ڸ�[=Ŭ������](){���~} returnŸ���� ����
	//�ʵ尪�� �ʱ�ȭ�Ҷ� ���� �̿��Ѵ�.
	/*
	 *�����ڶ�?
	 *1.��ü ������ ȣ��Ǵ� �޼ҵ� //Change ch= new Change();-> Change(); �⺻�����ڸ� ȣ���ϴ°�
	 *2.�����ڸ� �Ѱ��� ���� ���� �ʴ� ��� JVM�� Complie �� �⺻�����ڸ� ����(//bytecode ������� �����ϸ�����Ǵ°�)
	 * 3.�پ��� �Ķ���� ������ ������ �����ε��� �����ϴ�
	 * 4.returnŸ���� �������� �ʴ�.
	 * 5.this()�� �̿��Ͽ� ������ ȣ���� �����ϴ�.
	 */
	public ConstructorObject() {
		this("ȫ�浿","����",50,50,50);
		System.out.println("�⺻������ ȣ��");
//		this.name = "ȫ�浿";
//		this.address = "����";
//		this.kor = 50; this.eng = 50; this.math = 50;
		
	}
	public ConstructorObject(String name,String address) {
		this(name,address,0,0,0);
		System.out.println("�⺻������ ȣ��");
		this.name = name;
		this.address = address;
	}
	public ConstructorObject(String name,String address,int kor , int eng ,int math) {
		System.out.println("�⺻������ ȣ��");
		this.name = name;
		this.address = address;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//Method -�޼ҵ�
	public void test() {
		System.out.println("�̸� : "+name);
		System.out.println("�ּ� : "+address);
		System.out.println("���� : "+kor);
		System.out.println("���� : "+eng);
		System.out.println("���� : "+math);
	}
}
