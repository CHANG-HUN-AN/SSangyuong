package day0220;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		String[] strList = new String[2];
		strList[0] = "ȫ�浿";
		ArrayList<String> strList2 = new ArrayList<String>(2);
		strList2.add("ȫ�浿1");
		strList2.add("ȫ�浿2");
		strList2.add("ȫ�浿3");
		
		System.out.println("strList.length = " + strList.length);
		System.out.println("strList2.size = " + strList2.size());
		
		for(int i=0;i<strList2.size();i++) {
			System.out.println("strList2["+(i+1)+"]=" + strList2.get(i));
		}
		
		int num = 1;
		for(String name : strList2) {			
			System.out.println("name "+num+"= " + name);
			num++;
		}
		
		strList2.remove("ȫ�浿2");
		System.out.println("strList2.size = " + strList2.size());
		int num2 = 1;
		for(String name : strList2) {			
			System.out.println("name "+num2+"= " + name);
			num2++;
		}
	}

}











