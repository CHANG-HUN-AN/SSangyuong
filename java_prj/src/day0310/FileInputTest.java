package day0310;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 1. FileInput Ŭ���� �ǽ�
 * @author user
 */
public class FileInputTest {

	public static void main(String[] args) {
		File file = new File("c:/dev/test.txt"); // java�� ������ ������� / ->\\ �� �ذ�
		FileInputStream fis =null;
		FileOutputStream fos =null;
		try {
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			if (file.exists()) {
				System.out.println("���� o");
				//������ ������ ��������
				fis = new FileInputStream(file);
				// ��int Ÿ������ ��ȯ�Ѵٰ� �ص� �����͸� ��ȯ���ִ°��� �ƴϰ� �������� ��(���翩��)�� �˷��ִ°�
				// int data = fis.read() ; �� ���� �����͸� �о �����ϴ� ���̾ƴϴ�.!!!!!!!
				byte[] data = new byte[500];
				System.out.println("--------���� ���� ������0000000000");
				while(fis.read(data) != -1) { //�����Ͱ� �������� ������ �˷��ش� (-1)
					System.out.println(new String(data));
				}
				System.out.println("-------���� ���� �Ϸ�!!!!!!!!!!!!!!!!!!!!!!!");
				//�����ϴ� ���Ͽ�  �����͸� ����
				fos = new FileOutputStream(file,true);
				fos.write(new String("Hello~JAVA!!!").getBytes());
				fos.flush();
				System.out.println("���� ���� �Ϸ�~~");
			} else {
				System.out.println("���� x");

				if (file.createNewFile()) { // io�� ���� exception�� �߻��Ѵ�. try catch�� �ذ�
					System.out.println("���� ���� �Ϸ�!");
				} else {
					System.out.println("���� ���� ����!");
				}
			} // else ~if
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
