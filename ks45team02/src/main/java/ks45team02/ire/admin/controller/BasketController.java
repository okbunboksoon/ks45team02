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
	
	//상품 검색
	@GetMapping("/goodsSearchForBasketadd")
	public String goodsSearchForBasketadd(@RequestParam(value="searchKey", required = false) String searchKey
										 ,@RequestParam(value="searchValue", required = false) String searchValue
										 ,Model model) {
		
		List<Goods> goodsList = basketService.searchGoods(searchKey, searchValue);
		model.addAttribute("title", "상품 검색");
		model.addAttribute("goodsList", goodsList);
		
		return "admin/basket/goodsSearchForBasketadd";
	}
	
	//장바구니 등록 처리
	@PostMapping("/addBasket")
	public String addBasket(Basket basket, RedirectAttributes reAttr) {
		
		int result = basketService.addBasket(basket);
		if(result == 0) {
			reAttr.addAttribute("msg", "장바구니 등록에 실패하였습니다.");
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
	
	@GetMapping("/deleteBasket")
	public String deleteBasket() {
		
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

