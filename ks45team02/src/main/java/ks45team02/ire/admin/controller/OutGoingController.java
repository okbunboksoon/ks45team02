package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OutGoingController {

	@GetMapping("/addOutGoing")
	public String addOutGoing(Model model) {
		
		return "/admin/outgoing/outgoingAdd";
	}
	
	@GetMapping("/deleteOutGoing")
	public String deleteOutGoing() {
		
		return "/admin/outgoing/outgoingDelete";
	}
	
	@GetMapping("/listOutGoing")
	public String listOutGoing() {
		
		return "/admin/outgoing/outgoingList";
	}
	
	
	@GetMapping("/modifyOutGoing")
	public String modifyOutGoing() {
		
		return "/admin/outgoing/outgoingModify";
	}

}

