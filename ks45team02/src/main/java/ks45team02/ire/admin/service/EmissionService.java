package ks45team02.ire.admin.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.GoodsEmission;
import ks45team02.ire.admin.dto.RawMaterialsEmission;
import ks45team02.ire.admin.mapper.EmissionMapper;

@Service
public class EmissionService {

	private static final Logger log = LoggerFactory.getLogger(EmissionService.class);

	private final EmissionMapper emissionMapper;

	public EmissionService(EmissionMapper emissionMapper) {

		this.emissionMapper = emissionMapper;
	}

		/**
		 * 기부받은 의류 CO2 기준 리스트
		 * 
		 * @return
		 */
			  public List<RawMaterialsEmission> getRawMaterialsEmissionList(){
			  
			  List<RawMaterialsEmission> RawMaterialsEmissionList =
			  emissionMapper.RawMaterialsEmissionList(); return RawMaterialsEmissionList; 
			  }
			 

	/**
	 * 기부받은 의류 CO2 기준 등록
	 * 
	 * @param RawMaterialsEmission
	 * @return
	 */
	public int addRawMaterialsEmission(RawMaterialsEmission rawMaterialsEmission) {

		return emissionMapper.addRawMaterialsEmission(rawMaterialsEmission);
	}

	/**
	 * 기부받은 의류 CO2 기준 수정
	 * 
	 * @param RawMaterialsEmission
	 * @return emissionMapper.modifyRawMaterialsEmission(rawMaterialsEmission)
	 */
	public int modifyRawMaterialsEmission(RawMaterialsEmission rawMaterialsEmission) {

		return emissionMapper.modifyRawMaterialsEmission(rawMaterialsEmission);
	}

	/**
	 * 기부받은 의류 CO2 기준
	 * 
	 * @param raw_materials_co2_code
	 * @return RawMaterialsInfo
	 */
	public List<RawMaterialsEmission> getRawMaterialsCO2Code(String raw_materials_co2_code) {
		List<RawMaterialsEmission> RawMaterialsEmissionInfo = emissionMapper.getRawMaterialsCO2Code(raw_materials_co2_code);
		return RawMaterialsEmissionInfo;
	}

	/**
	 * ************************************* 여기서부터 원단별 CO2 ****************************************************
	 */
	
	
	/**
	 * 원단별 탄소 배출량 기준 리스트
	 * 
	 * @return
	 */
	public List<GoodsEmission> getGoodsEmissionList() {

		List<GoodsEmission> GoodsEmissionList = emissionMapper.GoodsEmissionList();
		return GoodsEmissionList;
	}
	
	
	/**
	 * 원단별 탄소 배출량 기준 등록
	 */
	public int addGoodsEmission(GoodsEmission goodsEmission) {
		return emissionMapper.addGoodsEmission(goodsEmission);
	}
	
	/**
	 * 상품 등록 시 이산화탄소 배출량 조회
	 */
	public Map<String, Object> getGoodsEmissionLevel(Map<String, Object> paramMap){
		
		String resultFirstFabric = (String) paramMap.get("firstFabric");
		String resultLastFabric = (String) paramMap.get("lastFabric");
		double FirstFabric = emissionMapper.getFirstFabric(resultFirstFabric);
		double LastFabric = emissionMapper.getLastFabric(resultLastFabric);
		paramMap.clear();
		paramMap.put("FirstFabric", FirstFabric);
		paramMap.put("LastFabric", LastFabric);
	
		return paramMap;
	}

}
