 package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsDay;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.mapper.EmissionStatisticsMapper;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;

@Service
public class EmissionStatisticsService {

	
	private static final Logger log = LoggerFactory.getLogger(EmissionStatisticsService.class);
	
	private EmissionStatisticsMapper emissionStatisticsMapper ;
	private RawMaterialsMapper rawMaterialsMapper;
	
	public EmissionStatisticsService(EmissionStatisticsMapper emissionStatisticsMapper, RawMaterialsMapper rawMaterialsMapper) {
		
		this.emissionStatisticsMapper = emissionStatisticsMapper;
		this.rawMaterialsMapper = rawMaterialsMapper;
	}
	
	/**
	 * 기부받은 의류별 CO2 일별 통계 전체 조회
	 */
	public List<RawMaterialsEmissionStatisticsDay>  getListRawMaterialsEmissionStatisticsDay() {
		
		List<RawMaterialsEmissionStatisticsDay> rawMaterialsEmissionStatisticsDayList = emissionStatisticsMapper.rawMaterialsDaySearch();
		
		return rawMaterialsEmissionStatisticsDayList;
	}
	
	/**
	 * 기부받은 의류별 CO2 일별 통계
	 */
	public void addRawMaterialsEmissionStatisticsDay (RawMaterialsIncoming rawMaterialsIncoming) {
		log.info("기부받은 의류별 CO2 일별 통계 / rawMaterialsIncoming :{}", rawMaterialsIncoming);
		
		int result = 0;
		
		RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay = new RawMaterialsEmissionStatisticsDay();
		
		String rawMaterialsDaygroup = rawMaterialsMapper.getLastRawMaterialsDaygroup();
		log.info("기부받은 의류별 CO2 일별 통계 / rawMaterialsDaygroup :{}", rawMaterialsDaygroup);
		
		// 일별 기부상품 입고 그룹 존재 확인
		int resultCheck = emissionStatisticsMapper.rawMaterialsDayCheck(rawMaterialsDaygroup);
		log.info("기부받은 의류별 CO2 일별 통계 / resultCheck :{}", resultCheck);
		
		// 기부받은 의류별 CO2 일별 등록날짜 생성
		String addYearAndMonth = emissionStatisticsMapper.addYearAndMonth(rawMaterialsIncoming.getRawMaterialsCode());
		log.info("기부받은 의류별 CO2 일별 통계 / addYearAndMonth :{}", addYearAndMonth);
		
		// 고객으로부터 받은 기부의류 입고날짜
		rawMaterialsEmissionStatisticsDay.setRm_incoming_date(rawMaterialsIncoming.getRawMaterialsIncomingDate());
		
		// 고객으로부터 받은 기부의류 일반 상품별 이산화탄소 배출량
		rawMaterialsEmissionStatisticsDay.setCarbon_dioxide_emission_sum(rawMaterialsIncoming.getCarbonDioxideEmissionLevel());
		
		rawMaterialsEmissionStatisticsDay.setRaw_materials_daygroup(rawMaterialsDaygroup);
			
		// 고객으로부터 받은 기부의류 일반 상품별 이산화탄소 배출량 x 원자재 입고 수량
		float carbonDioxideEmissionSum = (rawMaterialsIncoming.getCarbonDioxideEmissionLevel() * rawMaterialsIncoming.getRawMaterialsIncomingAmount());
		log.info("기부받은 의류별 CO2 일별 통계 / carbonDioxideEmissionSum: {}", carbonDioxideEmissionSum);	
			
		// 일별 기부상품 입고 없으면 -> 인서트 / 있으면 -> 업데이트 // *아이디는 나중 세션활성화 될 시 셋팅해줘야함
		if(resultCheck != 0) {
			// 기존 기부받은 의류별 CO2 일별 통계 / 일별 이산화탄소 배출량 합계  
			int sumThing = emissionStatisticsMapper.rawMaterialsDaySumSelect(rawMaterialsDaygroup);
			log.info("기부받은 의류별 CO2 일별 통계 / sumThing: {}", sumThing);
			
			// 기존 기부받은 의류별 CO2 일별 통계 / 일별 이산화탄소 배출량 합계 + 고객으로부터 받은 기부의류 일반 상품별 이산화탄소 배출량
			float sumSpeicalThing = sumThing + carbonDioxideEmissionSum;
			log.info("기부받은 의류별 CO2 일별 통계 / sumSpeicalThing: {}", sumSpeicalThing);
			
			rawMaterialsEmissionStatisticsDay.setCarbon_dioxide_emission_sum(sumSpeicalThing);
			log.info("기부받은 의류별 CO2 일별 통계 / update : {}", rawMaterialsEmissionStatisticsDay);
			result = emissionStatisticsMapper.rawMaterialsDayUpdate(rawMaterialsEmissionStatisticsDay);
			
		}else {
			rawMaterialsEmissionStatisticsDay.setCarbon_dioxide_emission_sum(carbonDioxideEmissionSum);
			rawMaterialsEmissionStatisticsDay.setYear_and_month(addYearAndMonth);
			log.info("기부받은 의류별 CO2 일별 통계 / insert : {}", rawMaterialsEmissionStatisticsDay);
			result = emissionStatisticsMapper.rawMaterialsDayAdd(rawMaterialsEmissionStatisticsDay);
		}
		
		// 등록, 업데이트 완료시 -> 월_마감그룹, user_id, 년월, 월별 이산화탄소 배출량 합계 셋팅 후 보낸다. 
		if(result != 0) {
			addRawMaterialsEmissionStatisticsMonth(result);
		}
	}
	
	
	/**
	 * 기부받은 의류별 CO2 월별 통계
	 */
	public void addRawMaterialsEmissionStatisticsMonth(int result) {
		log.info("기부받은 의류별 CO2 월별 통계 / result : {}", result);
	}
}
