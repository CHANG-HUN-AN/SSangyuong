package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import univ2.AdminStdVO;

public class AdmScoreDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@119.194.84.127:1521";// 211.63.89.213
	private String user = "System";
	private String password = "oracle";// oracle

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// Constructor
	public AdmScoreDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End AD

	// Method
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// End Prepared

	public Vector<AdminStdVO> getResultArrayList(String esql) {
		Vector<AdminStdVO> list = new Vector<AdminStdVO>();
		getPreparedStatement(esql);
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminStdVO vo = new AdminStdVO();
				vo.setStdno(rs.getString(1));
				vo.setSname(rs.getString(2));
				vo.setMname(rs.getString(3));
//				vo.set(rs.getString(4));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}// End getResultArrayList

	// VOList Overloading
	public Vector<Vector<String>> getResultVOList(String esql, String where) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(esql);
		try {
			pstmt.setString(1, where);
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
	}// End VOList Overloading

	public Vector<Vector<String>> getResultVectorList(String sql) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(sql);
		try {
			// pstmt쿼리 resultset에 담기전에 sql의 ?,? 에 조건주기
			// pstmt.setString(1, where);
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
	}// End VectorList 1

	// 오버로딩
	public Vector<Vector<String>> getResultVectorList(String sql, String where) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(sql);
		try {
			// pstmt쿼리 resultset에 담기전에 sql의 ?,? 에 조건주기
			pstmt.setString(1, where);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				Vector<String> vo = new Vector<String>();
				int colCount = rsmd.getColumnCount()+1;
				for (int i = 1; i < colCount; i++) {
					vo.add(rs.getString(i));
				
				}
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}// End Vector List2

	// 상세성적 학생정보 출력 DAO
	public Vector<AdminStdVO> getDetailScoreInfo(String detailData) {
		String sql = "SELECT STDNO,SNAME,MNAME " + "FROM STUDENT T,MAJOR M " + "WHERE T.MAJORNO = M.MAJORNO "
				+ "AND STDNO = ? ";
		Vector<AdminStdVO> list = new Vector<AdminStdVO>();
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, detailData);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AdminStdVO vo = new AdminStdVO();
				vo.setStdno(rs.getString(1));
				vo.setSname(rs.getString(2));
				vo.setMname(rs.getString(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 상세성적 성적 테이블 DAO
	public Vector<Vector<String>> getDetailScoreList(String sql, String where) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, where);
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
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//업데이트
		public int adminUpdate(AdminStdVO avo) {
			int result = 0;
			try {
			String sql = "UPDATE SCORE SET SCORE = ?, GRADE = ? WHERE SCOREID = ? ";	
			getPreparedStatement(sql);
			pstmt.setString(1, avo.getScore());
			pstmt.setString(2, avo.getGrade());
			pstmt.setString(3, avo.getScoreid());
			
			System.out.println(avo.getScore());
			System.out.println( avo.getGrade());
			System.out.println(avo.getScoreid());
			
			result = pstmt.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

}// End class
