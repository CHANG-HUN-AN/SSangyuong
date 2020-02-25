package day0218;

public class ConstructorObject {
	//Feild - 전역변수
	String name,address;
	int kor,eng,math;
	//Constructor - 생성자
	//생성자 형식: public 생성자명[=클래스명](){기능~} return타입이 없다
	//필드값을 초기화할때 많이 이용한다.
	/*
	 *생성자란?
	 *1.객체 생성시 호출되는 메소드 //Change ch= new Change();-> Change(); 기본생성자를 호출하는것
	 *2.생성자를 한개라도 정의 하지 않는 경우 JVM이 Complie 시 기본생성자를 생성(//bytecode 만들기전 저장하면생성되는것)
	 * 3.다양한 파라미터 값으로 생성자 오버로딩이 가능하다
	 * 4.return타입이 존재하지 않다.
	 * 5.this()를 이용하여 생성자 호출이 가능하다.
	 */
	public ConstructorObject() {
		this("홍길동","서울",50,50,50);
		System.out.println("기본생성자 호출");
//		this.name = "홍길동";
//		this.address = "서울";
//		this.kor = 50; this.eng = 50; this.math = 50;
		
	}
	public ConstructorObject(String name,String address) {
		this(name,address,0,0,0);
		System.out.println("기본생성자 호출");
		this.name = name;
		this.address = address;
	}
	public ConstructorObject(String name,String address,int kor , int eng ,int math) {
		System.out.println("기본생성자 호출");
		this.name = name;
		this.address = address;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//Method -메소드
	public void test() {
		System.out.println("이름 : "+name);
		System.out.println("주소 : "+address);
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+math);
	}
}
