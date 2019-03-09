package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Instructor;
import az.barama.hibernate.demo.entity.InstructorDetail;
import az.barama.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("Found instructor:"+tempInstructor);
			if(tempInstructor!=null) {
				System.out.println("deleting:"+tempInstructor);
			}
			session.delete(tempInstructor);
			
			

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
