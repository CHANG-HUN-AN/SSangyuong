package day0217;

public class GangNamLibrary {

	public static void main(String[] args) {
		BookMgmSystem bms = new BookMgmSystem();
		Staff hong = new Staff();
		
//		bms.register(hong.isbn, hong.name, hong.author, hong.price);
		//�Ű����� ����(2~3�� ����)�� �������� VO��üor �迭�� �Ұ��� ���
//		bms.showList();
//		�迭�μ� ���Ѱܹޱ�
//		bms.register(hong.input());
//		bms.showListArray();
		
		//VO��ü�� ���� �� �Ѱܹޱ�
		bms.register(hong.inputObject());
		bms.showListVO();
	}

}
