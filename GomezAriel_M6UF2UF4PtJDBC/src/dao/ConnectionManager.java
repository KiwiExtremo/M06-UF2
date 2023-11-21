package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String url = "jdbc:mysql://localhost/bdpremis";
	private static String user = "cfgs" ;
	private static String pwd = "ira491";
	
	private static Connection connection = null;
		
	private static int connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pwd);
			return 0;  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}	
	
	public static boolean isConnected() throws SQLException {
		if (connection == null || connection.isClosed()){
			return false;
		}else {
			return true;
		}
		
	}
	public static Connection getConnection(){
		try {
			if (!isConnected()){
				connect();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
