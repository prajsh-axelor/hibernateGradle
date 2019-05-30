package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate_mapping.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		Instructor tempInstructor = new Instructor("parry", "the platipus", "parrytheplatipus@spy.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("sypretro","mystry solving");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
	
		session.beginTransaction();
		
		session.save(tempInstructor);
		
		session.getTransaction().commit();
		
		System.out.println(tempInstructor+"\n"+tempInstructorDetail);
		System.out.print("Done!!");
		
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
		finally {
			factory.close();
		}

	}

}
