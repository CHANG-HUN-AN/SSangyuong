package day0217;

public class Customer {
	//Filed ��������
	//�̸� ���¹�ȣ(������ �ʴ� ������ ���->String���� �ִ°� ����) �ݾ�
	private String name="ȫ�浿" , accountNo="123-4567",pass="0000" ;
	private int money=0;
	//���������� ��� �ʱ�ȭ�� �˾Ƽ� ����//���������� �ʱ�ȭ �ݵ�� �ʿ�;
	String [] accountinfo = new String[3];
	AccountPaper paper = new AccountPaper();
	//���ٸ�Ŭ������ �������� ��ü���·� �������ִ�(��ġ �ϳ��� ��������ó��)
	//c����� ����ü ����� �����̳��� VO
	
	//Method
	public void setPaper(AccountPaper paper) {
		this.paper = paper;//��ü�� �ּҰ� �Ѿ��
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
	//getter �Ҷ� ������ ��Ƽ� ������
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
		System.out.println("ȣ�� : �̸��� �Է��Ѵ�.");
		return name;
	}
	public void  setAccountNO(String accountNO) {
		this.accountNo = accountNO;
	}
	public String getAccountNO() {
		System.out.println("ȣ�� : ���¹�ȣ�� �Է��Ѵ�.");
		return accountNo;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		System.out.println("ȣ�� : ��й�ȣ�� �Է��Ѵ�.");
		return pass;
	}
	public void setMoney(int money) {
		this.money =money;
	}
	public int getMoney() {
		System.out.println("ȣ�� : �ݾ��� �Է��Ѵ�.");
		return money;
	}
	
	
}//customer
