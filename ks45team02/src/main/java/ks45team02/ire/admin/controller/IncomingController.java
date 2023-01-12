package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.dto.Incoming;
import ks45team02.ire.admin.mapper.BusinessOrderMapper;
import ks45team02.ire.admin.mapper.IncomingMapper;
import ks45team02.ire.admin.mapper.OutgoingMapper;
import ks45team02.ire.admin.service.GoodsService;
import ks45team02.ire.admin.service.IncomingService;
import ks45team02.ire.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class IncomingController {
	private static final Logger log= LoggerFactory.getLogger(UserService.class);
	private final IncomingService incomingService;
	private final IncomingMapper incomingMapper;
	private final GoodsService goodsService;
	private final OutgoingMapper outgoingMapper;
	private final BusinessOrderMapper businessOrderMapper;


	public IncomingController(IncomingService incomingService, IncomingMapper incomingMapper, GoodsService goodsService, OutgoingMapper outgoingMapper, BusinessOrderMapper businessOrderMapper) {
		this.incomingService = incomingService;
		this.incomingMapper = incomingMapper;
		this.goodsService = goodsService;
		this.outgoingMapper = outgoingMapper;
		this.businessOrderMapper = businessOrderMapper;
	}

	@GetMapping("/addIncoming")
	public String addIncoming(Model model, @PathVariable(value = "businessOrderCode",required = false)String businessOrderCode) {
		model.addAttribute("title","addIncoming");
		model.addAttribute("pageTitle","상품 입고 추가");
		List<Goods>goodsList=goodsService.getListGoods();
		model.addAttribute("goodsList",goodsList);

		return "admin/incoming/incomingAdd";
	}
	@PostMapping("/addIncoming")
	public String addIncoming(Incoming incoming){
		incomingService.addIncoming(incoming);
		return "redirect:/admin/listIncoming";
	}
	
	@GetMapping("/deleteIncoming")
	public String deleteIncoming() {
		//삭제처리 없애기로 함...
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
	public String listIncomingStock(Model model) {
		//수정이 너무너무 너무 필요하다
		model.addAttribute("title","listStock");
		model.addAttribute("pageTitle","재고조회");
		List<Map<String,Object>>getStockAmount=incomingMapper.getStockAmount();
		model.addAttribute("getStockAmount",getStockAmount);
		return "admin/incoming/incomingListStock";
	}
	@GetMapping("/modifyIncoming")
	public String modifyIncoming(Model model,
								 @RequestParam(value = "incomingCode",required = false)String incomingCode) {
		model.addAttribute("title","modifyIncoming");
		model.addAttribute("pageTitle","상품입고 수정");
		Incoming getInfoByIncoming=incomingMapper.getInfoByIncoming(incomingCode);
		model.addAttribute("getInfoByIncoming",getInfoByIncoming);
		List<Goods>goodsList=goodsService.getListGoods();
		model.addAttribute("goodsList",goodsList);
		return "admin/incoming/incomingModify";
	}

}

