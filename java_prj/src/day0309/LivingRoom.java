package day0309;

public class LivingRoom {
	
	public  void openDoor(String name) {
		System.out.println(name+"-->입장");
		for (int i = 0; i < 20; i++) {
			System.out.println(name+"--->tv시청");
		}
		System.out.println(name+"-->퇴장");
	}
}
