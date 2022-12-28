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
		
		return "/admin/business/businessAdd";
	}
	
	@GetMapping("/deleteBusiness")
	public String deleteBusiness() {
		
		return "/admin/business/businessDelete";
	}
	
	@GetMapping("/listBusiness")
	public String listBusiness() {
		
		return "/admin/business/businessList";
	}
	
	
	@GetMapping("/modifyBusiness")
	public String modifyBusiness() {
		
		return "/admin/business/businessModify";
	}

}

