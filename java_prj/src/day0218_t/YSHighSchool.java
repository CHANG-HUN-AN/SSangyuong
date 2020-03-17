package day0218_t;

public class YSHighSchool {

	public static void main(String[] args) {
		Staff hong = new Staff();
		ScoreMgmSystem sms = new ScoreMgmSystem();
//		boolean flag = true;
//		while(flag) {;
//			flag =sms.scoreRegister(hong.input(),hong.scanner);
//		}
		sms.scoreRegister(hong);
		sms.showScoreList();
		
	}

}
