package ks45team02.ire.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.user.dto.UserOrder;
import ks45team02.ire.user.mapper.UserOrderMapper;
import ks45team02.ire.user.service.UserOrderService;

@Controller
@RequestMapping("/")
public class UserOrderController {
	
	private static final Logger log = LoggerFactory.getLogger(UserOrderController.class);

	private final UserOrderService userOrderService;
	private final UserOrderMapper userOrderMapper;
	
	public UserOrderController(UserOrderService userOrderService, UserOrderMapper userOrderMapper) {
		this.userOrderService = userOrderService;
		this.userOrderMapper = userOrderMapper;
	}
	
	@GetMapping("/deleteOrder")
	public String deleteOrder() {
		
		return "user/order/orderDelete";
	}
	
	//주문내역 상세
	@GetMapping("/contentsOrder")
	public String contentsOrder(Model model, HttpSession session
							  ,@RequestParam(value="orderCode") String orderCode) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		List<UserOrder> userOrderInfo = userOrderMapper.getUserOrderInfo(loginId, orderCode);
		
		model.addAttribute("title", "주문 상세");
		model.addAttribute("userOrderInfo", userOrderInfo);
		log.info("userOrderInfo : {}", userOrderInfo);
		
		return "user/order/orderContents";
	}
	
	//주문내역 리스트
	@GetMapping("/listOrder")
	public String listOrder(Model model, HttpSession session
						   ,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
						   ,@RequestParam(value="startDate", required = false) String startDate
						   ,@RequestParam(value="endDate", required = false) String endDate
						   ,@RequestParam(value="msg", required = false) String msg) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		Map<String, Object> pageMap = userOrderService.getUserOrderList(currentPage, loginId, startDate, endDate);
		
		int lastPage = (int) pageMap.get("lastPage");
		@SuppressWarnings("unchecked")
		List<UserOrder> userOrderList = (List<UserOrder>) pageMap.get("userOrderList");
		int startPageNum = (int) pageMap.get("startPageNum");
		int endPageNum = (int) pageMap.get("endPageNum");
		
		model.addAttribute("title", "주문 내역");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("userOrderList", userOrderList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "user/order/orderList";
	}
	
	
	@GetMapping("/modifyOrder")
	public String modifyOrder() {
		
		return "user/order/orderModify";
	}

}

