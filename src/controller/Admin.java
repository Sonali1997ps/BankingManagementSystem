package controller;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

 

public class Admin {

 

	private String password;

	private String username;

	private String query;

	private static Connection conn;

 

	public static Connection mmysqlconnection(String username, String password) throws SQLException {

 

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", username, password);

		return conn;

	}

 

	public Admin(String username, String password) throws SQLException {

		// TODO Auto-generated constructor stub

		System.out.println("par constructor");

		username = "root";

		password = "root";

		query = "";

		conn = Admin.mmysqlconnection(username, password);

		System.out.println(this.conn);

 

	}

 

	public void veiw_manager_customer_detalis() throws SQLException {

		int ch;

		Scanner sc = new Scanner(System.in);

 

		System.out.println("1.view manager details 2. veiw customer details");

		ch = sc.nextInt();

		switch (ch) {

		case 1:

			int manager_id;

			Scanner sc1 = new Scanner(System.in);

 

			System.out.println("enter the manager id to see manager details");

			manager_id = sc1.nextInt();

			Statement stmt = conn.createStatement();

 

			ResultSet ss = stmt.executeQuery("select * from employee where manager_id=" + manager_id);

			while (ss.next()) {

				System.out.println("   " + ss.getInt(1) + "          " + ss.getString(2) + "          "

						+ ss.getString(3) + "     " + ss.getString(4) + "        " + ss.getString(5) + "     "

						+ ss.getInt(6) + "      " + ss.getInt(7));

 

			}

			break;

		case 2:

			int customer_id;

			Scanner sc11 = new Scanner(System.in);

 

			System.out.println("enter the customer id to see customer details");

			customer_id = sc11.nextInt();

			Statement stmt1 = conn.createStatement();

 

			ResultSet ss1 = stmt1.executeQuery("select * from customer where customer_id=" + customer_id);

			while (ss1.next()) {

				System.out.println("   " + ss1.getInt(1) + "          " + ss1.getInt(2) + "          "

						+ ss1.getString(3) + "     " + ss1.getString(4) + "        " + ss1.getString(5) + "     "

						+ ss1.getString(6) + "      " + ss1.getString(7));

 

			}

			break;

		}

 

	}

 

	public void Add_or_update_bank_branch_details() throws IOException, SQLException {

		int choice;

		Scanner sc = new Scanner(System.in);

		System.out.println("1.add bank branch details\n 2.update  bank branch details");

		choice = sc.nextInt();

		switch (choice) {

		case 1:

 

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

			break;

 

		case 2:

			String branch_id1;

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

				PreparedStatement pst3 = conn

						.prepareStatement("update branch set address=? where branch_id=" + branch_id1);

 

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

				PreparedStatement pst4 = conn

						.prepareStatement("update branch set phone=? where branch_id=" + branch_id1);

 

				BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));

 

				System.out.println("Enter phone no.:");

				String phone5 = br5.readLine();

 

				pst4.setString(1, phone5);

				pst4.executeUpdate();

				System.out.println("sucessfully updates the record");

				break;

			}

 

		}

 

	}

 

	public void Add_or_update_manager_details() throws SQLException, NumberFormatException, IOException {

		int ch;

		Scanner sc = new Scanner(System.in);

 

		System.out.println("1.set manager details\n2.update manager id");

		ch = sc.nextInt();

 

		switch (ch) {

		case 1:

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

			break;

		case 2:

			int id1;

			System.out.println("enter the manager id to update it:");

			id1 = sc.nextInt();

			PreparedStatement pst5 = conn.prepareStatement("update employee set manager_id=? where manager_id=" + id1);

 

			BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));

 

			System.out.println("Enter manager id :");

			int manager_id1 = Integer.parseInt(br6.readLine());

 

			pst5.setInt(1, manager_id1);

			pst5.executeUpdate();

			System.out.println("sucessfully updates the record");

			break;

		}

 

	}

}
