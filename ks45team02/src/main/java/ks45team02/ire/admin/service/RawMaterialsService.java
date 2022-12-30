package ks45team02.ire.admin.service;

import java.util.List;
import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RawMaterialsService {

	private final RawMaterialsMapper rawmaterialsMapper ;
	public int result;
	public RawMaterialsService(RawMaterialsMapper rawmaterialsMapper) {
		this.rawmaterialsMapper =rawmaterialsMapper;
	
	}

	public List<RawMaterials> rawmaterialsList() {
		
		List<RawMaterials> rawmaterialsList =rawmaterialsMapper.rawmaterialsList();
		System.out.println(rawmaterialsList);
		return rawmaterialsList;
	}
	
	}


