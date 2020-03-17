package day0217;

public class Customer {
	//Filed 전역변수
	//이름 계좌번호(변하지 않는 숫자의 경우->String으로 주는게 좋다) 금액
	private String name="홍길동" , accountNo="123-4567",pass="0000" ;
	private int money=0;
	//전역변수의 경우 초기화를 알아서 해줌//지역변수는 초기화 반드시 필요;
	String [] accountinfo = new String[3];
	AccountPaper paper = new AccountPaper();
	//└다른클래스에 종속적인 객체형태로 들어갈수도있다(마치 하나의 데이터형처럼)
	//c언어의 구조체 비슷한 느낌이난다 VO
	
	//Method
	public void setPaper(AccountPaper paper) {
		this.paper = paper;//객체의 주소가 넘어간다
	}
	public AccountPaper getPaper() {
		paper.setName(name);
		paper.setAccountno(accountNo);
		paper.setPass(pass);
		paper.setMoney(money);
		return paper;
	}
	//(Setter,getter Method)
	//Setter Method
	public void setAccountinfo(String[] accountinfo) {
		this.accountinfo = accountinfo;
	}
	//getter 할때 정보를 담아서 보내자
	public String[] getAccountinfo() {
		accountinfo[0]=name;
		accountinfo[1]=accountNo;
		accountinfo[2]=String.valueOf(money);
		return accountinfo;
	}
	public void setName(String name) {
		this.name = name;
	}
	//Getter Method
	public  String getName() {
		System.out.println("호갱 : 이름을 입력한다.");
		return name;
	}
	public void  setAccountNO(String accountNO) {
		this.accountNo = accountNO;
	}
	public String getAccountNO() {
		System.out.println("호갱 : 계좌번호을 입력한다.");
		return accountNo;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		System.out.println("호갱 : 비밀번호을 입력한다.");
		return pass;
	}
	public void setMoney(int money) {
		this.money =money;
	}
	public int getMoney() {
		System.out.println("호갱 : 금액을 입력한다.");
		return money;
	}
	
	
}//customer
