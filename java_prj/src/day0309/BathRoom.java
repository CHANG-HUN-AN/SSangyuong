package day0309;

public class BathRoom {
	String name ;
	
	synchronized public void openDoor(String name ) {
		System.out.println(name+">>>>>����");
		for (int i= 0;  i< 20; ++i) {
			System.out.println(name +"->>>>�՝ɴ���");
		}
		System.out.println(name+">>>>>>>����");
	}
}
