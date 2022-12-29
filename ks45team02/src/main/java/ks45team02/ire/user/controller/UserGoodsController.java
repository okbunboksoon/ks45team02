package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserGoodsController {

	@GetMapping("/orderGoods")
	public String orderGoods() {
		
		return "user/goods/goodsOrder";
	}
	@GetMapping("/listGoods")
	public String listGoods() {
		
		return "user/goods/goodsList";
	}
	
}

