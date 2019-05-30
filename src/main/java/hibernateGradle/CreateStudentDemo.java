package hibernateGradle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateGradle.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
//		Session session = factory.getCurrentSession();  //works if this line is in the configuration file 
														// // // // <property name="hibernate.current_session_context_class">thread</property>
//		Session session = factory.openSession();
		
		try {
			System.out.println("Creating a new student object");
			//create a student object
			Student tempStudent = new Student("saveeing","fund","savingfunds@gmail.com");
			
//			//create a transaction
//			session.beginTransaction();
//			//save the student object
//			System.out.println("Saving the student");
//			session.save(tempStudent);
			
			Session sessionn = factory.openSession();
			sessionn.beginTransaction();
			sessionn.saveOrUpdate("from Student where firstName='saving");
			sessionn.getTransaction().commit();
			
			//commit transaction
//			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
