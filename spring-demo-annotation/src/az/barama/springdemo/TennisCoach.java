package az.barama.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	public TennisCoach() {
		System.out.println("TennisCoach: >>inside default constructor<<");
	}
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside of doMyStartupStuff()");
	}
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside of doMyCleanupStuff()");
		
	}
	
	
	
	
	/*
	@Autowired
	public void doSomeCrazyStuff (FortuneService theFortuneService) {
		System.out.println("inside setter method:doSomeCrazyStuff");
		fortuneService=theFortuneService;
	}*/
	
    /*public TennisCoach(FortuneService theFortuneService) {
    	fortuneService=theFortuneService;
	}*/
	@Override
	public String getDailyWorkout() {
		
		return "Today work on Football";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
