package ks45team02.ire.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.user.service.UserBasketService;

@Controller
@RequestMapping("/")
public class UserBasketController {
	
	private static final Logger log = LoggerFactory.getLogger(UserBasketController.class);

	private final UserBasketService userBasketService;
	
	public UserBasketController(UserBasketService userBasketService) {
		this.userBasketService = userBasketService;
	}
	
	//장바구니 추가
	@PostMapping("/addBasket")
	public String addBasket(Model model, HttpSession session, RedirectAttributes reAttr
						   ,@RequestParam(value="goodsCode") String goodsCode
						   ,@RequestParam(value="basketAmount") int basketAmount) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		Basket basket = new Basket();
		basket.setGoodsCode(goodsCode);
		basket.setUserId(loginId);
		basket.setBasketAmount(basketAmount);
		
		int result = userBasketService.addBasket(basket);
		if(result == 10){
			reAttr.addAttribute("msg", "이미 장바구니에 등록된 상품입니다.");
		}else if(result == 1) {
			reAttr.addAttribute("msg", "장바구니에 등록되었습니다.");
		}
		
		reAttr.addAttribute("goodsCode", goodsCode);
		return "redirect:/goodsContents"; 
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
	
	//장바구니 수정 처리
	@PostMapping("/modifyBasket")
	public String modifyBasket(HttpSession session
							  ,@RequestParam(value="basketCode") String basketCode
							  ,@RequestParam(value="basketAmount") String basketAmount) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		userBasketService.modifyBasket(basketCode, basketAmount);
		
		return "redirect:/listBasket";
	}

}
