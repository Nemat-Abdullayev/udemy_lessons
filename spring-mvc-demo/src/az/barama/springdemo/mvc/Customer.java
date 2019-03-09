package az.barama.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import az.barama.springdemo.mvc.validation.StartupCode;

public class Customer {
	private String firstName;
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	@Min(value=0,message="0-dan boyuk ve beraber ededler daxil edin")
	@Max(value=10,message="10-dan kicik ve beraber ededler daxil edin")
	@NotNull(message="is required")
	private Integer freePasses;
	@Pattern(regexp="[A-Za-z0-9]{5}",message="only 5 chars/digits")
	private String postalCode;
	@StartupCode
	private String startupCode;
	
	
	public String getStartupCode() {
		return startupCode;
	}
	
	public void setStartupCode(String startupCode) {
		this.startupCode=startupCode;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	 
	public void setPostalCode(String postalCode) {
		this.postalCode=postalCode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses=freePasses;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public void setLastName(String lastName) {
		 this.lastName=lastName;
	 }

}
