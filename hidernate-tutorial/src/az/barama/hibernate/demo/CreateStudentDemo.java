package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			System.out.println("creating new student object...");
			Student tempStudent=new Student("Nemo", "Abdull", "nemo.barama.az");
			
			session.beginTransaction();
			
			System.out.println("saving the student...");
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Done!");
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
