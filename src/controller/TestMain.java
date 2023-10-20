package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//import teller.Teller;

public class TestMain {

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
Teller t1=new Teller("root","root");
int choice;
System.out.println("1.Register_customer\n2.veiw customer information\n3.manage customer ");
Scanner sc=new Scanner(System.in);
choice=sc.nextInt();
switch(choice) {

   case 1:
	   t1.Register_customer();
	   break;
   case 2:
	   System.out.println("customer_id  login_id  password  name       phone   email_id  registration_no.");
	   t1.veiw_customer_information();
	   break;
   case 3:
	   t1.manage_customer_account();
	
}


	}

}

