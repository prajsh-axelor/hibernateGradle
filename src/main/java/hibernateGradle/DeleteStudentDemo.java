package hibernateGradle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateGradle.Student;

public class DeleteStudentDemo {

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

////			//updating the value in the database
//			int studentId = 4;
//			Student myStudent = session.get(Student.class, studentId);
//			
//			//deleting the student
//			System.out.println("Deleting student");
//			session.delete(myStudent);
			
			session.createQuery("delete from Student where lastName='leelgar'").executeUpdate();
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();	
		}

	}

}
