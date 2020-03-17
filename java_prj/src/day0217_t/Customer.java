package day0217_t;

public class Customer {
	// Field : 전역변수
	// 이름 계좌번호 등..변하기 쉽지않은것은 String 으로 금액등 연산은 int->VO객체사용이좋음)
	private String name = "홍길동", accountno = "123-4567", pass = "1234";
	private int money = 0;
	// 전역변수의 경우 초기화를 알아서해줌
	// int money; 이런식으로 해도 가능 지역변수안에서는 초기화 필요
	String[] accountinfo =new String[3];
	AccountPaper paper = new AccountPaper();
	// └다른클래스에 종속적인 객체형태로 들어갈수도있다(마치 하나의 데이터형처럼)

	// Constructor
	// Method
	// Setter,Getter Method
	public void setPaper(AccountPaper paper) {
		this.paper = paper;// VO객체의 paper의 주소가 넘어간다
	}

	public AccountPaper getPaper() {
		paper.setName(name);
		paper.setAccountno(accountno);
		paper.setPass(pass);
		paper.setMoney(money);

		return paper;
	}

	public void setAccountinfo(String[] accountinfo) {
	}

	public String[] getAccountinfo() {
		accountinfo[0] = name;
		accountinfo[1] = accountno;
		accountinfo[2] = String.valueOf(money); // "0"
		return accountinfo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		System.out.println("고객 :  이름을 입력한다");
		return name;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getAccountno() {
		System.out.println("고객 :  계좌번호를 입력한다");
		return accountno;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		System.out.println("고객 :  비밀번호를 입력한다");
		return pass;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		System.out.println("고객 :  금액을 입력한다");
		return money;
	}
}
