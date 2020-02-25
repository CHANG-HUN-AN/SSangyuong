package day0218;

public class StudentMgmSystem {
	// Field
	String stdno, name;
	int korea, english, math, sum, avg;
	int temp;
	// Constructor
	// Method
	String[] stdif ;
	public void register(String stdno, String name, int korea, int english, int math, int sum, int avg) {
		this.stdno = stdno;
		this.name = name;
		this.korea = korea;
		this.english = english;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
	}
	public void register(String[] stdif) {
		
		temp=Integer.parseInt(stdif[3])+Integer.parseInt(stdif[4])+Integer.parseInt(stdif[5]);
		stdif[5]=String.valueOf(temp);
		stdif[6]=String.valueOf(temp/3);
		this.stdif = stdif;
	}
//	public void output() {
//		System.out.println("========================================================");
//		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t");
//		System.out.println(stdno+"\t"+name+"\t"+korea+"\t"+english+"\t"+math+"\t"+sum+"\t"+avg+"\t");
//		System.out.println("========================================================");
//	}
	public void output() {
		System.out.println("========================================================");
		System.out.println("학번\t\t이름\t국어\t영어\t수학\t총점\t평균\t");
		System.out.println(stdif[0]+"\t"+stdif[1]+"\t"+stdif[2]+"\t"+stdif[3]+"\t"+stdif[4]+"\t"+stdif[5]+"\t"+stdif[6]+"\t");
		System.out.println("========================================================");
	}

}
