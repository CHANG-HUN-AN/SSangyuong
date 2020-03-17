package day0309;

public class ChildThread implements Runnable{
	//Field
	String name;
	//Constructor
	public ChildThread() {
	}
	public ChildThread(String name) {
		this.name = name;
	}
	//Method
//	public String getName() {
//		System.out.println("�̸� : "+ name);
//	}
	
	public void run() {
		//���������� ����Ǵ� �ڵ�!!
		try {
			System.out.println("-------------->���ο��� ����");
			System.out.println("�̸� : "+ name);
			
			System.out.println("-------------->ChildThread ����");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
