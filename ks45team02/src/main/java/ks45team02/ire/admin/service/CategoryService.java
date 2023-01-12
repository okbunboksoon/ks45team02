package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.CategoryBig;
import ks45team02.ire.admin.dto.CategoryMedium;
import ks45team02.ire.admin.mapper.CategoryMapper;

@Service
@Transactional
public class CategoryService {

	private CategoryMapper categoryMapper;
	
	public CategoryService(CategoryMapper categoryMapper) {
		
		this.categoryMapper = categoryMapper;
		
	}
	/**
	 * 카테고리 대 조회
	 * @return listAllCategory
	 */
	public List<CategoryBig> getListBigCategory(){
		
		List<CategoryBig> listAllCategory = categoryMapper.getListBigCategory();
		
		return listAllCategory;
	}
	
	/**
	 * 카테고리 중 전체 조회
	 * @return listMedium
	 */
	public List<CategoryMedium> getMediumCategory(){
		
		List<CategoryMedium> listMedium = categoryMapper.getMediumCategory();
		
		return listMedium;
	}
	
	/**
	 * 카테고리 중 조회
	 */
	public List<CategoryBig> getListMediumCategory(){
		
		List<CategoryBig> listMediumCategory = categoryMapper.getListMediumCategory();
		
		return listMediumCategory;
	}
	
	/**
	 * 카테고리 대 등록 처리
	 * @param categoryBig
	 * @return categoryMapper.addCategoryBig(categoryBig)
	 */
	public int addCategoryBig(CategoryBig categoryBig) {
		
		int result = 0;
		result = categoryMapper.addCategoryBig(categoryBig);
		
		return result;
	}
	
	/**
	 * 카테고리 중 등록 처리
	 * @param categoryMedium
	 * @return categoryMapper.addCategoryMedium(categoryMedium)
	 */
	public int addCategoryMedium(CategoryMedium categoryMedium) {
		
		int result = 0;
		result = categoryMapper.addCategoryMedium(categoryMedium);
		
		return result;
	}
	
	/**
	 * 카테고리 대 특정코드 조회
	 * @param categoryBigCode
	 * @return BigCategoryInfo
	 */
	public List<CategoryBig> getBigCategoryByCode(String categoryBigCode){
		
		List<CategoryBig> BigCategoryInfo = categoryMapper.getBigCategoryByCode(categoryBigCode);
		
		return BigCategoryInfo;
	}
	
	/**
	 * 카테고리 중 특정코드 조회
	 * @param categoryMediumCode
	 * @return mediumCategoryInfo
	 */
	public CategoryMedium getMediumCategoryByCode(String categoryMediumCode){
		
		CategoryMedium mediumCategoryInfo = categoryMapper.getMediumCategoryByCode(categoryMediumCode);
		
		return mediumCategoryInfo;
	}
	
	/**
	 * 카테고리 대 수정 처리
	 * @param categoryBig
	 * @return result
	 */
	public int modifyBigCategory(CategoryBig categoryBig) {
		
		int result = 0;
		result = categoryMapper.modifyBigCategory(categoryBig);
		
		return result;
	}
	
	/**
	 * 카테고리 중 수정 처리
	 * @param result
	 */
	public int  modifyMediumCategory(CategoryMedium categoryMedium) {
		
		int result = 0;
		result = categoryMapper.modifyMediumCategory(categoryMedium);
		
		return result;
	}
	
	/**
	 * 카테고리 중 삭제 처리
	 * @param categoryMediumCode
	 * @return result
	 */
	public int deleteMediumCategory(String categoryMediumCode) {
			
		int result = 0;
		result += categoryMapper.deleteMediumCategory(categoryMediumCode);
		
		return result;
	}
	
	/**
	 * 카테고리 대 삭제 처리
	 * @param categoryBigCode
	 * @return result
	 */
	public int deleteBigCateory(String categoryBigCode) {
		
		int result = 0;
		result += categoryMapper.deleteCateBigCode(categoryBigCode);
		result += categoryMapper.deleteBigCategory(categoryBigCode);
		
		return result;
	}
}
