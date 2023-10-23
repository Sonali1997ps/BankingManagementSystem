package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import dao.DBConnection;
import model.Customer;

public class AccountService {

	public void transfer(String username, String password) throws SQLException {

		DBConnection db = new DBConnection();

		Statement stmt = db.getStmt();

		ResultSet rs = null;

		BigDecimal bal = null, newBal = null;

		BigDecimal benBal = null, newBenBal = null;

		try {

			System.out.println("Enter Beneficiary's Customer Id: ");

			Scanner sc = new Scanner(System.in);

			String benCustId = sc.next();

			System.out.println("Enter Amount to be transfered : ");

			BigDecimal amt = sc.nextBigDecimal();

			System.out.println("Enter password : ");

			String pw = sc.next();

			if (password.equals(pw)) {

				rs = rs = stmt.executeQuery("select balance from accounts where customer_id= " + username);

				rs.next();

				bal = (BigDecimal) rs.getObject(1);

				newBal = bal.subtract(amt);

				if (newBal.compareTo(BigDecimal.ZERO) < 0) {
					System.out.println("Insufficient Balance!!");
				} else {
					stmt.executeUpdate("update accounts set balance= " + newBal + " where customer_id= " + username);

					rs = stmt.executeQuery("select balance from accounts where customer_id= " + benCustId);

					rs.next();

					benBal = (BigDecimal) rs.getObject(1);

					newBenBal = bal.add(amt);

					// System.out.println(newBal);

					stmt.executeUpdate(
							"update accounts set balance= " + newBenBal + " where customer_id= " + benCustId);
					System.out.println("Money transferred Successfully!!");

				}

			} else {

				System.out.println("Incorrect Password!!");

			}

		} catch (Exception e) {

			System.out.println("Enter Correct Beneficiary customer ID!!");

		}

	}

	public void closeAccount() throws SQLException {
		DBConnection db = new DBConnection();

		Statement stmt = db.getStmt();
		System.out.println("enter the acoount id to delete the account");
		Scanner sc1 = new Scanner(System.in);
		int ac_id = sc1.nextInt();
		stmt.executeUpdate("delete from accounts where account_id=" + ac_id);
	}

