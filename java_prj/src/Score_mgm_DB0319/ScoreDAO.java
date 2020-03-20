package Score_mgm_DB0319;

/**
 * java 와 데이터베이스 연동시에 쓰는 객체
 * @author user
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDAO {
	//field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521";
	private String id ="scott";
	private String pass = "tiger";
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	//constructor
	public ScoreDAO() {
		try {
			Class.forName(driver);
			System.out.println("-----1단계 성공");
			
			conn = DriverManager.getConnection(url,id,pass); 
			//전역변수로 만들어야될 변수를 지역변수로 다시선언했다면
			//오류로 다른메소드에서 conn 객체 사용시 오류발생할수도 있다.
			System.out.println("-----2단계 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//method
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("------------3단계 \n쿼리를 싣고 왔다갔다하는 문서의역활생성");
		} catch (Exception e) {
		}
	}
	
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("------------3단계 \n쿼리를 싣고 왔다갔다하는 문서의역활생성");
		} catch (Exception e) {
		}
	}
	//insert
	public int getResultInsert(ScoreVO vo) {
		int result = 0;
		//preparedStatement 를 위해 sql문을 저장한다
		String sql = "INSERT INTO SCORE VALUES(?,?,?,?,?,sysdate)";
		getPreparedStatement(sql);
		
		try {	// +"," 너무많은 부호 이런결과로->>preparedstatement 객체를 자주이용한다
//			String sql ="INSERT INTO SCORE VALUES('"
//						+vo.getStuno()+"','"
//						+vo.getName()+"',"
//						+vo.getKor()+","
//						+vo.getEng()+","
//						+vo.getMath()+","
//						+"sysdate"
//						+")";
//			result =stmt.executeUpdate(sql); //statement 에 실행시 데이터 
			//pstmt 에 객체에 데이터를 바인딩!!(? -> 뭐가들어갈지)
			pstmt.setString(1, vo.getStuno());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//list
	public ArrayList<ScoreVO> getResultList(){
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
	
			String sql = "select rownum rno , stuno, name ,kor ,eng ,math, "
					+ "to_char(sdate,'yyyy/mm/dd') as sdate "
					+ " from (select * from score order By stuno asc)";
			//삭제된 데이터역시 같이 가져와준다 db의 트랜잭션이 끝나지않아서 그런게 보임
			//DB에서 commit을 통해서 데이터를 완전히 적용시켜준다.
			getPreparedStatement(sql);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setRno(rs.getInt(1));
				vo.setStuno(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setKor(rs.getInt(4));
				vo.setEng(rs.getInt(5));
				vo.setMath(rs.getInt(6));
				vo.setSdate(rs.getString(7));
				list.add(vo); //다가져왔는데 list에 아무것도 안보인다면 list.add를 주목하자 안적혀있는경우가 있다
				//2번째문제: 마지막의 데이터만 계속해서 출력이 된다면 객체자체가 반복문
				//안에 들어가있으면 마지막 데이터가 계속해서 나온다
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	//close
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
