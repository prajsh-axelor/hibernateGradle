package hibernateGradle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateGradle.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("updating a new student object");
			
			session.beginTransaction();

//			//updating the value in the database
//			int studentId = 1;
//			Student myStudent = session.get(Student.class, studentId);
//			myStudent.setFirstName("PRAJJWAL");
//			
//			System.out.println(myStudent.getEmail());
//			
//			
			
			//Updating in more than one line and according to some specific conditions
			System.out.println("updating the email where the lastname is goku");
			session.createQuery("update Student set email='admin@geekygoku.com'  where lastName='Gohan'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
