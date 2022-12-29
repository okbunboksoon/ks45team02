package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RawmaterialsController {

	@GetMapping("/addIncomingRawmaterials")
	public String addIncomingRawMatrials(Model model) {
		
		return "admin/rawmatrials/rawmaterialsAddIncoming";
	}
	@GetMapping("/addoutgoingRawmaterials")
	public String addoutgoingRawMatrials(Model model) {
		
		return "admin/rawmatrials/rawmaterialsAddOutgoing";
	}
	
	@GetMapping("/deleteIncomingRawmaterials")
	public String deleteIncomingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsDeleteIncoming";
	}
	@GetMapping("/deleteoutgoingRawmaterials")
	public String deleteoutgoingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsDeleteOutgoing";
	}
	@GetMapping("/listIncomingRawmaterials")
	public String listIncomingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsListIncoming";
	}
	@GetMapping("/listNowRawmaterials")
	public String listNow() {
		
		return "admin/rawmatrials/rawmaterialsListNow";
	}
	@GetMapping("/listOutgoingRawmaterials")
	public String listOutgoingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsListOutgoing";
	}
	@GetMapping("/modifyIncomingRawmaterials")
	public String modifyIncomingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsModifyIncoming";
	}
	@GetMapping("/modifyOutgoingRawmaterials")
	public String modifyOutgoingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsModifyOutgoing";
	}
	
	
	@GetMapping("/totalRawmaterialsInOut")
	public String totalRawMatrialsInOut() {
		
		return "admin/rawmatrials/rawmaterialsTotalInOut";
	}
	

}

