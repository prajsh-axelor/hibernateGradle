package manytooneMappingDemo;

import manytooneMappingEntity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate_manytoonemapping.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 5;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			// create some courses
			Course tempCourse1 = new Course("Being Geek : how to learn everything faster");
			Course tempCourse2 = new Course("The hiTech course: Everything you want to know about new tech world");
			Course tempCourse3 = new Course("SuperSaiyan studies : tips to concentrate better");
			
			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			tempInstructor.add(tempCourse3);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





