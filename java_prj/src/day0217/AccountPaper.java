package day0217;

/**
 *VO(value of) 데이터값만 존재하는 Getter/Setter 생성
 * @author user
 */
public class AccountPaper {
	//Filed
	public String name,accountno,pass;
	public int money;
	//Constructor
	//Method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}//class


