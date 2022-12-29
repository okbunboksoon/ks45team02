package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("/listBuyBasket")
	public String listBuyBasket(Model model) {
		
		return "admin/buybasket/buybasketList";
	}
	@GetMapping("/modifyBuyBasket")
	public String modifyBuyBasket(Model model) {
		
		return "admin/buybasket/buybasketModify";
	}
}
