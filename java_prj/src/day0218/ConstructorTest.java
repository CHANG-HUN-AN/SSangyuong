package day0218;

public class ConstructorTest {

	public static void main(String[] args) {
		ConstructorObject co = new ConstructorObject();
		ConstructorObject co1 = new ConstructorObject("�ѿ���","�λ�");
		ConstructorObject co2 = new ConstructorObject("�ѿ�1","����",90,80,70);
		co.test();
		co1.test();
		co2.test();
	}

}
