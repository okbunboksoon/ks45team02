package ks45team02.ire.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.user.service.UserBuybasketService;

@Controller
public class UserBuybasketController {
	
	private static final Logger log = LoggerFactory.getLogger(UserBuybasketController.class);

	private final UserBuybasketService userBuybasketService;
	private final UserMapper userMapper;
	
	public UserBuybasketController(UserBuybasketService userBuybasketService, UserMapper userMapper) {
		this.userBuybasketService = userBuybasketService;
		this.userMapper = userMapper;
	}
	
	//장바구니 구매 등록 처리
	@PostMapping("/addBuyBasket")
	public String addBuyBasket(Buybasket buybasket, HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		buybasket.setUserId(loginId);

		userBuybasketService.addBuyBasket(buybasket);
		
		return "redirect:/listOrder";
	}
	
	//장바구니 구매 등록 페이지
	@GetMapping("/addBuyBasket")
	public String addBuyBasket(Model model, HttpSession session, Basket basket) {
			
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		basket.setUserId(loginId);
			
		User userInfo = userMapper.getUserInfoById(loginId);
		int userPointState = userInfo.getPointState();
		
		List<Basket> userBasketList = userBuybasketService.addBuyBasketPage(basket);
			
		model.addAttribute("title", "상품 주문");
		model.addAttribute("userPointState", userPointState);
		model.addAttribute("userBasketList", userBasketList);
			
		return "user/buybasket/buybasketAdd";
	}
}
