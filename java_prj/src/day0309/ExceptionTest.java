package day0309;

import java.io.IOException;
import java.net.ServerSocket;

public class ExceptionTest {

	/**
	 * Runtime Exception 발생 과 처리 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] nameList = new String[3];
		nameList[0]="홍길동";
		nameList[1]="홍길동1";
		nameList[2]="홍길동2";
		try {
			ServerSocket server = new ServerSocket(9000);
			for (int i = 0; i < 5; i++) {
				System.out.println(nameList[i]);
			}
		}catch (Exception e) { //->너무길면 최상위 객체인 Exception으로 받을수도 있다.
			// TODO: handle exception
			System.out.println("예외처리 완료~");
		}finally {
			System.out.println("finally");
			//try~catch 뒤 반드시 실행
		}
		

	}

}
