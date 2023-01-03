package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.service.GoodsService;

@Controller
@RequestMapping("/admin")
public class GoodsController {

	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		
		this.goodsService = goodsService;
		
	}
	
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		return "admin/goods/goodsAdd";
	}
	
	@GetMapping("/deleteGoods")
	public String deleteGoods() {
		
		return "admin/goods/goodsDelete";
	}
	
	
	@GetMapping("/listGoods")
	public String listGoods(Model model) {
		
		List<Goods> listGoods = goodsService.getListGoods();
		log.info("상품리스트 : {}", listGoods);
		model.addAttribute("title", "상품목록");
		model.addAttribute("subTitle", "상품목록");
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