	public void updateBranch() throws SQLException, IOException {
		DBConnection db = new DBConnection();
		Connection conn = db.getConn();

		String branch_id1;
		Scanner sc = new Scanner(System.in);

		int ch;
		System.out.println("1.update branch id\n2.update address\n3.update phone no ");
		ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("enter branch id which u want to update");
			branch_id1 = sc.next();
			PreparedStatement pst2 = conn
					.prepareStatement("update branch set branch_id=? where branch_id=" + branch_id1);

			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter branch ID:");
			String branch_id11 = br3.readLine();
			pst2.setString(1, branch_id11);
			pst2.executeUpdate();

			System.out.println("sucessfully updates the record");

			break;
		case 2:
			System.out.println("enter branch id to update address");
			branch_id1 = sc.next();
			PreparedStatement pst3 = conn.prepareStatement("update branch set address=? where branch_id=" + branch_id1);

			BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter address:");
			String address1 = br4.readLine();

			pst3.setString(1, address1);
			pst3.executeUpdate();
			System.out.println("sucessfully updates the record");
			break;
		case 3:
			System.out.println("enter branch id to update phone no.");
			branch_id1 = sc.next();
			PreparedStatement pst4 = conn.prepareStatement("update branch set phone=? where branch_id=" + branch_id1);

			BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter phone no.:");
			String phone5 = br5.readLine();

			pst4.setString(1, phone5);
			pst4.executeUpdate();
			System.out.println("sucessfully updates the record");

		}
	}

	public void addBranch() throws SQLException, IOException {
		DBConnection db = new DBConnection();
		Connection conn = db.getConn();
		PreparedStatement pst = conn.prepareStatement("insert into branch values(?,?,?)");
		PreparedStatement pst1 = conn.prepareStatement("insert into employee(branch_id) values(?)");

		// taking values from keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter branch ID:");
		String branch_id = br.readLine();

		System.out.println("Enter address:");
		String address = br.readLine();

		System.out.println("Enter phone:");
		String phone = br.readLine();

		pst.setString(1, branch_id);
		pst.setString(2, address);
		pst.setString(3, phone);
		pst1.setString(1, branch_id);
		pst.executeUpdate();
		pst1.executeUpdate();
		// pst.executeUpdate();
		System.out.println("sucessfully added bank branch details");
	}

	public void updateManagerDetails() throws SQLException, NumberFormatException, IOException {
		int id1;
		DBConnection db = new DBConnection();
		Connection conn = db.getConn();
		Scanner sc = new Scanner(System.in);

		System.out.println("enter the manager id to update it:");
		id1 = sc.nextInt();
		PreparedStatement pst5 = conn.prepareStatement("update employee set manager_id=? where manager_id=" + id1);

		BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter manager id :");
		int manager_id1 = Integer.parseInt(br6.readLine());

		pst5.setInt(1, manager_id1);
		pst5.executeUpdate();
		System.out.println("sucessfully updates the record");
	}

	public void addManagerDetails() throws SQLException, NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		DBConnection db = new DBConnection();
		Connection conn = db.getConn();
		int id;
		System.out.println("enter the emp id of manager");
		id = sc.nextInt();
		PreparedStatement pst4 = conn.prepareStatement("update employee set manager_id=? where emp_id=" + id);

		BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter manager id :");
		int manager_id = Integer.parseInt(br5.readLine());

		pst4.setInt(1, manager_id);
		pst4.executeUpdate();
		System.out.println("sucessfully added the record");
	}

	public void viewCustomerDetails() throws SQLException {
		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();

		int customer_id;
		Scanner sc11 = new Scanner(System.in);

		System.out.println("enter the customer id to see customer details");
		customer_id = sc11.nextInt();
//		Statement stmt1 = conn.createStatement();

		ResultSet ss1 = stmt.executeQuery("select * from customer where customer_id=" + customer_id);
		while (ss1.next()) {
			System.out.println("   " + ss1.getInt(1) + "          " + ss1.getInt(2) + "          " + ss1.getString(3)
					+ "     " + ss1.getString(4) + "        " + ss1.getString(5) + "     " + ss1.getString(6) + "      "
					+ ss1.getString(7));

		}
	}

	public void viewManagerDetails() throws SQLException {
		int ch;
		Scanner sc = new Scanner(System.in);
		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();

		int manager_id;
		Scanner sc1 = new Scanner(System.in);

		System.out.println("enter the manager id to see manager details");
		manager_id = sc1.nextInt();
		// Statement stmt = conn.createStatement();

		ResultSet ss = stmt.executeQuery("select * from employee where manager_id=" + manager_id);
		while (ss.next()) {
			System.out.println("   " + ss.getInt(1) + "          " + ss.getString(2) + "          " + ss.getString(3)
					+ "     " + ss.getString(4) + "        " + ss.getString(5) + "     " + ss.getInt(6) + "      "
					+ ss.getInt(7));

		}
	}

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
			stmt.executeUpdate("update accounts set balance= " + newBal + " where customer_id= " + username);
			System.out.println("Amount deposited Successfully!!");

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
			if (newBal.negate() != null) {
				System.out.println("Insufficient Balance!!");
			} else {
				System.out.println(newBal);
				stmt.executeUpdate("update accounts set balance= " + newBal + " where customer_id= " + username);
				System.out.println("Amount Withdrawn Successfully!!");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getDetails(String username) throws SQLException {

		Customer cs = new Customer();

		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();
		ResultSet rs = null;

		try {
			rs = rs = stmt.executeQuery(
					"select c.name,c.phone,c.email_id ,a.account_id,a.customer_id,a.branch_id, a.opening_date,a.balance from accounts a inner join customer c on a.customer_id=c.customer_id where a.customer_id="
							+ username);
			rs.next();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			System.out.println(" \t Name \t Phone \t Email id \t Account_id \t Customer_id \t balance");
			for (int i = 1; i <= columns; i++) {

				System.out.print("\t" + rs.getObject(i).toString());

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some Error Occured!!");
			System.out.println("Try Again After Sometime");

		}
	}

}
