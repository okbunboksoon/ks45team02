package ks45team02.ire.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team02.ire.admin.dto.UnitPrice;
import ks45team02.ire.admin.service.UnitPriceService;

@Controller
@RequestMapping("/admin")
public class UnitPriceController {
	
	private final UnitPriceService unitPriceService;
	
	public UnitPriceController(UnitPriceService unitPriceService) {
		
		this.unitPriceService = unitPriceService;
	}
	
	@GetMapping("/addUnitPrice")
	public String addUnitPrice(Model model) {
		
		return "admin/unitprice/unitpriceAddGoods";
	}	
	
	/**
	 * 상품별 매입 및 판매단가 조회
	 * @param model
	 * @return listUnitPrice
	 */
	@GetMapping("/listUnitPrice")
	public String listUnitPrice(Model model) {
		
		List<UnitPrice> listUnitPrice = unitPriceService.getListUnitPrice();
		
		model.addAttribute("title", "상품별 매입 및 판매 단가");
		model.addAttribute("pageTitle", "상품별 매입 및 판매 단가");
		model.addAttribute("listUnitPrice", listUnitPrice);
		
		return "admin/unitprice/unitpriceListGoods";
	}
	

}

