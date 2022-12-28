package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserOrderController {

	@GetMapping("/addOrder")
	public String addOrder(Model model) {
		
		return "/user/order/orderAdd";
	}
	
	@GetMapping("/deleteOrder")
	public String deleteOrder() {
		
		return "/user/order/orderDelete";
	}
	
	@GetMapping("/listOrder")
	public String listOrder() {
		
		return "/user/order/orderList";
	}
	
	
	@GetMapping("/modifyOrder")
	public String modifyOrder() {
		
		return "/user/order/orderModify";
	}

}

