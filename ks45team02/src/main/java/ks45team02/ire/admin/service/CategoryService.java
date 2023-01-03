package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.CategoryBig;
import ks45team02.ire.admin.dto.CategoryMedium;
import ks45team02.ire.admin.mapper.CategoryMapper;



@Service
public class CategoryService {

	private final CategoryMapper categoryMapper;
	
	public CategoryService(CategoryMapper categoryMapper) {
		
		this.categoryMapper = categoryMapper;
	}
	
	/**
	 * 카테고리 중 등록 처리
	 * @param categoryBig
	 * @return categoryMapper.addCategoryBig(categoryBig)
	 */
	public int addCategoryBig(CategoryBig categoryBig) {
		
		return categoryMapper.addCategoryBig(categoryBig);
	}
	
	public List<CategoryMedium> getCategoryMedium(){
		
		List<CategoryMedium> listCategoryMedium = categoryMapper.getCategoryMedium();
		
		return listCategoryMedium;
	}
}
