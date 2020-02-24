package h_day0212;

import java.util.Scanner;

public class Banker {
	public static final String[] DB = { "안창훈", "49010204111111", "1234", "5000000" };
	Scanner scanner = new Scanner(System.in);
	int money = 0;

	public boolean check(String[] personal_if) {
		int money = 0;
		int count = 0;
		boolean flag = true;
		for (int i = 0; i < DB.length; i++) {
			for (int j = 0; j < personal_if.length; j++) {
				if (personal_if[j].equals(DB[i])) {
					j = personal_if.length;
					count++;
				}
			}
		}
		if (count == personal_if.length - 1) {
			System.out.println("확인완료");
		} else {
			System.out.println("정보가 올바르지 않습니다.");
			flag = false;
		}
		return flag;
	}// method check()

	public void money_check(int money) {
		boolean flag = true;
		this.money = money;
		while (flag) {
			if (money > Integer.parseInt(DB[3])) {
				System.out.println("가진금액이 부족합니다");
			} else {
				DB[3] = Integer.toString(Integer.parseInt(DB[3]) - money);
				flag = false;
			}
		} // while
	}

	public int pass_check(String password) {
		boolean flag = true;

		while (flag) {
			if (password.equals(DB[2])) {
				System.out.println("패스워드 확인완료");
				flag =false;
			}else {
				System.out.println("비밀번호가 맞지않습니다.");
			}
		}

		return this.money;
	}

}// class
