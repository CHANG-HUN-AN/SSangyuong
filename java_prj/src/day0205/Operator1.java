package day0205;
/**
	단항연산자
	~, ! , +, - ,++, --
*/

public class Operator1 {
	public static void main(String[] args) 	{
		System.out.println("Hello World!");
		//~(tilde)
		int i = 10;
		int j = -10;
		System.out.println("i의 연산: ~"+i+"=" + ~i);// -11
		System.out.println("j의 연산: ~"+j+"=" + ~j);//-9

		//! (not)->*boolean 앞에만 쓸수있다는걸 꼭 기억하자!! 상수 앞에 사용 불가
		boolean b = true, c = false;
		System.out.println("b의 연산: !"+b+"=" + !b);
		System.out.println("c의 연산: 1"+c+"=" + !c);
		System.out.println(!(3>2));

		//+:형식적인 제공(값의 변화가 없다)
		System.out.println("i의 연산: "+i+"=" + +i);
		System.out.println("j의 연산: "+j+"=" + +j);
		
		//-:2의보수 연산,부호바꿈연산(값은 그대로이며 부호만 바뀌는 Operator)
		System.out.println("i의 연산: "+i+"=" + -i);
		System.out.println("j의 연산: "+j+"=" + -j);

		//++ : 증가 연산자 (대상체의 값을 1씩 증가한다)
		//-- : 감소 연산자 (대상체의 값을 1씩 감소한다)
		i = 0;
		j = 10;

		//전위 : 연산자는 대상체 앞에 온다
		++i;
		--j;
		System.out.println("전위 i의 연산: " + i);
		System.out.println("전위 j의 연산: " + j);

		//후위 : 연산자는 대상체 뒤에 온다.
		i++;
		j--;
		System.out.println("후위 i의 연산: " + i);
		System.out.println("후위 j의 연산: " + j);
		
		//증감연산자는 단독으로 쓰일때는 문제x , 대입연산자와 같이 사용되면 전,후위의 다른값을 대입한다
		//전위: (상수기준)내것먼저 (즉, 연산수행후 대입)
		int result = ++i;
		System.out.println("전위 i의 연산: " + i +", 대입받은 result의 값: "+result);
		//후위: 남의것 먼저(즉, 대입후 연산을 수행)
		result = 0;
		result = i++;
		System.out.println("후위 i의 연산: " + i +", 대입받은 result의 값: "+result);
		int  k = ++10; //상수는 대입 증감x

	}//main
}//class
