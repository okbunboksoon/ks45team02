package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class EmissionController {

	@GetMapping("/addEmission")
	public String addEmission(Model model) {
		
		return "/admin/emission/emissionAdd";
	}
		
	@GetMapping("/deleteEmission")
	public String deleteEmission() {
		
		return "/admin/emission/emissionDelete";
	}
	
	@GetMapping("/listEmissionC02GoodsTotal")
	public String listEmissionC02GoodsTotal() {
		
		return "/admin/emission/emissionListCO2goodsTotal";
	}
		
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "/admin/emission/emissionListCO2Total";
	}
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics() {
		
		return "/admin/emission/emissionListRawMaterialsGroupStatistics";
	}
	@GetMapping("/modifyEmission")
	public String modifyEmission() {
		
		return "/admin/emission/emissionModify";
	}
}

