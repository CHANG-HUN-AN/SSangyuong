package day0206;

/**
 * if~else 사용: 둘중 하나의 코드를 반드시 사용해야 할때<br>
 * 문법)if (조건식){<br>
 * 조건에 맞을때 수행할 문장<br>
 * }else{<br>
 * 조건에 맞지않을때 수행할 문장<br>
 * }<br>
 * 
 * @author user
 */
public class TestIfElse {

	public static void main(String[] args) {
		// 입력된 수가 홀수인지 짝수인지 출력하는method
		int i = Integer.parseInt(args[0]);
		System.out.print(i + "은(는) ");

		if (i % 2 == 0) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		} // end else

		/*
		 * //입력받은 수가 0~100사이라면 "유효점수" 를 출력하고 
		 * //점수가 "과락" 인지를 판단하여 과락을 출력한다.
		 * //그렇지않으면"무효 점수"를 출력한다
		 */
		
		System.out.print("입력받은 수 " + i + "는(은) ");
		if (i >-1 && i < 101) { //크거나 같다는 한번에 2번씩 계산 ->총 5번연산 //바꾼것으로하면 3번연산으로끝(좋은코딩)
			System.out.println(" 유효점수");
			if (i < 40) {
				System.out.println("이지만 과락");
			} // end if
		} else {
			System.out.println("무효점수");
		} // end else
		
		/*
		 * 두번째 입력값은 고객 등급입니다. 세번째 입력값은 상품가격입니다. 
		 * 고객등급은 "일반","특별"인경우에만 "일반"은 상품가격 10%할인
		 * "특별"은 상품가격의 30%할인 하여, 아래와같이 출력 
		 * 고객등급 "일반|특별" 상품가격: XXX원 할인가격 XX원 입니다.
		 * 고객등급이 일반과 특별이 아니라면 "잘못입력하셨습니다."를 출력합니다
		 */
		int price = Integer.parseInt(args[2]);
		
		if(args[1].equals("일반")||args[1].equals("특별")) {
			int discount = (int)(price*0.9);
			if(args[1].equals("특별")) {
				 discount = (int)(price*0.7);
			}//end if
				System.out.println("고객등급 \""+args[1]+"\" 상품가격 :"+price+",할인가격 :"+discount+"원 입니다.");
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}//end else
	}// main

}// class
