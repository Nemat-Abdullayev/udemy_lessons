package az.barama.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] data= {
			"bura yazacagimiz birinci hissedir:",
			"bura yazacagimiz ikinci setrdir",
			"bura yazacagimiz ise ucuncu hissedir"
	};
	private Random myRandom=new Random();
	
	
	
	

	@Override
	public String getFortune() {
		int index=myRandom.nextInt(data.length);
		String theFortune=data[index];
		return theFortune;
	}

}
