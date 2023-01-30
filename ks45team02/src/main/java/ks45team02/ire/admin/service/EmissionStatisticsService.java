 package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.EmissionTotal;
import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsDay;
import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsMonth;
import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsYear;
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
	 * 기부받은 의류별 CO2 월별 통계 전체 조회
	 */
	public List<RawMaterialsEmissionStatisticsMonth> rawMaterialsMonthSearch(){
		
		List<RawMaterialsEmissionStatisticsMonth> rmmsList = emissionStatisticsMapper.rawMaterialsMonthSearch();
		
		return rmmsList;
	}
	
	/**
	 * 기부받은 의류별 CO2 년별 통계 전체 조회
	 */
	public List<RawMaterialsEmissionStatisticsYear> rawMaterialsYearhSearch(){
		
		List<RawMaterialsEmissionStatisticsYear> rmysList = emissionStatisticsMapper.rawMaterialsYearhSearch();
		
		return rmysList;
	}
	
	/**
	 * 기부받은 의류별 CO2 일별 통계 등록
	 * @return rawMaterialsEmissionStatisticsDay
	 */
	public RawMaterialsEmissionStatisticsDay addRawMaterialsEmissionStatisticsDay (RawMaterialsIncoming rawMaterialsIncoming) {
		RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay = new RawMaterialsEmissionStatisticsDay();
		log.info("일별 통계 등록 / rawMaterialsIncoming : {}", rawMaterialsIncoming); //삭제가능 확인
		
		String rawMaterialsDaygroup = rawMaterialsMapper.getLastRawMaterialsDaygroup();
		log.info("일별 통계 등록 / rawMaterialsDaygroup :{}", rawMaterialsDaygroup); //삭제가능 확인
		
		// 통계 등록 확인
		int dayGroupCodeCheck = emissionStatisticsMapper.rawMaterialsDayCheck(rawMaterialsDaygroup);
		log.info("일별 통계 등록 / dayGroupCodeCheck :{}", dayGroupCodeCheck); //삭제가능 확인
		
		String rawMaterialsIncomingDate = emissionStatisticsMapper.getRawMaterialsIncomingDate(rawMaterialsIncoming.getRawMaterialsCode());
		rawMaterialsIncoming.setRawMaterialsIncomingDate(rawMaterialsIncomingDate);
		rawMaterialsIncoming.setRawMaterialsDaygroup(rawMaterialsDaygroup);
		log.info("일별 통계 등록 / rawMaterialsIncomingDate :{}", rawMaterialsIncomingDate); //삭제가능 확인
		String yearMonth = emissionStatisticsMapper.addYearAndMonth(rawMaterialsIncoming.getRawMaterialsCode());
		float carbonDioxideEmissionSum = (rawMaterialsIncoming.getCarbonDioxideEmissionLevel() * rawMaterialsIncoming.getRawMaterialsIncomingAmount());
		int sumThing = emissionStatisticsMapper.rawMaterialsDaySumSelect(rawMaterialsDaygroup);
		float sumSpeicalThing = sumThing + carbonDioxideEmissionSum;
		
		rawMaterialsEmissionStatisticsDay.setRm_incoming_date(rawMaterialsIncomingDate);
		rawMaterialsEmissionStatisticsDay.setYear_and_month(yearMonth);
		rawMaterialsEmissionStatisticsDay.setCarbon_dioxide_emission_sum(carbonDioxideEmissionSum);
		rawMaterialsEmissionStatisticsDay.setRaw_materials_daygroup(rawMaterialsDaygroup);


		if(dayGroupCodeCheck == 0) {
			emissionStatisticsMapper.rawMaterialsDayAdd(rawMaterialsEmissionStatisticsDay);
		}else {
			rawMaterialsEmissionStatisticsDay.setCarbon_dioxide_emission_sum(sumSpeicalThing);
			emissionStatisticsMapper.rawMaterialsDayUpdate(rawMaterialsEmissionStatisticsDay);
		}
		
		return rawMaterialsEmissionStatisticsDay;
	}
	
	/**
	 * 기부받은 의류별 CO2 월별 통계
	 * @return rawMaterialsEmissionStatisticsMonth
	 */
	public RawMaterialsEmissionStatisticsMonth addRawMaterialsEmissionStatisticsMonth(RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay) {
		RawMaterialsEmissionStatisticsMonth rawMaterialsEmissionStatisticsMonth = new RawMaterialsEmissionStatisticsMonth();
		
		String monthCode = rawMaterialsEmissionStatisticsDay.getRaw_materials_monthgroup();
		int codeCheck = emissionStatisticsMapper.rawMaterialsMonthCheck(rawMaterialsEmissionStatisticsDay.getRaw_materials_monthgroup());
		
		int MonthEmissionSum = emissionStatisticsMapper.getMonthEmissionSum(monthCode);
		
		rawMaterialsEmissionStatisticsMonth.setCarbon_dioxide_emission_sum((float) MonthEmissionSum);
		rawMaterialsEmissionStatisticsMonth.setRaw_materials_monthgroup(monthCode);
		rawMaterialsEmissionStatisticsMonth.setYear_and_month(rawMaterialsEmissionStatisticsDay.getYear_and_month());
		
		if(codeCheck == 0) {
			emissionStatisticsMapper.addrawMaterialsMonth(rawMaterialsEmissionStatisticsMonth);
			
		}else {
			emissionStatisticsMapper.updaterawMaterialsMonth(rawMaterialsEmissionStatisticsMonth);
		}		
		
		rawMaterialsEmissionStatisticsMonth.setRaw_materials_monthgroup(rawMaterialsEmissionStatisticsDay.getRaw_materials_monthgroup());
		
		return rawMaterialsEmissionStatisticsMonth;
	}
	
	/**
	 * 기부받은 의류별 CO2 년별 통계
	 * @param rawMaterialsEmissionStatisticsMonth
	 */
	public void addRawMaterialsEmissionStatisticsYear(RawMaterialsEmissionStatisticsMonth rawMaterialsEmissionStatisticsMonth) {
		RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear = new RawMaterialsEmissionStatisticsYear();
		String yearCode = rawMaterialsEmissionStatisticsMonth.getRaw_materials_yeargroup();
		int codeCheck = emissionStatisticsMapper.rawMaterialsYearCheck(yearCode);
		String year = emissionStatisticsMapper.getYear(yearCode);
		String month = emissionStatisticsMapper.getMonth(yearCode);
		rawMaterialsEmissionStatisticsYear.setYear(year);
		rawMaterialsEmissionStatisticsYear.setRaw_materials_yeargroup(rawMaterialsEmissionStatisticsMonth.getRaw_materials_yeargroup());
		
		int EmissionSum = emissionStatisticsMapper.getEmissionSum(yearCode);
		
		if(codeCheck == 0) {
			emissionStatisticsMapper.addrawMaterialsYear(rawMaterialsEmissionStatisticsYear);
		}
			if(month.equals("01월")) {
				rawMaterialsEmissionStatisticsYear.setJan(EmissionSum);
				emissionStatisticsMapper.updateJan(rawMaterialsEmissionStatisticsYear);
			}else if(month.equals("02월")) {
				rawMaterialsEmissionStatisticsYear.setFeb(EmissionSum);
				emissionStatisticsMapper.updateFeb(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("03월")) {
				rawMaterialsEmissionStatisticsYear.setMar(EmissionSum);
				emissionStatisticsMapper.updateMar(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("04월")) {
				rawMaterialsEmissionStatisticsYear.setApr(EmissionSum);
				emissionStatisticsMapper.updateApr(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("05월")) {
				rawMaterialsEmissionStatisticsYear.setMay(EmissionSum);
				emissionStatisticsMapper.updateMay(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("06월")) {
				rawMaterialsEmissionStatisticsYear.setJun(EmissionSum);
				emissionStatisticsMapper.updateJun(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("07월")) {
				rawMaterialsEmissionStatisticsYear.setJul(EmissionSum);
				emissionStatisticsMapper.updateJul(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("08월")) {
				rawMaterialsEmissionStatisticsYear.setAug(EmissionSum);
				emissionStatisticsMapper.updateAug(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("09월")) {
				rawMaterialsEmissionStatisticsYear.setSept(EmissionSum);
				emissionStatisticsMapper.updateSept(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("10월")) {
				rawMaterialsEmissionStatisticsYear.setOct(EmissionSum);
				emissionStatisticsMapper.updateOct(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("11월")) {
				rawMaterialsEmissionStatisticsYear.setNov(EmissionSum);
				emissionStatisticsMapper.updateNov(rawMaterialsEmissionStatisticsYear);				
			}else if(month.equals("12월")) {
				rawMaterialsEmissionStatisticsYear.setDec(EmissionSum);
				emissionStatisticsMapper.updateDec(rawMaterialsEmissionStatisticsYear);						
		}	
		
	}
	
	/**
	 * 일반상품 / 업사이클링상품 CO2 비교 조회
	 * return emissionTotal
	 */
	public List<EmissionTotal> getEmissionListCo2Total(){
		
		List<EmissionTotal> emissionTotal = emissionStatisticsMapper.getEmissionListCo2Total();
		
		return emissionTotal;
	}

}
