package ks45team02.ire.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.mapper.EmissionStatisticsMapper;

@Service
public class EmissionStatisticsService {

	
	private static final Logger log = LoggerFactory.getLogger(EmissionStatisticsService.class);
	
	private EmissionStatisticsMapper emissionStatisticsMapper ;
	
	public EmissionStatisticsService(EmissionStatisticsMapper emissionStatisticsMapper) {
		
		this.emissionStatisticsMapper = emissionStatisticsMapper;
	}
}
