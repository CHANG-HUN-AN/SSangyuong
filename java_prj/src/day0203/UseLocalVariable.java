package day0203;


public class UseLocalVariable{	
	//java application

	public static void main(String[] args){
		//1.지역변수의 선언 -데이터형,변수형
		int i;
		int j;
		
		//2.만들어진 변수의 값 할당: 변수명=값;
		i=48;
		i=4;
		j=10;
		
		//3.값 사용(출력,연산,재할당)
		System.out.println(i);
		System.out.print(j); //초기화 하지 않는 지역변수 사용시 에러발생 (현재 메인메소드안의 공간은 지역변수에 해당된다)
		
		//변수명은 한글도 가능
		
		int 변수;
		변수=2020;
		System.out.print(변수);
		
		//변수명은 숫자로 시작할 수 없다.
		//int 1k; //시 오류발생
	}//main method
}