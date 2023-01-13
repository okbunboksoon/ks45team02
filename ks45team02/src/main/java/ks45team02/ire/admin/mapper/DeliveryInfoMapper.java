package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.DeliveryInfo;

@Mapper
public interface DeliveryInfoMapper {
	
	// 배송정보 정보 전체 조회
    public List<DeliveryInfo> getListDeliveryInfo();
    
    // 배송지 추가
    public int addDeliveryInfo(DeliveryInfo deliveryInfo);
}
