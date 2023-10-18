package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {

	private Connection conn;
	
	public static Connection mysqlConnection() throws SQLException {
		Connection conn = null;
		String username = "root";
		String password = "root";

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", username, password);
		return conn;

	}

	public void closeCon() throws SQLException {

		if (this.conn != null) {
			this.conn.close();
			System.out.println("Connection Closed");
		} else {
			System.out.println("Con is null");
		}

	}

}
