package day0311;

import java.io.Serializable;

public class UserVO implements Serializable{//shift+alt s Generate Getter /Setter
	String name ,addr;
	public UserVO() { }
	public UserVO(String name,String addr) {
		this.name = name; this.addr = addr;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
