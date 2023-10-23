package controller;



import java.io.IOException;

import java.sql.SQLException;

import java.util.Scanner;

 

public class TestMainAdmin {

 

	public static void main(String[] args) throws SQLException, IOException {

		// TODO Auto-generated method stub

 

		Admin ad = new Admin("root", "root");

		int ch;

		Scanner sc = new Scanner(System.in);

		System.out.println(

				"1. veiw MANAGER OR CUSTOMER details\n2.add bank details or update bank branch details\n3.Add or update manager details");

		ch = sc.nextInt();

		switch (ch) {

		case 1:

 

			ad.veiw_manager_customer_detalis();

			break;

		case 2:

 

			ad.Add_or_update_bank_branch_details();

			break;

		case 3:

			ad.Add_or_update_manager_details();

			break;

 

		}

	}

 

}
