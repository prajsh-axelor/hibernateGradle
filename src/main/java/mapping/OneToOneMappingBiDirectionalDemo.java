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
			
			
			// // forward one to one mapping
//			Instructor tempInstructor = new Instructor("A inst -> instD", "son", "goku@supersiyan.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("A","increasing the fighting capabilities");
//			
//			tempInstructor.setInstructorDetail(tempInstructorDetail);
//			System.out.println(tempInstructor);
//			
//			session.save(tempInstructor);
			
			
//			int theId = 10;
//			InstructorDetail tempInstD = session.get(InstructorDetail.class, theId);
//			
//			System.out.println("tempInstructorDetail : "+tempInstD);
//			
//			System.out.println("the associated instructor : "+tempInstD.getInstructor());
//			
//			
			
			
////			//backward one to one mapping
			Instructor tempInstructorr = new Instructor("C instD -> inst", "son", "gohan@supersiyan.com");
			InstructorDetail tempInstructorDetaill = new InstructorDetail("C","reading and inventing");
			
			session.save(tempInstructorDetaill);
			session.getTransaction().commit();
			
			
			System.out.println("Saved student. Generated id: "+tempInstructorDetaill.getId());
			
			tempInstructorr.setInstructorDetail(tempInstructorDetaill);
			
//			tempInstructorDetaill.setInstructor(tempInstructorr);
//			System.out.println(tempInstructorr);
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.save(tempInstructorr);				
			session.getTransaction().commit();
			
			System.out.println(tempInstructorr);
			
			System.out.println("Done!!");
		
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
		finally {
			factory.close();
		}

	}

}
