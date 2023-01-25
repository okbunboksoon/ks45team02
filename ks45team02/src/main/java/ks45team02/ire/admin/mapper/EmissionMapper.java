package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.GoodsEmission;
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
	
	/**
	 * 기부받은 의류별 CO2 기준 삭제
	 */
	public int deleteRawMaterialsEmission (String raw_materials_category);
	
	/**
	 * 원단별 탄소배출량 기준 리스트
	 */
	public List<GoodsEmission> GoodsEmissionList();
	
	
	/**
	 * 원단별 탄소배출량 기준 등록
	 */
	public int addGoodsEmission(GoodsEmission goodsEmission);
	
	
	/**
	 * 원단별 탄소배출량 기준 수정 
	 */
	public int modifyGoodsEmission (GoodsEmission goodsEmission);
	
	
	/**
	 * 원단별 탄소배출량 기준 삭제
	 */
	public int deleteGoodsEmission (String fabric);
	
	/**
	 * 원단 이름으로 원단별 탄소배출량 기준 조회
	 */
	public List<GoodsEmission> getGoodsEmissionFabric(String carbon_dioxide_emission_level);
	
	/**
	 * 상품 원단 비율 firstFabric
	 */
	public double getFirstFabric(String resultFirstFabric);
	
	/**
	 * 상품 원단 비율 LastFabric
	 */
	public double getLastFabric(String resultLastFabric);

	
}
