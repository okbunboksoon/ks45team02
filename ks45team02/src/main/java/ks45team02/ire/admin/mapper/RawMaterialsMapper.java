package ks45team02.ire.admin.mapper;

import java.util.List;
import ks45team02.ire.admin.dto.RawMaterials;

public interface RawMaterialsMapper {

	 //원자재 목록 조회
	public List<RawMaterials> getRawMaterialsList();	
}
