package CategoryWebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CategoryWebService.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer>{

}
