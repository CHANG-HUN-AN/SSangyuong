package day0207;

/**
 * switch case 를 사용하여 학점구하기<br>
 * @author user
 */
public class TestSwitchCase2 {
	//case문에 상수를 쓰는것보다 constant 를 써서 가독성을 향상시킬수 있다.
	public static final int GRADE_A_PLUS=10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;
	public static void main(String[] args) {
		int score = 100;
		char grade = 'F';
		if(score>-1 && score<101) {
			switch(score/10) {
			case GRADE_A_PLUS: 
			case GRADE_A: grade ='A';break;
			case GRADE_B: grade ='B';break;
			case GRADE_C: grade ='C';break;
			case GRADE_D: grade ='D';
			}//end switch
			System.out.println(score+" 점의 학점은 "+grade+" 이네 축하해");
		}//end if
		//위에는 break를 많이써서 아래거는 break를 조금써서(break가 있는게 좋은코드 why? 적게 실행하여 결과값을 내주기때문)
		//break 를 많이쓴다고 항상 좋은 코드는 아니다 상황에 따라 적적하게 써줘야 좋은코드
		System.out.println("----------------------------------------");
		grade = 'A';//유니코드 64기본으로 
		score = 96;
		switch(score/10) {
		case GRADE_D: grade++;
		case GRADE_C: grade++;
		case GRADE_B: grade++;
		case GRADE_A: 
		case GRADE_A_PLUS:grade++;break;
		default: grade+= 6;
		}//end switch
		System.out.println("점수"+score+"학점은"+grade);
		
		System.out.println("----------------------------------------");
		
	}//end main
}//end class
