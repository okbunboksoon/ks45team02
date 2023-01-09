package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.service.BuynowService;

@Controller
@RequestMapping("/admin")
public class BuynowController {
	
	private static final Logger log = LoggerFactory.getLogger(BuynowController.class);

	private static BuynowService buynowService;
	
	public BuynowController(BuynowService buynowService) {
		this.buynowService = buynowService;
	}
	
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
	public String listBuyNow(Model model
							,@RequestParam(value="msg", required = false) String msg) {
		
		List<Buynow> buynowList = buynowService.getBuynowList();
		
		model.addAttribute("title", "즉시결제 조회");
		model.addAttribute("pageTitle", "즉시결제 조회");
		model.addAttribute("buynowList", buynowList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buynow/buynowList";
	}
	@GetMapping("/modifyBuyNow")
	public String modifyBuyNow(Model model) {
		
		return "admin/buynow/buynowModify";
	}
}
