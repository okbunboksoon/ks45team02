package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BusinessController {

	@GetMapping("/addBusinessOrder")
	public String addBusinessOrder(Model model) {
		
		return "/admin/businessorder/businessOrderAdd";
	}
	
	@GetMapping("/deleteBusinessOrder")
	public String deleteBusinessOrder() {
		
		return "/admin/businessorder/businessOrderDelete";
	}
	
	@GetMapping("/listBusinessOrder")
	public String listBusinessOrder() {
		
		return "/admin/businessorder/businessOrderList";
	}
	
	
	@GetMapping("/modifyBusinessOrder")
	public String modifyBusinessOrder() {
		
		return "/admin/businessorder/businessOrderModify";
	}

}

