package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnTest {

	public static void main(String[] args) {
		try {
			//0단계 : 드라이버 준비 - 이클립스 프로젝트 Build path에 등록
			//1단계 : 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공~");
			
			//2단계 : Connection 객체 생성
			String url = "jdbc:oracle:thin:@211.63.89.210:1521";
			String user = "scott";
			String pass = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("2단계 성공~");
			
			//3단계 : Statement 객체 생성
			Statement stmt = conn.createStatement();
			
			//4단계 : ResultSet 객체 생성
			Scanner scan = new Scanner(System.in);
			System.out.print("부서번호>");
			int dno = scan.nextInt();
			String sql = "select rownum rno, empno, ename, job, deptno "
					+ " from emp"
					+ " where deptno ="+dno;
			ResultSet rs = stmt.executeQuery(sql);
			
			//5단계 : ResultSet 객체에서 데이터 가져오기
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\n");
			}
			
			//6단계 : 생성된 객체 종료
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}//class








