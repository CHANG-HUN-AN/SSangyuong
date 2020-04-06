package univ2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ProInfoDAO {

		//Field
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@211.63.89.213:1521";//211.63.89.213
		private String user = "System";
		private String password = "oracle";//oracle
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		//Constructor
		public ProInfoDAO() { 
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Method
		public void getPreparedStatement(String sql) {
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public Vector<Vector<String>> getResultVectorList(String pid) {
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			String sql = " SELECT S.STDNO,PNAME,M.MNAME " + 
					" FROM ENROL EN, STUDENT S, SUBJECT B,PROFESSOR P,MAJOR M " + 
					" WHERE S.STDNO = EN.STDNO " + 
					" AND EN.SUBNO = B.SUBNO " + 
					" AND M.MAJORNO = S.MAJORNO" + 
					" AND PNAME = ? " + 
					" AND SUBNAME = '�����ͺ��̽�' " ;
			try {
				getPreparedStatement(sql);
				pstmt.setString(1,pid);
//				pstmt.setString(2,pid);
				rs = pstmt.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();
			
				while(rs.next()) {
					Vector<String> vo = new Vector<String>();
					int colCount = rsmd.getColumnCount()+1;
					for(int i =1; i<colCount; i++) {
						vo.add(rs.getString(i));
					}
					list.add(vo);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//volist �����ε�
		public Vector<Vector<String>> getResultVOList(String esql,String where) {
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			getPreparedStatement(esql);
			try {
				pstmt.setString(1, where);
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next()) {
					Vector<String> vo = new Vector<String>();
					int colCount = rsmd.getColumnCount()+1;
					for(int i =1; i<colCount; i++) {
						vo.add(rs.getString(i));
					}
					list.add(vo);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//�����ε�
		public Vector<Vector<String>> getResultVectorList(String sql,String where) {
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			getPreparedStatement(sql);
			try {
				//pstmt���� resultset�� ������� sql�� ?,? �� �����ֱ�
				pstmt.setString(1, where);	
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
			
				while(rs.next()) {
					Vector<String> vo = new Vector<String>();
					int colCount = rsmd.getColumnCount()+1;
					for(int i =1; i<colCount; i++) {
						vo.add(rs.getString(i));
					}
					list.add(vo);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//������ �˻�DAO
		public Vector<AdminStdVO> getDetailSearch(String detailData) {
			String sql = "select stdno,pw,sname,gender,ph,to_char(birth,'yyyy/mm/dd'),mname from student STU,MAJOR MAJ where STU.MAJORNO = MAJ.MAJORNO AND STDNO = ?";
			Vector<AdminStdVO> list = new Vector<AdminStdVO>();
			try {
				getPreparedStatement(sql);
				pstmt.setString(1,detailData);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					AdminStdVO vo = new AdminStdVO();
					vo.setStdno(rs.getString(1));
					vo.setPw(rs.getString(2));
					vo.setSname(rs.getString(3));
					vo.setGender(rs.getString(4));
					vo.setPh(rs.getString(5));
					vo.setBirth(rs.getString(6));
					vo.setMname(rs.getString(7));
					list.add(vo);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public void close() {
			try {
				if(rs != null)rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

