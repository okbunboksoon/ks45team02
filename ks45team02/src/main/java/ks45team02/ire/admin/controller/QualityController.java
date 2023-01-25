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
import java.util.Map;

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
	public String deleteQualityGeneralLevel(@RequestParam(value = "generalQualityLevel", required = false )String generalQualityLevel, Model model) {

		log.info("일반품질검사기준: {}", generalQualityLevel);
		Quality deleteQualityGeneralLevelInfo = qualityService.deleteQualityGeneralLevelInfo(generalQualityLevel);
		log.info("일반품질검사 기준 삭제: {}", deleteQualityGeneralLevelInfo);
		model.addAttribute("deleteQualityGeneralLevelInfo", deleteQualityGeneralLevelInfo);
		
		return "admin/quality/qualityDeleteGeneralLevel";
	}
	@PostMapping("/deleteQualityGeneralLevel")
	public String deleteQualityGeneralLevel(Quality quality){

		log.info("삭제할 일반품질검사기준: {}", quality);
		qualityService.deleteQualityGeneralLevel(quality);

		return "redirect:/admin/listQualityGeneralLevel";
	}
	@GetMapping("/deleteQualityHazadousSubstanceLevel")
	public String deleteQualityHazadousSubstanceLevel(@RequestParam(value = "hazadousQualityLevel", required = false)
														  String hazadousQualityLevel, Model model) {
		log.info("유해물질검사기준:{}", hazadousQualityLevel);
		Quality deleteQualityHazadousSubstanceLevelInfo = qualityService.deleteQualityHazadousSubstanceLevelInfo(hazadousQualityLevel);
		log.info("유해물질검사기준 삭제 : {}", deleteQualityHazadousSubstanceLevelInfo);
		model.addAttribute("deleteQualityHazadousSubstanceLevelInfo", deleteQualityHazadousSubstanceLevelInfo);
		return "admin/quality/qualityDeleteHazadousSubstanceLevel";
	}
	@PostMapping("/deleteQualityHazadousSubstanceLevel")
	public String deleteQualityHazadousSubstanceLevel(Quality quality){
		log.info("삭제할 유해물질시험검사기준 : {}", quality);
		qualityService.deleteQualityHazadousSubstanceLevel(quality);

		return "redirect:/admin/listQualityHazadousSubstanceLevel";
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
	public String modifyQualityHazadousSubstanceLevel(@RequestParam(value = "hazadousQualityLevel", required = false)
													  String hazadousQualityLevel, Model model) {

		Quality qualityHazadousSubstanceLevelInfo = qualityService.qualityHazadousSubstanceLevelInfo(hazadousQualityLevel);

		model.addAttribute("title", "modifyQualityHazadousSubstanceLEvel");
		model.addAttribute("pageTitle", "유해물질검사기준 수정");
		model.addAttribute("qualityHazadousSubstanceLevelInfo", qualityHazadousSubstanceLevelInfo);

		
		return "admin/quality/qualityModifyHazadousSubstanceLevel";
	}
	@PostMapping("/modifyQualityHazadousSubstanceLevel")
	public String modifyQualityHazadousSubstanceLevel(Quality quality){
		log.info("수정할 유해물질검사기준: {}", quality);
		qualityService.modifyQualityHazadousSubstanceLevel(quality);
		return "redirect:/admin/listQualityHazadousSubstanceLevel";
	}
	
	@GetMapping("/requestQualityInspection")
	public String requestQualityInspection(Model model) {


		List<Quality> qualityInspectionRequestList = qualityMapper.qualityInspectionRequestList();
		model.addAttribute("title", qualityInspectionRequestList);
		model.addAttribute("qualityInspectionRequestList", qualityInspectionRequestList);
		
		return "admin/quality/qualityRequestInspection";
	}

	@GetMapping("/addRequestQualityInspection")
	public String addRequestQualityInspection(Model model){

		List<Map<String, Object>> qualityInspectionRequestInfo = qualityMapper.qualityInspectionRequestInfo();
		log.info("입고코드 조회:{}", qualityInspectionRequestInfo);
		model.addAttribute("title", "입고코드 등록");
		model.addAttribute("qualityInspectionRequestInfo", qualityInspectionRequestInfo);

		return "admin/quality/qualityAddRequestQualityInspection";
	}
	@PostMapping("/addRequestQualityInspection")
	public String addRequestQualityInspection(Quality quality) {
		log.info("품질검사요청 파라미터: {} ", quality);
		qualityService.addRequestQualityInspection(quality);
		qualityService.addInspectionStandard(quality);
		return "redirect:/admin/requestQualityInspection";
	}

	@GetMapping("addInspectionStandard")
	public String addInspectionStandard(Model model){
		Quality InspectionStandardInfo = qualityMapper.InspectionStandardInfo();
		log.info("검사 목록 조회:{}", InspectionStandardInfo);
		model.addAttribute("title", "검사 목록 조회");
		model.addAttribute("InspectionStandardInfo", InspectionStandardInfo);

		return "admin/quality/qualityAddInspectionStandard";
	}
}

