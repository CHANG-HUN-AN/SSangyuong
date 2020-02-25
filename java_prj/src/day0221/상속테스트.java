package day0221;

public class 상속테스트 {

	public static void main(String[] args) {
		삼각형 빨강색삼각형 = new 삼각형();
		도형 노랑색삼각형 = new 삼각형();
		사각형 파랑색사각형 = new 사각형();
		원 초록색원 = new 원();
		도형 도형 = new 도형();
		
//		삼각형 초록삼각형 = new 도형(); ->문장구조자체도 성립 x
		System.out.println("-----------------------------");
		도형.draw();
		빨강색삼각형.draw();
		파랑색사각형.draw();
		초록색원.draw();
		System.out.println("-----------------------------");
		삼각형 초록삼각형 = (삼각형)노랑색삼각형;
		노랑색삼각형.getColor();
		System.out.println(노랑색삼각형.color);
		
		
		초록삼각형.getColor();
		System.out.println(초록삼각형.color);
		초록삼각형.draw();
		
		
		빨강색삼각형.color="빨간";
		파랑색사각형.color="파란";
		초록색원.color="초록";

		빨강색삼각형.getColor();
		파랑색사각형.getColor();
		초록색원.getColor();
		
	}
}
