package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.DeliveryInfo;
import ks45team02.ire.admin.mapper.DeliveryInfoMapper;

@Service
@Transactional
public class DeliveryInfoService {

	private final DeliveryInfoMapper deliveryInfoMapper;
	
	public DeliveryInfoService(DeliveryInfoMapper deliveryInfoMapper) {
		
		this.deliveryInfoMapper = deliveryInfoMapper;
		
	}
	
	/**
	 * 배송정보 전체 조회
	 * @return listDeliveryInfo
	 */
	public List<DeliveryInfo> getListDeliveryInfo(){
		
		List<DeliveryInfo> listDeliveryInfo = deliveryInfoMapper.getListDeliveryInfo();
		
		return listDeliveryInfo;
	}
}
