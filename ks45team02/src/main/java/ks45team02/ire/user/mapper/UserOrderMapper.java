package ks45team02.ire.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.user.dto.UserOrder;

@Mapper
public interface UserOrderMapper {

	//주문상세
	public List<UserOrder> getUserOrderInfo(String loginId, String orderCode);
	
	//주문내역 개수
	public int getOrderCnt(String loginId);
	
	//주문내역 리스트
	public List<UserOrder> getUserOrderList(Map<String, Object> pageMap);
}
