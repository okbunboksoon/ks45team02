package ks45team02.ire.user.controller;

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
@RequestMapping("/")
public class UserGoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserGoodsController.class);

	
	private GoodsService goodsService;
	
	public UserGoodsController(GoodsService goodsService) {
		
		this.goodsService = goodsService;
	}
	
	@GetMapping("/orderGoods")
	public String orderGoods() {
		
		return "user/goods/goodsOrder";
	}
	
	/**
	 * 상품 화면
	 */
	@GetMapping("/listGoods")
	public String listGoods(Model model) {
		
		List<Goods> listGoods =  goodsService.getListGoods();
		
		model.addAttribute("title", "Ire");
		model.addAttribute("listGoods", listGoods);
		log.info("listGoods : {}", listGoods);
		
		return "user/goods/goodsList";
	}
	
}

