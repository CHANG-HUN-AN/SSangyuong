package day0207;

/**
 * for문:개발자가 처음과 끝을 알때 사용이 적합 <br>
 * for(초기값;조건식;증·감){<br>
 * 실행문<br>
 * }<br>
 * 
 * @author user
 */
public class TestFor {

	public static void main(String[] args) {
//		for (int i = 1; i < 101; i += 2) {
//			System.out.println(i + "안녕하세요?");
//		} // END FOR
//
//		for (int i = 1; i < 101; i++) {
//			if (i % 2 == 0)
//				System.out.println(i + "안녕하세요?");
//		} // END FOR
//
//		// 1~100까지 아래와 같이 출력
//		// 1 2 짝 ! 4 5 짝! 7 8 짝!10 11 짝!(숫자를쓸것이냐 짝을찍을것이냐)
//		// 둘중하나이기에 if~else구문
//		for (int i = 1; i < 101; i++) {
//			if (i % 3 == 0) {
//				System.out.print("짝! ");
//			} else {
//				System.out.print(i + " ");
//			} // end else
//		} // END FOR
//		System.out.println("");
//		// 1에서 100까지의 누적합을 출력 1+2+3+4....=5050;
//		int sum = 0;
//		for (int i = 1; i < 101; i++) {
//			sum = sum + i;
//		} // END FOR
//		System.out.println(sum);
//		// review: 지역변수 i의 경우 상관없지만 누적갑의 변수명은 신경쓰지 않음
//
//		// 1~9까지 출력해라
//		for (int i = 1; i < 10; i++) {
//			System.out.println("2 * " + i + "= " + i * 2 + " ");
//		} // end for
//
//		// 단을 args 입력받아 구구단을 출력하시오(단,구구단은 2~9단까지)
//		int dan = Integer.parseInt(args[0]);
//		if (dan > 1 && dan < 10) {
//			for (int i = 1; i < 10; i++) {
//				System.out.println(dan + "*" + i + "= " + dan * i + " ");
//			} // end for
//		} else {
//			System.out.println("구구단은 2~9단까지입니다");
//		} // end else
//		
//		//대문자 A~Z 까지 출력하라
//		for(char c = 65; c <91;c++) {
//			System.out.print(c+" ");
//		}//Z91 a98 0 48

		// 0에서 부터 65535 반복시키면서 숫자 0 ~ 9 ,영문자 소문자 전부, 영문자 대문자 전부 출력
		for (char i = 0; i < 65536; i++) {
			if ((i > 47 && i < 58) || (i > 64 && i < 91) || (i > 96 && i < 123)) {
				System.out.print(i + " ");
			} // end for
		} // end for
	}// End main

}// End main
