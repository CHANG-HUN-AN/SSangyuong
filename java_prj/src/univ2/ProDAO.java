package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProDAO {
	// Field
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@211.63.89.213:1521";
	private String user = "SYSTEM";
	private String pass = "oracle";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// Constructor
	public ProDAO() {
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
	
	public int proLogin(String pname, String prono) {
		try {
			String sql = "select prono from professor where pname = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, pname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(prono)) {
					return 1; // 로그인 성공
				} else {
					return 0;
				}
			}
			return -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
}
