package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {

	@GetMapping("/")
	public String userMain(Model model) {
		
		model.addAttribute("title", "Ire");
		return "user/userMain";
	}
}
