package day0310;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 2. io 패키지의 클래스 연습(FileReader,FileWriter)
 * 목적 : ui와 메모장을 연결하여 영구적인 저장공간을 만들수 있다.
 * @author user
 */
public class FileInputTest2 {

	public static void main(String[] args) {
//		1.파일 존재 확인 :c:/dev/test2.txt
//		2.파일존재시 데이터를 test2.txt에 전송후 데이터를 다시 수신하여 내용 을 콘솔에 출력
//		3.파일 미존재시 -파일생성
		Scanner scan = new Scanner(System.in);
		System.out.println("파일명>>");
		String fname = scan.next();
		
		File file = new File("c:/dev/"+fname);
		FileReader fr = null;
		FileWriter fw =null;
		
		try {
			if(file.exists()) {
				System.out.println("파일o");
				//파일데이터 전송
				fw = new FileWriter(file,true); //filewriter 생성자 (file객체 , append) 기존데이터 추가여부
				String str = "Hello~java!!!!";
				fw.write(str,0,str.length());
				fw.flush(); // 파일 전송메소드
				System.out.println("--------------------->파일전송완료!!");
				//파일데이터 수신
				fr = new FileReader(file);
				char[] c = new char[100];
//				fr.read();
				fr.read(c,0,c.length);
				System.out.println("------>"+new String(c));
			}else {
				file.createNewFile(); // 파일부재시 파일 생성
				System.out.println("------------------->\n파일생성완료o");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//try
	}//main
}//class
