package day0212;

/**
 * 2차원원 배열을 통해 마방진의(3*3)의 대각선 숫자에 랜덤값을넣고
 * 대각선값의 합계 출력
 * @author user
 */
public class MultiArrayTest {

	public static void main(String[] args) {
		//1) 2차원 배열생성
		//2) 데이터 생성
		//3)	대각선 데이터 합 구하기
		int [][] bingo = new int [3][3];
//		int count =0;
		int sum =0;//누적변수 를 count변수라고 한다.
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(i==j) {
					bingo[i][j] = (int) (Math.random() * 10);
					sum += bingo[i][j];
				}//if
				System.out.print("bingo["+i+"]["+j+"] : "+bingo[i][j]+"\t");
			}//inner for
			System.out.println();
//			count++;
		}//outer for \t 6칸정도 
		System.out.println("\t\t\t\t    대각선숫자의 합은 = "+sum);
	}//main

}//class
