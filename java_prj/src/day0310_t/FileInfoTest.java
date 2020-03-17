package day0310_t;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileInfoTest {

	public static void main(String[] args) {
		File f = new File("c:/dev/test.txt");
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		try {
			if(f.exists()) {
				System.out.println("파일 있음");	
				//파일에 데이터 전송
				fos = new FileOutputStream(f, true);	
				fos.write(new String("Hello~JAVA!!!").getBytes());
				fos.flush();
				System.out.println("파일 전송 완료~");
				
				//파일의 데이터 가져오기
				fis = new FileInputStream(f);
				byte[] b = new byte[1];
				//int d = fis.read();
				System.out.println("-------- 파일 수신 데이터 -------");
				while(fis.read(b) != -1) {
					System.out.println(new String(b));
				}	
				System.out.println("-------- 파일 수신 완료 -------");
				

			}else {
				System.out.println("파일 없음");			
					if(f.createNewFile()) {
						System.out.println("파일 생성 완료!");
					}else {
						System.out.println("파일 생성 실패!!");
					}			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//main

}//class











