package day0309;

import java.util.StringTokenizer;

/**
 *  Runtime Exception 발생 과 처리 2 ->NullPointerException 의경우
 *  원칙: try~catch 문으로 잡을수 없다
 *  예외: try~catch로도 잡을수 있는 경우가 있기는 하지만 의미가 없다.
 * @author user
 */
public class ExceptionTest2 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("자바 수업 입니다."); //[컴퓨터 공학] 낱말 분석 이라는 뜻을 가지고 있다
		int tokens = st.countTokens();
		System.out.println(tokens);
		System.out.println("예외처리 완료");
	}

}
