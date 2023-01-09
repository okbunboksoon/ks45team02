package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.Delivery;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.dto.Outgoing;
import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.mapper.DeliveryMapper;
import ks45team02.ire.admin.mapper.GoodsMapper;
import ks45team02.ire.admin.mapper.OutgoingMapper;
import ks45team02.ire.admin.mapper.PaymentCompleteMapper;
import ks45team02.ire.admin.service.OutgoingService;
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
public class OutGoingController {
	private static final Logger log= LoggerFactory.getLogger(UserService.class);
	private final OutgoingMapper outgoingMapper;
	private final OutgoingService outgoingService;

	private final DeliveryMapper deliveryMapper;
	private final PaymentCompleteMapper paymentCompleteMapper;
	private final GoodsMapper goodsMapper;

	public OutGoingController(OutgoingMapper outgoingMapper, OutgoingService outgoingService, DeliveryMapper deliveryMapper, PaymentCompleteMapper paymentCompleteMapper, GoodsMapper goodsMapper) {
		this.outgoingMapper = outgoingMapper;
		this.outgoingService = outgoingService;
		this.deliveryMapper = deliveryMapper;
		this.paymentCompleteMapper = paymentCompleteMapper;
		this.goodsMapper = goodsMapper;
	}

	@GetMapping("/addOutGoing")
	public String addOutGoing(Model model) {
		model.addAttribute("title","addOutgoing");
		model.addAttribute("pageTitle","상품출고 등록");
		List<Goods>goodsList=goodsMapper.getListGoods();
		model.addAttribute("goodsList",goodsList);
		List<Delivery>deliveryList=deliveryMapper.listDelivery();
		model.addAttribute("deliveryList",deliveryList);
		List<PaymentComplete>paymentCompleteList=paymentCompleteMapper.listPaymentComplete();
		model.addAttribute("paymentCompleteList",paymentCompleteList);
		return "admin/outgoing/outgoingAdd";
	}
	@PostMapping("/addOutGoing")
	public String addOutGoing(Outgoing outgoing){
		log.info("상품출고등록:{}",outgoing);
		outgoingService.addOutgoing(outgoing);
		return "redirect:/admin/listOutGoing";
	}
	
	@GetMapping("/deleteOutGoing")
	public String deleteOutGoing() {
		
		return "admin/outgoing/outgoingDelete";
	}
	
	@GetMapping("/listOutGoing")
	public String listOutGoing(Model model) {
		model.addAttribute("title","listOutgoing");
		model.addAttribute("pageTitle","상품출고 조회");
		List<Outgoing>outgoingList=outgoingMapper.listOutgoing();
		model.addAttribute("outgoingList",outgoingList);
		return "admin/outgoing/outgoingList";
	}
	
	
	@GetMapping("/modifyOutGoing")
	public String modifyOutGoing() {
		
		return "admin/outgoing/outgoingModify";
	}

}

