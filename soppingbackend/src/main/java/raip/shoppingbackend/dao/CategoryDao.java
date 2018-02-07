package raip.shoppingbackend.dao;

import java.util.List;

import raip.shoppingbackend.dto.Category;


public interface CategoryDao {

		List<Category> list();

		Category get(int id);
		
		boolean add(Category category);
}
