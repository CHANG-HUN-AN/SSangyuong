package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConn {
	//Field
	private String url = "jdbc:oracle:thin:@211.63.89.210:1521";
	private String user = "scott";
	private String pass = "tiger";
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	//Constructor
	public DBConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("---------->> 1단계 성공");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("---------->> 2단계 성공");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	//Method
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("---------->> 3단계 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<EmpVO> getResultEmpList(String sql) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			rs = stmt.executeQuery(sql);			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getString(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));				
				list.add(vo);
			}			
		} catch (Exception e) {	e.printStackTrace();	}
		
		return list;
	}	
	
	/** 모든 테이블에서 데이터 가져오기 **/
	public ArrayList<ArrayList<String>> getResultList(String sql) {
		ArrayList<ArrayList<String>> list 
				= new ArrayList<ArrayList<String>>();
		
		try {
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("colCount ===>>"+ rsmd.getColumnCount());	
		
			while(rs.next()) {
				ArrayList<String> vo = new ArrayList<String>();
				int colCount = rsmd.getColumnCount()+1;
				for(int i=1;i<colCount;i++) {
					vo.add(rs.getString(i));
				}
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return list;
	}	
	
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}//class










