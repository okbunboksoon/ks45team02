package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.mapper.BasketMapper;
import ks45team02.ire.admin.service.BasketService;
import ks45team02.ire.admin.service.DonationService;

@Controller
@RequestMapping("/admin")
public class BasketController {

	private static final Logger log = LoggerFactory.getLogger(DonationService.class);
	
	private final BasketService basketService;
	private final BasketMapper basketMapper;
	
	public BasketController(BasketMapper basketMapper, BasketService basketService) {
		this.basketMapper = basketMapper;
		this.basketService = basketService;
	}
	
	//장바구니 등록 페이지
	@GetMapping("/addBasket")
	public String addBasket(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "장바구니 등록");
		model.addAttribute("pageTitle", "장바구니 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/basket/basketAdd";
	}
	
	@GetMapping("/deleteBasket")
	public String deleteBasket() {
		
		return "admin/basket/basketDelete";
	}
	
	//장바구니 조회 페이지
	@GetMapping("/listBasket")
	public String listBasket(Model model) {
		
		List<Basket> basketList = basketService.getBasketList();
		
		model.addAttribute("title", "장바구니 조회");
		model.addAttribute("pageTitle", "장바구니 조회");
		model.addAttribute("basketList", basketList);
		
		
		return "admin/basket/basketList";
	}
	
	
	@GetMapping("/modifyBasket")
	public String modifyBasket() {
		
		return "admin/basket/basketModify";
	}

}

