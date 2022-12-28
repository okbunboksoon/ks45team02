package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Sales_BuyingController {

	@GetMapping("/addGoodsBuyingSales_Buying")
	public String addGoodsBuyingSales_Buying(Model model) {
		
		return "/admin/sales_buying/sales_buyingAddGoodsBuying";
	}
	@GetMapping("/addGoodsSalesSales_Buying")
	public String addGoodsSalesSales_Buying() {
		
		return "/admin/sales_buying/sales_buyingAddGoodsSales";
	}
	
	@GetMapping("/goodsSalesBuyingGroupSales_Buying")
	public String goodsSalesBuyingGroupSales_Buying() {
		
		return "/admin/sales_buying/sales_buyingGoodsSalesBuyingGroup";
	}
	@GetMapping("/goodsSalesTotalInquirySales_Buying")
	public String goodsSalesTotalInquirySales_Buying() {
		
		return "/admin/sales_buying/sales_buyingGoodsSalesTotalInquiry";
	}
	@GetMapping("/listGoodsBuyingSales_Buying")
	public String listGoodsBuyingSales_Buying() {
		
		return "/admin/sales_buying/sales_buyingListGoodsBuying";
	}
	@GetMapping("/modifyGoodsBuyingSales_Buying")
	public String modifyGoodsBuyingSales_Buying() {
		
		return "/admin/sales_buying/sales_buyingModifyGoodsBuying";
	}
	@GetMapping("/modifyGoodsSalesSales_Buying")
	public String modifyGoodsSalesSales_Buying() {
		
		return "/admin/sales_buying/sales_buyingModifyGoodsSales";
	}
	@GetMapping("/addSalesSales_Buying")
	public String addSalesSales_Buying() {
		
		return "/admin/sales_buying/sales_buyingSalesAdd";
	}



}

