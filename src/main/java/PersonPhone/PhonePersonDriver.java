package PersonPhone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PhonePersonDriver {

	public static void main(String[] args) {
		
		
		//build a session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate_person_phone.cfg.xml")
				.addAnnotatedClass(Phone.class)
				.addAnnotatedClass(PhoneDetails.class).buildSessionFactory();
		
		//get the current session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			
			
			
			
			
			//commit a transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
				

	}

}
