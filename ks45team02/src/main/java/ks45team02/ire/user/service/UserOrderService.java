package ks45team02.ire.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.user.dto.UserOrder;
import ks45team02.ire.user.mapper.UserOrderMapper;

@Service
@Transactional
public class UserOrderService {
	
	private final UserOrderMapper userOrderMapper;
	
	public UserOrderService(UserOrderMapper userOrderMapper) {
		this.userOrderMapper = userOrderMapper;
	}

	/**
	 * 주문내역 리스트
	 * @return List<UserOrder>
	 */
	public List<UserOrder> getUserOrderList(){
		
		List<UserOrder> userOrderList = userOrderMapper.getUserOrderList();
		
		return userOrderList;
	}
}
