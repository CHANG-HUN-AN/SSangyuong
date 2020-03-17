package day0309;

public class FamilyThreadTest {

	public static void main(String[] args) {
		LivingRoom livingRoom = new LivingRoom();
		BathRoom bathRoom = new BathRoom();
		FamilyThread father = new FamilyThread("father",bathRoom);
		FamilyThread mother = new FamilyThread("mohter",bathRoom);
		FamilyThread sister = new FamilyThread("sister",bathRoom);
		FamilyThread brother = new FamilyThread("brother",bathRoom);
		
		father.start();
		mother.start();
		sister.start();
		brother.start();
	}

}
