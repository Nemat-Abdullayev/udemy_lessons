package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			System.out.println("creating 3 student object...");
			Student tempStudent = new Student("Conn", "Delarj", "con.delarj@info.com");
			Student tempStudent1 = new Student("Sara", "Annoy", "sara.ani@test.com");
			Student tempStudent2 = new Student("Alex", "Vidal", "alex.vidal@info.com");
			Student tempStudent3 = new Student("Allen", "Veliky", "allen.veliky@info.com");
			session.beginTransaction();
			System.out.println("saving the student");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.getTransaction().commit();
			System.out.println("Done!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
