package az.barama.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class SwingJavaConfigDemoApp2 {
	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("SwimCoach:"+theCoach.getEmail());
		System.out.println("SwimCoach:"+theCoach.getTeam());
		
		
		
		context.close();
		
	}

}
