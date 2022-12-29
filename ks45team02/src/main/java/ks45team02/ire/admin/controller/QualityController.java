package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class QualityController {

	@GetMapping("/addQualityGeneralLevel")
	public String addQualityGeneralLevel(Model model) {
		
		return "admin/quality/qualityAddGeneralLevel";
	}
	
	@GetMapping("/addQualityHazadousSubstanceLevel")
	public String addQualityHazadousSubstanceLevel() {
		
		return "admin/quality/qualityAddHazadousSubstanceLevel";
	}
	@GetMapping("/deleteQualityGeneralLevel")
	public String deleteQualityGeneralLevel() {
		
		return "admin/quality/qualityDeleteGeneralLevel";
	}
	@GetMapping("/deleteQualityHazadousSubstanceLevel")
	public String deleteQualityHazadousSubstanceLevel() {
		
		return "admin/quality/qualityDeleteHazadousSubstanceLevel";
	}
	@GetMapping("/listQualityGeneralLevel")
	public String listQualityGeneralLevel() {
		
		return "admin/quality/qualityListGeneralLevel";
	}
	@GetMapping("/listQualityHazadousSubstanceLevel")
	public String listQualityHazadousSubstanceLevel() {
		
		return "admin/quality/qualityListHazadousSubStanceLevel";
	}
	
	
	@GetMapping("/listQualityInspectionStandard")
	public String listQualityInspectionStandard() {
		
		return "admin/quality/qualityListInspectionStandard";
	}
	@GetMapping("/modifyQualityGeneralLevel")
	public String modifyQualityGeneralLevel() {
		
		return "admin/quality/qualityModifyGeneralLevel";
	}
	@GetMapping("/modifyQualityHazadousSubstanceLevel")
	public String modifyQualityHazadousSubstanceLevel() {
		
		return "admin/quality/qualityModifyHazadousSubstanceLevel";
	}
	
	@GetMapping("/requestQualityInspection")
	public String requestQualityInspection() {
		
		return "admin/quality/qualityRequestInspection";
	}
}

