package day0310;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 1. FileInput 클래스 실습
 * @author user
 */
public class FileInputTest {

	public static void main(String[] args) {
		File file = new File("c:/dev/test.txt"); // java의 버전이 낮은경우 / ->\\ 로 해결
		FileInputStream fis =null;
		FileOutputStream fos =null;
		try {
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			if (file.exists()) {
				System.out.println("파일 o");
				//파일의 데이터 가져오기
				fis = new FileInputStream(file);
				// ★int 타입으로 반환한다고 해도 데이터를 반환해주는것이 아니고 데이터의 끝(존재여부)을 알려주는것
				// int data = fis.read() ; 를 통해 데이터를 읽어서 저장하는 것이아니다.!!!!!!!
				byte[] data = new byte[500];
				System.out.println("--------파일 수신 데이터0000000000");
				while(fis.read(data) != -1) { //데이터가 존재하지 않음을 알려준다 (-1)
					System.out.println(new String(data));
				}
				System.out.println("-------파일 수신 완료!!!!!!!!!!!!!!!!!!!!!!!");
				//존재하는 파일에  데이터를 전송
				fos = new FileOutputStream(file,true);
				fos.write(new String("Hello~JAVA!!!").getBytes());
				fos.flush();
				System.out.println("파일 전송 완료~~");
			} else {
				System.out.println("파일 x");

				if (file.createNewFile()) { // io에 많은 exception이 발생한다. try catch로 해결
					System.out.println("파일 생성 완료!");
				} else {
					System.out.println("파일 생성 실패!");
				}
			} // else ~if
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
