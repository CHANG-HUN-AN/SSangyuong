package day0218;

public class YsSchool {
	
	public static void main(String[] args) {
		Manager hong = new Manager();
		StudentMgmSystem stdms= new StudentMgmSystem();
		
//		stdms.register(hong.stdno, hong.name, hong.korea,hong.english,hong.math,hong.sum,hong.avg);
//		stdms.output();
		stdms.register(hong.input());
		stdms.output();
	}
}
