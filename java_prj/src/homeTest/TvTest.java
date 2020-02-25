package homeTest;

public class TvTest {
	String color;
	boolean power;
	int chanel;
	void power() {
		power = !power;
	}
	void chanelUp() {
		chanel ++;
	}
	void chanelDown() {
		--chanel;
	}
	public static void main(String[] args) {
		TvTest tv;
		tv = new TvTest();
		
	}

}
