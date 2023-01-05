package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BusinessController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final BusinessService businessService;

	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}

	//거래처추가
	@GetMapping("/addBusiness")
	public String addBusiness(Model model) {
		model.addAttribute("title","addBusiness");
		model.addAttribute("pageTitle","거래처추가");
		return "admin/business/businessAdd";
	}
	@PostMapping("/addBusiness")
	public String addBusiness(Business business){
		businessService.addBusiness(business);
		log.info("거래처추가:{}",business);
		return "redirect:/admin/listBusiness";
	}
	
	@GetMapping("/deleteBusiness")
	public String deleteBusiness() {
		
		return "admin/business/businessDelete";
	}
	//거래처 조회
	@GetMapping("/listBusiness")
	public String listBusiness(Model model) {
		model.addAttribute("title","contract");
		model.addAttribute("pageTitle","거래처 조회");
		List<Business>businessList=businessService.businessList();
		model.addAttribute("businessList",businessList);
		return "admin/business/businessList";
	}
	
	//거래처 수정
	@GetMapping("/modifyBusiness")
	public String modifyBusiness(Model model,
								 @RequestParam(value = "businessCode",required = false)String businessCode) {
		model.addAttribute("title","modifyBusiness");
		model.addAttribute("pageTitle","거래처수정");
		Business businessInfo=businessService.getInfoByBusiness(businessCode);
		model.addAttribute("businessInfo",businessInfo);
		return "admin/business/businessModify";
	}
	@PostMapping("/modifyBusiness")
	public String modifyBusiness(Business business){
		businessService.modifyBusiness(business);
		return "redirect:/admin/listBusiness";
	}

}

