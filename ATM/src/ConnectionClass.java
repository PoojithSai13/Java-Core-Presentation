import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass
{
	Statement st=null;
	ResultSet rs=null;
	Connection con=null;
	
	int customerId=0;
	int BalanceMoney=0;
	
	public ConnectionClass() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank?characterEncoding=latin1","root","Poojith@13");
			System.out.println("Success....!!!!");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public boolean login(String name,String password) throws SQLException 
	{
		st=con.createStatement();
		rs=st.executeQuery("select * from customer where customerName='"+name+"' and customerPassword='"+password+"'");
		if(rs.next()) 
		{
			customerId=rs.getInt("customerId");
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int GetBalance(int Id) throws SQLException 
	{
		rs=st.executeQuery("select balanceAmount from account where customerId="+Id+"");
		if(rs.next()) 
		{
			BalanceMoney=rs.getInt("balanceAmount");
			return BalanceMoney;
		}
		else 
		{
			return 0;
		}
		
	}
	public boolean Withdraw(int Id,int amount) throws SQLException 
	{
		if(amount>BalanceMoney) 
		{
			System.out.println("Can't dispense all amount");
			return false;
		}
		else 
		{
			st.executeUpdate("update account set balanceAmount="+(BalanceMoney-amount)+" where customerId="+Id);
			return true;
		}
	}
	
	public boolean deposit(int Id,int amount) throws SQLException 
	{
		int a=st.executeUpdate("update account set balanceAmount="+(BalanceMoney+amount)+" where customerId="+Id);
		if(a==1) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public boolean newaccount(int Id,String name,String password, int amount) throws SQLException 
	{
		
		int ra=st.executeUpdate("insert into customer(customerId,customerName,customerPassword,customerAge) values("+(Id)+","+(name)+","+(password)+","+(amount)+")");
		if(ra==1) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	

}
