package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * java 와 db 연동 -->preparedStatement 사용(3단계)
 * @author user
 */
public class DBConnTest2 {

	public static void main(String[] args) {
		try {
//			0.드라이버 준비 --이클립스 프로젝트에 build path __oracle 의 jdbc 파일의 .jar 파일을 등록
//			1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 드라이버 로딩 성공~");
			
			//2단계 : Connection 객체 생성(java.sql.Connection)
			String url = "jdbc:oracle:thin:@211.63.89.213:1521";//"jdbc:oracle:thin:@서버ip:1521";
			String user = "scott";
			String pass = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("2단계 java 와 db 를 연결시켜 길을 만든다");
//			//3단계 : preparedstatement 객체 생성

//			Statement stmt = conn.createStatement();
			String sql = "select rownum rnm ,empno,ename,job,deptno "
					+ "from emp "
					+ "where deptno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql을 3단계에서 생성 원래 4단계
			//4단계 resultset 객체 생성
			Scanner scan = new Scanner(System.in);
			System.out.print("부서번호입력>");
			int dno =scan.nextInt();
			String dname =scan.next();
			
			pstmt.setInt(1,dno); //?에 자동으로 인덱스 부여(1번부터) 인덱스 부여된 ? 에서 dno 의 값을 넣어
			//조건절로 검색 executeQuery가져오기전에 맵핑을 해주는것 statement 로 실행하면 조건절이 길어지면
			//+로 일일히 다붙여줘야되서 오류가 많이 발생할수 있다.
			ResultSet rs = pstmt.executeQuery();
			System.out.println("4단계 Statement 에 적혀진 sql문을 실행해 자바의 resultset에 담는다");
			//5단계 resultset 객체 에서 데이터를 가져온다 ->insert ,update ,delete 과정에서는 5단계가 없어도된다.
			System.out.println();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");//1번 컬럼에있는 데이터를 int 타입으로 가져온다
				System.out.print(rs.getInt(2)+"\t");//2번 컬럼에 있는 데이터를  int  타입으로 가져온다
				System.out.print(rs.getString(3)+"\t");//3번 컬럼에 있는 데이터를 String 타입으로 가져온다
				//db 에 숫자로저장된 데이터는 STring으로 가져올수있지만 
				//db에 문자로 저장된 데이터는 int 로 가져올수 없다.
				System.out.print(rs.getString(4)+"\t");//4번 컬럼에 있는 데이터를 String 타입으로 가져온다
				System.out.print(rs.getString(5)+"\n");//4번 컬럼에 있는 데이터를 String 타입으로 가져온다
			}
			System.out.println("5단계 resultset 에 있는 db에서 가져온 데이터를 자바에서 출력한다");
			//6단계 생성된 객체 역순 종료 close
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}//class
