package inheritance0221;

public class test2 {

	public static void main(String[] args) {	
		������ �θ� = new ������();
//		������ �θ�2 = new ������();
//		��� �ڽ� = new ���();
		��� �ڽ�2 = (���)�θ�;
		
		System.out.println("==================");
		System.out.println(�θ�.name);
		�θ�.think();
		
		System.out.println(�ڽ�2.name);
		�ڽ�2.think();
	}

}
