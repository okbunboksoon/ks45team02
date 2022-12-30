package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserDonationController {

	
	@GetMapping("/listDonation")
	public String listDonation() {
		
		return "user/donation/donationList";
	}
		
	
	@GetMapping("/addDonation")
	public String addDonation(Model model) {
		
		return "user/donation/donationAdd";
	}

}

