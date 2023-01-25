package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
	@GetMapping("")
	public String adminMain(Model model) {
		
		model.addAttribute("title", "Ire Admin");
		return "admin/adminMain";
	}
}