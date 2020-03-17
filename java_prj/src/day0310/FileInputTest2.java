package day0310;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 2. io ��Ű���� Ŭ���� ����(FileReader,FileWriter)
 * ���� : ui�� �޸����� �����Ͽ� �������� ��������� ����� �ִ�.
 * @author user
 */
public class FileInputTest2 {

	public static void main(String[] args) {
//		1.���� ���� Ȯ�� :c:/dev/test2.txt
//		2.��������� �����͸� test2.txt�� ������ �����͸� �ٽ� �����Ͽ� ���� �� �ֿܼ� ���
//		3.���� ������� -���ϻ���
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϸ�>>");
		String fname = scan.next();
		
		File file = new File("c:/dev/"+fname);
		FileReader fr = null;
		FileWriter fw =null;
		
		try {
			if(file.exists()) {
				System.out.println("����o");
				//���ϵ����� ����
				fw = new FileWriter(file,true); //filewriter ������ (file��ü , append) ���������� �߰�����
				String str = "Hello~java!!!!";
				fw.write(str,0,str.length());
				fw.flush(); // ���� ���۸޼ҵ�
				System.out.println("--------------------->�������ۿϷ�!!");
				//���ϵ����� ����
				fr = new FileReader(file);
				char[] c = new char[100];
//				fr.read();
				fr.read(c,0,c.length);
				System.out.println("------>"+new String(c));
			}else {
				file.createNewFile(); // ���Ϻ���� ���� ����
				System.out.println("------------------->\n���ϻ����Ϸ�o");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}//try
	}//main
}//class
