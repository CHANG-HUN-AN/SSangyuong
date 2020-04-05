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
	
<<<<<<< Upstream, based on origin/master
=======
<<<<<<< HEAD
//	//리스트 출력 (이전)
//		public Vector<Vector<String>> getVectorList(){
//			Vector<Vector<String>> list	= new Vector<Vector<String>>();
//			String sql="SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME " + 
//					"FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB " + 
//					"WHERE Q.SUBNO = SUB.SUBNO";
////			String sql="SELECT SUB.SUBNO,SUBNAME,CREDIT,PNAME "
////							+" FROM (select SUBNO,PNAME from lecture lec,professor pro where lec.PRONO = pro.PRONO) Q,SUBJECT SUB"
////							+" WHERE Q.SUBNO = SUB.SUBNO and SUB.TERM =? ORDER BY SUBNO "; 
//			try {
//				getPreparedStatement(sql);
////				pstmt.setString(1, term);
//				rs = pstmt.executeQuery();
//				ResultSetMetaData rsmd = rs.getMetaData();
//				while(rs.next()) {
//					Vector<String> vo = new Vector<String>();
//					int colCount = rsmd.getColumnCount()+1;
//					for(int i =1; i<colCount;i++) {
//						vo.add(rs.getString(i));
//					}
//					list.add(vo);
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			return list;
//		}
	
=======
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
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
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;//colum은 4개닌까 5개맞지
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
<<<<<<< Upstream, based on origin/master
	
=======
<<<<<<< HEAD
	//수강신청 버튼클릭시 insert(mydata에있는값)
	//2개밖에 되지않아 vo 객체는 만들지 않음
	public int getRegInsert(String uid,Vector<String> subjectNo) {
		int result = 0;
		Vector<Vector<String>> list	= new Vector<Vector<String>>();
		String sql = "insert into ENROL VALUES('C'||TRIM(TO_CHAR(SEQU_ENROL.NEXTVAL,'000')),?,?)";
		try {
			getPreparedStatement(sql);
			
			//매핑
			pstmt.setString(1, uid);
			for(String str:subjectNo) {
				System.out.println(str);
				pstmt.setString(2, str);
				result = pstmt.executeUpdate();
				System.out.println(result);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Vector<StdRegCourseVO> getArrVoList(int dataRowCount,DefaultTableModel myData){
//		StdRegCourseVO vo = new StdRegCourseVO();
		Vector<StdRegCourseVO> list = new Vector<StdRegCourseVO>();
		for(int i=0; i< dataRowCount ;i++) {
			StdRegCourseVO vo = new StdRegCourseVO();
			vo.setSubno((String)myData.getValueAt(i, 0));
			vo.setSubname((String)myData.getValueAt(i, 1));
			vo.setCredit((String)myData.getValueAt(i, 2));
			vo.setProfessor((String)myData.getValueAt(i, 3));
			list.add(vo);
		}
		
		return list;
	}
=======
	
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase

	
}
