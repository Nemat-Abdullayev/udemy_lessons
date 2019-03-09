package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Student;


public class UpdateStudentDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			int studentId=5;
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\ngetting student with id:"+studentId);
			Student myStudent=session.get(Student.class,studentId);
			System.out.println("Updating student:"+studentId);
			myStudent.setFirstName("Alan");
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email for all students:");
			session.createQuery("update Student set email='test@gmail.com'").executeUpdate();
			
			
			session.getTransaction().commit();
			
			
			
			
			System.out.println("The student updated!!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}

	}

}
