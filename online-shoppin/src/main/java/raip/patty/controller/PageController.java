package raip.patty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import raip.shoppingbackend.dao.CategoryDao;
import raip.shoppingbackend.dto.Category;

@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/", "/home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");

		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");

		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value = { "/listProducts" })
	public ModelAndView listProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = { "/test/{greeting}" })
	public ModelAndView index(@PathVariable String greeting) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		return mv;
	}

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");


		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAllProducts", true);

		mv.addObject("title", "Products");
		return mv;
	}
	
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");

		
		mv.addObject("userClickCategoryProducts", true);
		
		mv.addObject("category", categoryDao.get(id));



		mv.addObject("title", "All Products");
		return mv;
	}


}
