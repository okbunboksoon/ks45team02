package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Emission;

@Mapper
public interface EmissionMapper {
	
	/**
	 * 기부받은 의류별 CO2 기준 리스트
	 * 
	 */
	public List<Emission> RawMaterialsEmissionList ();
	
	
	
	
}
