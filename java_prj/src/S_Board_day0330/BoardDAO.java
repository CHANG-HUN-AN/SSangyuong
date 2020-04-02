package S_Board_day0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 0330,0401...
 * 
 * 0401:개발영역의 트랜잭션관리(CONN.AUTOCOMMIT)
 * 
 * @author user
 */
public class BoardDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521";
	private String user = "scott";
	private String pass = "tiger";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// Constructor
	public BoardDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			// 3단계를 생성자단계에서 생성하면안됨 받는 sql문이 실행할때마다 다르기때문에
//			System.out.println("commit status------------------> "+ conn.getAutoCommit());
//			conn.setAutoCommit(false); //오토커밋을 false 로해놓으면 쿼리실행후 commit을 일일이 해줘야한다.
//			System.out.println("commit status2------------------> "+ conn.getAutoCommit());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method
	public void getPreParedStatement(String sql) {
		try {
			// error 수정시
			// nullpointex -> 객체가 없다 //sql exception sql문 잘못적었다
			pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//
		// db에 insert

	public int getResultInsert(BoardVO vo) {
		int result = 0;
		try {
			String sql = "INSERT INTO S_BOARD VALUES('B_'||TRIM(TO_CHAR(SEQU_S_BOARD_BID.NEXTVAL,'000'))"
					+ ",?,?,SYSDATE,0)";
			// preparedstatement메소드
			getPreParedStatement(sql);
			// 맵핑
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());

			result = pstmt.executeUpdate();
//			conn.commit(); //autocommit 이 풀려 수동으로 커밋해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// read
	public ArrayList<BoardVO> getResultList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {// order by 정렬은 rownum과 같이쓸수 없다.
				// 게시판에서 최신글이 위로올라와야되기때문에 BDATE 를 내림차순으로 정렬한다
				// 수정할때는 pk가 꼭 필요하다
			String sql = "SELECT ROWNUM RNO,BTITLE ,BCONTENT,BDATE, BHITS,bid"
					+ " FROM (SELECT BTITLE,BCONTENT,to_char(BDATE,'yy/mm/dd') bdate,BHITS,bid FROM S_BOARD ORDER BY BDATE DESC)";
			getPreParedStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setRno(rs.getInt(1));
				vo.setBtitle(rs.getString(2));
				vo.setBcontent(rs.getString(3));
				vo.setBdate(rs.getString(4));
				vo.setBhits(rs.getInt(5));
				vo.setBid(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// update
	public int getresultUpdate(BoardVO uvo) {
		int result = 0;
		try{
			String sql ="update s_board set btitle = ? , bcontent =? where bid = ?";
			getPreParedStatement(sql);
			//pstmt 매핑
			pstmt.setString(1, uvo.getBtitle());
			pstmt.setString(2, uvo.getBcontent());
			pstmt.setString(3, uvo.getBid());
			
			result =pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void closing() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
