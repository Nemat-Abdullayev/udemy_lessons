package az.barama.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(@RequestParam("studentName") String theName,
			                    @RequestParam("studentSurname")String theSurname, Model model) {
		
		//String theName=request.getParameter("studentName");
		//String theSurname=request.getParameter("studentSurname");
		
		theName=theName.toUpperCase();
		theSurname=theSurname.toUpperCase();
		String result="nameUpper"+" "+theName;
		String result1="surnameUpper"+" "+theSurname;
		
		model.addAttribute("message", result);
		model.addAttribute("message1", result1);
		
	return "helloworld";
	}
	
	
	


}
