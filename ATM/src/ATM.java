import java.sql.SQLException;
import java.util.Scanner;

public class ATM
{
	Scanner s=new Scanner(System.in);
	ConnectionClass cid;
	
	public ATM() 
	{
		cid=new ConnectionClass();
	}
	
	public void Login() throws SQLException 
	{
		System.out.println("Enter Customer Name: ");
		String name=s.next();
		System.out.println("Enter Your PassWord: ");
		String password=s.next();
		boolean flag=cid.login(name, password);
		if(flag) 
		{
			System.out.println("Logged in");
		}
		else 
		{
			System.out.println("Login failed, Try again");
			Login();
		}
	}
	
	public void display() throws SQLException 
	{
		System.out.println("***************MENU***************");
		System.out.println("1.Check Balance");
		System.out.println("2.Withdraw Money");
		System.out.println("3.Diposit Money");
		System.out.println("4.Logout");
		System.out.println("**********************************");
		System.out.println("Select your Choice: ");
		int choice=s.nextInt();
		switch(choice) 
		{
		case 1:
			checkbalance();
			break;
		case 2:
			withdrawmoney();
			break;
		case 3:
			dipositmoney();
			break;
		case 4:
			logout();
			break;
		default:
			System.out.println("Enter valid input!!");
		}
	}
	
	public void checkbalance() throws SQLException 
	{
		int balance=cid.GetBalance(cid.customerId);
		System.out.println("total balance in the account is: "+balance);
		display();
	}
	public void withdrawmoney() throws SQLException
	{
		System.out.println("Enter the anount to withdrawn:");
		int amount=s.nextInt();
		boolean flag=cid.Withdraw(cid.customerId, amount);
		if(flag) 
		{
			System.out.println("Take your money: "+amount);
			display();
		}
		else 
		{
			System.out.println("Not enough money in your account!!");
		}
	}
	
	public void dipositmoney() throws SQLException 
	{
		System.out.println("Enter the amount you have to diposit: ");
		int amount=s.nextInt();
		boolean flag=cid.deposit(cid.customerId, amount);
		if(flag) 
		{
			System.out.println("Successfully deposited your money: "+amount);
			display();
		}
	}

	public void logout()
	{
		System.out.println("Good bye!!!");
		System.out.println("Thank you for using our ATM!!!");
		System.exit(0);
	}

	
	public static void main(String[] args) throws SQLException 
	{
		ATM A1=new ATM();
		A1.Login();
		A1.display();

	}

}
