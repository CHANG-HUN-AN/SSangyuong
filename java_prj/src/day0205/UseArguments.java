package day0205;
/**
main method 에 외부 값 입력
*/
public class UseArguments {
	public static void main(String[] args) 	{
	System.out.println(args[0]);
	System.out.println(args[1]);
	System.out.println(args[2]);
	//string 형이라 연산은 되지 않는다
	System.out.println(args[1]+args[2]);
	//int  i = (int) args[1]; //참조형 데이터형(String)은 기본형(int)로 변경 될 수 없다.
	//강제형변환 될수 없다.
	
	//wrapper class 를 사용하면 문자열을 기본형데이터형으로 잘라서 변환할수 있다.
	int i = Integer.parseInt(args[1]);
	int j = Integer.parseInt(args[2]);
	System.out.println(i+j);
	
	double d = Double.parseDouble(args[3]);
	System.out.println(d);

	}//main
}//class
