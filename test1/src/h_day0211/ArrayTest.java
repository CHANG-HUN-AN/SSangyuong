package h_day0211;

/**
 * �迭�� ���� ����
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
		//�������Է�
		for (int i = 0; i < numArr.length; i++) {
			numArr[i]=i+1;
			System.out.println("numArr["+i+"]= "+numArr[i]);
		}
		
		//������ ���
//		for (int i = 0; i < numArr.length; i++) {
//			System.out.println("numArr["+i+"]= "+numArr[i]);
//		}
		
	}//end main
}//end class
