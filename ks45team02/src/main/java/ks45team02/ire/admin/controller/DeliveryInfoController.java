package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class DeliveryInfoController {

	@GetMapping("/addDeliveryInfo")
	public String addDelivery(Model model,
							  @RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "배송목록지");
		model.addAttribute("pageTitle", "배송목록지");
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/delivery/deliveryAdd";
	}
	
	@GetMapping("/deleteDeliveryInfo")
	public String deleteDelivery() {
		
		return "admin/delivery/deliveryDelete";
	}
	
	
	@GetMapping("/listDeliveryInfo")
	public String listDelivery() {
		
		return "admin/delivery/deliveryList";
	}
	
	
	@GetMapping("/modifyDeliveryInfo")
	public String modifyDelivery() {
		
		return "admin/delivery/deliveryModify";
	}

}

