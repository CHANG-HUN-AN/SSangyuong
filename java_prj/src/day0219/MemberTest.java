package day0219;

import java.util.Scanner;

public class MemberTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GuestTest guest = new GuestTest();
		MemberMgmSystem mms = new MemberMgmSystem();
		boolean flag2 = true;
		
		while(flag2) {
		int menu = mms.menuchoice();
		boolean flag =true;
			if(menu==1) {
				while(flag) {
					flag = mms.MbRegister(guest);
				}
			}else if(menu ==2) {
				mms.ShowRegisterList();
			}else if (menu ==3 ) {
				mms.listSearch();
			}
		}
		

	}//main
}//class
