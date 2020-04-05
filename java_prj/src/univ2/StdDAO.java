package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
<<<<<<< Upstream, based on origin/master
=======
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
import java.util.Vector;

public class StdDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@211.63.89.213:1521";//211.63.89.213
	private String user = "SYSTEM";
	private String pass = "oracle";//oracle
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
	 * �α���
	 */
<<<<<<< Upstream, based on origin/master
	public int stdLogin(String stdno, String pw) {
		try {
			String sql = "select pw from student where stdno = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, stdno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; // �α��� ����
					
				} else {
					return 0; // ��й�ȣ ����ġ
				}
			}
			return -1; // ���̵� ����ġ
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -2;
	}
	
	/**
	 * ��й�ȣ ã��
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
	 * �л� ���� �ҷ�����
	 */
	public StdVO stdInfoList(String stdno) {
		StdVO vo = new StdVO();
		String sql = "select mname, stdno, sname, pw, ph, gender, to_char(birth, 'yyyy/mm/dd') " + 
				"from student s, major m " + 
				"where s.majorno = m.majorno " + 
				"and stdno = '" + stdno + "'";
		// REGEXP_REPLACE(PH, '(.{3})(.+)(.{4})', '\\1-\\2-\\3') // ����ó ������ �߰�
=======
<<<<<<< HEAD
	public ArrayList<StdVO> stdSubjectList(String stdno) {
		ArrayList<StdVO> list = new ArrayList<StdVO>();
		String sql = "SELECT SUBNAME, SCORE, GRADE, S.STDNO, PNAME, CREDIT FROM STUDENT S, MAJOR M, SCORE SC, SUBJECT SB, LECTURE L, TERM T, PROFESSOR P WHERE M.MAJORNO = S.MAJORNO AND S.STDNO = SC.STDNO AND SC.SUBNO = SB.SUBNO AND SB.SUBNO = L.SUBNO AND L.PRONO = P.PRONO AND S.TERM = T.TERM AND S.STDNO = '"
				+ stdno + "'";
=======
	public int stdLogin(String stdno, String pw) {
		try {
			String sql = "select pw from student where stdno = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, stdno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; // �α��� ����
					
				} else {
					return 0; // ��й�ȣ ����ġ
				}
			}
			return -1; // ���̵� ����ġ
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -2;
	}
	
	/**
	 * ��й�ȣ ã��
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
	 * �л� ���� �ҷ�����
	 */
	public StdVO stdInfoList(String stdno) {
		StdVO vo = new StdVO();
		String sql = "select mname, stdno, sname, pw, ph, gender, to_char(birth, 'yyyy/mm/dd') " + 
				"from student s, major m " + 
				"where s.majorno = m.majorno " + 
				"and stdno = '" + stdno + "'";
		// REGEXP_REPLACE(PH, '(.{3})(.+)(.{4})', '\\1-\\2-\\3') // ����ó ������ �߰�
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
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
<<<<<<< Upstream, based on origin/master
	
	public int stdInfoUpdate(StdVO uvo) {
		int result = 0;
		
		try {
			String sql = "UPDATE STUDENT SET PW = ?, SNAME = ?, PH = ?, BIRTH = ? WHERE STDNO = ?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, uvo.getPw());
			pstmt.setString(2, uvo.getSname());
			pstmt.setString(3, uvo.getPh());
			pstmt.setString(4, uvo.getBirth());
			pstmt.setString(5, uvo.getStdno());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public StdVO stdScore(String stdno) {
		StdVO vo = new StdVO();
		String sql = "SELECT SNAME, MNAME, STDNO FROM STUDENT S, MAJOR M WHERE S.MAJORNO = M.MAJORNO AND STDNO = '" + stdno + "'";
=======
<<<<<<< HEAD
   /**
    * ������ȸ - ���� ����(�б⺰)
    */
	public ArrayList<StdVO> stdSubjectList(String stdno, String term) {
		ArrayList<StdVO> list = new ArrayList<StdVO>();
		String sql = "SELECT SUBNAME, SCORE, GRADE, S.STDNO, PNAME, CREDIT FROM STUDENT S, MAJOR M, SCORE SC, SUBJECT SB, LECTURE L, TERM T, PROFESSOR P WHERE M.MAJORNO = S.MAJORNO AND S.STDNO = SC.STDNO AND SC.SUBNO = SB.SUBNO AND SB.SUBNO = L.SUBNO AND L.PRONO = P.PRONO AND S.TERM = T.TERM "
				+ " AND SB.TERM = '" + term +"' AND S.STDNO = '"
					+ stdno + "'";
>>>>>>> 85ee785 @rebase
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setSname(rs.getString(1));
				vo.setMname(rs.getString(2));
				vo.setStdno(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public Vector<Vector<String>> getResultVectorList(String sql){
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
   
=======
	
	public int stdInfoUpdate(StdVO uvo) {
		int result = 0;
		
		try {
			String sql = "UPDATE STUDENT SET PW = ?, SNAME = ?, PH = ?, BIRTH = ? WHERE STDNO = ?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, uvo.getPw());
			pstmt.setString(2, uvo.getSname());
			pstmt.setString(3, uvo.getPh());
			pstmt.setString(4, uvo.getBirth());
			pstmt.setString(5, uvo.getStdno());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public StdVO stdScore(String stdno) {
		StdVO vo = new StdVO();
		String sql = "SELECT SNAME, MNAME, STDNO FROM STUDENT S, MAJOR M WHERE S.MAJORNO = M.MAJORNO AND STDNO = '" + stdno + "'";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setSname(rs.getString(1));
				vo.setMname(rs.getString(2));
				vo.setStdno(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public Vector<Vector<String>> getResultVectorList(String sql){
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
				}
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
>>>>>>> refs/remotes/origin/master
>>>>>>> 85ee785 @rebase
}