package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ContractController {

	@GetMapping("/addContract")
	public String addContract(Model model) {
		
		return "admin/contract/contractAdd";
	}
	
	@GetMapping("/deleteContract")
	public String deleteContract() {
		
		return "admin/contract/contractDelete";
	}
	
	@GetMapping("/listContract")
	public String listContract() {
		
		return "admin/contract/contractList";
	}
	
	
	@GetMapping("/modifyContract")
	public String modifyContract() {
		
		return "admin/contract/contractModify";
	}

}

