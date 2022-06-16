package MavenHibernate.Poojith;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.Transaction;

public class mainfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
			SessionFactory sfactory=cfg.buildSessionFactory();
				Session session=sfactory.openSession();
					student stu=new student();
					stu.setId(1002);
					stu.setName("Jishnu1");
					stu.setRollno(1);
					stu.setDegree("Bsc");
					stu.setPhone(55545);
					Transaction tx=session.beginTransaction();
					session.save(stu);
					System.out.println("student object saved");
					tx.commit();
				session.close();
			sfactory.close();

	}

}
