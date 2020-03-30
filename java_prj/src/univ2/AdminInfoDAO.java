package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class AdminInfoDAO {
	//Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521";
	private String user = "System";
	private String password = "oracle";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	//Constructor
	public AdminInfoDAO() { 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Method
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<StudentVO> getResultArrayList(String esql) {
		Vector<StudentVO> list = new Vector<StudentVO>();
		getPreparedStatement(esql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setStdno(rs.getString(1));
				vo.setSname(rs.getString(2));
				vo.setMname(rs.getString(3));
				vo.setGender(rs.getString(4));
				vo.setBirth(rs.getString(5));
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//volist 오버로딩
	public Vector<Vector<String>> getResultVOList(String esql,String where) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(esql);
		try {
			pstmt.setString(1, where);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
				for(int i =1; i<colCount; i++) {
					vo.add(rs.getString(1));
					vo.add(rs.getString(2));
					vo.add(rs.getString(3));
					vo.add(rs.getString(4));
					vo.add(rs.getString(5));
				}
				list.add(vo);
//				StudentVO vo = new StudentVO();
//				vo.setStdno(rs.getString(1));
//				vo.setSname(rs.getString(2));
//				vo.setMname(rs.getString(3));
//				vo.setGender(rs.getString(4));
//				vo.setBirth(rs.getString(5));
//				list.add(vo); -->VECTOR 의 2차원배열로 데이터출력이가능 VO객체사용이 안된다.
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Vector<Vector<String>> getResultVectorList(String sql) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(sql);
		try {
			
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
		
			while(rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
				for(int i =1; i<colCount; i++) {
					vo.add(rs.getString(1));
					vo.add(rs.getString(2));
					vo.add(rs.getString(3));
					vo.add(rs.getString(4));
					vo.add(rs.getString(5));
				}
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//오버로딩
	public Vector<Vector<String>> getResultVectorList(String sql,String where) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(sql);
		try {
			//pstmt쿼리 resultset에 담기전에 sql의 ?,? 에 조건주기
			pstmt.setString(1, where);	
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
		
			while(rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
				for(int i =1; i<colCount; i++) {
					vo.add(rs.getString(1));
					vo.add(rs.getString(2));
					vo.add(rs.getString(3));
					vo.add(rs.getString(4));
					vo.add(rs.getString(5));
				}
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//상세정보 검색DAO
	public Vector<StudentVO> getDetailSearch() {
		String sql = "select stdno,pw,sname,gender,ph,birth from student where stdno = ?";
		Vector<StudentVO> list = new Vector<StudentVO>();
		pstmt.setString(1, detailData);
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setStdno(rs.getString(1));
				vo.setSname(rs.getString(2));
				vo.setMname(rs.getString(3));
				vo.setGender(rs.getString(4));
				vo.setBirth(rs.getString(5));
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void close() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
