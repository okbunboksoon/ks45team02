package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Delivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
	
	//deliveryCode와 UserId 일치 확인
	public int checkDeliveryCodeAndUserId(String deliveryCode, String userId);
	
    public List<Delivery>listDelivery();
}
