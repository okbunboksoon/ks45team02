package ks45team02.ire.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsDay;

@Mapper
public interface EmissionStatisticsMapper {
	
	
	/**
	 * 기부받은 의류별 CO2 일별 통계
	 */
	public int addRawMaterialsEmissionStatisticsDay (RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay);
	
	
	/**
	 * CO2 통계 입고 그룹코드 존재 여부 확인
	 */
	public int rawMaterialsDayCheck (String rawMaterialsDaygroup);
	
}
