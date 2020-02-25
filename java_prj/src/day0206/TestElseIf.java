package day0206;

/**
 * else-if(다중if):연관된 여러 조건을 비교(메뉴판과 비슷하다)<br>
 * 세세한 비교가 가능하다<br>
 * if(조건식){<br>
 * 조건에 맞음<br>
 * }else if(조건식){<br>
 * 
 * 
 * @author user
 */
public class TestElseIf {

	public static void main(String[] args) {
		//입력받은 점수의 유효성 검증(vaildation):0보다 작거나 100보다 크면 
		//상황에 맞게 실패 메세지를 출력하고 그렇지 않다면 성공과 함께 점수를 출력
		int score = 101;
		System.out.print(score+"점은 ");
		if(score <0) {
			System.out.println("0보다 작을 수 없습니다.");
		}else if(score>100) {
			System.out.println("100보다 클 수 없습니다.");
		}else {
			System.out.println("올바른점수입니다");
		}//end else
		
		
		//태어난해로 띠 구하기
		int birth = 1994;
		int zodiacFlag=birth%12;
		if(zodiacFlag==0) {
			System.out.println("원숭이띠");
		}else if(zodiacFlag==1) {
			System.out.println("닭띠");
		}else if(zodiacFlag==2) {
			System.out.println("개띠");
		}else if(zodiacFlag==3) {
			System.out.println("돼지띠");
		}else if(zodiacFlag==4) {
			System.out.println("쥐띠");
		}else if(zodiacFlag==5) {
			System.out.println("소띠");
		}else if(zodiacFlag==6) {
			System.out.println("호랑이띠");
		}else if(zodiacFlag==7) {
			System.out.println("토끼띠");
		}else if(zodiacFlag==8) {
			System.out.println("용띠");
		}else if(zodiacFlag==9) {
			System.out.println("뱀띠");
		}else if(zodiacFlag==10) {
			System.out.println("말띠");
		}else{
			System.out.println("양띠");
		}//end else
	}

}
