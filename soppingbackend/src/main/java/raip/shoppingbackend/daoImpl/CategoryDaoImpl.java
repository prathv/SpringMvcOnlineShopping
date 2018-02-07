package raip.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import raip.shoppingbackend.dao.CategoryDao;
import raip.shoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	private static List<Category> categories = new ArrayList<>();
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("television");
		category.setDescription("this is description for television");
		category.setImageUrl("CAT_1.png");
		categories.add(category);
		
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("this is description for mobile");
		category2.setImageUrl("CAT_2.png");
		categories.add(category2);
		
		Category category3 = new Category();
		category3.setId(2);
		category3.setName("Laptop");
		category3.setDescription("this is description for Laptop");
		category3.setImageUrl("CAT_3.png");
		categories.add(category3);
	}	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category: categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	@Transactional
	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;

		}
	}
	
}
