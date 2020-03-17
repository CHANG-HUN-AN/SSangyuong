package day0310;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 3.testUI의 파일전송및 관리 를 맡는 class
 * @author user
 */
public class testUIProc {
	File file ;
	FileInputStream fis;
	FileOutputStream fos;
	//파일 존재하는지 Check여부
	public boolean fileCheck(String fname) {
		file = new File("c:/dev/"+fname);
		boolean flag = false;
		
		if(file.exists()) { flag = true; }
		
		return flag;
	}
	
	public boolean fileCreate(String fname) {
		boolean resultCreate= false;
		file = new File("c:/dev/"+fname);
		try {
			resultCreate = file.createNewFile(); //이 이름의 파일이 아직 존재하지 않는 경우에만 이 추상 경로 이름에 의해 이름이 지정된 새 빈 파일을 생성한다
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
			fos.flush(); //강제적으로 버퍼에 저장된 내용을 스트림을통해 보내는것
			result= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String fileRead(String fname) {
		String data = "";
		
		try {
			fis = new FileInputStream("c:/dev/"+fname); //입력스트림으로 File 객체의 통로를 열어준다
			byte[] bytedata = new byte[500];
			while(fis.read(bytedata) != -1) { //해당 입력 스트림으로부터 특정 바이트를 읽어들인 후, 배열 b에 저장함.(현재bytedata에 저장)
				data = new String(bytedata);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//try
		
		return data;
	}

	

}
