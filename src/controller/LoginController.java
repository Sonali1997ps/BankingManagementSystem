package controller;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import dao.DBConnection;
import model.Account;
import model.Customer;
import service.AccountService;
import service.Bank;

public class LoginController {

	public static void main(String[] args) throws SQLException {

		Customer cs = new Customer();
		Account ac = new Account();
		Teller t1 = new Teller();
		AccountService as = new AccountService();
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		Statement stmt = db.getStmt();
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String username, password;
		BigDecimal amount = null;
		String role = null;
		// String custId=null;
		// Bank bank = new Bank();

		int choice;
		outer: while (true) {
			try {
				System.out.println("\n-------------------");
				System.out.println("     ");

				System.out.println("1. Login.");
				System.out.println("2. Exit.");
				System.out.println("-------------------\n");

				System.out.print("\nEnter your choice : ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {

				case 1:

					System.out.println("Enter Role (Admin/Teller/Customer) : ");
					role = sc.next();
					System.out.println("Enter username : ");
					username = sc.next();
					sc.nextLine();
					System.out.println("Enter password : ");
					password = sc.next();

					rs = stmt.executeQuery("select password,role from login where customer_id= " + username);
					rs.next();

					if (rs != null && rs.getObject(2).toString().equalsIgnoreCase(role)) {
						if (rs.getObject(1).equals(password)) {
							System.out.println("Successfully Logged In... ");

							if (role.equalsIgnoreCase("Customer")) {
								while (true) {
									System.out.println("\n-------------------");
									System.out.println("W  E  L  C  O  M  E");
									System.out.println("-------------------\n");
									System.out.println("1. Deposit.");
									System.out.println("2. Withdraw.");
									System.out.println("3. Money Transfer");
									System.out.println("4. User information.");
									System.out.println("5. Log out.");
									System.out.print("\nEnter your choice : ");
									choice = sc.nextInt();
									sc.nextLine();

									switch (choice) {
									case 1:
										System.out.print("Enter amount to deposit : ");
										amount = sc.nextBigDecimal();
										as.deposit(amount, new Date(), username);
										break;
									case 2:
										System.out.print("Enter amount to be withdraw: ");
										amount = sc.nextBigDecimal();
										as.withdrawal(amount, new Date(), username);
										break;
									case 3:
										as.transfer(username, password);
										break;
									case 4:
										as.getDetails(username);

										break;
									case 5:
										continue outer;
									default:
										System.out.println("Wrong choice !");
										continue;
									}
								}
							} else if (role.equalsIgnoreCase("Teller")) {

								while (true) {
									System.out.println("\n-------------------");
									System.out.println("W  E  L  C  O  M  E");
									System.out.println("-------------------\n");
									System.out.println("1. Register Customer");
									System.out.println("2. Veiw Existing Customers");
									// System.out.println("3. Manage Customers");
									System.out.println("3. Log out.");
									System.out.print("\nEnter your choice : ");
									choice = sc.nextInt();
									sc.nextLine();

									switch (choice) {

									case 1:
										t1.Register_customer();
										break;
									case 2:
										System.out.println(
												"Customer_id\tLogin_id\tPassword\tName\tPhone\tEmail_id\tRegistration_Date");
										t1.veiw_customer_information();
										break;
									case 3:
										continue outer;

									default:
										System.out.println("Wrong choice !");
										continue;

									}
								}

							} else if (role.equalsIgnoreCase("Admin")) {

								while (true) {
//								System.out.println(
//										"1. veiw MANAGER OR CUSTOMER details\n2.add bank details or update bank branch details\n3.Add or update manager details");
									System.out.println("1.view manager details\n2. veiw customer details");
									System.out.println("\n3.set manager details\n4.update manager id");
									System.out.println("\n5.add bank branch details\n 6.update  bank branch details");
									System.out.println("\n7.Close Account\n8. Log out.");

									choice = sc.nextInt();
									switch (choice) {
									case 1:

										as.viewManagerDetails();
										break;
									case 2:

										as.viewCustomerDetails();
										break;
									case 3:
										as.addManagerDetails();
										;
										break;
									case 4:
										as.updateManagerDetails();
										break;
									case 5:
										as.addBranch();
										break;
									case 6:
										as.updateBranch();
										break;
									case 7:
										as.closeAccount();
										break;
									case 8:
										continue outer;
									}
								}
							}

						} else {
							System.out.println("Wrong Password!!");
							continue;
						}
					} else {

						System.out.println("This " + username + " doesn't have " + role + " access!! ");
						continue;
					}

				case 2:
					System.out.println("\nThank you for choosing our Bank.");
					System.exit(1);
					break;
				default:
					System.out.println("Wrong choice !");
				}
			} catch (Exception e) {
				// System.out.println(e.getMessage());
				if (e.getMessage().contains("Illegal operation on empty result set")) {
					System.out.println("Kindly Enter correct username and password!!");
					continue outer;
				} else if (e.getMessage() == null) {

				}

				else {

					System.out.println(e.getMessage());
					System.out.println("Some Error Occured!!");
					System.out.println("Try Again After Sometime");
				}
			}
		}

	}
}
