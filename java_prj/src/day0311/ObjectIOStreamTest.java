package day0311;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 0312 ObjectIOStream 에대한 구조이해와 실습
 * @author user
 */
public class ObjectIOStreamTest {
	public static void main(String[] args) {
		//1.c://dev/sample.dat 파일에 UserVO객체를 전송한다
		
		try {
			File f = new File("c://dev/sample.dat");
			FileOutputStream fos = null;
			ObjectOutputStream oos =null;
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			if (f.exists()) {//파일 존재서 붙여쓰기
				//new Object
				fos = new FileOutputStream(f,true); //true값을 줘서 붙여넣기기능을 실행
				oos = new ObjectOutputStream(fos);
				UserVO vo = new UserVO("송강호","부산");
				//Write ObjectData
				oos.writeObject(vo);
			}else {//처음으로 파일을 만들때 실행
				//new Object
				f.createNewFile();
				fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);
				UserVO vo = new UserVO("홍길동","서울"); 
				//Write ObjectData
				oos.writeObject(vo);//★Serialize Error ★->보낼객체 데이터 직렬화 하지 않아서 오류
			}
			//Stream 객체 닫기
			oos.close();
			fos.close();
			
			//2.c://dev/sample.dat 파일의 UserVO 객체 수신한다.
//			ois = new ObjectInputStream(fis); //-->객체(자식)로 보냈지만 최상위객체 Object로만 반환 메모리에는 Object만 활성화
//			UserVO obj = (UserVO)ois.readObject(); //★casting★-> readObject가 반환값 Object이지만 직렬화로 메모리엔 vo ,Object둘다잡힘 돌아올때는
//			ois = new ObjectInputStream(fis); //-->객체(자식)로 보냈지만 최상위객체 Object로만 반환 메모리에는 Object만 활성화
//			UserVO obj2 = (UserVO)ois.readObject(); 
//			//Object만 활성화 되서 UserVO 로 레퍼런스 변수 만들고 캐스팅을통해 두개다 활성화 시켜주면 VO객체의 메소드를 사용이 가능하다
//			System.out.println("이름 "+obj.getName()); //-->Object만 활성화되서 이클립스가 VO객체의 메소드를 잡아주지 않는다.
//			
			fis = new FileInputStream(f);
			while(fis.available() >0) {
				ois = new ObjectInputStream(fis); //-->객체(자식)로 보냈지만 최상위객체 Object로만 반환 메모리에는 Object만 활성화
				UserVO obj = (UserVO)ois.readObject();
				
				System.out.print("이름 "+obj.getName()+"\t"); //-->Object만 활성화되서 이클립스가 VO객체의 메소드를 잡아주지 않는다.
				System.out.print("주소 "+obj.getAddr()+"\n"); //-
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}//class
