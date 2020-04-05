package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StdMyRegCourseDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521";// 211.63.89.213
	private String user = "System";
	private String password = "root";//oracle
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String uid;

	// Constructor
	public StdMyRegCourseDAO(String uid) {
		this.uid = uid;
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

	// 나의 수강리스트 SELECT
	public Vector<Vector<String>> getMyRegisterList() {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		String sql = "select vv.subno,subname,credit,pname from (SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME"
				+ "                  FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB "
				+ "                  WHERE Q.SUBNO = SUB.SUBNO) vv ,enrol en where vv.subno = en.subno and en.stdno = ? order by subno ";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount() + 1;
				for (int i = 1; i < colCount; i++) {
					vo.add(rs.getString(i));
				}
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}//myLegList
	
	// 나의 수강리스트 SELECT(vo객체버전)
	public ArrayList<StdRegCourseVO> getVoMyRegisterList() {
		ArrayList<StdRegCourseVO> list = new ArrayList<StdRegCourseVO>();
		String sql = "select vv.subno,subname,credit,pname from (SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME"
				+ "                  FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB "
				+ "                  WHERE Q.SUBNO = SUB.SUBNO) vv ,enrol en where vv.subno = en.subno and en.stdno = ? order by subno ";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					StdRegCourseVO vo = new StdRegCourseVO();
					vo.setSubno(rs.getString(1));
					vo.setSubname(rs.getString(2));
					vo.setCredit(rs.getString(3));
					vo.setPname(rs.getString(4));
					list.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}//myLegList
	
	//delete myLegList
	public int getMyRegDelete() {  //전체삭제
		int result = 0;
		Vector<Vector<String>> list	= new Vector<Vector<String>>();
		String sql = "delete from enrol ";
		try {
			getPreparedStatement(sql);
			//매핑
			result = pstmt.executeUpdate(); //성공시 update 한 쿼리수를 가져옴
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getMyRegDelete(String subNO) { // 선택삭제
		int result = 0;
		String sql = "delete from enrol where subno = ?";
		try {
			getPreparedStatement(sql);
			//매핑
			pstmt.setString(1, subNO);
			result = pstmt.executeUpdate(); //성공시 1
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
//	}
//	public Vector<Vector<String>> getMyRegisterInsert(){
//		Vector<Vector<String>> list	= new Vector<Vector<String>>();
//		String sql = "insert into ENROL VALUES('C'||TRIM(TO_CHAR(SEQU_ENROL.NEXTVAL,'000')),?,?)";
//		try {
//			getPreparedStatement(sql);
//			pstmt.setString(1, uid);
//			pstmt.setString(2, uid);
//			rs = pstmt.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			while(rs.next()) {
//				Vector<String> vo = new Vector<String>();
//				int colCount = rsmd.getColumnCount()+1;
//				for(int i =1; i<colCount;i++) {
//					vo.add(rs.getString(i));
//				}
//				list.add(vo);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	public Vector<Vector<String>> getResultVector(String sql){
//		Vector<Vector<String>> list	= new Vector<Vector<String>>();
//		sql="SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME " + 
//				"FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB " + 
//				"WHERE Q.SUBNO = SUB.SUBNO";
//		try {
//			getPreparedStatement(sql);
//			rs = pstmt.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			while(rs.next()) {
//				Vector<String> vo = new Vector<String>();
//				int colCount = rsmd.getColumnCount()+1;  
//				for(int i =1; i<colCount;i++) {
//					vo.add(rs.getString(i));
//				}
//				list.add(vo);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	//오버로딩 조건에따라 다른sql문 받기
//	public Vector<Vector<String>> getResultVector(String esql,String where){
//		Vector<Vector<String>> list	= new Vector<Vector<String>>();
//		String sql = esql;
//		try {
//			getPreparedStatement(sql);
//			
//			//매핑
//			pstmt.setString(1, where);
//			
//			rs = pstmt.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			while(rs.next()) {
//				Vector<String> vo = new Vector<String>();
//				int colCount = rsmd.getColumnCount()+1;//colum은 4개닌까 5개맞지
////				System.out.println(colCount);
//				for(int i =1; i<colCount;i++) {
//					vo.add(rs.getString(i));
//				}
//				list.add(vo);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
