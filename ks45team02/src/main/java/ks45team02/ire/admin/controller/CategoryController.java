package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.CategoryBig;
import ks45team02.ire.admin.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
		
	}
	
	/**
	 * 카테고리 대 등록 화면
	 * @param model
	 * @return admin/category/categoryBigAdd
	 */
	@GetMapping("/addCategoryBig")
	public String addBigCategory(Model model) {
		
		model.addAttribute("Title", "카테고리 대 등록");
		model.addAttribute("pageTitle", "카테고리 대 등록");
		
		return "admin/category/categoryBigAdd";
	}
	
	/**
	 * 카테고리 대 등록 처리
	 * @param categoryBig
	 * @return redirect:/admin/listCategory
	 */
	@PostMapping("addCategoryBig")
	public String addBigCategory(CategoryBig categoryBig) {
		
		categoryService.addCategoryBig(categoryBig);
		
		return "redirect:/admin/listCategory";
	}
	
	/**
	 * 카테고리 중 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/addCategoryMedium")
	public String addMidiumCategory(Model model) {
		
		model.addAttribute("Title", "카테고리 중 등록");
		model.addAttribute("pageTitle", "카테고리 중 등록");
		
		return "admin/category/categoryMediumAdd";
	}
	
	@GetMapping("/deleteCategory")
	public String deleteCategory() {
		
		return "admin/category/categoryDelete";
	}
	
	@GetMapping("/listCategory")
	public String listCategory() {
		
		return "admin/category/categoryList";
	}
	
	
	@GetMapping("/modifyCategory")
	public String modifyCategory() {
		
		return "admin/category/categoryModify";
	}

	
}

