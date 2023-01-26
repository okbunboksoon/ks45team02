package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserUnitPriceController {

	/**
	 * 판매단가 및 상품가격 조회
	 * @return
	 */
	@GetMapping("/listUnitPrice")
	public String listUnitPrice() {
		
		return "user/unitprice/unitpriceListGoods";
	}
	

}

