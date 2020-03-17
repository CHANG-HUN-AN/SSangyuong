package day0218;

public class ConstructorTest {

	public static void main(String[] args) {
		ConstructorObject co = new ConstructorObject();
		ConstructorObject co1 = new ConstructorObject("한예ㅅ","부산");
		ConstructorObject co2 = new ConstructorObject("한예1","서울",90,80,70);
		co.test();
		co1.test();
		co2.test();
	}

}
