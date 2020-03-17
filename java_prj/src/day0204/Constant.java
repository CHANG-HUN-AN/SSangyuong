package day0204;
/**
Constant 변수를 상수처럼 쓰고싶다.
Constnatn 는 기준값이다.
*/
public class Constant {
	//Constant 선언
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;

	public static void main(String[] args) {
//상수의 값은 변경할수있다 예를들면 MAX)SCORE)=
		System.out.println("최고점수: " + MAX_SCORE);
		System.out.println("최저점수: " + Constant.MIN_SCORE);

		int myScore= 93;
		System.out.println("최고점수:" + Constant.MAX_SCORE+",최고점수와 획득점수의 차: "+ (Constant.MAX_SCORE - myScore));
		
	}
}
