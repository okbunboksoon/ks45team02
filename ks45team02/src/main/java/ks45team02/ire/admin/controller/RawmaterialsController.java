package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/admin")
public class RawmaterialsController {
	
	private static final Logger log=
	 LoggerFactory.getLogger(RawmaterialsController.class);
	
	
	

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
		
		return "admin/rawmaterials/rawmaterialsDeleteOutgoing";
	}
	@GetMapping("/listIncomingRawmaterials")
	public String listIncomingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsListIncoming";
	}
	@GetMapping("/listNowRawmaterials")
	public String listNow() {
		
		return "admin/rawmaterials/rawmaterialsListNow";
	}
	@GetMapping("/listOutgoingRawmaterials")
	public String listOutgoingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsListOutgoing";
	}
	@GetMapping("/modifyIncomingRawmaterials")
	public String modifyIncomingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsModifyIncoming";
	}
	@GetMapping("/modifyOutgoingRawmaterials")
	public String modifyOutgoingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsModifyOutgoing";
	}
	
	
	@GetMapping("/totalRawmaterialsInOut")
	public String totalRawMatrialsInOut() {
		
		return "admin/rawmaterials/rawmaterialsTotalInOut";
	}
	

}

