package day0217;

public class Banker {
	// Field
	private String name = "홍길동", accountNo = "123-4567", pass = "0000";
	private int money = 500;
	String  checkResult = "";
	//accountNo메소드 실행시 입력받은 개인정보는 생존기간이 짧아 전역변수로 장기간  넣어준다.
	String request_name,request_accountNo,request_pass;
	int request_money;
	AccountPaper paper;
	// Constructor
	// Method
	// 계좌정보 체크
	
	public void accountCheck(String name, String accountNo, int money) {
		this.request_name = name;
		this.request_accountNo =accountNo;
		this.request_money = money;
		
		// 값의 유효성 체크
		if (name.equals("")) {
			// System.out.println("이름을 묻는다");
			checkResult = "name";
		} else if (accountNo.equals("")) {
//			System.out.println("계좌번호를 묻는다");
			checkResult = "accountNo";
		} else if (money == 0) {
//			System.out.println("금액을 묻는다");
			checkResult = "money";
		} // if
		System.out.println("직원 : "+checkResult + "부분이 입력되지 않으셨습니다.");
	}// method accountCheck

	//오버로딩 매개변수 값을 달리해서 동일한 메소드명 사용가능;

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
		
		// 값의 유효성 체크
		if ( accountinfo[0].equals("")) {
			// System.out.println("이름을 묻는다");
			checkResult ="name";
		} else if ( accountinfo[1].equals("")) {
//			System.out.println("계좌번호를 묻는다");
			checkResult = "account";
		} else if (Integer.parseInt((accountinfo[2])) == 0) {
//			System.out.println("금액을 묻는다");
			checkResult = "money";
		} // if
		System.out.println("직원 : "+checkResult + "부분이 입력되지 않으셨습니다.");
	}// method accountCheck

	// 계좌정보에대한 추가정보(체크후 빠진정보)
	public void askAccountInfo() {
		if (checkResult.equals("name")) {
			System.out.println("이름을 알려주세요");
		} else if (checkResult.equals("accountNo")) {
			System.out.println("계좌번호을 알려주세요");
		} else if (checkResult.equals("money")) {
			System.out.println("직원 : 금액을 알려주세요");
		}//multi if
	}// method askAccountInfo
	
	public void askMoney(int money) {;
		this.request_money=money;
		
	}
	
	//비밀번호 확인후
	public void askPass(String pass) {
		System.out.println("직원: 비밀번호를 물어본다.");
		this.request_pass = pass;
	}
	//출금진행
	public void success() {
		
		if(name.equals(request_name)&&accountNo.equals(accountNo)
				&&pass.equals(request_pass)) {
			if(money>request_money) {
				this.money = money - request_money;
				System.out.println("직원 : "+request_money+"만원이 출금 완료되었습니다");
			}
		}else {
			System.out.println("정보가 올바르지 않습니다.");
		}
		System.out.println("*** 출금정보 ***");
		System.out.println("출금 후 잔액"+ money);
	}

}// class
