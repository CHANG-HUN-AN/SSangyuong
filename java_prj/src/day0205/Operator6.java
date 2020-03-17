package day0205;
/**
	삼항(조건) 연산자
	조건식?항1[true] :항2[false]

*/
public class Operator6 {
	public static void main(String[] args) 	{
	//삼항연산자
	int i = -10;
	
	System.out.println(i+" 는(은)" + (i>=0?"양슈에요":"음수에요"));

	int year = 2020;
	int brith = 1994;

	int result = (year-brith+1);
	System.out.println("귀하 는(은)" + (result >= 20?"성인":"미성년") + result);
	}//main
}//class
