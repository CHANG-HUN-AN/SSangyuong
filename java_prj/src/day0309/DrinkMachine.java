package day0309;
//���� ��ü
public class DrinkMachine {
	//Field
	String[] drinkList = {"�ݶ�","���̴�","ĵĿ��","��","����"};
	//Constructor
	//Method
	synchronized public void putDrink(String name) {
		System.out.println(name+"=============>�ֱ�");
		for(int i = 0 ; i < drinkList.length ; i++) {
			System.out.println(i+1+" ���� "+drinkList[i]+" �ֱ� ");
		}
		System.out.println("============>�ֱ�Ϸ�");
	}
	synchronized public void getDrink(String name) {
		System.out.println(name+"=============>������");
		for(int i = 0 ; i < drinkList.length ; i++) {
			System.out.println(i+1+" ���� "+drinkList[i]+"���� ");
		}
		System.out.println("============>������");
	}
	
}
