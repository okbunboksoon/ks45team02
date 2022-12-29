package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class GoodsController {

	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		return "admin/goods/goodsAdd";
	}
	
	@GetMapping("/deleteGoods")
	public String deleteGoods() {
		
		return "admin/goods/goodsDelete";
	}
	
	@GetMapping("/listGoods")
	public String listGoods() {
		
		return "admin/goods/goodsList";
	}
	
	@GetMapping("/modifyGoods")
	public String modifyGoods() {
		
		return "admin/goods/goodsModify";
	}
	@GetMapping("/orderGoods")
	public String orderGoods() {
		
		return "admin/goods/goodsOrder";
	}

}

