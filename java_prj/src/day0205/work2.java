package day0205;
/**
	숙제 2. 나이를 main method의 arguments로 입력받아서 태어난 해를 출력하세요.
     출력 :   입력 나이 xx살  xxxx년생

*/
public class work2 {
	public static final int year = 2020;
	public static void main(String[] args) 	{
	 int myYear=Integer.parseInt(args[0]);
	 
	int	result = year -myYear +1;

	System.out.println("입력 나이 " +result + "살 "+ myYear+"년생");
	}//main
}//class