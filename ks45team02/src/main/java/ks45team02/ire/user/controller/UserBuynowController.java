package ks45team02.ire.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.user.service.UserBuynowService;

@Controller
@RequestMapping("/")
public class UserBuynowController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserBuynowController.class);

	private final UserBuynowService userBuynowService;
	private final UserMapper userMapper;
	
	public UserBuynowController(UserBuynowService userBuynowService, UserMapper userMapper) {
		this.userBuynowService = userBuynowService;
		this.userMapper = userMapper;
	}
	
	//즉시구매 등록 처리
	@PostMapping("/addBuyNow")
	public String addBuyNow(Buynow buynow, HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		buynow.setUserId(loginId);
		
		userBuynowService.addBuynow(buynow);
		
		return "redirect:/listOrder";
	}
	
	//즉시구매 등록 페이지
	@GetMapping("/addBuyNow")
	public String addBuyNow(HttpSession session, Model model
						   ,@RequestParam(value="goodsCode") String goodsCode
						   ,@RequestParam(value="basketAmount") int buynowAmount) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		User userInfo = userMapper.getUserInfoById(loginId);
		int userPointState = userInfo.getPointState();
		
		Buynow buynow = new Buynow();
		buynow.setGoodsCode(goodsCode);
		buynow.setBuynowAmount(buynowAmount);
		buynow.setUserId(loginId);
		Buynow buynowInfo = userBuynowService.addBuynowPage(buynow);
		
		model.addAttribute("title", "주문");
		model.addAttribute("buynowInfo", buynowInfo);
		model.addAttribute("userPointState", userPointState);
		
		return "user/buynow/buynowAdd";
	}
}
