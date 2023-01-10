package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.Quality;
import ks45team02.ire.admin.mapper.QualityMapper;
import ks45team02.ire.admin.service.QualityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class QualityController {

	private static final Logger log = LoggerFactory.getLogger(QualityController.class);

	private final QualityService qualityService;
	private final QualityMapper qualityMapper;

	public QualityController(QualityService qualityService, QualityMapper qualityMapper) {
		this.qualityService = qualityService;
		this.qualityMapper = qualityMapper;
	}

	@GetMapping("/addQualityGeneralLevel")
	public String addQualityGeneralLevel(Model model) {

		List<Quality> qualityGeneralList = qualityMapper.getQualityGeneralLevelList();

		model.addAttribute("title", "일반품질검사기준 등록");
		model.addAttribute("qualityGeneralList", qualityGeneralList);
		return "admin/quality/qualityAddGeneralLevel";
	}

	@PostMapping("/addQualityGeneralLevel")
	public String addQualityGeneralLevel(Quality quality){
		log.info("일반품질검사기준 등록 쿼리 파라미터: {}", quality);
		qualityService.addQualityGeneralLevel(quality);

		return "redirect:/admin/listQualityGeneralLevel";
	}

	@GetMapping("/addQualityHazadousSubstanceLevel")
	public String addQualityHazadousSubstanceLevel(Model model) {

		List<Quality> qualityHazadousSubstanceLevelList = qualityMapper.getQualityHazadousSubstanceLevelList();
		model.addAttribute("title", "유해물질시험검사기준 등록");
		model.addAttribute("qualityHazadousSubstanceLevelList", qualityHazadousSubstanceLevelList);
		
		return "admin/quality/qualityAddHazadousSubstanceLevel";
	}
	@PostMapping("/addQualityHazadousSubstanceLevel")
	public String addQualityHazadousSubstanceLevel(Quality quality){
		log.info("유해물질시험검사기준 등록 쿼리 파라미터: {}", quality);
		qualityService.addQualityHazadousSubstanceLevel(quality);

		return "redirect:/admin/listQualityHazadousSubstanceLevel";

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
	public String listQualityGeneralLevel(Model model) {

		List<Quality> qualityGeneralLevelList = qualityMapper.getQualityGeneralLevelList();
		log.info("일반품질검사기준{}", qualityGeneralLevelList);

		model.addAttribute("title", "일반품질검사기준");
		model.addAttribute("qualityGeneralLevelList", qualityGeneralLevelList);

		
		return "admin/quality/qualityListGeneralLevel";
	}
	@GetMapping("/listQualityHazadousSubstanceLevel")
	public String listQualityHazadousSubstanceLevel(Model model) {

		List<Quality> qualityHazadousSubstanceLevelList = qualityMapper.getQualityHazadousSubstanceLevelList();

		log.info("유해물질시험검사기준{}", qualityHazadousSubstanceLevelList);
		model.addAttribute("title", "유해물질시험검사기준");
		model.addAttribute("qualityHazadousSubstanceLevelList", qualityHazadousSubstanceLevelList);
		
		return "admin/quality/qualityListHazadousSubStanceLevel";
	}
	
	
	@GetMapping("/listQualityInspectionStandard")
	public String listQualityInspectionStandard(Model model) {

		List<Quality> qualityInspectionStandardList = qualityMapper.getQualityInspectionStandardList();

		log.info("품질검사결과조회{}", qualityInspectionStandardList);
		model.addAttribute("title", "품질검사결과조회");
		model.addAttribute("qualityInspectionStandardList", qualityInspectionStandardList);

		
		return "admin/quality/qualityListInspectionStandard";
	}
	@GetMapping("/modifyQualityGeneralLevel")
	public String modifyQualityGeneralLevel(@RequestParam(value = "generalQualityLevel", required = false)
												String generalQualityLevel, Model model) {
		Quality qualityGeneralLevelInfo = qualityService.qualityGeneralLevelInfo(generalQualityLevel);

		model.addAttribute("title", "modifyQualityGeneralLevel");
		model.addAttribute("pageTitle", "일반품질검사기준 수정");
		model.addAttribute("qualityGeneralLevelInfo", qualityGeneralLevelInfo);
		return "admin/quality/qualityModifyGeneralLevel";
	}

	@PostMapping("/modifyQualityGeneralLevel")
	public String modifyQualityGeneralLevel(Quality quality){

		log.info("수정할 일반품질검사기준: {}", quality);
		qualityService.modifyQualityGeneralLevel(quality);
		return "redirect:/admin/listQualityGeneralLevel";
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

