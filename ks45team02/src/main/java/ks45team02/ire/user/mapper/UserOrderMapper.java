package ks45team02.ire.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.user.dto.UserOrder;

@Mapper
public interface UserOrderMapper {

	//주문내역 리스트
	public List<UserOrder> getUserOrderList();
}
