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
				for(int i =1; i<colCount;i++) {
					vo.add(rs.getString(i));
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
				for(int i =1; i<colCount;i++) {
					vo.add(rs.getString(i));
				}
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//�����ε� ���ǿ����� �ٸ�sql�� �ޱ�
	public Vector<Vector<String>> getResultVector(String esql,String where){
		Vector<Vector<String>> list	= new Vector<Vector<String>>();
		String sql = esql;
		try {
			getPreparedStatement(sql);
			
			//����
			pstmt.setString(1, where);
			
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;//colum�� 4���ѱ� 5������
//				System.out.println(colCount);
				for(int i =1; i<colCount;i++) {
					vo.add(rs.getString(i));
				}
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
}
