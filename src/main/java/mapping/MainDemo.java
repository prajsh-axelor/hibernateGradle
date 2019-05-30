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
		
		int id = 3;
		
		InstructorDetail instD = session.get(InstructorDetail.class, id);
		
		System.out.println("1"+ instD+"\n"+instD.getInstructor());
		
		session.delete(instD);
		
//		session.createQuery("delete from InstructorDetail where hobby=:m").executeUpdate();
		
		System.out.println("2"+instD+"\n"+instD.getInstructor());
		
		session.getTransaction().commit();
		
		System.out.println("3"+instD+"\n"+instD.getInstructor());
//		System.out.println(inst+"\n"+inst.getInstructorDetail());
		
		System.out.print("Done!!");
		
		} finally {
			factory.close();
		}

	}

}
