package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class BuybasketController {

	
	@GetMapping("/addBuyBasket")
	public String addBuyBasket(Model model) {
		
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
		
		model.addAttribute("title", "장바구니 구매 조회");
		model.addAttribute("pageTitle", "장바구니 구매 조회");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketList";
	}
	@GetMapping("/modifyBuyBasket")
	public String modifyBuyBasket(Model model) {
		
		return "admin/buybasket/buybasketModify";
	}
}
