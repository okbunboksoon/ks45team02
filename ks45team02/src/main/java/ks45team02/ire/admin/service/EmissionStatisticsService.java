 package ks45team02.ire.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsDay;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.mapper.EmissionStatisticsMapper;

@Service
public class EmissionStatisticsService {

	
	private static final Logger log = LoggerFactory.getLogger(EmissionStatisticsService.class);
	
	private EmissionStatisticsMapper emissionStatisticsMapper ;
	
	public EmissionStatisticsService(EmissionStatisticsMapper emissionStatisticsMapper) {
		
		this.emissionStatisticsMapper = emissionStatisticsMapper;
	}
	
	
	
	/**
	 * 기부받은 의류별 CO2 일별 통계
	 */
	public void addRawMaterialsEmissionStatisticsDay (RawMaterialsIncoming rawMaterialsIncoming) {
		
		RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay = new RawMaterialsEmissionStatisticsDay();
		
		String rawMaterialsDaygroup = rawMaterialsIncoming.getRawMaterialsDaygroup();
		int resultCheck = emissionStatisticsMapper.rawMaterialsDayCheck(rawMaterialsDaygroup);
		rawMaterialsEmissionStatisticsDay.setRm_incoming_date(rawMaterialsIncoming.getRawMaterialsIncomingDate());
		rawMaterialsEmissionStatisticsDay.setCarbon_dioxide_emission_sum(rawMaterialsIncoming.getCarbonDioxideEmissionLevel());
		
		
		if (resultCheck != 0) {
			emissionStatisticsMapper.addRawMaterialsEmissionStatisticsDay(rawMaterialsEmissionStatisticsDay);
		}else {
			int sumThing = emissionStatisticsMapper.rawMaterialsDayCheck(rawMaterialsDaygroup);
			log.info("sumThing: {}", sumThing);
			float sumThingSpecial = rawMaterialsIncoming.getCarbonDioxideEmissionLevel();
			float sumSpeicalThing = sumThing + sumThingSpecial;
			
			log.info("sumThingSpecial: {}", sumThingSpecial);
			log.info("sumSpeicalThing: {}", sumSpeicalThing);
		}
		
		log.info("resultCheck: {}, rawMaterialsIncoming:{}", resultCheck, rawMaterialsIncoming);
		
		
		
	}
	

}
