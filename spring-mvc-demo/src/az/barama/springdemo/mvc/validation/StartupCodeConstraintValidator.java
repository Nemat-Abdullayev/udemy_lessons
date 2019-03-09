package az.barama.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartupCodeConstraintValidator implements 
                               ConstraintValidator<StartupCode,String> {
	
	
	private String startupPrefix;
	
	@Override
	public void initialize(StartupCode theStartupCode) {
		startupPrefix=theStartupCode.value();
		
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext 
			theConstraintValidatorContext) {
		boolean result;
		
		if(theCode!=null) {
		result=theCode.startsWith(startupPrefix);
		}else {
			result=true;
		}
		return result;
		}
		
	}


