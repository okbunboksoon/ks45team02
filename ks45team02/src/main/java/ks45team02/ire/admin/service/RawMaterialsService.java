package ks45team02.ire.admin.service;

import java.util.List;
import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;

public class RawMaterialsService {

	private final RawMaterialsMapper rawmaterialsMapper ;
	public int result;
	public RawMaterialsService(RawMaterialsMapper rawmaterialsMapper) {
		this.rawmaterialsMapper =rawmaterialsMapper;
	
	}

	public List<RawMaterials> getRawMaterialsList() {
		
		List<RawMaterials> getRawMaterialsList =rawmaterialsMapper.getRawMaterialsList();
		return getRawMaterialsList;
	}
	
	}


