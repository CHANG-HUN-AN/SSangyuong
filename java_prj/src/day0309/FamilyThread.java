package day0309;

public class FamilyThread extends Thread{
	//Field
	LivingRoom livingRoom ;
	BathRoom bathRoom;
	String name;
	
	//Constructor
	public FamilyThread() { }
	public FamilyThread(String name ,LivingRoom livingRoom) { 
		this.livingRoom = livingRoom;
		this.name = name;
	}
	public FamilyThread(String name ,BathRoom bathRoom) { 
		this.bathRoom = bathRoom;
		this.name = name;
	}
	//Method
	
	public void run() { 
		bathRoom.openDoor(name);
	}
}
