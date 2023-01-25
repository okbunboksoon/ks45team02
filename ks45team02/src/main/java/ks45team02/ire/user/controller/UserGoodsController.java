package ks45team02.ire.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.service.GoodsService;
import ks45team02.ire.user.dto.UserGoods;
import ks45team02.ire.user.service.UserGoodsService;

@Controller
@RequestMapping("/")
public class UserGoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserGoodsController.class);

	
	private UserGoodsService userGoodsService;
	
	public UserGoodsController(UserGoodsService userGoodsService) {
		
		this.userGoodsService = userGoodsService;
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
		
		List<UserGoods> listGoods =  userGoodsService.getUserGoodsList();
		
		model.addAttribute("title", "Ire");
		model.addAttribute("listGoods", listGoods);
		log.info("listGoods : {}", listGoods);
		
		return "user/goods/goodsList";
	}
	
	/**
	 * 상품상세페이지
	 * @param model, goodsCode
	 */
	@GetMapping("/goodsContents")
	public String goodsContents(Model model
							   ,@RequestParam(value = "goodsCode")String goodsCode
							   ,@RequestParam(value="msg", required = false) String msg){
		log.info("goodsCode : {}", goodsCode);
		List<UserGoods> getGoodsList = userGoodsService.getGoodsFileByCode(goodsCode);
		model.addAttribute("title", "Ire");
		model.addAttribute("getGoodsList", getGoodsList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "user/goods/goodsContents";
	}
	
	@GetMapping("/listGoodsItem")
	public String listGoodsItem(Model model, @RequestParam(value = "item") String item ) {
		log.info("item : {}", item);
		
		List<UserGoods> listGoods = userGoodsService.getListItemValueByBigCode(item);
		model.addAttribute("title", "Ire");
		model.addAttribute("listGoods", listGoods);
		
		return "user/goods/goodsListItem";
	}
	
	
}

