package priv.bss.gj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConn() throws SQLException, ClassNotFoundException {
		Connection conn;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//conn = DriverManager.getConnection("jdbc:oracle:thin:@134.224.120.196:1521:bss30", "bss_gj", "oracle189");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "zhangxueyou", "123456");
		return conn;
	}
	
	public static void close(ResultSet set, PreparedStatement statement, Connection conn) {
		if (set != null)
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/*public static void main(String[] args) {
		try {
			Connection conn = getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
}
