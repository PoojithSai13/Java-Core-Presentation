package MavenHibernate.Poojith;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	student s=new student();
    	s.setId(6);
    	s.setName("Pramodh");
    	s.setRollno(107);
    	s.setDegree("BTech");
    	s.setPhone(6848849);
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(student.class);
    	ServiceRegistry ser=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf=con.buildSessionFactory(ser);
    	Session session= sf.openSession();
    	Transaction tx=session.beginTransaction();
    	session.save(s);
    	
    	tx.commit();
    }
}
