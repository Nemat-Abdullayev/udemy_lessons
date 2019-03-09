package az.barama.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
			displayStudents(theStudents);
			theStudents = session.createQuery("from Student s where s.lastName='Annoy'").getResultList();
			System.out.println("\n\nThe student who has lastName of 'Annoy':");
			displayStudents(theStudents);
			theStudents=session.createQuery("from Student where email like '%info.com'").getResultList();
			System.out.println("\n\nThe student who has email like:");
			displayStudents(theStudents);
			theStudents=session.createQuery("from Student where firstName='Alex'or lastName='Vidal'").getResultList();
			System.out.println("\n\nThe student who has name=Alex lastName=Vidal:");
			displayStudents(theStudents);


			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}



}
