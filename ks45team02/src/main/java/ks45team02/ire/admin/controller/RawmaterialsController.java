package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;
import ks45team02.ire.admin.service.RawMaterialsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RawmaterialsController {
	
	private static final Logger log=
	 LoggerFactory.getLogger(RawmaterialsController.class);
	
	private final RawMaterialsMapper rawmaterialsMapper;
	private final RawMaterialsService rawmaterialsService;
	
	public RawmaterialsController(RawMaterialsService rawmaterialsService,
			
			RawMaterialsMapper rawmaterialsMapper) {
		this.rawmaterialsMapper =rawmaterialsMapper;
		this.rawmaterialsService=rawmaterialsService;
		
	}
	
	
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
	public String totalRawMatrialsInOut(Model model) {
		List<RawMaterials> rawmaterialsList =rawmaterialsService.rawmaterialsList();
		
		model.addAttribute("title", "원자재리스트");
		model.addAttribute("rawmaterialsList",rawmaterialsList);
		log.info("찍히나?");
	
		return "admin/rawmaterials/rawmaterialsTotalInOut";
	}
	

}

