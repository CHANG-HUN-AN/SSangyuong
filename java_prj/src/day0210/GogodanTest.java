package day0210;

/**
 *구구단 가로로 출력을 배워본다
 * @author user
 */
public class GogodanTest {

	public static void main(String[] args) {
			
		for(int i =1; i<10;i++) {
			for(int j =2 ; j<10;j++) {
				System.out.print(j+" * " + i + " = "+i*j+ "\t");
			}//end inner for
			System.out.println("");
		}//end outer for
	}//end main
}//end class
