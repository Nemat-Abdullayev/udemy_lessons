package az.barama.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=StartupCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartupCode {
	
	public String value() default "BARAMA";
	
	
	public String message() default "'BARAMA' sozu ile baslamalidir";
	
	public Class <?>[] groups () default {};
	
	public Class<? extends Payload>[] payload() default {};
		
	

}
