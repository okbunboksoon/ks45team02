package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UnitPriceController {

	@GetMapping("/addUnitPrice")
	public String addUnitPrice(Model model) {
		
		return "/admin/unitprice/unitpriceAddGoods";
	}	

	@GetMapping("/listUnitPrice")
	public String listUnitPrice() {
		
		return "/admin/unitprice/unitpriceListGoods";
	}
	

}

