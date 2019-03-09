package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Student;


public class DeleteStudentDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			//int studentId=1;
			session=factory.getCurrentSession();
			session.beginTransaction();
			//System.out.println("\ngetting student with id:"+studentId);
			//Student myStudent=session.get(Student.class,studentId);
			//System.out.println("Deleting the Student:"+myStudent);
			//session.delete(myStudent);
			System.out.println("Deleting student id=2:");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			
		    session.getTransaction().commit();
		    System.out.println("Done!!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}

	}

}
