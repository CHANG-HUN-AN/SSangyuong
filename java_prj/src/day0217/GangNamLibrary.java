package day0217;

public class GangNamLibrary {

	public static void main(String[] args) {
		BookMgmSystem bms = new BookMgmSystem();
		Staff hong = new Staff();
		
//		bms.register(hong.isbn, hong.name, hong.author, hong.price);
		//매개변수 갯수(2~3개 적당)가 많아지면 VO객체or 배열로 할건지 고민
//		bms.showList();
//		배열로서 값넘겨받기
//		bms.register(hong.input());
//		bms.showListArray();
		
		//VO객체를 통해 값 넘겨받기
		bms.register(hong.inputObject());
		bms.showListVO();
	}

}
