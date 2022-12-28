package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DeliveryController {

	@GetMapping("/addDelivery")
	public String addDelivery(Model model) {
		
		return "/admin/delivery/deliveryAdd";
	}
	
	@GetMapping("/deleteDelivery")
	public String deleteDelivery() {
		
		return "/admin/delivery/deliveryDelete";
	}
	
	@GetMapping("/listDelivery")
	public String listDelivery() {
		
		return "/admin/delivery/deliveryList";
	}
	
	
	@GetMapping("/modifyDelivery")
	public String modifyDelivery() {
		
		return "/admin/delivery/deliveryModify";
	}

}

