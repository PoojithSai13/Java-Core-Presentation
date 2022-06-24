import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bank
{
	static int customerId;
	Statement st=null;
	ResultSet rs=null;
	static Connection con=null;
	
	public static void main(String []args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Poojith@13");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter id");
		customerId =sc.nextInt();
		System.out.println("Enter customer name: ");
		String customerName =sc.next();
		System.out.println("Enter customer password: ");
		String customerPassword =sc.next();
		System.out.println("Enter customer age: ");
		int customerAge =sc.nextInt();
		sc.nextLine();


		
		String query = "INSERT INTO customer(customerId,customerName,customerPassword,customerAge) VALUES (?, ?, ?, ?)";
	    PreparedStatement pstmt = con.prepareStatement(query);
	    pstmt.setInt(1, customerId);
	    pstmt.setString(2, customerName);
	    pstmt.setString(3, customerPassword);
	    pstmt.setLong(4, customerAge);
	    
	    int i= pstmt.executeUpdate();
	    
		if(i==1)
		{
			System.out.println("customer created a new account Successfully");
		}
		else 
		{
			System.out.println("new account creation Unsuccessfull");
		}
		
		
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter Account Type (Savings or Current): ");
		String accountType =sc1.next();
		System.out.println("Enter money to create the account: ");
		Integer balanceAmount=sc1.nextInt();

		
		String query1 = "INSERT INTO account(customerId,accountType,balanceAmount) VALUES (?, ?, ?)";
	    PreparedStatement pstmt1 = con.prepareStatement(query1);
	    pstmt1.setInt(1, customerId);
	    pstmt1.setString(2, accountType);
	    pstmt1.setInt(3, balanceAmount);
	    
	    int j= pstmt1.executeUpdate();
	    
		if(j==1)
		{
			System.out.println("Account Initiated Successfully ");
		}
		else 
		{
			System.out.println("Account Initiation Unsuccessfull");
		}
		con.close();
		sc1.close();
		sc.close();
		
		
	}

}