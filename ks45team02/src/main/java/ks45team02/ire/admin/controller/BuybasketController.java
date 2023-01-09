package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.service.BuybasketService;

@Controller
@RequestMapping("/admin")
public class BuybasketController {

	
	private static final Logger log = LoggerFactory.getLogger(BuybasketController.class);

	
	private final BuybasketService buybasketService;
	
	public BuybasketController(BuybasketService buybasketService) {
		this.buybasketService = buybasketService;
	}
	
	//장바구니 구매 등록
	@GetMapping("/addBuyBasket")
	public String addBuyBasket(Model model
							 ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "장바구니 구매 등록");
		model.addAttribute("pageTitle", "장바구니 구매 등록");
				
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketAdd";
	}
	@GetMapping("/deleteBuyBasket")
	public String deleteBuyBasket(Model model) {
		
		return "admin/buybasket/buybasketDelete";
	}
	
	//장바구니 구매 조회
	@GetMapping("/listBuyBasket")
	public String listBuyBasket(Model model
							   ,@RequestParam(value="msg", required = false) String msg) {
		
		List<Buybasket> buybasketList = buybasketService.getBuybasketList();
		
		model.addAttribute("title", "장바구니 구매 조회");
		model.addAttribute("pageTitle", "장바구니 구매 조회");
		model.addAttribute("buybasketList", buybasketList);
		//model.addAttribute("buybasketList", buybasketList);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketList";
	}
	
	//장바구니 구매 수정 페이지
	@GetMapping("/modifyBuyBasket")
	public String modifyBuyBasket(Model model
								,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "장바구니 구매 수정");
		model.addAttribute("pageTitle", "장바구니 구매 수정");
				
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketModify";
	}
}
