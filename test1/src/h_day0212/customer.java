package h_day0212;

import java.util.Scanner;

public class customer {
	Scanner scanner = new Scanner(System.in);
	int money = 0;

	public String[] withdraw() {
		String[] personal_if = new String[3];

		System.out.print("�̸��� �Է��ϼ���.>\t");
		String name = scanner.next();
		System.out.print("���¹�ȣ�� �Է��ϼ���.>\t");
		String account = scanner.next();
		System.out.print("����� ���� �Է����ּ���>\t\n");
		String money = scanner.next();

		for (int i = 0; i < personal_if.length; i++) {
			switch (i) {
			case 0:
				personal_if[i] = name;
				break;
			case 1:
				personal_if[i] = account;
				break;
			case 2:
				personal_if[i] = money;
				break;
			default:
				System.out.println("�����߻�");
			}//switch
		}//fors
		return personal_if;
	}// method withdraw()

	public int money() {
		System.out.println("����� ���� �Է����ּ���>>>\t");
		int money_ct = scanner.nextInt();
		return money_ct;
	}

	public String password() {
		System.out.println("�н����带 �Է��ϼ���>>>\t");
		String password = scanner.next();

		return password;
	}

	public void withdraw_com(int withdrawed_money) {
		this.money = withdrawed_money;
		System.out.println("���� �����ݾ���" + this.money);

	}
}// class
