package h_day0211;

/**
 * 배열의 응용에 대한 연습
 * 인덱스별 국어,영어,수학,총점,평균 출력
 * @author user
 */
public class ScoreArrayTest {

	public static void main(String[] args) {
		int [] score = {90,100,100,100,50};
		String [] subject = {"국어","수학","영어","과학","사회"};
		int sum=0;
		
		for (int i = 0; i < score.length; i++) {
			String sub ="";
//			if(i==0)sub ="국어";
//			else if (i==1) sub ="영어";
//			else if (i==2)sub ="수학";
			System.out.println(subject[i]+":"+score[i]);
//			if(i==0) {
//				System.out.println("국어["+score[i]+"]");
//			}else if(i==1) {
//				System.out.println("영어["+score[i]+"]");
//			}else if(i==2) {
//				System.out.println("수학["+score[i]+"]");
//			}//end else -> 반복되는 문장 syso +socre[i] 
			sum+=score[i];
			if(i==score.length-1) {
				System.out.println("---------------------------------------");
				System.out.println("총점 : " +sum+" 평균 : "+sum/score.length);
			}
		}//end for
		System.out.println("국어["+score[0]+"]"+"영어["+score[1]+"]"+"수학["+score[2]+"]"+
								"수학["+sum+"]"+"수학["+sum/score.length+"]");
	}//end main

}//end class
