package lab.software.engineering.spring.Reddit.Clone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.engine.AttributeName;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HomeController {
	
	
	/*/@RequestMapping(path="/",method=RequestMethod.GET)
	public String home() {
		return "Hello Spring boot 2";
	}*/

	
	/*@RequestMapping(path="/",method=RequestMethod.GET, consumes="application/json"
			,produces="application/json")
	public String home() {
		return "index";
	}*/
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Hello world");
		return "index";
	}
}
