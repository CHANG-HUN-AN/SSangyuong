package day0221;

/**
 * 은닉화를 쓰기위한 modifier 의 성질에대해 알아보자
 * @author user
 */
public class HidingObject {
	//Field
	public String name1 = "홍길동";
	private String name2 = "고길동";
	String name3 = "홍길동3";
	
	/**
	 *private의 접근제어자 변수를 우회적으로 read만 되게 만드는과정
	 * @return
	 */
	public String getName2() {
		return name2; 
	}
}
