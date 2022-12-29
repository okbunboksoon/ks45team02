package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BusinessOrderController {

	@GetMapping("/addBusiness")
	public String addBusiness(Model model) {
		
		return "admin/businessorder/businessOrderAdd";
	}
	
	@GetMapping("/deleteBusiness")
	public String deleteBusiness() {
		
		return "admin/businessorder/businessOrderDelete";
	}
	
	@GetMapping("/listBusiness")
	public String listBusiness() {
		
		return "admin/businessorder/businessOrderList";
	}
	
	
	@GetMapping("/modifyBusiness")
	public String modifyBusiness() {
		
		return "admin/businessorder/businessOrderModify";
	}

}

