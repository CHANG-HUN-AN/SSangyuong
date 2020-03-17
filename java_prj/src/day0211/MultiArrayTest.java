package day0211;

/**
 *2차원 배열
 * @author user
 */
public class MultiArrayTest {

	public static void main(String[] args) {
//		int [][] numList = new int[2][3];
//		numList[0][0]=100;
//		numList[1][1]=200;
//		numList[1][2]=300;
//		
//		for (int i = 0; i < numList.length; i++) {
//			for (int j = 0; j < numList[i].length; j++) {
//				System.out.println("numList["+i+"]["+j+"] = "+numList[i][j]);
//			}
		
		//가변배열
		int [][] numlist = new int [3][];
		numlist[0] = new int[2];
		numlist[1] = new int[3];
		numlist[2] = new int[2];
		
		for (int  i = 0;  i< numlist.length; i++) {
			for (int j = 0; j < numlist[i].length; j++) {
				System.out.println("numlist["+i+"]["+j+"] = "+numlist[i][j]);
			}
		}//m for
		
	}//main

}//class
