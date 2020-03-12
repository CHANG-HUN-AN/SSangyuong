package day0311;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 0312 ObjectIOStream ������ �������ؿ� �ǽ�
 * @author user
 */
public class ObjectIOStreamTest {
	public static void main(String[] args) {
		//1.c://dev/sample.dat ���Ͽ� UserVO��ü�� �����Ѵ�
		
		try {
			File f = new File("c://dev/sample.dat");
			FileOutputStream fos = null;
			ObjectOutputStream oos =null;
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			if (f.exists()) {//���� ���缭 �ٿ�����
				//new Object
				fos = new FileOutputStream(f,true); //true���� �༭ �ٿ��ֱ����� ����
				oos = new ObjectOutputStream(fos);
				UserVO vo = new UserVO("�۰�ȣ","�λ�");
				//Write ObjectData
				oos.writeObject(vo);
			}else {//ó������ ������ ���鶧 ����
				//new Object
				f.createNewFile();
				fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);
				UserVO vo = new UserVO("ȫ�浿","����"); 
				//Write ObjectData
				oos.writeObject(vo);//��Serialize Error ��->������ü ������ ����ȭ ���� �ʾƼ� ����
			}
			//Stream ��ü �ݱ�
			oos.close();
			fos.close();
			
			//2.c://dev/sample.dat ������ UserVO ��ü �����Ѵ�.
//			ois = new ObjectInputStream(fis); //-->��ü(�ڽ�)�� �������� �ֻ�����ü Object�θ� ��ȯ �޸𸮿��� Object�� Ȱ��ȭ
//			UserVO obj = (UserVO)ois.readObject(); //��casting��-> readObject�� ��ȯ�� Object������ ����ȭ�� �޸𸮿� vo ,Object�Ѵ����� ���ƿö���
//			ois = new ObjectInputStream(fis); //-->��ü(�ڽ�)�� �������� �ֻ�����ü Object�θ� ��ȯ �޸𸮿��� Object�� Ȱ��ȭ
//			UserVO obj2 = (UserVO)ois.readObject(); 
//			//Object�� Ȱ��ȭ �Ǽ� UserVO �� ���۷��� ���� ����� ĳ���������� �ΰ��� Ȱ��ȭ �����ָ� VO��ü�� �޼ҵ带 ����� �����ϴ�
//			System.out.println("�̸� "+obj.getName()); //-->Object�� Ȱ��ȭ�Ǽ� ��Ŭ������ VO��ü�� �޼ҵ带 ������� �ʴ´�.
//			
			fis = new FileInputStream(f);
			while(fis.available() >0) {
				ois = new ObjectInputStream(fis); //-->��ü(�ڽ�)�� �������� �ֻ�����ü Object�θ� ��ȯ �޸𸮿��� Object�� Ȱ��ȭ
				UserVO obj = (UserVO)ois.readObject();
				
				System.out.print("�̸� "+obj.getName()+"\t"); //-->Object�� Ȱ��ȭ�Ǽ� ��Ŭ������ VO��ü�� �޼ҵ带 ������� �ʴ´�.
				System.out.print("�ּ� "+obj.getAddr()+"\n"); //-
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}//class
