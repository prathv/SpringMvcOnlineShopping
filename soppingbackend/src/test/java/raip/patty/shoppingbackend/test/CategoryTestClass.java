package raip.patty.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import raip.shoppingbackend.dao.CategoryDao;
import raip.shoppingbackend.dto.Category;

public class CategoryTestClass {
		
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("raip.shoppingbackend");
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean("categoryDao");		
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		
		
	}
	
}
