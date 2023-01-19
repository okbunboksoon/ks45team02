package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.dto.RawMaterialsOutgoing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RawMaterialsMapper {

	
	//원자재 입고 삭제
	public int deleteRawMaterialsIncomingByRawMaterialsCode(String rawMaterialsCode);
	
	//원자재 입고 코드로 raw_materials_outgoing 삭제
	public int deleteRawMaterialsOutgoingByRawMaterialsCode(String rawMaterialsCode);
	
	//원자재 입고 코드로 raw_materials 삭제
	public int deleteRawMaterialsByRawMaterialsCode(String rawMaterialsCode);
	
	//원자재 입고 수정
	public int modifyIncomingRawMatrials(RawMaterialsIncoming rawMaterialsIncoming);
	
	//원자재 입고 코드로 원자재 입고 조회
	public RawMaterialsIncoming getRawMaterialsIncomingInfo(String rawMaterialsCode);
	
	//원자재 입고 등록
	public int addIncomingRawmaterials(RawMaterialsIncoming rawMaterialsIncoming);
	
	//원자재 입고 등록되지 않은 기부 코드 조회
	public List<String> getDonationCodeNotIncoming();
	
	//원자재 입고 조회
	public List<RawMaterialsIncoming> getRawMaterialsIncomingList();
	
	 //원자재 목록 조회
	public List<RawMaterials> rawmaterialsList();	
	
	//원자재 입고 일별 기부상품 입고 그룹 확인
	public String getLastRawMaterialsDaygroup();

    List<RawMaterialsOutgoing> rawMaterialsOutgoingList();

	List<RawMaterialsOutgoing> addoutgoingRawmaterialsInfo();

	int addoutgoingRawmaterials(RawMaterialsOutgoing rawMaterialsOutgoing);

	RawMaterialsOutgoing modifyOutgoingRawmaterialsInfo(String rawMaterialsOutgoingCode);

	int modifyOutgoingRawMatrials(RawMaterialsOutgoing rawMaterialsOutgoing);

	int checkRawMaterialCode(String rawMaterialsCode);

	RawMaterialsOutgoing rawMaterialsOutgoingDeleteInfo(String rawMaterialsOutgoingCode);

	int deleteoutgoingRawMatrials(String rawMaterialsOutgoingCode);
}
