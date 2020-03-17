package day0310_t;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileInfoTest2 {

	//FileReader, FileWriter 객체  
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("파일명>");
		String fname = scan.next();
		
		File f = new File("c:/dev/"+fname);
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			if(f.exists()) {
				String str = "Hello~~JAVA!!";
				fw = new FileWriter(f, true);
				fw.write(str,0,str.length());
				fw.flush();
				System.out.println("----------->> 데이터 전송 완료");
				
				fr = new FileReader(f);
				char[] c = new char[100];
				//fr.read();
				fr.read(c,0,c.length);
				System.out.println("수신--->>"+  new String(c));				
				
			}else {
				f.createNewFile();
				System.out.println("------------->> 파일생성 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}//main

}//class










