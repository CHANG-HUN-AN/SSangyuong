package day0217_t;

public class Customer {
	// Field : ��������
	// �̸� ���¹�ȣ ��..���ϱ� ������������ String ���� �ݾ׵� ������ int->VO��ü���������)
	private String name = "ȫ�浿", accountno = "123-4567", pass = "1234";
	private int money = 0;
	// ���������� ��� �ʱ�ȭ�� �˾Ƽ�����
	// int money; �̷������� �ص� ���� ���������ȿ����� �ʱ�ȭ �ʿ�
	String[] accountinfo =new String[3];
	AccountPaper paper = new AccountPaper();
	// ���ٸ�Ŭ������ �������� ��ü���·� �������ִ�(��ġ �ϳ��� ��������ó��)

	// Constructor
	// Method
	// Setter,Getter Method
	public void setPaper(AccountPaper paper) {
		this.paper = paper;// VO��ü�� paper�� �ּҰ� �Ѿ��
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
		System.out.println("�� :  �̸��� �Է��Ѵ�");
		return name;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getAccountno() {
		System.out.println("�� :  ���¹�ȣ�� �Է��Ѵ�");
		return accountno;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		System.out.println("�� :  ��й�ȣ�� �Է��Ѵ�");
		return pass;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		System.out.println("�� :  �ݾ��� �Է��Ѵ�");
		return money;
	}
}
