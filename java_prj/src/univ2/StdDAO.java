package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

public class StdDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@211.63.89.213:1521";// 211.63.89.213
	private String user = "SYSTEM";
	private String password = "oracle";// oracle
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// Constructor
	public StdDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
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

			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
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
		String sql = "select mname, stdno, sname, pw, ph, gender, to_char(birth, 'yyyy/mm/dd'), term "
				+ "from student s, major m " + "where s.majorno = m.majorno " + "and stdno = '" + stdno + "'";
		// REGEXP_REPLACE(PH, '(.{3})(.+)(.{4})', '\\1-\\2-\\3') // 연락처 하이픈 추가
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setMname(rs.getString(1));
				vo.setStdno(rs.getString(2));
				vo.setSname(rs.getString(3));
				vo.setPw(rs.getString(4));
				vo.setPh(rs.getString(5));
				vo.setGender(rs.getString(6));
				vo.setBirth(rs.getString(7));
				vo.setTerm(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	/**
	 * 학생 정보 수정
	 */
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

	/**
	 * 성적조회 - 학생 정보
	 */
	public StdVO stdScore(String stdno) {
		StdVO vo = new StdVO();
		String sql = "SELECT SNAME, MNAME, STDNO FROM STUDENT S, MAJOR M WHERE S.MAJORNO = M.MAJORNO AND STDNO = '"
				+ stdno + "'";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setSname(rs.getString(1));
				vo.setMname(rs.getString(2));
				vo.setStdno(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	/**
	 * 성적조회 - 과목 정보(전체)
	 */
	public ArrayList<StdVO> stdSubjectList(String stdno) {
		ArrayList<StdVO> list = new ArrayList<StdVO>();
		String sql = "SELECT SUBNAME, SCORE, GRADE, S.STDNO, PNAME, CREDIT FROM STUDENT S, MAJOR M, SCORE SC, SUBJECT SB, LECTURE L, TERM T, PROFESSOR P WHERE M.MAJORNO = S.MAJORNO AND S.STDNO = SC.STDNO AND SC.SUBNO = SB.SUBNO AND SB.SUBNO = L.SUBNO AND L.PRONO = P.PRONO AND S.TERM = T.TERM AND S.STDNO = '"
				+ stdno + "'";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StdVO vo = new StdVO();
				vo.setSubname(rs.getString(1));
				vo.setScore(rs.getInt(2));
				vo.setGrade(rs.getString(3));
				vo.setStdno(rs.getString(4));
				vo.setPname(rs.getString(5));
				vo.setCredit(rs.getInt(6));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 성적조회 - 과목 정보(학기별)
	 */
	public ArrayList<StdVO> stdSubjectList(String stdno, String term) {
		ArrayList<StdVO> list = new ArrayList<StdVO>();
		String sql = "SELECT SUBNAME, SCORE, GRADE, S.STDNO, PNAME, CREDIT FROM STUDENT S, MAJOR M, SCORE SC, SUBJECT SB, LECTURE L, TERM T, PROFESSOR P WHERE M.MAJORNO = S.MAJORNO AND S.STDNO = SC.STDNO AND SC.SUBNO = SB.SUBNO AND SB.SUBNO = L.SUBNO AND L.PRONO = P.PRONO AND S.TERM = T.TERM "
				+ " AND SB.TERM = '" + term + "' AND S.STDNO = '" + stdno + "'";
		getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StdVO vo = new StdVO();
				vo.setSubname(rs.getString(1));
				vo.setScore(rs.getInt(2));
				vo.setGrade(rs.getString(3));
				vo.setStdno(rs.getString(4));
				vo.setPname(rs.getString(5));
				vo.setCredit(rs.getInt(6));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}// class