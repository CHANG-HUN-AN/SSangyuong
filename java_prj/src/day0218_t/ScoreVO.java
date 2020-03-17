package day0218_t;

public class ScoreVO {
	//Field
	String stuno,name;
	int kor,eng,math;
	double tot,avg;
	//Method - Getter , Setter;
	
	public void setStuno(String stuno) {
		this.stuno= stuno;
	}
	public void setName(String name) {
		this.name= name;
	}
	public void setKor(int kor) {
		this.kor= kor;
	}
	public void setEng(int eng) {
		this.eng= eng;
	}
	public void setMath(int math) {
		this.math=math; 
	}
	public String getStuno() {
		return stuno;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public double getTot() {
		return tot=kor+eng+math;
	}
	public double getAvg() {
		return avg=tot/3;
	}
	
}
