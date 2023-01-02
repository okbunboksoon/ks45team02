package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.Donation;
import ks45team02.ire.admin.service.DonationService;

@Controller
@RequestMapping("/admin")
public class DonationController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DonationController.class);

	private final DonationService donationService;
	
	public DonationController(DonationService donationService) {
		this.donationService = donationService;
	}
	
	@PostMapping("/addDonation")
	public String addDonation(Donation donation, RedirectAttributes reAttr) {
		
		int result = donationService.addDonation(donation);

		if(result == 0) {
			reAttr.addAttribute("msg", "기부 등록에 실패하였습니다.");
			return "redirect:/admin/addDonation";
		}else{
			reAttr.addAttribute("msg", "기부 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listDonation";
	}

	@GetMapping("/addDonation")
	public String addDonation(Model model
							 ,@RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "기부 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}

		return "admin/donation/donationAdd";
	}
	
	@GetMapping("/addDonationPointSave")
	public String addDonationPointSave() {
		
		return "admin/donation/donationAddPointSave";
	}
	
	@GetMapping("/deleteDonation")
	public String deleteDonation() {
		
		return "admin/donation/donationDelete";
	}
	
	//기부 조회
	@GetMapping("/listDonation")
	public String listDonation(@RequestParam(value="searchKey", required=false) String searchKey
							  ,@RequestParam(value="searchValue", required=false) String searchValue
							  ,@RequestParam(value="startDate", required=false) String startDate		
							  ,@RequestParam(value="endDate", required=false) String endDate	
							  ,@RequestParam(value="msg", required=false)String msg
							  ,Model model) {
		
		List<Donation> donationList = donationService.getDonationList(searchKey, searchValue, startDate, endDate);
		
		model.addAttribute("title", "기부 조회");
		model.addAttribute("donationList", donationList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/donation/donationList";
	}
		
	@GetMapping("/modifyDonation")
	public String modifyDonation() {
		
		return "admin/donation/donationModify";
	}

}

