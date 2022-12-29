package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class IncomingController {

	@GetMapping("/addIncoming")
	public String addIncoming(Model model) {
		
		return "admin/incoming/incomingAdd";
	}
	
	@GetMapping("/deleteIncoming")
	public String deleteIncoming() {
		
		return "admin/incoming/incomingDelete";
	}
	
	@GetMapping("/listIncoming")
	public String listIncoming() {
		
		return "admin/incoming/incomingList";
	}
	
	
	@GetMapping("/listIncomingStock")
	public String listIncomingStock() {
		
		return "admin/incoming/incomingListStock";
	}
	@GetMapping("/modifyIncoming")
	public String modifyIncoming() {
		
		return "admin/incoming/incomingModify";
	}

}

