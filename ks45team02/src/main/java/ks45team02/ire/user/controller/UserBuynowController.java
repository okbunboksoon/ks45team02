package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserBuynowController {

	
	@GetMapping("/addBuyNow")
	public String addBuyNow() {
		
		return "user/buynow/buynowAdd";
	}
}
