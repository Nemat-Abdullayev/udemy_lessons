package az.barama.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import az.barama.hibernate.demo.entity.Student;


public class ReadStudentDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			Student tempStudent1=new Student("Alexsandra", "Halilovic", "alex.halil@test.org");
			session.beginTransaction();
			session.save(tempStudent1);
			session.getTransaction().commit();
			System.out.println("Done!!");
			System.out.println("Save student.Generated id:"+tempStudent1.getId());
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\ngetting student with id:"+tempStudent1.getId());
			Student myStudent=session.get(Student.class, tempStudent1.getId());
			System.out.println("get complete:"+myStudent);
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}

	}

}
