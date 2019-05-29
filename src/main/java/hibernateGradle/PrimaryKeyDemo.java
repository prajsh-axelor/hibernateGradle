package hibernateGradle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateGradle.Student;

public class PrimaryKeyDemo {
	public static void main(String [] args) {
				//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				Session session = factory.getCurrentSession();
				
				try {
					System.out.println("Creating 3 new student object");
					//create 3 student object
					Student tempStudent1 = new Student("Kinjal","Singh","kinjal@gmail.com");
					Student tempStudent2 = new Student("Prerna","Singh","prerna@gmail.com");
					Student tempStudent3 = new Student("Satyam","Singh","satyam@gmail.com");

					//create a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the students");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}



	}
}
