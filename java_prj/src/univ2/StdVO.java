package univ2;

public class StdVO {
	// Field
	String stdno, sname, gender, pw, ph, birth, term, mname;
	int majorno;

	// Constructor
	// Method

	public String getStdno() {
		return stdno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setStdno(String stdno) {
		this.stdno = stdno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getMajorno() {
		return majorno;
	}
	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

}