package day0310;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 3.testUI�� �������۹� ���� �� �ô� class
 * @author user
 */
public class testUIProc {
	File file ;
	FileInputStream fis;
	FileOutputStream fos;
	//���� �����ϴ��� Check����
	public boolean fileCheck(String fname) {
		file = new File("c:/dev/"+fname);
		boolean flag = false;
		
		if(file.exists()) { flag = true; }
		
		return flag;
	}
	
	public boolean fileCreate(String fname) {
		boolean resultCreate=true;
		file = new File("c:/dev/"+fname);
		try {
			resultCreate = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultCreate;
	}
	
	public boolean fileSave(String fname, String content, boolean appendOK) {
		boolean result =false;
		try {
			fos = new FileOutputStream("c:/dev/"+fname,appendOK);
			fos.write(content.getBytes()) ;
			fos.flush();
			result= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String fileRead(String fname) {
		String data = "";
		try {
			fis = new FileInputStream("c:/dev/"+fname);
			byte[] bytedata = new byte[500];
			if(fis.read(bytedata) != -1) {
				data = new String(bytedata);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//try
		return data;
	}

	

}
