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

import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.mapper.BuybasketMapper;
import ks45team02.ire.admin.service.BuybasketService;

@Controller
@RequestMapping("/admin")
public class BuybasketController {

	
	private static final Logger log = LoggerFactory.getLogger(BuybasketController.class);

	
	private final BuybasketService buybasketService;
	private final BuybasketMapper buybasketMapper;
	
	public BuybasketController(BuybasketService buybasketService, BuybasketMapper buybasketMapper) {
		this.buybasketService = buybasketService;
		this.buybasketMapper = buybasketMapper;
	}
	
	//장바구니 구매 처리
	@PostMapping("/addBuyBasket")
	public String addBuyBasket(Buybasket buybasket, RedirectAttributes reAttr) {
		
		int result = buybasketService.addBuybasket(buybasket);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "장바구니 구매 등록에 실패하였습니다.");
			return "redirect:/admin/addBuyBasket";
		}
		reAttr.addAttribute("msg", "장바구니 구매 등록에 성공하였습니다.");
		
		return "redirect:/admin/listBuyBasket";
	}
	
	//장바구니 구매 등록
	@GetMapping("/addBuyBasket")
	public String addBuyBasket(Model model
							 ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "장바구니 구매 등록");
		model.addAttribute("pageTitle", "장바구니 구매 등록");
				
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketAdd";
	}
	@GetMapping("/deleteBuyBasket")
	public String deleteBuyBasket(Model model) {
		
		return "admin/buybasket/buybasketDelete";
	}
	
	//장바구니 구매 조회
	@GetMapping("/listBuyBasket")
	public String listBuyBasket(Model model
							   ,@RequestParam(value="msg", required = false) String msg) {
		
		List<Buybasket> buybasketList = buybasketService.getBuybasketList();
		
		model.addAttribute("title", "장바구니 구매 조회");
		model.addAttribute("pageTitle", "장바구니 구매 조회");
		model.addAttribute("buybasketList", buybasketList);
		//model.addAttribute("buybasketList", buybasketList);
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketList";
	}
	
	//장바구니 구매 수정 처리
	@PostMapping("/modifyBuyBasket")
	public String modifyBuyBasket(Buybasket buybasket, RedirectAttributes reAttr) {
		
		int result = buybasketService.modifyBuybasket(buybasket);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "장바구니 구매 수정에 실패하였습니다.");
			reAttr.addAttribute("basketGroup", buybasket.getBasketGroup());
			return "redirect:/admin/modifyBuyBasket";
		}
		reAttr.addAttribute("msg", "장바구니 구매 수정에 성공하였습니다.");
		return "redirect:/admin/listBuyBasket";
	}
	
	//장바구니 구매 수정 페이지
	@GetMapping("/modifyBuyBasket")
	public String modifyBuyBasket(Model model
								,@RequestParam(value="basketGroup") String basketGroup
								,@RequestParam(value="msg", required = false) String msg) {
		
		Buybasket buybasketInfo = buybasketMapper.getBuybasketInfo(basketGroup);
		
		model.addAttribute("title", "장바구니 구매 수정");
		model.addAttribute("pageTitle", "장바구니 구매 수정");
		model.addAttribute("buybasketInfo", buybasketInfo);
				
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buybasket/buybasketModify";
	}
}
