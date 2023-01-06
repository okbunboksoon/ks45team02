package ks45team02.ire.admin.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.dto.PointSaveAndMinus;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.dto.User;

@Mapper
public interface PointMapper {

	//포인트 차감 등록
	public int addPointMinus(PointMinus pointMinus);
	
	//포인트 지급 수정
	public int modifyPointSave(PointSave pointSave);
	
	//포인트 지급 코드로 포인트 지급 조회
	public PointSave getPointSaveInfo(String pointSaveCode);
	
	//포인트 지급 금액 리스트 조회
	public List<String> getPointStandardSaveAmountList();
	
	//회원 포인트 현황 수정
	public int modifyUserPointState(User user);
	
	//포인트 지급 등록
	public int addPointSave(PointSave pointSave);
	
	//포인트 지급/차감 총 조회
	public List<PointSaveAndMinus> getPointSaveAndMinusList();
	
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
