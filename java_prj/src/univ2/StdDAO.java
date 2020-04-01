package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StdDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@211.63.89.213:1521";
	private String user = "SYSTEM";
	private String pass = "oracle";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// Constructor
	public StdDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 로그인
	 */
	public int stdLogin(String stdno, String pw) {
		try {
			String sql = "select pw from student where stdno = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, stdno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; // 로그인 성공
					
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디 불일치
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -2;
	}
	
	/**
	 * 비밀번호 찾기
	 */
	public String stdPassSearch(String sname, String stdno) {
		String result = "";
		String sql = "SELECT PW FROM STUDENT WHERE SNAME = ? AND STDNO = ?";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, sname);
			pstmt.setString(2, stdno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 학생 정보 불러오기
	 */
	public StdVO stdInfoList(String stdno) {
		StdVO vo = new StdVO();
		String sql = "select mname, stdno, sname, pw, ph, gender, to_char(birth, 'yyyy/mm/dd') " + 
				"from student s, major m " + 
				"where s.majorno = m.majorno " + 
				"and stdno = '" + stdno + "'";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setMname(rs.getString(1));
				vo.setStdno(rs.getString(2));
				vo.setSname(rs.getString(3));
				vo.setPw(rs.getString(4));
				vo.setPh(rs.getString(5));
				vo.setGender(rs.getString(6));
				vo.setBirth(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
}