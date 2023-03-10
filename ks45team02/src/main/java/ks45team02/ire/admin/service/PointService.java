package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.dto.PointSaveAndMinus;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class PointService {
	
	private static final Logger log = LoggerFactory.getLogger(PointService.class);
	
	private final PointMapper pointMapper;
	private final UserMapper userMapper;
	
	public PointService(PointMapper pointMapper, UserMapper userMapper) {
		this.pointMapper = pointMapper;
		this.userMapper = userMapper;
	}
	
	/**
	 * 포인트 차감 수정
	 * @param pointMinus
	 * @return int
	 */
	public int modifyPointMinus(PointMinus pointMinus) {
		
		int result = 0;
		String userId = pointMinus.getUserId();
		int idCheck = userMapper.idCheck(userId);
		
		if(idCheck == 1) {
			
			String pointMinusReason = pointMinus.getPointMinusReason();
			
			if(pointMinusReason.equals("기타")) {
				String pointMinusReasonEtc = pointMinus.getPointMinusReasonEtc();
				pointMinusReason += " (사유: " + pointMinusReasonEtc + ")";
				pointMinus.setPointMinusReason(pointMinusReason);
			}
			result = pointMapper.modifyPointMinus(pointMinus);
		}
		
		
		return result;
	}
	
	/**
	 * 포인트 차감 등록
	 * @param pointMinus
	 * @return int
	 */
	public int addPointMinus(PointMinus pointMinus) {
		
		int result = 0;
		String userId = pointMinus.getUserId();
		int idCheck = userMapper.idCheck(userId);
		
		if(idCheck == 1) {
			
			String pointMinusReason = pointMinus.getPointMinusReason();
			
			if(pointMinusReason.equals("기타")) {
				String pointMinusReasonEtc = pointMinus.getPointMinusReasonEtc();
				pointMinusReason += " (사유: " + pointMinusReasonEtc + ")";
				pointMinus.setPointMinusReason(pointMinusReason);
			}
			
			//회원 포인트 적립금 수정
			User userInfo = userMapper.getUserInfoById(userId);
			int pointState = userInfo.getPointState();
			pointState -= pointMinus.getPointMinus();
			
			pointMinus.setPointState(pointState);
			userInfo.setPointState(pointState);
			pointMapper.modifyUserPointState(userInfo);
			
			result = pointMapper.addPointMinus(pointMinus);
		}
		
		return result;
	}
	
	/**
	 * 포인트 지급 수정
	 * @param pointSave
	 * @return int
	 */
	public int modifyPointSave(PointSave pointSave) {
		
		int result = 0;
		String userId = pointSave.getUserId();
		int idCheck = userMapper.idCheck(userId);
		
		if(idCheck == 1) {
			String pointSaveReason = pointSave.getPointSaveReason();
			
			if(pointSaveReason.equals("기타")) {
				String pointSaveReasonEtc = pointSave.getPointSaveReasonEtc();
				pointSaveReason += " (사유: " + pointSaveReasonEtc + ")";
				pointSave.setPointSaveReason(pointSaveReason);
			}
			
			result = pointMapper.modifyPointSave(pointSave);
		}
		return result;
	}
	
	/**
	 * 포인트 지급 등록
	 * @param pointSave
	 * @return int 
	 */
	public int addPointSave(PointSave pointSave) {
		
		int result = 0;
		
		String userId = pointSave.getUserId();
		int idCheck = userMapper.idCheck(userId);
		
		if(idCheck == 1) {
			
			String pointSaveReason = pointSave.getPointSaveReason();
			
			if(pointSaveReason.equals("기타")) {
				String pointSaveReasonEtc = pointSave.getPointSaveReasonEtc();
				pointSaveReason += " (사유: " + pointSaveReasonEtc + ")";
				pointSave.setPointSaveReason(pointSaveReason);
			}
			
			//회원 포인트 적립금 수정
			User userInfo = userMapper.getUserInfoById(userId);
			int pointState = userInfo.getPointState();
			pointState += pointSave.getPointSave();
			
			pointSave.setPointState(pointState);
			userInfo.setPointState(pointState);
			pointMapper.modifyUserPointState(userInfo);
			
			result = pointMapper.addPointSave(pointSave);
		}		
		
		return result;
	}
	
	/**
	 * 포인트 지급/차감 총 조회
	 * @return List<PointSaveAndMinus>
	 */
	public List<PointSaveAndMinus> getPointSaveAndMinusList(){
		
		List<PointSaveAndMinus> pointSaveAndMinusList = pointMapper.getPointSaveAndMinusList();
		
		return pointSaveAndMinusList;
	}
	
	/**
	 * 포인트 적립 기준 삭제
	 * @param pointSaveStandard
	 * @return int
	 */
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
