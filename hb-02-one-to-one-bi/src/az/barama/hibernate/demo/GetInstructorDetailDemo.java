package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Instructor;
import az.barama.hibernate.demo.entity.InstructorDetail;
import az.barama.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			
			int theId=2;

			session.beginTransaction();
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			System.out.println("instructorDetail:"+tempInstructorDetail);
			
			System.out.println("the associated instructor:"+tempInstructorDetail.getInstructor());
			
			System.out.println("deleting tempInstructorDetail: "+tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
