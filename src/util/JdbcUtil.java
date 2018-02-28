package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	private static final String driver="com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/pims?unicode=true&charset=gbk";
	private final static String user ="root";
	private final static String pwd ="root";
	
	public JdbcUtil(){
		super();
	}
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO  Auto-generated catch block
			e.printStackTrace();
		}
		}
	public static Connection getConnection(){
	Connection  conn = null;
	try {
		conn = DriverManager.getConnection(url,user,pwd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
}
	protected void close(ResultSet rs,PreparedStatement ps,Connection conn){
		if(null!=rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO  Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != ps){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
