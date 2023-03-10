package ks45team02.ire.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.PointSaveAndMinus;

@Mapper
public interface UserPointMapper {

	//포인트 데이터 개수 조회
	public int getPointCnt(String loginId);
	
	//포인트 내역 조회
	public List<PointSaveAndMinus> getUserPointSaveAndMinusList(Map<String, Object> pageMap);
}
