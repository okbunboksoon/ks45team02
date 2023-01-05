package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
	 * @return
	 */
	public List<RawMaterialsEmission> getRawMaterialsEmissionList(){
		
		List<RawMaterialsEmission> RawMaterialsEmissionList = emissionMapper.RawMaterialsEmissionList();
		return RawMaterialsEmissionList;
	}

	/**
	 * 기부받은 의류 CO2 기준 등록
	 * @param RawMaterialsEmission
	 * @return 
	 */
	public int addRawMaterialsEmission(RawMaterialsEmission rawMaterialsEmission) {
		
		return emissionMapper.addRawMaterialsEmission(rawMaterialsEmission);
	}
}
