package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.CategoryBig;
import ks45team02.ire.admin.dto.CategoryMedium;

@Mapper
public interface CategoryMapper {
	
	/**
	 * 카테고리 대 조회
	 */
	public List<CategoryBig> getListBigCategory();
	
	/**
	 * 카테고리 중 조회
	 */
	public List<CategoryBig> getListMediumCategory();
	
	/**
	 * 카테고리 대 등록 처리
	 */
	public int addCategoryBig(CategoryBig categoryBig);
	
	/**
	 * 카테고리 중 등록 처리
	 * @param categoryMedium
	 */
	public int addCategoryMedium(CategoryMedium categoryMedium);
	
	/**
	 * 카테고리 대 코드 조회
	 */
	public List<CategoryBig> getBigCategoryByCode(String categoryBigCode);
	
	/**
	 * 카테고리 중 코드 조회
	 */
	public CategoryMedium getMediumCategoryByCode(String categoryMediumCode);
	
	/**
	 * 카테고리 대 수정 처리
	 */
	public int modifyBigCategory(CategoryBig categoryBig);
	
	/**
	 * 카테고리 중 수정 처리
	 */
	public int modifyMediumCategory(CategoryMedium categoryMedium);
}
