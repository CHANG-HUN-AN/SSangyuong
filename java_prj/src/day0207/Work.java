package day0207;

/**
 * 0207�� ����
 * �������� ��������� ����
 * 2 *1 =2 3*1=3 ......9*1=81
 * ...... 
 * @author user
 */
public class Work {
	public static void main(String[] args) {
		for(int i = 1 ; i<10;i++) {
			for(int j = 2;j<10;j++ ) {
				System.out.print(j+" * "+i+" = "+j*i+"   ");
			}//end for
			System.out.println();
		}//end for
	}//end main
}//end class
