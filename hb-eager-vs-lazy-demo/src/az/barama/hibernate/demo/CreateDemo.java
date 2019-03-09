package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Instructor;
import az.barama.hibernate.demo.entity.InstructorDetail;
import az.barama.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

	/*		Instructor tempInstructor = new Instructor("Aslan", "Aslanli", "az.barama@info.az");

			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"https://www.youtube.com/channel/aslan/aslanli", "yo play the Piano");
					*/
			Instructor tempInstructor = new Instructor("Nihat", "Abdull", "nihat.abdull@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"www.youtube.com", "Guitar");

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.beginTransaction();

			System.out.println("saving tempInstructor" + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
