package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BuynowController {

	@GetMapping("/addBuyNow")
	public String addBuyNow(Model model) {
		
		return "admin/buynow/buynowAdd";
	}
	@GetMapping("/deleteBuyNow")
	public String deleteBuyNow(Model model) {
		
		return "admin/buynow/buynowDelete";
	}
	
	//즉시결제 조회 페이지
	@GetMapping("/listBuyNow")
	public String listBuyNow(Model model) {
		
		
		return "admin/buynow/buynowList";
	}
	@GetMapping("/modifyBuyNow")
	public String modifyBuyNow(Model model) {
		
		return "admin/buynow/buynowModify";
	}
}
