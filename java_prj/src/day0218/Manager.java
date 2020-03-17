package day0218;

import java.util.Scanner;

public class Manager {
	String stdno="202033056",name="홍길동";
	int korea= 60 , english=50 , math =50;
	int sum = korea+english+math;
	int avg = sum/3;
	Scanner scanner = new Scanner(System.in);
	public String[] input() {
		String[] stdif = new String[7];
		
		System.out.print("학번을 입력하세요>>\t");
		stdif[0]=scanner.next();
		System.out.print("이름을 입력하세요>>\t");
		stdif[1]=scanner.next();
		System.out.print("국어성적을 입력하세요>>\t");
		stdif[2]=scanner.next();
		System.out.print("영어성적을 입력하세요>>\t");
		stdif[3]=scanner.next();
		System.out.print("수학성적을 입력하세요>>\t");
		stdif[4]=scanner.next();
		stdif[5]="0";
		stdif[6] = "0";
		return stdif;
	}
	public void setStdno(String stdno) {
		this.stdno = stdno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKorea(int korea) {
		this.korea = korea;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getStdno() {
		return stdno;
	}
	public String getName() {
		return name;
	}
	public int getKorea() {
		return korea;
	}
	public int getEnglish() {
		return korea;
	}
	public int getMath() {
		return korea;
	}
	public int getSum() {
		return korea;
	}
	public int getavg() {
		return korea;
	}
}
