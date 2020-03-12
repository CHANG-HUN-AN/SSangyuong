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
			File f = new File("c:/dev/sample.dat");
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis); 
			
			String data = dis.readUTF(); //writeUTF�� ���� ����� ���ĸ� ����!!!
			int d1 = dis.readInt(); //writeInt������ ����� ���ĸ� �о�´�
			long d2 = dis.readLong();
			double d3=dis.readDouble();
			boolean d4 = dis.readBoolean();
			
			System.out.println(data); //-->writeUTF �θ� ��ϵ� String���� ��ȯ
			System.out.println(d1); //-->writeUTF �θ� ��ϵ� String���� ��ȯ
			System.out.println(d2);
			System.out.println(d3);
			System.out.println(d4);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}//class
