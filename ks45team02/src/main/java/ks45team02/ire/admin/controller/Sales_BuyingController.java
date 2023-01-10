package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.service.Sales_BuyingService;

@Controller
@RequestMapping("/admin")
public class Sales_BuyingController {
	
	
	private static final Logger log = LoggerFactory.getLogger(Sales_BuyingController.class);
	
	private Sales_BuyingService sales_BuyingService;
	
	public Sales_BuyingController(Sales_BuyingService sales_BuyingService) {
		this.sales_BuyingService = sales_BuyingService;
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
	

	@GetMapping("/addGoodsSales")
	public String addGoodsSales() {
		
		return "admin/sales_buying/GoodsSalesAdd";
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

