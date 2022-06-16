package Employe;
import java.sql.*;
import java.util.Scanner;
public class Employee 
{
	public void insert() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1jdev","root","Poojith@13");Statement St=con.createStatement();)
		{
			String query = "insert into employ values(10,'Saikiran',2021,'capgemini')";
			int count = St.executeUpdate(query);
			if(count==0) 
			{
				System.out.println("Not Inserted");
			} 
			else 
			{
				System.out.println("Inserted");
			}
		}
		catch(SQLException Se) 
		{
			System.out.println(Se.getMessage());
			Se.printStackTrace();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void Select() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1jdev","root","Poojith@13");Statement St=con.createStatement();)
		{
			String query = "select * from employ";
			ResultSet rs=St.executeQuery(query);
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			
		}
		catch(SQLException Se) 
		{
			System.out.println(Se.getMessage());
			Se.printStackTrace();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	public void update() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1jdev","root","Poojith@13");Statement St=con.createStatement();)
		{
			String query = "update employ set name='sunjay' where id=10 ";
			int count = St.executeUpdate(query);
			if(count==0) 
			{
				System.out.println("Not Updated");
			} 
			else 
			{
				System.out.println("Updated");
			}
		}
		catch(SQLException Se) 
		{
			System.out.println(Se.getMessage());
			Se.printStackTrace();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void delete() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1jdev","root","Poojith@13");Statement St=con.createStatement();)
		{
			String query = "delete from employ where id=10";
			int count = St.executeUpdate(query);
			if(count==0) 
			{
				System.out.println("Not Deleted");
			} 
			else 
			{
				System.out.println("Deleted");
			}
		}
		catch(SQLException Se) 
		{
			System.out.println(Se.getMessage());
			Se.printStackTrace();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) 
	{
		Employee E= new Employee();
		System.out.println("***Employ Details***");
		System.out.println("***please enter numbers between(1-4) for the CRUD operation you required ;) ***");
		System.out.println("***Enter corresponding number(1.Create/Insert, 2.Read/Select, 3.Update, 4.Delete)***");
		Scanner s=new Scanner(System.in);
		int Opp=s.nextInt();
		switch(Opp) 
		{
		case 1:
			E.insert();
			break;
		case 2:
			E.Select();
			break;
		case 3:
			E.update();
			break;
		case 4:
			E.delete();
			break;
		default:
			System.out.println("***Inalid Input please Enter numbers (1-4)***");
		}
		s.close();
		
	}

}
