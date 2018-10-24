package priv.bss.gj.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DBUtil {
	
	private static Logger logger = Logger.getLogger(DBUtil.class);
	private static Properties properties;
	
	/**
	 * 抽取数据库配置文件
	 */
	static {
		try {
		properties = new Properties();
		//读取程序内部（根目录下）的配置文件
		//InputStream resourceAsStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		
		/**
		 * 读取程序外部配置文件（jar包外的文件）
		 * System.getProperty("user.dir") 获取项目的绝对路径
		 */
		String property = System.getProperty("user.dir")+"/db.properties";
		//logger.debug(property);
		InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property));
		properties.load(bufferedInputStream);
		} catch (IOException e) {
			logger.error("读取配置文件出错!",e);
		}
	}
	
	/**
	 * 获取conn对象
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConn() throws SQLException, ClassNotFoundException {
		Connection conn;
		//加载驱动类
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//获取连接
		conn = DriverManager.getConnection(properties.getProperty("url"), 
										   properties.getProperty("user"), 
										   properties.getProperty("pass"));
		return conn;
	}
	
	/**
	 * 关闭数据库资源
	 * @param set
	 * @param statement
	 * @param conn
	 */
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
