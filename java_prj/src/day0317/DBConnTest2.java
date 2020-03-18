package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBConnTest2 {

	public static void main(String[] args) {
		try {
			//0�ܰ� : ����̹� �غ� - ��Ŭ���� ������Ʈ Build path�� ���
			//1�ܰ� : ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����~");
			
			//2�ܰ� : Connection ��ü ����
			String url = "jdbc:oracle:thin:@211.63.89.210:1521";
			String user = "scott";
			String pass = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("2�ܰ� ����~");
			
			//3�ܰ� : Statement ��ü ����
			//Statement stmt = conn.createStatement();
			String sql = "select rownum rno, empno, ename, job, deptno "
					+ " from emp"
					+ " where deptno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4�ܰ� : ResultSet ��ü ����
			Scanner scan = new Scanner(System.in);
			System.out.print("�μ���ȣ>");
			int dno = scan.nextInt();
			
			pstmt.setInt(1, dno);	
			ResultSet rs = pstmt.executeQuery();
			
			//5�ܰ� : ResultSet ��ü���� ������ ��������
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\n");
			}
			
			//6�ܰ� : ������ ��ü ����
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}//class








