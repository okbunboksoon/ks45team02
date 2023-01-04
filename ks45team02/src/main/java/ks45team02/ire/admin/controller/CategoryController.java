package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.CategoryBig;
import ks45team02.ire.admin.dto.CategoryMedium;
import ks45team02.ire.admin.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	}
	
	
	/**
	 * 카테고리 등록 화면
	 * @param model
	 * @return admin/category/categoryBigAdd
	 */
	@GetMapping("/addCategory")
	public String addCategory(Model model) {
		
		List<CategoryBig> listAllCategory = categoryService.getListBigCategory();
		log.info("카테고리 전체 조회 : {}", listAllCategory);
		model.addAttribute("title", "카테고리 등록");
		model.addAttribute("pageTitle", "카테고리 등록");
		model.addAttribute("listAllCategory", listAllCategory);
		
		return "admin/category/categoryBigAdd";
	}
	
	/**
	 * 카테고리 대 등록 처리
	 * @param categoryBig
	 * @return redirect:/admin/listCategory
	 */
	@PostMapping("/addCategoryBig")
	public String addCategoryBig(CategoryBig categoryBig) {
		
		log.info("카테고리 대 입력 정보 : {}", categoryBig);
		categoryService.addCategoryBig(categoryBig);
		
		return "redirect:/admin/listBigCategory";
	}
	
	/**
	 * 카테고리 중 등록 처리
	 * @param categoryMedium
	 * @return redirect:/admin/listCategory
	 */
	@PostMapping("/addCategoryMedium")
	public String addCategoryMedium(CategoryMedium categoryMedium) {
		
		log.info("카테고리 중 입력 정보 : {}", categoryMedium);
		categoryService.addCategoryMedium(categoryMedium);
		
		return "redirect:/admin/listMideumCategory";
	}
	
	/**
	 * 카테고리 대 수정화면
	 * @param categoryBigCode model
	 * @return admin/category/categoryBigModify
	 */
	@GetMapping("/modifyBigCategory")
	public String modifyBigCategory(@RequestParam(value = "categoryBigCode")String categoryBigCode, Model model) {
		
		List<CategoryBig> BigCategoryInfo = categoryService.getBigCategoryByCode(categoryBigCode);
		model.addAttribute("title", "카테고리 대 수정");
		model.addAttribute("pageTitle", "카테고리 대 수정");
		model.addAttribute("BigCategoryInfo", BigCategoryInfo);
		log.info("categoryMediumCode : {}", BigCategoryInfo);
		
		return "admin/category/categoryBigModify";
	}
	
	/**
	 * 카테고리 중 수정화면
	 * @param categoryMediumCode model
	 * @return admin/category/categoryBigModify
	 */
	@GetMapping("/modifyMediumCategory")
	public String modifyMediumCategory(@RequestParam(value = "categoryMediumCode")String categoryMediumCode, Model model) {
		
		CategoryMedium mediumCategoryInfo = categoryService.getMediumCategoryByCode(categoryMediumCode);
		List<CategoryBig> categoryBig =  categoryService.getListBigCategory();
		model.addAttribute("title", "카테고리 중 수정");
		model.addAttribute("pageTitle", "카테고리 중 수정");
		model.addAttribute("mediumCategoryInfo", mediumCategoryInfo);
		model.addAttribute("categoryBig", categoryBig);
		log.info("mediumCategoryInfo : {}", mediumCategoryInfo);
		log.info("categoryBig : {}", categoryBig);
		
		return "admin/category/categoryMediumModify";
	}
	
	/**
	 * 카테고리 대 수정 처리
	 * @param categoryBig
	 * @return redirect:/admin/listBigCategory
	 */
	@PostMapping("/modifyBigCategory")
	public String modifyBigCategory(CategoryBig categoryBig) {
		
		categoryService.modifyBigCategory(categoryBig);
		log.info("categoryBig : {}", categoryBig);
		
		return "redirect:/admin/listBigCategory";
	}
	
	/**
	 * 카테고리 중 수정 처리
	 * @param categoryMedium
	 * @return redirect:/admin/listMideumCategory
	 */
	@PostMapping("/modifyMediumCategory")
	public String modifyMediumCategory(CategoryMedium categoryMedium) {
		
		categoryService.modifyMediumCategory(categoryMedium);
		log.info("categoryMedium : {}", categoryMedium);
		
		return "redirect:/admin/listMideumCategory";
	}
	
	//@GetMapping("/deleteBigCategory")
	public String deleteBigCategory(@RequestParam(value = "categoryBigCode")String categoryBigCode, Model model) {
		
		model.addAttribute("title", "카테고리 대 삭제");
		model.addAttribute("pageTitle", "카테고리 대 삭제");
		log.info("categoryMediumCode : {}", categoryBigCode);
		
		return "admin/category/categoryBigDelete";
	}
	
	//@PostMapping("/deleteMediumCategory")
	public String deleteMediumCategory(@RequestParam(value = "categoryMediumCode")String categoryMediumCode, Model model) {
		
		model.addAttribute("title", "카테고리 중 삭제");
		model.addAttribute("pageTitle", "카테고리 중 삭제");
		log.info("categoryMediumCode : {}", categoryMediumCode);
		return "admin/category/categoryMediumDelete";
	}
	
	/**
	 * 카테고리 대 목록 조회
	 * @param model
	 * @return admin/category/categoryList
	 */
	@GetMapping("/listBigCategory")
	public String listCategory(Model model) {
		
		List<CategoryBig> listAllCategory = categoryService.getListBigCategory();
		model.addAttribute("title", "카테고리 대 목록");
		model.addAttribute("pageTitle", "카테고리 대 목록");
		model.addAttribute("listAllCategory", listAllCategory);
		
		return "admin/category/categoryBigList";
	}
	
	/**
	 * 카테고리 중 목록 조회
	 * @param model
	 * @return admin/category/categoryMediumList
	 */
	@GetMapping("/listMideumCategory")
	public String listCategor(Model model) {
		
		List<CategoryBig> listMediumCategory = categoryService.getListMediumCategory();
		model.addAttribute("title", "카테고리 중 목록");
		model.addAttribute("pageTitle", "카테고리 중 목록");
		model.addAttribute("listMediumCategory", listMediumCategory);
		
		log.info("카테고리 중 목록 : {}", listMediumCategory);
		
		return "admin/category/categoryMediumList";
	}
	
	
}
