package ks45team02.ire.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.service.EmissionStatisticsService;

@Controller
@RequestMapping("/admin")
public class EmissionStatisticsController {
	
	 
	private static final Logger log = LoggerFactory.getLogger(EmissionStatisticsController.class);

	private final EmissionStatisticsService emissionStatisticsService;
	
	public EmissionStatisticsController (EmissionStatisticsService emissionStatisticsService) {
		this.emissionStatisticsService = emissionStatisticsService;
	}
	
	
	/**
	 * 기부받은 의류 CO2 일,월,년 통계
	 * @return
	 */
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics() {
		
		return "admin/emissionstatistics/emissionListRawMaterialsGroupStatistics";
	}
	
	
	
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "admin/emissionstatistics/emissionListCO2Total";
	}
	
	
	
}
