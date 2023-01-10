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

import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.service.BusinessOrderService;
import ks45team02.ire.admin.service.Sales_BuyingService;

@Controller
@RequestMapping("/admin")
public class Sales_BuyingController {
	
	
	private static final Logger log = LoggerFactory.getLogger(Sales_BuyingController.class);
	
	private Sales_BuyingService sales_BuyingService;
	private BusinessOrderService businessOrderService;

	
	public Sales_BuyingController(Sales_BuyingService sales_BuyingService, BusinessOrderService businessOrderService) {
		this.sales_BuyingService = sales_BuyingService;
		this.businessOrderService = businessOrderService;
	}


	@GetMapping("/addGoodsBuying")
	public String addGoodsBuying() {
		return "admin/sales_buying/GoodsBuyingAdd";
	}
	
	/**
	 * 상품 매입 조회
	 * @param model
	 * @return GoodsBuyingList
	 */
	@GetMapping("/listGoodsBuying")
	public String listGoodsBuying(Model model
			,@RequestParam(value="gb", required = false) String gb) {
		
		List<GoodsBuying> goodsBuyingList = sales_BuyingService.getListGoodsBuying();
		model.addAttribute("title", "상품 매입 목록");
		model.addAttribute("pageTitle", "상품 매입 목록");
		model.addAttribute("goodsBuyingList",goodsBuyingList);
		
		log.info("goodsBuyingList: {}", goodsBuyingList);
		
		return "admin/sales_buying/GoodsBuyingList";
	}
	
	@GetMapping("/modifyGoodsBuying")
	public String modifyGoodsBuying() {
		
		return "admin/sales_buying/GoodsBuyingModify";
	}
	
	/**
	 * 상품 매입 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/addGoodsSales")
	public String addGoodsSales(Model model
								,@RequestParam(value="msg", required = false) String msg) {
		model.addAttribute("title", "발주등록");
		model.addAttribute("pageTitle", "발주등록");
		
		if(msg!= null) {
			model.addAttribute("msg",msg);
		}
		return "admin/sales_buying/GoodsSalesAdd";
	}
	
	/**
	 * 상품 매입 등록 처리
	 * @param goodsBuying
	 */
	@PostMapping("/addGoodsBuying")
	public String addGoodsBuying(GoodsBuying goodsBuying, RedirectAttributes reAttr) {
		
		log.info("goodsBuying: {}", goodsBuying);
		
		int result = sales_BuyingService.addGoodsBuying(goodsBuying);
		
		log.info("result:{}", result);
		if(result ==0) {
			reAttr.addAttribute("msg", "상품 매입 등록에 실패하였습니다");
			return "redirect:/admin/addGoodsBuying";
		}else {
			reAttr.addAttribute("msg", "상품 매입 등록에 성공하였습니다.");
		}
		return "redirect:/admin/listGoodsBuying";
	}
	
	/**
	 * 발주 검색
	 * @param searchKey, searchValue, model
	 * @return businessOrder
	 */
	@GetMapping("/businessOrderForGoodsBuyingAdd")
	public String businessOrderForGoodsBuyingAdd(@RequestParam(value="searchKey", required = false) String searchKey
	 											,@RequestParam(value="searchValue", required = false) String searchValue
	 											,Model model) {
		
		List<BusinessOrder> businessOrderList = businessOrderService.getListBusinessOrderRe();
		model.addAttribute("title", "발주 검색");
		model.addAttribute("businessOrderList",businessOrderList);
		
		return "admin/sales_buying/businessOrderForGoodsBuyingAdd";
	}

	@GetMapping("/modifyGoodsSales")
	public String modifyGoodsSales() {
		
		return "admin/sales_buying/GoodsSalesModify";
	}
	
	@GetMapping("/listGoodsSales")
	public String listGoodsSales() {
		
		return "admin/sales_buying/GoodsSalesList";
	}
	
	@GetMapping("/goodsSalesBuyingGroup")
	public String goodsSalesBuyingGroup() {
		
		return "admin/sales_buying/GoodsSalesBuyingGroup";
	}
	

	@GetMapping("/goodsSalesTotalSearch")
	public String goodsSalesTotalSearch() {
		
		return "admin/sales_buying/GoodsSalesTotalSearch";
	}
	
	
}

