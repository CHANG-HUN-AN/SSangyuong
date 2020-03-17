package inheritance0221;

public class Test {

	public static void main(String[] args) {
		사람 홍길동 = new 사람();
		포유류 송중기 = new 사람();
		동물 공유 = new 사람();
		동물 손예진 = new 포유류();
//		사람 jf = new 동물(); 자식데이터형에 부모데이터형을 넣을수없다
		
		홍길동.eat();
		홍길동.name = "hong";
		공유 = (동물)홍길동;
		(포유류)홍길동 = (포유류)손예진;
//		송중기.think();
//		송중기.addr;
		송중기.name = "song";
		
//		공유.addr; 공유.name = "공유";
//		손예진.think(); 손예진.name = "손예진";
		
		공유 =홍길동;
		손예진 = 홍길동;
		홍길동 = (사람)공유;
		송중기 = (포유류)손예진;
		공유 = 손예진;
	}

}
