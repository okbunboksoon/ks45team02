package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.*;
import ks45team02.ire.admin.service.EmissionStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmissionStatisticsController {
	
	 
	private static final Logger log = LoggerFactory.getLogger(EmissionStatisticsController.class);

	private final EmissionStatisticsService emissionStatisticsService;
	
	public EmissionStatisticsController (EmissionStatisticsService emissionStatisticsService) {
		this.emissionStatisticsService = emissionStatisticsService;
	}
	
	
	/**
	 * 기부받은 의류 CO2 일 통계 조회
	 * @return
	 */
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics(Model model) {
		
		List<RawMaterialsEmissionStatisticsDay> getListRawMaterialsEmissionStatisticsDay = emissionStatisticsService.getListRawMaterialsEmissionStatisticsDay();
		
		model.addAttribute("title", "기부받은 의류 일 통계 자료");
		model.addAttribute("pageTitle", "기부받은 의류 일 통계 자료");
		model.addAttribute("getListRawMaterialsEmissionStatisticsDay", getListRawMaterialsEmissionStatisticsDay);
		
		log.info("getListRawMaterialsEmissionStatisticsDay: {}", getListRawMaterialsEmissionStatisticsDay);
		return "admin/emissionstatistics/emissionListRawMaterialsGroupStatistics";
	}
	
	/**
	 * 기부받은 의류 CO2 월 통계 조회
	 * @return
	 */
	@GetMapping("/listEmissionRawMaterialsGroupStatisticsMonth")
	public String listEmissionRawMaterialsGroupStatisticsMonth(Model model) {
		
		List<RawMaterialsEmissionStatisticsMonth> rmmsList = emissionStatisticsService.rawMaterialsMonthSearch();
		
		model.addAttribute("title", "기부받은 의류 월 통계 자료");
		model.addAttribute("pageTitle", "기부받은 의류 월 통계 자료");
		model.addAttribute("rmmsList", rmmsList);
		
		log.info("rmmsList: {}", rmmsList);
		return "admin/emissionstatistics/emissionListRawMaterialsGroupStatisticsMonth";
	}
	
	/**
	 * 기부받은 의류 CO2 년 통계 조회
	 * @return
	 */
	@GetMapping("/listEmissionRawMaterialsGroupStatisticsYear")
	public String listEmissionRawMaterialsGroupStatisticsYear(Model model) {
		
		List<RawMaterialsEmissionStatisticsYear> rmysList = emissionStatisticsService.rawMaterialsYearhSearch();
		
		model.addAttribute("title", "기부받은 의류 년 통계 자료");
		model.addAttribute("pageTitle", "기부받은 의류 년 통계 자료");
		model.addAttribute("rmysList", rmysList);
		
		log.info("rmysList: {}", rmysList);
		return "admin/emissionstatistics/emissionListRawMaterialsGroupStatisticsYear";
	}
	
	 
	public void addRawMaterialsEmissionStatisticsDay(RawMaterialsIncoming rawMaterialsIncoming) {
		
		RawMaterialsEmissionStatisticsDay dayList = emissionStatisticsService.addRawMaterialsEmissionStatisticsDay(rawMaterialsIncoming);

		RawMaterialsEmissionStatisticsMonth monthList = emissionStatisticsService.addRawMaterialsEmissionStatisticsMonth(dayList);
		emissionStatisticsService.addRawMaterialsEmissionStatisticsYear(monthList);
	}
	
	
	/**
	 * 일반상품 / 업사이클링 상품 CO2 비교 통계 
	 */
	@GetMapping("/listEmissionCO2Total")
	
	public String listEmissionCO2Total(Model model) {
		List<EmissionTotal> emissionTotal = emissionStatisticsService.getEmissionListCo2Total();
		log.info("emissionTotal: {}", emissionTotal);
		model.addAttribute("title", "일반상품 / 업사이클링 상품 CO2 비교");
		model.addAttribute("pageTitle", "일반상품 / 업사이클링 상품 CO2 비교");		
		model.addAttribute("emissionTotal", emissionTotal);		
		
		
		return "admin/emissionstatistics/emissionListCO2Total";
	}
	
}
