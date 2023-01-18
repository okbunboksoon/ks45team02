package ks45team02.ire.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.user.service.UserBasketService;

@Controller
@RequestMapping("/")
public class UserBasketController {
	
	private final UserBasketService userBasketService;
	
	public UserBasketController(UserBasketService userBasketService) {
		this.userBasketService = userBasketService;
	}
	
	@GetMapping("/addBasket")
	public String addBasket(Model model) {
		
		return "user/basket/basketAdd";
	}
	
	@GetMapping("/deleteBasket")
	public String deleteBasket() {
		
		return "user/basket/basketDelete";
	}
	
	//회원의 장바구니 조회
	@GetMapping("/listBasket")
	public String listBasket(Model model, HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		List<Basket> userBasketList = userBasketService.getUserBasketList(loginId);
		
		model.addAttribute("title", "장바구니");
		model.addAttribute("userBasketList", userBasketList);
		
		return "user/basket/basketList";
	}
	
	
	@GetMapping("/modifyBasket")
	public String modifyBasket() {
		
		return "user/basket/basketList";
	}

}
