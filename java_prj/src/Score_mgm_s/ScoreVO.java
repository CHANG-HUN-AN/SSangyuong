package Score_mgm_s;

import java.io.Serializable;

public class ScoreVO implements Serializable{
	String stuno, name;
	int kor, eng, math, tot, avg;
	
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return kor+eng+math;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getAvg() {
		return getTot()/3;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}

}
