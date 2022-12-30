package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DonationController {

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
	public String listDonation() {
		
		return "admin/donation/donationList";
	}
		
	@GetMapping("/modifyDonation")
	public String modifyDonation() {
		
		return "admin/donation/donationModify";
	}

}

