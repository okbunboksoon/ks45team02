package ks45team02.ire.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
}
