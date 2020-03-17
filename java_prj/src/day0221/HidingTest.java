package day0221;

import java.util.ArrayList;

public class HidingTest {

	public static void main(String[] args) {
		HidingObject ho = new HidingObject();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		System.out.println("public = "+ho.name1);
		System.out.println("private = "+ho.getName2());
		System.out.println("default(friendly) = "+ho.name3);
		
	}

}
