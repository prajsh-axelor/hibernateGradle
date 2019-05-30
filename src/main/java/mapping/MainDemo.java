package mapping;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate_mapping.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		session.beginTransaction();
		
		int id = 2;
		
		InstructorDetail instD = session.get(InstructorDetail.class, id);
		
		System.out.println(instD+"\n"+instD.getInstructor());
		
//		session.delete(instD);
		
		Query q = session.createQuery("delete from InstructorDetail where hobby=:m");
		q.setParameter("m", "mystry solving");
		q.executeUpdate();
		
//		session.createQuery(m).executeUpdate();
			
		session.getTransaction().commit();
		
//		System.out.println(inst+"\n"+inst.getInstructorDetail());
		
		System.out.print("Done!!");
		
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
		finally {
			factory.close();
		}

	}

}
