package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OrderController {

	@GetMapping("/addOrder")
	public String addOrder(Model model) {
		
		return "/admin/order/orderAdd";
	}
	
	@GetMapping("/deleteOrder")
	public String deleteOrder() {
		
		return "/admin/order/orderDelete";
	}
	
	@GetMapping("/listOrder")
	public String listOrder() {
		
		return "/admin/order/orderList";
	}
	
	
	@GetMapping("/modifyOrder")
	public String modifyOrder() {
		
		return "/admin/order/orderModify";
	}

}

