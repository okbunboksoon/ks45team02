package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserEmissionController {

	@GetMapping("/listEmissionC02GoodsTotal")
	public String listEmissionC02GoodsTotal() {
		
		return "/user/emission/emissionListCO2goodsTotal";
	}
		
	@GetMapping("/listEmissionC02Total")
	public String listEmissionC02Total() {
		
		return "/user/emission/emissionListCO2Total";
	}
	@GetMapping("/listEmissionRawMaterialsGroupStatistics")
	public String listEmissionRawMaterialsGroupStatistics() {
		
		return "/user/emission/emissionListRawMaterialsGroupStatistics";
	}
	
}

