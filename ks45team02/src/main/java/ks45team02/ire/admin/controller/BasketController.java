package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BasketController {

	@GetMapping("/addBasket")
	public String addBasket(Model model) {
		
		return "/admin/basket/basketAdd";
	}
	
	@GetMapping("/deleteBasket")
	public String deleteBasket() {
		
		return "/admin/basket/basketDelete";
	}
	
	@GetMapping("/listBasket")
	public String listBasket() {
		
		return "/admin/basket/basketList";
	}
	
	
	@GetMapping("/modifyBasket")
	public String modifyBasket() {
		
		return "/admin/basket/basketModify";
	}

}

