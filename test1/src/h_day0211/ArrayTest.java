package h_day0211;

/**
 * 배열에 대한 연습
 * @author user
 */
public class ArrayTest {
	//Filed
	//Constructor
	
	//Main Mathod
	public static void main(String[] args) {
		int[] numArr = new int[8];
		numArr[0]= 100;
		System.out.println(numArr[0]);
		//데이터입력
		for (int i = 0; i < numArr.length; i++) {
			numArr[i]=i+1;
			System.out.println("numArr["+i+"]= "+numArr[i]);
		}
		
		//데이터 출력
//		for (int i = 0; i < numArr.length; i++) {
//			System.out.println("numArr["+i+"]= "+numArr[i]);
//		}
		
	}//end main
}//end class
