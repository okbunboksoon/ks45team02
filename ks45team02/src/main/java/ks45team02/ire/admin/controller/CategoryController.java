package ks45team02.ire.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String addCategory(Model model
							 ,@RequestParam(value="msg", required=false) String msg) {
		
		List<CategoryBig> listAllCategory = categoryService.getListBigCategory();
		model.addAttribute("title", "카테고리 등록");
		model.addAttribute("pageTitle", "카테고리 등록");
		model.addAttribute("listAllCategory", listAllCategory);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/category/categoryBigAdd";
	}
	
	/**
	 * 상품 등록시 카테고리 분류
	 * @param categoryBigCode
	 * @return listMedium
	 */
	@GetMapping("/checkGoodsCategoryValue")
	@ResponseBody
	public List<CategoryMedium> checkGoodsValue(@RequestParam(value = "categoryBigCode")String categoryBigCode) {
		
		List<CategoryMedium> listMedium = categoryService.getmediumCodeByBigCode(categoryBigCode);

		log.info("categoryBigCode : {}", categoryBigCode);
		log.info("listMedium : {}", listMedium);
		return listMedium;
	}
	
	/**
	 * 카테고리 대 등록 처리
	 * @param categoryBig
	 * @return redirect:/admin/listCategory
	 */
	@PostMapping("/addCategoryBig")
	public String addCategoryBig(CategoryBig categoryBig
								,RedirectAttributes reAttr) {
		
		log.info("카테고리 대 입력 정보 : {}", categoryBig);
		int result = categoryService.addCategoryBig(categoryBig);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "카테고리 등록에 실패하였습니다.");
			return "redirect:/admin/addCategory";
		}else{                                                                                                                                                                                                                                                                                                                                                             
			reAttr.addAttribute("msg", "카테고리 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBigCategory";
	}
	
	/**
	 * 카테고리 중 등록 처리
	 * @param categoryMedium
	 * @return redirect:/admin/listCategory
	 */
	@PostMapping("/addCategoryMedium")
	public String addCategoryMedium(CategoryMedium categoryMedium
									,RedirectAttributes reAttr) {
		
		log.info("카테고리 중 입력 정보 : {}", categoryMedium);
		int result = categoryService.addCategoryMedium(categoryMedium);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "카테고리 등록에 실패하였습니다.");
			return "redirect:/admin/addCategory";
		}else{                                                                                                                                                                                                                                                                                                                                                             
			reAttr.addAttribute("msg", "카테고리 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listMideumCategory";
	}
	
	/**
	 * 카테고리 대 수정화면
	 * @param categoryBigCode model
	 * @return admin/category/categoryBigModify
	 */
	@GetMapping("/modifyBigCategory")
	public String modifyBigCategory(@RequestParam(value = "categoryBigCode")String categoryBigCode
								   ,@RequestParam(value="msg", required=false) String msg, Model model) {
		
		List<CategoryBig> BigCategoryInfo = categoryService.getBigCategoryByCode(categoryBigCode);
		model.addAttribute("title", "카테고리 대 수정");
		model.addAttribute("pageTitle", "카테고리 대 수정");
		model.addAttribute("BigCategoryInfo", BigCategoryInfo);
		log.info("categoryMediumCode : {}", BigCategoryInfo);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/category/categoryBigModify";
	}
	
	/**
	 * 카테고리 중 수정화면
	 * @param categoryMediumCode model
	 * @return admin/category/categoryBigModify
	 */
	@GetMapping("/modifyMediumCategory")
	public String modifyMediumCategory(@RequestParam(value = "categoryMediumCode")String categoryMediumCode
									  ,@RequestParam(value="msg", required=false) String msg,Model model) {
		
		CategoryMedium mediumCategoryInfo = categoryService.getMediumCategoryByCode(categoryMediumCode);
		List<CategoryBig> categoryBig =  categoryService.getListBigCategory();
		model.addAttribute("title", "카테고리 중 수정");
		model.addAttribute("pageTitle", "카테고리 중 수정");
		model.addAttribute("mediumCategoryInfo", mediumCategoryInfo);
		model.addAttribute("categoryBig", categoryBig);
		log.info("mediumCategoryInfo : {}", mediumCategoryInfo);
		log.info("categoryBig : {}", categoryBig);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/category/categoryMediumModify";
	}
	
	/**
	 * 카테고리 대 수정 처리
	 * @param categoryBig
	 * @return redirect:/admin/listBigCategory
	 */
	@PostMapping("/modifyBigCategory")
	public String modifyBigCategory(CategoryBig categoryBig
									,RedirectAttributes reAttr) {
		
		int result = categoryService.modifyBigCategory(categoryBig);
		log.info("categoryBig : {}", categoryBig);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "카테고리 수정에 실패하였습니다.");
			return "redirect:/admin/modifyBigCategory";
		}else{                                                                                                                                                                                                                                                                                                                                                             
			reAttr.addAttribute("msg", "카테고리 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listBigCategory";
	}
	
	/**
	 * 카테고리 중 수정 처리
	 * @param categoryMedium
	 * @return redirect:/admin/listMideumCategory
	 */
	@PostMapping("/modifyMediumCategory")
	public String modifyMediumCategory(CategoryMedium categoryMedium
									   ,RedirectAttributes reAttr) {
		
		int result = categoryService.modifyMediumCategory(categoryMedium);
		log.info("categoryMedium : {}", categoryMedium);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "카테고리 수정에 실패하였습니다.");
			return "redirect:/admin/modifyMediumCategory";
		}else{                                                                                                                                                                                                                                                                                                                                                             
			reAttr.addAttribute("msg", "카테고리 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listMideumCategory";
	}
	
	/**
	 * 카테고리 대 삭제 처리
	 * @param param
	 * @return redirect:/admin/listBigCategory
	 */
	@ResponseBody
	@RequestMapping(value="deleteBigCategory", method = {RequestMethod.POST})
	public HashMap<String, String> deleteBigCategory(@RequestParam Map<String, Object> param
													 ,RedirectAttributes reAttr) {
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		
		String categoryBigCode = (String) param.get("categoryBigCode");
		int result = categoryService.deleteBigCateory(categoryBigCode);
		if(result == 0) {
			reResult.put("result", "실패");			
		}else {
			reResult.put("result", "성공");					
		}
			reResult.put("categoryBigCode", categoryBigCode);	
			reResult.put("redirect", "/admin/listBigCategory");				
		
		return reResult;
	}
	
	/**
	 * 카테고리 중 삭제 처리
	 * @param param
	 * @return reResult;
	 */
	@ResponseBody
	@RequestMapping(value="deleteMediumCategory", method = {RequestMethod.POST})
	public HashMap<String, String> deleteMediumCategory(@RequestParam Map<String, Object> param
													    ,RedirectAttributes reAttr) {
		
		HashMap<String, String> reResult = new HashMap<String, String>();
		
		String categoryMediumCode = (String) param.get("categoryMediumCode");
		int result = categoryService.deleteMediumCategory(categoryMediumCode);

		if(result == 0) {
			reResult.put("result", "실패");			
		}else {
			reResult.put("result", "성공");			
		}
			reResult.put("categoryMediumCode", categoryMediumCode);	
			reResult.put("redirect", "/admin/listMideumCategory");			
			
		return reResult;
	}
	
	/**
	 * 카테고리 대 목록 조회
	 * @param model
	 * @return admin/category/categoryList
	 */
	@GetMapping("/listBigCategory")
	public String listCategory(Model model
							  ,@RequestParam(value="msg", required=false) String msg) {
		
		List<CategoryBig> listAllCategory = categoryService.getListBigCategory();
		model.addAttribute("title", "카테고리 대 목록");
		model.addAttribute("pageTitle", "카테고리 대 목록");
		model.addAttribute("listAllCategory", listAllCategory);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/category/categoryBigList";
	}
	
	/**
	 * 카테고리 중 목록 조회
	 * @param model
	 * @return admin/category/categoryMediumList
	 */
	@GetMapping("/listMideumCategory")
	public String listCategor(Model model
							 ,@RequestParam(value="msg", required=false) String msg) {
		
		List<CategoryBig> listMediumCategory = categoryService.getListMediumCategory();
		model.addAttribute("title", "카테고리 중 목록");
		model.addAttribute("pageTitle", "카테고리 중 목록");
		model.addAttribute("listMediumCategory", listMediumCategory);
		log.info("카테고리 중 목록 : {}", listMediumCategory);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/category/categoryMediumList";
	}
	
	
}
