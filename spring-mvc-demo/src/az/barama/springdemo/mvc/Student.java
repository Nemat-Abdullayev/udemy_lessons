package az.barama.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap <String,String> countryOptions;	
	private String [] favoriteLanguage;
	private String [] operationSystems;
	
	

	
	
	public String[] getOperationSystems() {
		return operationSystems;
	}
	public void setOperationSystems(String[] operationSystems) {
		this.operationSystems = operationSystems;
	}
	public String[] getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String[] favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public Student() {
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("BR","Brazil");
		countryOptions.put("AZ","Azerbaijan");
		countryOptions.put("TR","Turkey");
		countryOptions.put("USA","United State of America");
		countryOptions.put("UK","United Kingdom");
		countryOptions.put("IN","India");
		countryOptions.put("RU","Russian Federation");
		countryOptions.put("FR","France");
		countryOptions.put("UR","Ukrain");
		countryOptions.put("IR","Iran");
		countryOptions.put("GR","Georgia");
		countryOptions.put("CA","Canada");
		
			
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country=country;
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
