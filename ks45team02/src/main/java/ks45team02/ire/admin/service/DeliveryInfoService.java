package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Delivery;
import ks45team02.ire.admin.dto.DeliveryInfo;
import ks45team02.ire.admin.mapper.DeliveryInfoMapper;
import ks45team02.ire.admin.mapper.DeliveryMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class DeliveryInfoService {
	
	private static final Logger log = LoggerFactory.getLogger(DeliveryInfoService.class);

	private final DeliveryInfoMapper deliveryInfoMapper;
	private final UserMapper userMapper;
	private final DeliveryService deliveryService;
	
	public DeliveryInfoService(DeliveryInfoMapper deliveryInfoMapper, UserMapper userMapper, DeliveryService deliveryService) {
		
		this.deliveryInfoMapper = deliveryInfoMapper;
		this.userMapper = userMapper;
		this.deliveryService = deliveryService;
		
	}
	
	/**
	 * 배송정보 전체 조회
	 * @return listDeliveryInfo
	 */
	public List<DeliveryInfo> getListDeliveryInfo(){
		
		List<DeliveryInfo> listDeliveryInfo = deliveryInfoMapper.getListDeliveryInfo();
		
		return listDeliveryInfo;
	}
	
	/**
	 * 배송지 추가
	 * @param deliveryInfo
	 * @return result
	 */
	public int addDeliveryInfo(DeliveryInfo deliveryInfo) {
		
		int result = 0;
		String userId = deliveryInfo.getUserId();
		int idCheck = userMapper.idCheck(userId);

		log.info("idCheck :{}", idCheck);
		
		if(idCheck != 1) {
			result = 20;
		}else {
			result = deliveryInfoMapper.addDeliveryInfo(deliveryInfo);	
			deliveryService.addDelivery(deliveryInfo);
		}
		if(result == 1) {
			log.info("deliveryInfo insert 후 :{}", deliveryInfo);
		}
		return result;
	}
}
