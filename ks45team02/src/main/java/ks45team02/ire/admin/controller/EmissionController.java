package ks45team02.ire.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.Emission;
import ks45team02.ire.admin.service.EmissionService;


@Controller
@RequestMapping("/admin")
public class EmissionController {
	
	private final EmissionService emissionService;
	
	public EmissionController (EmissionService emissionService) {
		this.emissionService = emissionService;
		
	}
	
	@GetMapping("/addEmission")
	public String addEmission(Model model) {
		
		return "admin/emission/emissionAdd";
	}
		
	@GetMapping("/deleteEmission")
	public String deleteEmission() {
		
		return "admin/emission/emissionDelete";
	}
	
	@GetMapping("/listEmissionC02GoodsTotal")
	public String listEmissionC02GoodsTotal(Model model) {
		
		List<Emission> EmissionList = emissionService.EmissionList();
		model.addAttribute("EmissionList", EmissionList);
		
		return "admin/emission/emissionListCO2goodsTotal";
	}
		
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "admin/emission/emissionListCO2Total";
	}
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics() {
		
		return "admin/emission/emissionListRawMaterialsGroupStatistics";
	}
	@GetMapping("/modifyEmission")
	public String modifyEmission() {
		
		return "admin/emission/emissionModify";
	}
}

