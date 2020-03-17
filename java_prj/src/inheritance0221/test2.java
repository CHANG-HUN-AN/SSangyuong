package inheritance0221;

public class test2 {

	public static void main(String[] args) {	
		포유류 부모 = new 포유류();
//		포유류 부모2 = new 포유류();
//		사람 자식 = new 사람();
		사람 자식2 = (사람)부모;
		
		System.out.println("==================");
		System.out.println(부모.name);
		부모.think();
		
		System.out.println(자식2.name);
		자식2.think();
	}

}
