package day0217_t;


/**
 *VO(Value Object) 데이터값만 존재하는 Getter/Setter 를 생성
 * @author user
 */
public class AccountPaper {
	//Field
	public String name,accountno,pass;
	public int money;
	
	//Constructor
	//Method - setter, getter
	public void setName(String name) {
		this.name = name;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	//getter
	public String getName() { return name; }
	public String getAccountno() { return accountno;}
	public String getPass() {return pass; }
	public int getMoney() { return money; }
}




















