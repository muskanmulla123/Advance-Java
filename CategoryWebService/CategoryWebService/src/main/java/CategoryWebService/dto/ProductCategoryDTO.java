package CategoryWebService.dto;

import java.util.List;

import CategoryWebService.model.Category;

public class ProductCategoryDTO {
	private Category category;
	private List<ProductDTO> plist;
	public ProductCategoryDTO() {
		super();
	}
	public ProductCategoryDTO(Category category, List<ProductDTO> plist) {
		super();
		this.category = category;
		this.plist = plist;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<ProductDTO> getPlist() {
		return plist;
	}
	public void setPlist(List<ProductDTO> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "ProductCategoryDTO [category=" + category + ", plist=" + plist + "]";
	}
	
	

}
