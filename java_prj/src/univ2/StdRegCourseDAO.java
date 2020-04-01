package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class StdRegCourseDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@211.63.89.213:1521";//211.63.89.213
	private String user = "System";
	private String password = "oracle";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	//Constructor
	public StdRegCourseDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Vector<String>> getResultVector(){
		Vector<Vector<String>> list	= new Vector<Vector<String>>();
		String sql="SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME " + 
				"FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB " + 
				"WHERE Q.SUBNO = SUB.SUBNO";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
				for(int i =0; i<colCount;i++) {
					vo.add(rs.getString(1));
					vo.add(rs.getString(2));
					vo.add(rs.getString(3));
					vo.add(rs.getString(4));
				}
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Vector<Vector<String>> getResultVector(String sql){
		Vector<Vector<String>> list	= new Vector<Vector<String>>();
		sql="SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME " + 
				"FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB " + 
				"WHERE Q.SUBNO = SUB.SUBNO";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
				for(int i =0; i<colCount;i++) {
					vo.add(rs.getString(1));
					vo.add(rs.getString(2));
					vo.add(rs.getString(3));
					vo.add(rs.getString(4));
				}
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//오버로딩 조건에따라 다른sql문 받기
	public Vector<Vector<String>> getResultVector(String esql,String where){
		Vector<Vector<String>> list	= new Vector<Vector<String>>();
		String sql = esql;
		try {
			getPreparedStatement(sql);
			
			//매핑
			pstmt.setString(1, where);
			
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				Vector<String> vo2 = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
//				System.out.println(colCount);
				for(int i =0; i<colCount;i++) {
					vo2.add(rs.getString(1));
					vo2.add(rs.getString(2));
					vo2.add(rs.getString(3));
					vo2.add(rs.getString(4));
				}
				list.add(vo2);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
