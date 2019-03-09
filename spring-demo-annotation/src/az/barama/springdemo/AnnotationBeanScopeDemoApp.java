package az.barama.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		/*Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
		
		boolean result=(theCoach==alphaCoach);
		
		System.out.println("\nPointing the same object:"+result);
		
		System.out.println("\nMemory location for theCoach:"+theCoach);
		
		System.out.println("\nMemory location for alphaCoach"+ alphaCoach);*/
		
		context.close();
		
	}

}
