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
//		System.out.println("이름 : "+ name);
//	}
	
	public void run() {
		//독립했을때 실행되는 코드!!
		try {
			System.out.println("-------------->메인에서 독립");
			System.out.println("이름 : "+ name);
			
			System.out.println("-------------->ChildThread 종료");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
