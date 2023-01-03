package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.CategoryBig;
import ks45team02.ire.admin.dto.CategoryMedium;

@Mapper
public interface CategoryMapper {
	
	/**
	 * 카테고리 대 추가
	 */
	public int addCategoryBig(CategoryBig categoryBig);
	
	public List<CategoryMedium> getCategoryMedium();
}
