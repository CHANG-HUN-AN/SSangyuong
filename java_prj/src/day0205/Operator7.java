package day0205;
/**
	대입연산자
	=(순수대입연산)
	+=,-=,*=,/=,%= (산술대입)
	<<=, >>= , >>>= (시프트대입)
	&=, |= , ^= (비트논리대입)
*/
public class Operator7 {
	public static void main(String[] args) 	{
	
	System.out.println();
	int  i =3 ;
	//산술대입
	i+=2 ;//i = i+2;
	i-=1;
	i*=2;
	i/=3f;


	//시프트 대입
	i<<=4 ;// i = i<<4, 0000 0100 -> 0100 0000 
	i>>=1 ;//i = i>>1; 
	i>>>=2;

	//비트 논리 대입
	i&=15;//0xF로 해도 가능 // i = i&15; 0000 0100 & 0000 1111 ->0000 0100;
	i|=6;// 0000 0100 | 0000 0110 - >0000 0110
	i^=9; //0000 0110 ^ 0000 1001; - > 0000 1111
	System.out.println(i);
	}//main
}//class
