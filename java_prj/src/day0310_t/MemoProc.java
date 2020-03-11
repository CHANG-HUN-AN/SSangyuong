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
	/** ���� üũ **/
	public boolean fileCheck(String fname) {
		boolean result = false;
		f = new File("c:/dev/" + fname);		
		if(f.exists()) result = true;
		
		return result;
	}
	
	/** ���� ���� **/
	public boolean createFile(String fname) {
		boolean result = false;		
		try {
			result = f.createNewFile();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** ���� ���� **/
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
	
	/** ���� �о���� **/
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











