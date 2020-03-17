package day0204;
public class work3 {
	public static final int  TODAYMONEY = 10000; ;
	public static void main(String[] args) {
		int onetam = 1250;
		int tam = onetam *2;
		int launch =6000;
		int result = TODAYMONEY -(tam+launch);
		System.out.println("하루 용돈: "+ TODAYMONEY+"원,"+
							"편도차비: "+ onetam+"원,"+
							"왕복차비: "+ tam+"원,"+
							"점심값: "+ launch+"원,"+
							"남은금액: " + result+"원");				 
	}
}
