package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Delivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
	
	//deliveryCode와 UserId 일치 확인
	public int checkDeliveryCodeAndUserId(String deliveryCode, String userId);
	
	// 배송 전체 조회
    public List<Delivery> listDelivery();
    
    // 운송장 번호 생성
    public String addDeliveryNum();
    
    // 배송 추가
    public int addDelivery(Delivery delivery);
    
    // 배송코드로 배송상태 확인
    public String getDeliveryStateByCode(String deliveryCode);
    
    // 배송정보 업데이트
    public int updateDeliveryState(String deliveryCode, String deliveryState);
}
