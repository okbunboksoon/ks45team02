package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.dto.Incoming;
import ks45team02.ire.admin.mapper.GoodsMapper;
import ks45team02.ire.admin.service.GoodsService;
import ks45team02.ire.admin.service.IncomingService;
import ks45team02.ire.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class IncomingController {
	private static final Logger log= LoggerFactory.getLogger(UserService.class);
	private final IncomingService incomingService;
	private final GoodsService goodsService;
	private final GoodsMapper goodsMapper;

	public IncomingController(IncomingService incomingService, GoodsService goodsService, GoodsMapper goodsMapper) {
		this.incomingService = incomingService;
		this.goodsService = goodsService;
		this.goodsMapper = goodsMapper;
	}

	@GetMapping("/addIncoming")
	public String addIncoming(Model model) {
		model.addAttribute("title","addIncoming");
		model.addAttribute("pageTitle","상품 입고 추가");
		List<Goods>goodsList=goodsService.getListGoods();
		Goods getIncomingEmissionLevel= goodsMapper.getIncomingEmissionLevel(goodsList.toString());
		model.addAttribute("goodsList",goodsList);
		model.addAttribute("getIncomingEmissionLevel",getIncomingEmissionLevel);
		return "admin/incoming/incomingAdd";
	}
	@PostMapping("/addIncoming")
	public String addIncoming(Incoming incoming){
		incomingService.addIncoming(incoming);
		return "redirect:/admin/listIncoming";
	}
	
	@GetMapping("/deleteIncoming")
	public String deleteIncoming() {
		
		return "admin/incoming/incomingDelete";
	}
	
	@GetMapping("/listIncoming")
	public String listIncoming(Model model) {
		model.addAttribute("title","listIncoming");
		model.addAttribute("pageTitle","상품입고 조회");
		List<Incoming>incomingList=incomingService.incomingList();
		model.addAttribute("incomingList",incomingList);
		return "admin/incoming/incomingList";
	}
	
	
	@GetMapping("/listIncomingStock")
	public String listIncomingStock() {
		
		return "admin/incoming/incomingListStock";
	}
	@GetMapping("/modifyIncoming")
	public String modifyIncoming() {
		
		return "admin/incoming/incomingModify";
	}

}

