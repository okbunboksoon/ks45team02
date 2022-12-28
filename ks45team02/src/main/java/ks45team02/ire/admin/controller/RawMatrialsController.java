package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RawMatrialsController {

	@GetMapping("/addIncomingRawMatrials")
	public String addIncomingRawMatrials(Model model) {
		
		return "/admin/rawmatrials/rawmatrialsAddIncoming.html";
	}
	@GetMapping("/addoutgoingRawMatrials")
	public String addoutgoingRawMatrials(Model model) {
		
		return "/admin/rawmatrials/rawmatrialsAddOutgoing.html";
	}
	
	@GetMapping("/deleteIncomingRawMatrials")
	public String deleteIncomingRawMatrials() {
		
		return "/admin/rawmatrials/rawmatrialsDeleteIncoming.html";
	}
	@GetMapping("/deleteoutgoingRawMatrials")
	public String deleteoutgoingRawMatrials() {
		
		return "/admin/rawmatrials/rawmatrialsDeleteOutgoing.html";
	}
	@GetMapping("/listIncomingRawMatrials")
	public String listIncomingRawMatrials() {
		
		return "/admin/rawmatrials/rawmatrialsListIncoming.html";
	}
	@GetMapping("/listNowRawMatrials")
	public String listNow() {
		
		return "/admin/rawmatrials/rawmatrialsListNow.html";
	}
	@GetMapping("/listOutgoingRawMatrials")
	public String listOutgoing() {
		
		return "/admin/rawmatrials/rawmatrialsListOutgoing.html";
	}
	@GetMapping("/modifyIncomingRawMatrials")
	public String modifyIncomingRawMatrials() {
		
		return "/admin/rawmatrials/rawmatrialsModifyIncoming.html";
	}
	@GetMapping("/modifyOutgoingRawMatrials")
	public String modifyOutgoingRawMatrials() {
		
		return "/admin/rawmatrials/rawmatrialsModifyOutgoing.html";
	}
	
	
	@GetMapping("/totalRawMatrialsInOut")
	public String totalRawMatrialsInOut() {
		
		return "/admin/rawmatrials/rawmatrialsTotalInOut.html";
	}
	

}

