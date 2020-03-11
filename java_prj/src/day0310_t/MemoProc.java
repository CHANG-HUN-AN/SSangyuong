package day0310_t;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MemoProc {
	//Field
	File f;
	FileOutputStream fos;
	FileInputStream fis;
	
	//Constructor
	//Method
	/** 파일 체크 **/
	public boolean fileCheck(String fname) {
		boolean result = false;
		f = new File("c:/dev/" + fname);		
		if(f.exists()) result = true;
		
		return result;
	}
	
	/** 파일 생성 **/
	public boolean createFile(String fname) {
		boolean result = false;		
		try {
			result = f.createNewFile();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 파일 저장 **/
	public boolean saveFile(String fname, String content, 
								boolean appendOK) {
		boolean result = false;
		try {
			fos = new FileOutputStream("c:/dev/"+fname, appendOK );
			fos.write(content.getBytes());
			fos.flush();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	/** 파일 읽어오기 **/
	public String readFile(String fname) {
		String data = "";
		byte[] b = new byte[1000];
		try {
			fis = new FileInputStream("c:/dev/"+fname);
			fis.read(b);
			data = new String(b);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return data;
	}

	
}//class











