package day0217_t;


public class GangNamLibrary {

	public static void main(String[] args) {
		BookMgmSystem bms = new BookMgmSystem();
		Staff hong = new Staff();
		boolean flag =true;
		
		while(flag) {
			flag = bms.register(hong.inputObject());
		}
		bms.showListObject();
		
//		bms.register(hong.input());
//		bms.showListArray();
		
		//bms.register(hong.isbn, hong.name, hong.author, hong.price);
		//bms.showList();
		
	}

}
