package day0311;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 *1. outputStream 의 정교한 전송을위한 DataoutputStream (포장도로)
 * @author user
 */
public class DataOutputStreamTest {

	public static void main(String[] args) {
		FileOutputStream fos=null;
		DataOutputStream dos=null;
		try {
			File f = new File("c:/dev/sample.dat");
			if(!f.exists())f.createNewFile();
			fos = new FileOutputStream(f);
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("홍길동");
			dos.writeInt(100);
			dos.writeLong(100000);
			dos.writeDouble(100.234);
			dos.writeBoolean(true);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos != null)  dos.close();
				if(fos != null)	fos.close();
			}catch (Exception e) {
			}
		}
		
	}
}
