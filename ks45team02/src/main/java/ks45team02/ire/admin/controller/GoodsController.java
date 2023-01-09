package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.CategoryMedium;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.service.CategoryService;
import ks45team02.ire.admin.service.GoodsService;

@Controller
@RequestMapping("/admin")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private final GoodsService goodsService;
	private final CategoryService categoryService;
	
	public GoodsController(GoodsService goodsService, 
						   CategoryService categoryService) {
		this.categoryService = categoryService;
		this.goodsService = goodsService;
		
		
	}
	
	/**
	 * 상품등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		List<CategoryMedium> listAllCategory = categoryService.getMediumCategory();
		model.addAttribute("title", "상품등록");
		model.addAttribute("pageTitle", "상품등록");
		model.addAttribute("listAllCategory", listAllCategory);
		
		return "admin/goods/goodsAdd";
	}
	
	/**
	 * 상품 등록 처리
	 * @param goods
	 * @return
	 */
	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {
		
		goodsService.addGoods(goods);
		
		log.info("goods : {}", goods);
		
		return "redirect:/admin/listGoods";
	}
	
	@GetMapping("/deleteGoods")
	public String deleteGoods() {
		
		return "admin/goods/goodsDelete";
	}
	
	/**
	 * 상품 목록 조회
	 * @param model
	 * @return listGoods
	 */
	@GetMapping("/listGoods")
	public String listGoods(Model model) {
		
		List<Goods> listGoods = goodsService.getListGoods();
		log.info("상품리스트 : {}", listGoods);
		model.addAttribute("title", "상품목록");
		model.addAttribute("pageTitle", "상품목록");
		model.addAttribute("listGoods", listGoods);
		
		return "admin/goods/goodsList";
	}
	
	@GetMapping("/modifyGoods")
	public String modifyGoods() {
		
		return "admin/goods/goodsModify";
	}
	@GetMapping("/orderGoods")
	public String orderGoods() {
		
		return "admin/goods/goodsOrder";
	}

}

