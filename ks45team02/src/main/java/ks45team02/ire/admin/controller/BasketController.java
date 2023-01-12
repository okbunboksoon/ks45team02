package ks45team02.ire.admin.controller;

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

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.mapper.BasketMapper;
import ks45team02.ire.admin.service.BasketService;
import ks45team02.ire.admin.service.DonationService;

@Controller
@RequestMapping("/admin")
public class BasketController {

	private static final Logger log = LoggerFactory.getLogger(DonationService.class);
	
	private final BasketService basketService;
	private final BasketMapper basketMapper;
	
	public BasketController(BasketMapper basketMapper, BasketService basketService) {
		this.basketMapper = basketMapper;
		this.basketService = basketService;
	}
	
	//결제 전인 장바구니 검색
	@GetMapping("/basketBeforePaymentSearch")
	public String basketBeforePaymentSearch(Model model
										   ,@RequestParam(value="searchKey", required = false) String searchKey
										   ,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		List<Basket> basketBeforePaymentList = basketService.getBasketListBeforePayment(searchKey, searchValue);
		
		model.addAttribute("title", "결제 전인 장바구니 검색");
		model.addAttribute("basketBeforePaymentList", basketBeforePaymentList);
		
		return "admin/search/basketBeforePaymentSearch";
	}
	
	//장바구니 등록 처리
	@PostMapping("/addBasket")
	public String addBasket(Basket basket, RedirectAttributes reAttr) {
		
		int result = basketService.addBasket(basket);
		if(result == 0) {
			reAttr.addAttribute("msg", "장바구니 등록에 실패하였습니다.");
			return "redirect:/admin/addBasket";
		}else if(result == 51) {
			reAttr.addAttribute("msg", "다른 회원의 장바구니 그룹입니다.");
			return "redirect:/admin/addBasket";
		}else if(result == 52) {
			reAttr.addAttribute("msg", "해당 회원의 미주문 장바구니가 이미 존재합니다.");
			return "redirect:/admin/addBasket";
		}else {
			reAttr.addAttribute("msg", "장바구니 등록에 성공하였습니다.");
		}
		return "redirect:/admin/listBasket";
	}
	
	//장바구니 등록 페이지
	@GetMapping("/addBasket")
	public String addBasket(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "장바구니 등록");
		model.addAttribute("pageTitle", "장바구니 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/basket/basketAdd";
	}
	
	//장바구니 삭제 처리
	@PostMapping("/deleteBasket")
	public String deleteBasket(@RequestParam(value="basketCode") String basketCode
							  ,RedirectAttributes reAttr) {
		
		int result = basketService.deleteBasket(basketCode);
		if(result == 0) {
			reAttr.addAttribute("msg", "장바구니 삭제에 실패하였습니다.");
			reAttr.addAttribute("basketCode", basketCode);
			return "redirect:/admin/deleteBasket";
		}else {
			reAttr.addAttribute("msg", result + "개의 데이터가 삭제되었습니다.");
		}
		return "redirect:/admin/listBasket";
	}
	
	//장바구니 삭제 페이지
	@GetMapping("/deleteBasket")
	public String deleteBasket(Model model
							 ,@RequestParam(value="basketCode") String basketCode
							 ,@RequestParam(value="msg", required = false) String msg) {
		
		Basket basketInfo = basketMapper.getBasketInfo(basketCode);
		
		model.addAttribute("title", "장바구니 삭제");
		model.addAttribute("pageTitle", "장바구니 삭제");
		model.addAttribute("basketInfo", basketInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/basket/basketDelete";
	}
	
	//장바구니 조회 페이지
	@GetMapping("/listBasket")
	public String listBasket(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
		
		List<Basket> basketList = basketService.getBasketList();
		
		model.addAttribute("title", "장바구니 조회");
		model.addAttribute("pageTitle", "장바구니 조회");
		model.addAttribute("basketList", basketList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/basket/basketList";
	}
	
	//장바구니 수정 처리
	@PostMapping("/modifyBasket")
	public String modifyBasket(Basket basket, RedirectAttributes reAttr) {
		
		int result = basketService.modifyBasket(basket);
		if(result == 0) {
			reAttr.addAttribute("basketCode", basket.getBasketCode());
			reAttr.addAttribute("msg", "장바구니 수정에 실패하였습니다.");
			return "redirect:/admin/modifyBasket";
		}else if(result == 51) {
			reAttr.addAttribute("basketCode", basket.getBasketCode());
			reAttr.addAttribute("msg", "다른 회원의 장바구니 그룹입니다.");
			return "redirect:/admin/modifyBasket";
		}else if(result == 52) {
			reAttr.addAttribute("basketCode", basket.getBasketCode());
			reAttr.addAttribute("msg", "해당 회원의 미주문 장바구니가 이미 존재합니다.");
			return "redirect:/admin/modifyBasket";
		}else {
			reAttr.addAttribute("msg", "장바구니 수정에 성공하였습니다.");
		}
		return "redirect:/admin/listBasket";
	}
	
	//장바구니 수정 페이지
	@GetMapping("/modifyBasket")
	public String modifyBasket(Model model
							 ,@RequestParam(value="basketCode") String basketCode
							 ,@RequestParam(value="msg", required = false) String msg) {
		
		Basket basketInfo = basketMapper.getBasketInfo(basketCode);
		
		model.addAttribute("title", "장바구니 수정");
		model.addAttribute("pageTitle", "장바구니 수정");
		model.addAttribute("basketInfo", basketInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/basket/basketModify";
	}

}

