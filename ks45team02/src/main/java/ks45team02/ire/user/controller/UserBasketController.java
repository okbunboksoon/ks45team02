package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserBasketController {
	@GetMapping("/addBasket")
	public String addBasket(Model model) {
		
		return "/user/basket/basketAdd";
	}
	
	@GetMapping("/deleteBasket")
	public String deleteBasket() {
		
		return "/user/basket/basketDelete";
	}
	
	@GetMapping("/listBasket")
	public String listBasket() {
		
		return "/user/basket/basketList";
	}
	
	
	@GetMapping("/modifyBasket")
	public String modifyBasket() {
		
		return "/user/basket/basketList";
	}

}
