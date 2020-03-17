package day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * java �� db ���� 
 * @author user
 */
public class DBConnTest {

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
			//3�ܰ� : statement ��ü ����
			Scanner scan = new Scanner(System.in);
			System.out.print("�μ���ȣ�Է�>");
			int dno =scan.nextInt();
			
			Statement stmt = conn.createStatement();
			System.out.println("3�ܰ� stmt ��ü�� �����Ѵ� java�� db�� �����͸� ������ϴ� ����");
			//4�ܰ� resultset ��ü ����
			String sql = "select rownum rnm ,empno,ename,job,deptno "
					+ "from emp "
					+ "where deptno = "+dno ;//sql ���� �����ݷ��� �����ʴ´�. //!!java ����� sql ���� �������ʴ´� jobfrom ��� ����
			ResultSet rs = stmt.executeQuery(sql);
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
			if(rs !=null)rs.close();
			if(stmt !=null)stmt.close();
			if(conn !=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}//class
