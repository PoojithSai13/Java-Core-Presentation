package MavenHibernate.Poojith;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//(name="Specific table name which we want==Table name AS Query")EX:(name="Student_details")
//@Table(name="Specific table name which we want==Table name AS Query")EX:(name="Student_details")
public class student 
{
	@Id
	private long id;
	//@Column(name=My_students)
	private String name;
	//@Transient
	private int rollno;
	private String degree;
	private int phone;
	
	public student() 
	{
		super();
	}
	
	public student(long id, String name, int rollno, String degree, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.degree = degree;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() 
	{
		return "student [id=" + id + ", name=" + name + ", rollno=" + rollno + ", degree=" + degree + ", phone=" + phone+ "]";
	}
	
	
	
}
