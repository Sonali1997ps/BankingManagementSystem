package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import dao.DBConnection;

//import JDBCConnection.JDBCoprations;

public class Teller {
	public Teller() {
		super();
	}

	private String password;
	private String username;
	private String query;
	private static Connection conn;

//	public static Connection mmysqlconnection(String username, String password) throws SQLException {
//
//		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", username, password);
//		return conn;
//	}

//	public Teller(String username, String password) throws SQLException {
//		// TODO Auto-generated constructor stub
//		System.out.println("par constructor");
//		username = "root";
//		password = "root";
//		query = "";
//		conn = Teller.mmysqlconnection(username, password);
//		System.out.println(this.conn);
//	}

	public void Register_customer() throws SQLException, NumberFormatException, IOException {
		   Random rand = new Random();
		   
	        // Generate random integers in range 0 to 999
		// Statement stmt=conn.createStatement();
		//
		DBConnection db=new DBConnection();
		Statement stmt = db.getStmt();
		int balance=0;
//		ResultSet rs=null;
		Scanner sc  =  new Scanner(System.in);

		//PreparedStatement pst = conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
	//	PreparedStatement pst1 = conn.prepareStatement("insert into accounts(customer_id,branch_id,account_type_id) values(?,?,?)");

		
		
		

		// rs.next();
		// taking values from keyboard
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Customer ID:");
		int customer_id = sc.nextInt();
		sc.nextLine();

//		System.out.println("Enter login ID:");
//		int login_id =sc.nextInt();
//		sc.nextLine();

		System.out.println("Enter Password:");
		String password = sc.next();
		sc.nextLine();

		System.out.println("enter the name");
		String name = sc.next();
		sc.nextLine();

		System.out.println("Enter phone:");
		String phone = sc.next();
		sc.nextLine();
		System.out.println("Enter email id:");
		String email_id = sc.next();
		sc.nextLine();

		System.out.println("Enter branch id:");
		String branch_id = sc.next();
		sc.nextLine();
		
		System.out.println("Enter Account Type Id:");
		String acc_type = sc.next();
		sc.nextLine();
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date registration_Date =Date.valueOf(LocalDate.now());
//		System.out.println("enter the registration date");
//		String registration_Date = sc.next();
//		sc.nextLine();
		
		int acc_id= rand.nextInt(100000);
		System.out.println(acc_id);
		
		
		stmt.executeUpdate("insert into customer values("+ customer_id+","+customer_id+",'"+password+"','"+name+"','"+phone+"','"+email_id+"','"+registration_Date+"')");
		System.out.println(" Record is inserted in customer");

		stmt.executeUpdate("insert into accounts(account_id,customer_id,branch_id,opening_date,balance,account_type_id) values("+acc_id+",'"+customer_id+"','"+branch_id+"','"+registration_Date+"',"+balance+",'"+acc_type+"')");
		System.out.println(" Record is inserted in accounts");

		// The values are stored in local varables, id, name and salary

		System.out.println(name + " Record is inserted");

	}

	public void veiw_customer_information() throws SQLException {
		DBConnection db=new DBConnection();
		Statement stmt =db.getStmt();

		ResultSet ss = stmt.executeQuery("select * from customer;");
		while (ss.next()) {
			System.out.println("\t" + ss.getObject(1) + "\t" + ss.getObject(2)+ "\t" + ss.getObject(3) + "\t"
					+ ss.getObject(4) + "\t" + ss.getObject(5) + "\t" + ss.getObject(6) + "\t" + ss.getObject(7));

		}

	}

//	public void manage_customer_account() throws SQLException, NumberFormatException, IOException {
//		this.query = query;
//		Statement stmt = conn.createStatement();
//		int ch;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("1.close customer account\n2. block customer account\n3.open customer account");
//		ch = sc.nextInt();
//		switch (ch) {
//		case 1:
//			System.out.println("enter the acoount id to delete the account");
//			Scanner sc1 = new Scanner(System.in);
//			int ac_id = sc1.nextInt();
//			stmt.executeUpdate("delete from accounts where account_id=" + ac_id);
//			break;
//
//		case 2:
//			System.out.println("enter the acoount id to block the account");
//			Scanner sc2 = new Scanner(System.in);
//			int ac_id1 = sc2.nextInt();
//			System.out.println("yet to implement");
////			 stmt.executeUpdate("delete from customer where account_id="+ac_id1);
//			break;
//		case 3:
//			int ch1;
//			Scanner ss = new Scanner(System.in);
//			System.out.println("1.creating new customer account 2.creating existing customer account");
//			ch1 = ss.nextInt();
//
//			switch (ch1) {
//			case 1:
//
//				System.out.println("enter the  valid customer_id to create account");
//				Scanner sc11 = new Scanner(System.in);
//				int customer = sc11.nextInt();
//				// 1 if( PreparedStatement pst = conn.prepareStatement(""+customer);)
//				PreparedStatement pst2 = conn.prepareStatement(
//						"update accounts set branch_id=? ,opening_date=?,balance=?,account_type_id=? where customer_id="
//								+ customer);
//
//				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
//
//				System.out.println("Enter branch_id:");
//				int branch_id = Integer.parseInt(br2.readLine());
//
//				System.out.println("Enter balance:");
//				int balance = Integer.parseInt(br2.readLine());
//
//				System.out.println("Enter opening date");
//				String opening_date = br2.readLine();
//
//				System.out.println("enter the account_type_id");
//				String account_type_id = br2.readLine();
//
//				pst2.setInt(1, branch_id);
//				pst2.setString(2, opening_date);
//				pst2.setInt(3, balance);
//				pst2.setString(4, account_type_id);
//				// stmt.executeUpdate();
//				pst2.executeUpdate();
//				System.out.println("account created sucessfully___________________________________");
//				break;
//			case 2:
//
//				PreparedStatement pst21 = conn.prepareStatement(
//						"insert into accounts(customer_id,branch_id,opening_date,balance,account_type_id) values(?,?,?,?,?)");
//
//				BufferedReader br21 = new BufferedReader(new InputStreamReader(System.in));
//
//				System.out.println("Enter customer_id:");
//				int customer_id1 = Integer.parseInt(br21.readLine());
//
//				System.out.println("Enter branch_id:");
//				int branch_id1 = Integer.parseInt(br21.readLine());
//
//				System.out.println("Enter balance:");
//				int balance1 = Integer.parseInt(br21.readLine());
//
//				System.out.println("Enter opening date");
//				String opening_date1 = br21.readLine();
//
//				System.out.println("enter the account_type_id");
//				String account_type_id1 = br21.readLine();
//
//				pst21.setInt(1, customer_id1);
//				pst21.setInt(2, branch_id1);
//				pst21.setString(3, opening_date1);
//				pst21.setInt(4, balance1);
//				pst21.setString(5, account_type_id1);
//				// stmt.executeUpdate();
//				pst21.executeUpdate();
//				System.out.println("account created sucessfully___________________________________");
//				break;
//			}
//			// stmt.executeUpdate();
//		}
//	}
}
