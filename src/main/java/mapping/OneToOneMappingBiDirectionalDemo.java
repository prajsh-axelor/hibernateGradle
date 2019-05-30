package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingBiDirectionalDemo {

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
//		Instructor inst = session.get(Instructor.class, id);
		
		InstructorDetail instD = session.get(InstructorDetail.class, id);
		
			
		session.getTransaction().commit();
		
//		System.out.println(inst+"\n"+inst.getInstructorDetail());
		System.out.println(instD+"\n"+instD.getInstructor());
		System.out.print("Done!!");
		
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
		finally {
			factory.close();
		}

	}

}
