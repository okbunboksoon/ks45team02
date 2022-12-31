package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

	@GetMapping("/addDonation")
	public String addDonation(Model model) {
		
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
	
	@GetMapping("/listDonation")
	public String listDonation(Model model) {
		
		List<Donation> donationList = donationService.getDonationList();
		
		model.addAttribute("title", "기부 조회");
		model.addAttribute("donationList", donationList);
		
		return "admin/donation/donationList";
	}
		
	@GetMapping("/modifyDonation")
	public String modifyDonation() {
		
		return "admin/donation/donationModify";
	}

}

