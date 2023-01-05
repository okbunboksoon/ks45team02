package ks45team02.ire.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.PointSaveStandard;

@Mapper
public interface PointMapper {

	//포인트 지급 기준 삭제
	public int deletePointSaveStandard(String pointSaveStandard);
	
	//포인트 지급 기준 수정
	public int modifyPointSaveStandard(PointSaveStandard pointSaveStandard);
	
	//포인트 지급 기준 등록
	public int addPointSaveStandard(PointSaveStandard pointSaveStandard);
	
	//포인트 지급 기준 리스트 조회
	public List<PointSaveStandard> getPointSaveStandardList();
	
	//포인트 지급 기준 코드로 포인트 적립 조회
	public PointSaveStandard getPointSaveStandardInfo(String pointSaveStandardCode);
}
