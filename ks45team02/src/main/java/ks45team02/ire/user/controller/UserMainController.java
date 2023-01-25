package ks45team02.ire.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks45team02.ire.user.dto.UserGoods;
import ks45team02.ire.user.service.UserGoodsService;

@Controller
public class UserMainController {

	private UserGoodsService userGoodsService;
	
	public UserMainController(UserGoodsService userGoodsService) {
		
		this.userGoodsService = userGoodsService;
	}	
	
	@GetMapping("/")
	public String userMain(Model model) {
		
		List<UserGoods> listGoods =  userGoodsService.getUserGoodsList();
		List<UserGoods> BaglistGoods = userGoodsService.getListGoodsBag();
		List<UserGoods> ShoselistGoods = userGoodsService.getListGoodsShose();
		List<UserGoods> acclistGoods = userGoodsService.getListGoodsAcc();
		
		model.addAttribute("title", "Ire");
		model.addAttribute("listGoods", listGoods);
		model.addAttribute("BaglistGoods", BaglistGoods);
		model.addAttribute("ShoselistGoods", ShoselistGoods);
		model.addAttribute("acclistGoods", acclistGoods);
		
		return "user/userMain";
	}
}
