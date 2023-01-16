package ks45team02.ire.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsDay;

@Mapper
public interface EmissionStatisticsMapper {
	
	
	/**
	 * 기부받은 의류별 CO2 일별 통계 추가
	 */
	public int rawMaterialsDayAdd (RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay);
	
	
	/**
	 * CO2 통계 입고 그룹코드 존재 여부 확인
	 */
	public int rawMaterialsDayCheck (String rawMaterialsDaygroup);
	
	/**
	 * 기부받은 의류별 CO2 일별 일반 상품별 이산화탄소 배출량 조회
	 */
	public int rawMaterialsDaySumSelect (String rawMaterialsDaygroup);
	
	/**
	 * 기부받은 의류별 CO2 일별 등록날짜 생성
	 */
	public String addYearAndMonth(String rawMaterialsIncomingDate);
	
	/**
	 * 기부받은 의류별 CO2 일별 통계 업데이트
	 */
	public int rawMaterialsDayUpdate(RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay);
	
	
	
	/**
	 * 
	 */
}
