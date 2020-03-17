package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConn {
	//Field
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	private String url ="jdbc:oracle:thin:@211.63.89.213:1521";
	private String user = "scott";
	private String pass = "tiger";
	//Constructor
	public DBConn() {
		try {
			//1.����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("------------1�ܰ輺�� ����̹� �ε�");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("------------2�ܰ輺�� connection��ü���� java�� db����");
			
		}catch (Exception e) { }
	}
	
	//Method
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("----3�ܰ� ���� statemet��ü connection ��ü�� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param sql
	 * @return
	 */
	public  ArrayList getResult(String sql) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				EmpVO vo	= new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getString(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));
				
				list.add(vo);
				}
		}catch (Exception e) { e.printStackTrace(); }
		return list;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt !=null)stmt.close();
			if(conn !=null) conn.close();
		}catch (Exception e) { e.printStackTrace();}
	}
}
