package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {

	private Connection conn;
	private Statement stmt;
	
	public DBConnection() throws SQLException {
		super();
		String username = "root";
		String password = "root";
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", username, password);
		this.stmt = conn.createStatement();
		
		System.out.println("DB Connected");
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setSt(Statement stmt) {
		this.stmt = stmt;
	}

	public void closeCon() throws SQLException {

		if (this.conn != null) {
			this.conn.close();
			System.out.println("Connection Closed");
		} else {
			System.out.println("Con is null");
		}

	}

	public int update(String query) throws SQLException {
		
		System.out.println("Updated table ");
		return stmt.executeUpdate(query);
		
	}

	public void remove(String tableName, String columnName, String value) throws SQLException {
		
		stmt.executeUpdate("delete from " + tableName + " where " + columnName + " = " + value);
		System.out.println("deleted entry for " + columnName +" = "+ value + " from table " + tableName);
		
	}
	
	
	public ResultSet getResultSet(String tableName, String columnName, String value) throws SQLException {

		ResultSet rs=stmt.executeQuery("select * from " + tableName + " where " + columnName + " = " + value);

		return rs;
	}	
//      ArrayList columnNames = new ArrayList();
//      ArrayList data = new ArrayList();
//		ResultSetMetaData md = rs.getMetaData();
//        int columns = md.getColumnCount();
//        //  Get column names
//        for (int i = 1; i <= columns; i++)
//        {
//            columnNames.add( md.getColumnName(i) );
//        }
//        //  Get row data
//        while (rs.next())
//        {
//            ArrayList row = new ArrayList(columns);
//
//            for (int i = 1; i <= columns; i++)
//            {
//                row.add( rs.getObject(i));
//            }
//            System.out.println(row);
////            data.add(row);
//        }
	
}
