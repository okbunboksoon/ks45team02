package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.Emission;
import ks45team02.ire.admin.service.EmissionService;


@Controller
@RequestMapping("/admin")
public class EmissionController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmissionController.class);

	
	private final EmissionService emissionService;
	
	public EmissionController (EmissionService emissionService) {
		this.emissionService = emissionService;
		
	}
	
	@GetMapping("/addRawMaterials")
	public String addRawMaterials() {
		
		return "admin/emission/emissionAddRawMaterials";
	}
	
	@GetMapping("/modifyRawMaterials")
	public String modifyRawMaterials() {
		
		return "admin/emission/emissionModifyRawMaterials";
	}
	
	@GetMapping("/deleteRawMaterials")
	public String deleteRawMaterials() {
		
		return "admin/emission/emissionDeleteRawMaterials";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/listRawMaterialsEmission")
	public String listRawMaterialsEmission(Model model) {
		
		List<Emission> rawMaterialsEmissionList = emissionService.getRawMaterialsEmissionList();

		model.addAttribute("rawMaterialsEmissionList", rawMaterialsEmissionList);
		model.addAttribute("title", "기부받은 의류 CO2 기준 리스트");
		return "admin/emission/emissionListRawMaterials";
	}
	
	
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics() {
		
		return "admin/emission/emissionListRawMaterialsGroupStatistics";
	}
	
	
	@GetMapping("/addEmission")
	public String addEmission(Model model) {
		
		return "admin/emission/emissionAdd";
	}
		
	@GetMapping("/deleteEmission")
	public String deleteEmission() {
		
		return "admin/emission/emissionDelete";
	}
	
	@GetMapping("/modifyEmission")
	public String modifyEmission() {
		
		return "admin/emission/emissionModify";
	}
	
	@GetMapping("/listEmission")
	public String listEmission(Model model) {
		
		return "admin/emission/emissionList";
	}
		
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "admin/emission/emissionListCO2Total";
	}
	

}

