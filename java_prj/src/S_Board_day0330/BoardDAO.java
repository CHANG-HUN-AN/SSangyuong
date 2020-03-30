package S_Board_day0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	//Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521";
	private String user ="scott";
	private String pass ="tiger";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	//Constructor
	public BoardDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			//3�ܰ踦 �����ڴܰ迡�� �����ϸ�ȵ� �޴� sql���� �����Ҷ����� �ٸ��⶧����
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	public void getPreParedStatement(String sql) {
		try {
			//error ������
			//nullpointex -> ��ü�� ���� //sql exception sql�� �߸�������
			pstmt = conn.prepareStatement(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//
	//db�� insert
	public int getResultInsert(BoardVO vo) {
		int result = 0;
		try {
			String sql ="INSERT INTO S_BOARD VALUES('B_'||TRIM(TO_CHAR(SEQU_S_BOARD_BID.NEXTVAL,'000'))" + 
					",?,?,SYSDATE,0)";
			//preparedstatement�޼ҵ�
			getPreParedStatement(sql);
			//����
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//read
	public ArrayList<BoardVO> getResultList() {
		 ArrayList<BoardVO> list = new  ArrayList<BoardVO>();
		try {
			String sql ="SELECT ROWNUM RNO,BTITLE,BCONTENT,to_char(BDATE,'yy/mm/dd'),BHITS FROM S_BOARD";
			getPreParedStatement(sql);
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setRno(rs.getInt(1));
				vo.setBtitle(rs.getString(2));
				vo.setBcontent(rs.getString(3));
				vo.setBdate(rs.getString(4));
				vo.setBhits(rs.getInt(5));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void closing() {
		try {
			if(rs != null	) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null)conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
