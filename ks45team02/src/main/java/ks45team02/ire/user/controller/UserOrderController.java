package ks45team02.ire.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.user.dto.UserOrder;
import ks45team02.ire.user.mapper.UserOrderMapper;
import ks45team02.ire.user.service.UserOrderService;

@Controller
@RequestMapping("/")
public class UserOrderController {
	
	private final UserOrderService userOrderService;
	private final UserOrderMapper userOrderMapper;
	
	public UserOrderController(UserOrderService userOrderService, UserOrderMapper userOrderMapper) {
		this.userOrderService = userOrderService;
		this.userOrderMapper = userOrderMapper;
	}

	@GetMapping("/addOrder")
	public String addOrder(Model model) {
		
		return "user/order/orderAdd";
	}
	
	@GetMapping("/deleteOrder")
	public String deleteOrder() {
		
		return "user/order/orderDelete";
	}
	
	//주문내역 리스트
	@GetMapping("/listOrder")
	public String listOrder(Model model) {
		
		List<UserOrder> userOrderList = userOrderService.getUserOrderList();
		
		model.addAttribute("title", "주문 내역");
		model.addAttribute("userOrderList", userOrderList);
		
		return "user/order/orderList";
	}
	
	
	@GetMapping("/modifyOrder")
	public String modifyOrder() {
		
		return "user/order/orderModify";
	}

}

