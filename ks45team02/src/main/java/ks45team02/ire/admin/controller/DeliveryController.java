package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class DeliveryController {

	@GetMapping("/addDelivery")
	public String addDelivery(Model model,
							  @RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "배송목록");
		model.addAttribute("pageTitle", "배송목록");
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/delivery/deliveryAdd";
	}
	
	@GetMapping("/deleteDelivery")
	public String deleteDelivery() {
		
		return "admin/delivery/deliveryDelete";
	}
	
	
	@GetMapping("/listDelivery")
	public String listDelivery() {
		
		return "admin/delivery/deliveryList";
	}
	
	
	@GetMapping("/modifyDelivery")
	public String modifyDelivery() {
		
		return "admin/delivery/deliveryModify";
	}

}

