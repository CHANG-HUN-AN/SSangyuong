package day0205;
/**
	숙제3. arguments로 입력받아 입력받은 수가 "홀수"인지 "짝수"인지를 출력하세요.
     출력 :   입력 수 : xx 홀수       
*/
public class work3 {
	public static void main(String[] args) 	{
	int i = Integer.parseInt(args[0]);
	System.out.println("입력 수 : " + (i%2 == 0?"짝수":"홀수"));
	}//main
}//class