package Multi_Chat_Object_3_0313.copy;

import java.io.Serializable;

public class MessageVO implements Serializable{
	//Field
	String name,content;
	public static final int CONNECT = 0;
	public static final int TALKING = 1;
	public static final int EXIT = -1;
	
	int status;
	//Constructor
	public MessageVO() { }
	//클라이언트
	public MessageVO(String name , String content) {
		this.name = name;
		this.content = content;
	}
	//서버용
	public MessageVO(String name , String content,int status) {
		this.name = name;
		this.content = content;
		this.status = status;
	}

	//Method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
