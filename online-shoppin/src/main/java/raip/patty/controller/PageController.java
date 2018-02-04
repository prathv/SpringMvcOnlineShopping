package raip.patty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping(value ={"/", "/home", "index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to spring web mvc");
		return mv;
	}
	
	@RequestMapping(value ={"/test/{greeting}"})
	public ModelAndView index(@PathVariable String greeting ) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to spring web mvc "+greeting);
		return mv;
	}
	
	
}
