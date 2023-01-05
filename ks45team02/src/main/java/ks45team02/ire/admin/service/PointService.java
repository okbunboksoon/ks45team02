package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.mapper.PointMapper;

@Service
@Transactional
public class PointService {
	
	private static final Logger log = LoggerFactory.getLogger(PointService.class);
	
	private final PointMapper pointMapper;
	
	public PointService(PointMapper pointMapper) {
		this.pointMapper = pointMapper;
	}
	
	public int deletePointSaveStandard(String pointSaveStandard) {
		
		int result = 0;
		
		result = pointMapper.deletePointSaveStandard(pointSaveStandard);
		
		return result;
	}
	
	/**
	 * 포인트 지급 기준 수정
	 * @param pointSaveStandardCode
	 * @return
	 */
	public int modifyPointSaveStandard(PointSaveStandard pointSaveStandard) {
		
		int result = 0;
		result = pointMapper.modifyPointSaveStandard(pointSaveStandard);
		
		return result;
	}
	
	/**
	 * 포인트 적립 기준 등록
	 * @param pointSaveStandard
	 * @return int
	 */
	public int addPointSaveStandard(PointSaveStandard pointSaveStandard) {
		
		int result = 0;
		
		result = pointMapper.addPointSaveStandard(pointSaveStandard);
		
		return result;
	}
	
	/**
	 * 포인트 적립기준 리스트 조회
	 * @return List<PointSaveStandard>
	 */
	public List<PointSaveStandard> getPointSaveStandardList(){
		
		List<PointSaveStandard> pointSaveStandardList = pointMapper.getPointSaveStandardList();
		
		return pointSaveStandardList;
	}
	
}
