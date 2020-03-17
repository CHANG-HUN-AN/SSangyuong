package day0205;
/**
	논리연산자
	일반논리:여러개의 관계연산자를 묶어서 비교할 때
	 &&, ||
	비트논리: 비트를 연산할때
	 &&, || ,^
	 
*/
public class Operator5 {
	public static void main(String[] args) 	{
		//일반논리
		//&&;전항과 후항이 모두 t >>t 
		
//		System.out.println(5>2 && 10 < 100);
		boolean flag1 = true , flag2 = false , flag3 = true, flag4 = false;
		System.out.println("--------------&&--------------------");
		System.out.println(flag1 + " && " +flag3+"= " + (flag1 && flag3));
		System.out.println(flag1 + " && " +flag2+"= " + (flag1 && flag2));
		//전항이 거짓이면 뒤에는 연산하지 않는다
		System.out.println(flag2 + " && " +flag3+"= " + (flag2 && flag3));
		System.out.println(flag2 + " && " +flag4+"= " + (flag2 && flag4));

		System.out.println("--------------||--------------------");
		//전항이 true 이면 계산하지않고 true
		System.out.println(flag1 + " || " +flag3+"= " + (flag1 || flag3));
		System.out.println(flag1 + " ||	" +flag2+"= " + (flag1 || flag2));
		System.out.println(flag2 + " || " +flag3+"= " + (flag2 || flag3));
		System.out.println(flag2 + " || " +flag4+"= " + (flag2 || flag4));

		boolean temp1 = false, temp2 = false, result = false;
		//전항이 false 이면 후항연산을 하지 않는다.
		result= (temp1=3<2) && ( temp2 = 3>2);
		System.out.println(temp1 + ", " + temp2 +", "+result);

		//비트논리
		//&(and): 상위비트와 하위비트 모두 1인경우 1을내려준다
		//|(or)
		//^(xor)

		int i= 19, j =25 ;
		System.out.println(i+" & " +j +" = "+ (i&j));
		System.out.println(i+" | " +j +" = "+ (i|j));
		System.out.println(i+" ^ " +j +" = "+ (i^j));
	}//main

	
}//class

