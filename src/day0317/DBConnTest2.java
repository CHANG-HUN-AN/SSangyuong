package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * java �� db ���� -->preparedStatement ���(3�ܰ�)
 * @author user
 */
public class DBConnTest2 {

	public static void main(String[] args) {
		try {
//			0.����̹� �غ� --��Ŭ���� ������Ʈ�� build path __oracle �� jdbc ������ .jar ������ ���
//			1.����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1�ܰ� ����̹� �ε� ����~");
			
			//2�ܰ� : Connection ��ü ����(java.sql.Connection)
			String url = "jdbc:oracle:thin:@211.63.89.213:1521";//"jdbc:oracle:thin:@����ip:1521";
			String user = "scott";
			String pass = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("2�ܰ� java �� db �� ������� ���� �����");
//			//3�ܰ� : preparedstatement ��ü ����

//			Statement stmt = conn.createStatement();
			String sql = "select rownum rnm ,empno,ename,job,deptno "
					+ "from emp "
					+ "where deptno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); //sql�� 3�ܰ迡�� ���� ���� 4�ܰ�
			//4�ܰ� resultset ��ü ����
			Scanner scan = new Scanner(System.in);
			System.out.print("�μ���ȣ�Է�>");
			int dno =scan.nextInt();
			String dname =scan.next();
			
			pstmt.setInt(1,dno); //?�� �ڵ����� �ε��� �ο�(1������) �ε��� �ο��� ? ���� dno �� ���� �־�
			//�������� �˻� executeQuery������������ ������ ���ִ°� statement �� �����ϸ� �������� �������
			//+�� ������ �ٺٿ���ߵǼ� ������ ���� �߻��Ҽ� �ִ�.
			ResultSet rs = pstmt.executeQuery();
			System.out.println("4�ܰ� Statement �� ������ sql���� ������ �ڹ��� resultset�� ��´�");
			//5�ܰ� resultset ��ü ���� �����͸� �����´� ->insert ,update ,delete ���������� 5�ܰ谡 ����ȴ�.
			System.out.println();
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");//1�� �÷����ִ� �����͸� int Ÿ������ �����´�
				System.out.print(rs.getInt(2)+"\t");//2�� �÷��� �ִ� �����͸�  int  Ÿ������ �����´�
				System.out.print(rs.getString(3)+"\t");//3�� �÷��� �ִ� �����͸� String Ÿ������ �����´�
				//db �� ���ڷ������ �����ʹ� STring���� �����ü������� 
				//db�� ���ڷ� ����� �����ʹ� int �� �����ü� ����.
				System.out.print(rs.getString(4)+"\t");//4�� �÷��� �ִ� �����͸� String Ÿ������ �����´�
				System.out.print(rs.getString(5)+"\n");//4�� �÷��� �ִ� �����͸� String Ÿ������ �����´�
			}
			System.out.println("5�ܰ� resultset �� �ִ� db���� ������ �����͸� �ڹٿ��� ����Ѵ�");
			//6�ܰ� ������ ��ü ���� ���� close
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}//class
