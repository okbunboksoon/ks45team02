package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.TypePaymentInfo;
import ks45team02.ire.admin.mapper.TypePaymentInfoMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class TypePaymentInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(TypePaymentInfoService.class);
	
	private final TypePaymentInfoMapper typePaymentInfoMapper;
	private final UserMapper userMapper;
	
	public TypePaymentInfoService(TypePaymentInfoMapper typePaymentInfoMapper, UserMapper userMapper) {
		this.typePaymentInfoMapper = typePaymentInfoMapper;
		this.userMapper = userMapper;
	}
	
	/**
	 * 구매자별 결제 종류 수정
	 * @param typePaymentInfo
	 * @return
	 */
	public int modifyPaymentInfo(TypePaymentInfo typePaymentInfo) {
		
		int result = 0;
		
		String userId = typePaymentInfo.getUserId();
		int idCheck = userMapper.idCheck(userId);
		
		if(idCheck == 0) {
			result = 10;
		}
		
		result = typePaymentInfoMapper.modifyTypePaymentInfo(typePaymentInfo);
		
		return result;
	}
	
	/**
	 * 구매자별 결제 종류 등록
	 * @param typePaymentInfo
	 * @return
	 */
	public int addTypePaymentInfo(TypePaymentInfo typePaymentInfo) {
		
		int result = 0;
		
		String userId = typePaymentInfo.getUserId();
		int idCheck = userMapper.idCheck(userId);
		
		if(idCheck == 0) {
			result = 10;
		}
		
		result = typePaymentInfoMapper.addTypePaymentInfo(typePaymentInfo);
		
		return result;
	}
	
	/**
	 * 구매자별 결제 종류 조회
	 * @return List<TypePaymentInfo>
	 */
	public List<TypePaymentInfo> getTypePaymentInfoList(){
		
		List<TypePaymentInfo> typePaymentInfoList = typePaymentInfoMapper.getTypePaymentInfoList();
		
		return typePaymentInfoList;
	}
	
}
