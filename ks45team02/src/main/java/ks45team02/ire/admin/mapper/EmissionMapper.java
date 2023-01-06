package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.RawMaterialsEmission;

@Mapper
public interface EmissionMapper {
	
	/**
	 * 기부받은 의류별 CO2 기준 리스트
	 * 
	 */
	public List<RawMaterialsEmission> RawMaterialsEmissionList ();
	
	
	/**
	 * 기부받은 의류별 CO2 기준 등록
	 */
	public int addRawMaterialsEmission(RawMaterialsEmission rawmaterialsEmission);
	
	/**
	 * 기부받은 의류별 CO2 기준 수정
	 */
	public int modifyRawMaterialsEmission(RawMaterialsEmission RawMaterialsEmission);
	
	/**
	 * 기부받은 의류별 CO2 코드로 기부받은 의류별 CO2 기준 조회
	 */
	public List<RawMaterialsEmission> getRawMaterialsCO2Code(String raw_materials_category);
}
