package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Delivery;
import ks45team02.ire.admin.mapper.DeliveryMapper;

@Service
@Transactional
public class DeliveryService {

	
	private static final Logger log = LoggerFactory.getLogger(DeliveryService.class);
	
	private final DeliveryMapper deliveryMapper;
	
	public DeliveryService(DeliveryMapper deliveryMapper) {
		
		this.deliveryMapper = deliveryMapper;
		
	}
	
	/**
	 * 배송 전체 조회
	 * @return listDelivey
	 */
    public List<Delivery> getlistDelivery(){
    	
    	List<Delivery> listDelivey =  deliveryMapper.listDelivery();
    	
    	return listDelivey;
    }
}
