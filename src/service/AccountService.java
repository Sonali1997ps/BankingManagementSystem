package service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import dao.DBConnection;
import model.Customer;

public class AccountService {

	public void deposit(BigDecimal amt, Date date, String username) throws SQLException {
		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();
		ResultSet rs = null;
		BigDecimal bal = null, newBal = null;

		try {
			rs = rs = stmt.executeQuery("select balance from accounts where customer_id= " + username);
			rs.next();

			bal = (BigDecimal) rs.getObject(1);
			newBal = bal.add(amt);
			System.out.println(newBal);
			stmt.executeUpdate("update accounts set balance= " + newBal+ " where customer_id= " + username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void withdrawal(BigDecimal amt, Date date, String username) throws SQLException {
		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();
		ResultSet rs = null;
		BigDecimal bal = null, newBal = null;

		try {
			rs = rs = stmt.executeQuery("select balance from accounts where customer_id= " + username);
			rs.next();

			bal = (BigDecimal) rs.getObject(1);
			newBal = bal.subtract(amt);
			System.out.println(newBal);
			stmt.executeUpdate("update accounts set balance= " + newBal+ " where customer_id= " + username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void getDetails(String username) throws SQLException {
		
		Customer cs=new Customer();

		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();
		ResultSet rs = null;
		
		try {
			rs = rs = stmt.executeQuery("select * from customer where customer_id= " + username);
			rs.next();
			ResultSetMetaData md = rs.getMetaData();
	        int columns = md.getColumnCount();
	        
	        
	        for(int i=4; i<=columns;i++) {
			
	        	System.out.println(rs.getObject(i).toString());
//			System.out.println(rs.getObject(5).toString());
//			System.out.println(rs.getObject(6).toString());
//			System.out.println(rs.getObject(7).toString());

	        }
		} catch (Exception e) {
			System.out.println("Some Error Occured!!");
			System.out.println("Try Again After Sometime");

			//System.out.println(e.getMessage());
		}
	}

}
