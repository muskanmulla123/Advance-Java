package CategoryWebService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CategoryWebService.dao.CategoryDao;
import CategoryWebService.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
	CategoryDao cdao;

	@Override
	public Category findById(int cid) {
		Optional<Category> category=cdao.findById(cid);
		if(category.isPresent()) {
			Category c1=category.get();
			return c1;
		}
		return null;
	}
}
