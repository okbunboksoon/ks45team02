package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import ks45team02.ire.admin.dto.Delivery;
import ks45team02.ire.admin.dto.DeliveryInfo;
import ks45team02.ire.admin.mapper.BusinessMapper;
import ks45team02.ire.admin.mapper.DeliveryMapper;

@Service
@Transactional
public class DeliveryService {

	
	private static final Logger log = LoggerFactory.getLogger(DeliveryService.class);
	
	private final DeliveryMapper deliveryMapper;
	private final BusinessMapper businessMapper;
	
	public DeliveryService(DeliveryMapper deliveryMapper, BusinessMapper businessMapper) {
		
		this.deliveryMapper = deliveryMapper;
		this.businessMapper = businessMapper;
		
	}
	
	/**
	 * 배송 전체 조회
	 * @return listDelivey
	 */
    public List<Delivery> getlistDelivery(){
    	
    	List<Delivery> listDelivey =  deliveryMapper.listDelivery();
    	
    	return listDelivey;
    }
    
    /**
     * 배송 추가
     */
    public int addDelivery(DeliveryInfo deliveryInfo) {
    	
    	String delivery_num = deliveryMapper.addDeliveryNum();
    	String business_code = businessMapper.randemSectors();
    	
    	Delivery delivery = new Delivery();
    	
    	delivery.setDelInfoCode(deliveryInfo.getDelInfoCode());
    	delivery.setUserId(deliveryInfo.getUserId());
    	delivery.setDeliveryNum(delivery_num);
    	delivery.setBusinessCode(business_code);
    	log.info("딜리버리 서비스 delivery : {}", delivery);
    	
    	int addDelivery = deliveryMapper.addDelivery(delivery);
    	
    	
    	return addDelivery;
    }
    /**
     * 배송코드로 배송정보확인 수정
     * @param deliveryCode
     * @return result
     */
    public int getDeliveryStateByCode(String deliveryCode) {
    	int result = 0;
    	String deliveryStateCheck = deliveryMapper.getDeliveryStateByCode(deliveryCode);
    	log.info("deliveryStateCheck : {}", deliveryStateCheck);
    	String deliveryState = null;
    	if(deliveryStateCheck != "배송완료") {
    		
    		switch (deliveryStateCheck) {
    		case "배송전"
    		: deliveryState = "배송중";
    		  result = deliveryMapper.updateDeliveryState(deliveryCode, deliveryState);
    		break;
    		case "배송중"
    		: deliveryState = "배송완료";
    		  result = deliveryMapper.updateDeliveryState(deliveryCode, deliveryState);
    		break;
    		}
    		log.info("deliveryState : {}, deliveryCode : {}", deliveryState,deliveryCode);
    	}
    	return result;
    }
}
