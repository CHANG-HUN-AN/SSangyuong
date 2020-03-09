package day0309;
//공유 객체
public class DrinkMachine {
	//Field
	String[] drinkList = {"콜라","사이다","캔커피","물","우유"};
	//Constructor
	//Method
	synchronized public void putDrink(String name) {
		System.out.println(name+"=============>넣기");
		for(int i = 0 ; i < drinkList.length ; i++) {
			System.out.println(i+1+" 번쨰 "+drinkList[i]+" 넣기 ");
		}
		System.out.println("============>넣기완료");
	}
	synchronized public void getDrink(String name) {
		System.out.println(name+"=============>꺼내기");
		for(int i = 0 ; i < drinkList.length ; i++) {
			System.out.println(i+1+" 번쨰 "+drinkList[i]+"꺼냄 ");
		}
		System.out.println("============>꺼내기");
	}
	
}
