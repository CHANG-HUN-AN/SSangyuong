package day0311;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 1. inputStream �� ������ ���������� DataInputStream (���嵵��)
 * @author user
 */
public class DataInputStreamTest {

	public static void main(String[] args) {
		try {
			File f = new File("c:/dev/test.txt");
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis); 
			String result = "";
			while((dis.readUTF())!=null) {
				System.out.println(result);
			}
			dis.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}//class
