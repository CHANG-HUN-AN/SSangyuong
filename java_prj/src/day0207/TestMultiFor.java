package day0207;

/**
 * 다중 for 에 대한 설명
 * 
 * @author user
 */
public class TestMultiFor {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(i + " " + j);
			} // mfor\
			System.out.println("---------------------------");
		} // for

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "= " + i * j);
			} // end for
			System.out.println("---------------------------");
		} // end for

//		00
//		1011
//		202122
//		30313233 을 출력하라
//		다중 for 문 사용
//		hint ) print 와 print ln 을 적절히 써야한다.

		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print((i-1)+""+j);
			}//end mfor
			System.out.println();
		}//end for
		System.out.println("------------------------------");
		
		for(int i =0; i<6; i++) {
			for(int j = i+1; j<6;j++) {
				System.out.print(i+""+j);
			}
			System.out.println();
		}
		
		//무한루프~(채팅서버,웹서버)시 사용
		for(;;) {
			System.out.println("이이이이이이잉이");
			break;
		}//end for
		System.out.println("무한루프~");
		
		//수를 증가시킬수 있는 무한루프
//		for(int i =1 ; ; i++) {
//			System.out.println("무한루프~");
//		}//end for
		
		//continue : 반복문의 실행을 건너 뛸때
		//0~100까지 짝수만 실행(continue이용)
		for(int i = 0; i <100; i++) {
			if(i%2==1) {
				continue;
			}//end if
			System.out.println(i);
		}//end for
	}// end main
}// end class
