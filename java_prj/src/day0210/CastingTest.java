package day0210;

public class CastingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 =10;
		int i1 = b1; //4byte 짜리 형변환됨(byte->int)자동형변환
		
		int i2 = 987654;
		byte b2 = (byte)i2; //강제 형변환시 데이터가 유실될수도 있음
		
		System.out.println(b1);
		System.out.println(i1);
		
		System.out.println(b2);//데이터가 유실됨
		System.out.println(i2);
	}//end main

}//end class
