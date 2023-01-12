package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.UnitPrice;
import ks45team02.ire.admin.service.UnitPriceService;

@Controller
@RequestMapping("/admin")
public class UnitPriceController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UnitPriceController.class);

	
	private final UnitPriceService unitPriceService;
	
	public UnitPriceController(UnitPriceService unitPriceService) {
		
		this.unitPriceService = unitPriceService;
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
	
	/**
	 * 상품코드로 특정 상품 판매단가 및 상품가격 조회
	 * @param unitPrice
	 * @param model
	 * @return
	 */
	@GetMapping("/modifyUnitPrice")
	public String modifyUnitPrice(@RequestParam(value="goodsCode")String goodsCode, Model model) {
		
		UnitPrice getListUnitPriceByGoodsCode = unitPriceService.getListUnitPriceByGoodsCode(goodsCode);
		model.addAttribute("title", "상품별 매입 및 판매단가 수정");
		model.addAttribute("pageTitle", "상품별 매입 및 판매단가 수정");
		model.addAttribute("getListUnitPriceByGoodsCode", getListUnitPriceByGoodsCode);
		log.info("getListUnitPriceByGoodsCode : {}", getListUnitPriceByGoodsCode);
		
		return "/admin/unitpriceModifyGoods";
	}

}

