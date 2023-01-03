package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
@Mapper
public interface RawMaterialsMapper {

	//원자재 등록
	public int addIncomingRawmaterials(RawMaterialsIncoming rawMaterialsIncoming);
	
	//원자재 입고 등록되지 않은 기부 코드 조회
	public List<String> getDonationCodeNotIncoming();
	
	//원자재 입고 조회
	public List<RawMaterialsIncoming> getRawMaterialsIncomingList();
	
	 //원자재 목록 조회
	public List<RawMaterials> rawmaterialsList();	
}
