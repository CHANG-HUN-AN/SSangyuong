package day0217;

public class Banker {
	// Field
	private String name = "ȫ�浿", accountNo = "123-4567", pass = "0000";
	private int money = 500;
	String  checkResult = "";
	//accountNo�޼ҵ� ����� �Է¹��� ���������� �����Ⱓ�� ª�� ���������� ��Ⱓ  �־��ش�.
	String request_name,request_accountNo,request_pass;
	int request_money;
	AccountPaper paper;
	// Constructor
	// Method
	// �������� üũ
	
	public void accountCheck(String name, String accountNo, int money) {
		this.request_name = name;
		this.request_accountNo =accountNo;
		this.request_money = money;
		
		// ���� ��ȿ�� üũ
		if (name.equals("")) {
			// System.out.println("�̸��� ���´�");
			checkResult = "name";
		} else if (accountNo.equals("")) {
//			System.out.println("���¹�ȣ�� ���´�");
			checkResult = "accountNo";
		} else if (money == 0) {
//			System.out.println("�ݾ��� ���´�");
			checkResult = "money";
		} // if
		System.out.println("���� : "+checkResult + "�κ��� �Էµ��� �����̽��ϴ�.");
	}// method accountCheck

	//�����ε� �Ű����� ���� �޸��ؼ� ������ �޼ҵ�� ��밡��;

	public void accountCheck(AccountPaper paper) {
		if(paper.getName().equals("")) {
			checkResult ="name";
		}else if (paper.getAccountno().equals("")) {
			checkResult = "accountno";
		}else if (paper.getMoney() == 0) {
			checkResult = "money";
		}
		this.paper=paper;
	}//method overload accountcheck(AccountPaper)
	
	public void accountCheck(String [] accountinfo) {
		this.request_name = accountinfo[0];
		this.request_accountNo =accountinfo[1];
		this.request_money =Integer.parseInt((accountinfo[2]));
		
		// ���� ��ȿ�� üũ
		if ( accountinfo[0].equals("")) {
			// System.out.println("�̸��� ���´�");
			checkResult ="name";
		} else if ( accountinfo[1].equals("")) {
//			System.out.println("���¹�ȣ�� ���´�");
			checkResult = "account";
		} else if (Integer.parseInt((accountinfo[2])) == 0) {
//			System.out.println("�ݾ��� ���´�");
			checkResult = "money";
		} // if
		System.out.println("���� : "+checkResult + "�κ��� �Էµ��� �����̽��ϴ�.");
	}// method accountCheck

	// �������������� �߰�����(üũ�� ��������)
	public void askAccountInfo() {
		if (checkResult.equals("name")) {
			System.out.println("�̸��� �˷��ּ���");
		} else if (checkResult.equals("accountNo")) {
			System.out.println("���¹�ȣ�� �˷��ּ���");
		} else if (checkResult.equals("money")) {
			System.out.println("���� : �ݾ��� �˷��ּ���");
		}//multi if
	}// method askAccountInfo
	
	public void askMoney(int money) {;
		this.request_money=money;
		
	}
	
	//��й�ȣ Ȯ����
	public void askPass(String pass) {
		System.out.println("����: ��й�ȣ�� �����.");
		this.request_pass = pass;
	}
	//�������
	public void success() {
		
		if(name.equals(request_name)&&accountNo.equals(accountNo)
				&&pass.equals(request_pass)) {
			if(money>request_money) {
				this.money = money - request_money;
				System.out.println("���� : "+request_money+"������ ��� �Ϸ�Ǿ����ϴ�");
			}
		}else {
			System.out.println("������ �ùٸ��� �ʽ��ϴ�.");
		}
		System.out.println("*** ������� ***");
		System.out.println("��� �� �ܾ�"+ money);
	}

}// class
