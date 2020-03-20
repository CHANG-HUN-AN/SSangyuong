package Score_mgm_DB0319;

/**
 * java �� �����ͺ��̽� �����ÿ� ���� ��ü
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
			System.out.println("-----1�ܰ� ����");
			
			conn = DriverManager.getConnection(url,id,pass); 
			//���������� �����ߵ� ������ ���������� �ٽü����ߴٸ�
			//������ �ٸ��޼ҵ忡�� conn ��ü ���� �����߻��Ҽ��� �ִ�.
			System.out.println("-----2�ܰ� ����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//method
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("------------3�ܰ� \n������ �ư� �Դٰ����ϴ� �����ǿ�Ȱ����");
		} catch (Exception e) {
		}
	}
	
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("------------3�ܰ� \n������ �ư� �Դٰ����ϴ� �����ǿ�Ȱ����");
		} catch (Exception e) {
		}
	}
	//insert
	public int getResultInsert(ScoreVO vo) {
		int result = 0;
		//preparedStatement �� ���� sql���� �����Ѵ�
		String sql = "INSERT INTO SCORE VALUES(?,?,?,?,?,sysdate)";
		getPreparedStatement(sql);
		
		try {	// +"," �ʹ����� ��ȣ �̷������->>preparedstatement ��ü�� �����̿��Ѵ�
//			String sql ="INSERT INTO SCORE VALUES('"
//						+vo.getStuno()+"','"
//						+vo.getName()+"',"
//						+vo.getKor()+","
//						+vo.getEng()+","
//						+vo.getMath()+","
//						+"sysdate"
//						+")";
//			result =stmt.executeUpdate(sql); //statement �� ����� ������ 
			//pstmt �� ��ü�� �����͸� ���ε�!!(? -> ��������)
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
			//������ �����Ϳ��� ���� �������ش� db�� Ʈ������� �������ʾƼ� �׷��� ����
			//DB���� commit�� ���ؼ� �����͸� ������ ��������ش�.
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
				list.add(vo); //�ٰ����Դµ� list�� �ƹ��͵� �Ⱥ��δٸ� list.add�� �ָ����� �������ִ°�찡 �ִ�
				//2��°����: �������� �����͸� ����ؼ� ����� �ȴٸ� ��ü��ü�� �ݺ���
				//�ȿ� �������� ������ �����Ͱ� ����ؼ� ���´�
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
