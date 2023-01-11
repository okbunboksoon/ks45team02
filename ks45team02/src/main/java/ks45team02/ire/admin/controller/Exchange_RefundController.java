package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.*;
import ks45team02.ire.admin.mapper.*;
import ks45team02.ire.admin.service.ExchangeStandardService;
import ks45team02.ire.admin.service.GoodsExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class Exchange_RefundController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final ExchangeStandardMapper exchangeStandardMapper;
	private final RefundStandardMapper refundStandardMapper;
	private final ExchangeStandardService exchangeStandardService;
	private final GoodsExchangeService goodsExchangeService;
	private final GoodsMapper goodsMapper;
	private final UserMapper userMapper;
	private final PaymentCompleteMapper paymentCompleteMapper;

	public Exchange_RefundController(ExchangeStandardMapper exchangeStandardMapper, RefundStandardMapper refundStandardMapper, ExchangeStandardService exchangeStandardService, GoodsExchangeService goodsExchangeService, GoodsMapper goodsMapper, UserMapper userMapper, PaymentCompleteMapper paymentCompleteMapper) {
		this.exchangeStandardMapper = exchangeStandardMapper;
		this.refundStandardMapper = refundStandardMapper;
		this.exchangeStandardService = exchangeStandardService;
		this.goodsExchangeService = goodsExchangeService;
		this.goodsMapper = goodsMapper;
		this.userMapper = userMapper;
		this.paymentCompleteMapper = paymentCompleteMapper;
	}


	@GetMapping("/approvalExchange_Refund")
	public String approvalExchange_Refund(Model model) {
		
		return "admin/exchange_refund/exchange_refundApproval";
	}
		
	@GetMapping("/searchExchange_Refund")
	public String searchExchange_Refund() {
		
		return "admin/exchange_refund/exchange_refundSearch";
	}
	
	@GetMapping("/addExchangeStandard")
	public String addExchangeStandard(Model model) {
		model.addAttribute("title","addExchangeStandard");
		model.addAttribute("pageTitle","교환 기준 등록");
		return "admin/exchange_refund/exchangeAddStandard";
	}
	@PostMapping("/addExchangeStandard")
	public String addExchangeStandard(ExchangeStandard exchangeStandard){
		exchangeStandardService.addExchangeStandard(exchangeStandard);
		return "redirect:/admin/listExchangeStandard";
	}
	@GetMapping("/listExchangeStandard")
	public String listExchangeStandard(Model model) {
		model.addAttribute("title","listExchangeStandard");
		model.addAttribute("pageTitle","교환기준 조회");
		List<ExchangeStandard>exchangeStandardList=exchangeStandardMapper.listExchangeStandard();
		model.addAttribute("exchangeStandardList",exchangeStandardList);

		return "admin/exchange_refund/exchangeListStandard";
	}
		
	@GetMapping("/modifyExchange")
	public String modifyExchange() {
		
		return "admin/exchange_refund/exchangeModify";
	}
	@GetMapping("/requestExchange")
	public String requestExchange(Model model,
								  @RequestParam(value = "paymentCompleteCode",required = false)String paymentCompleteCode) {
		model.addAttribute("title","requestExchange");
		model.addAttribute("pageTitle","교환 요청");
		PaymentComplete paymentCompleteInfo=paymentCompleteMapper.getPaymentCompleteInfo(paymentCompleteCode);
		model.addAttribute("paymentCompleteInfo",paymentCompleteInfo);
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		List<Goods>goodsList=goodsMapper.getListGoods();
		model.addAttribute("goodsList",goodsList);
		List<ExchangeStandard>exchangeStandardList=exchangeStandardMapper.listExchangeStandard();
		model.addAttribute("exchangeStandardList",exchangeStandardList);
		return "admin/exchange_refund/exchangeRequest";
	}
	@PostMapping("/requestExchange")
	public String requestExchange(GoodsExchange goodsExchange){
		goodsExchangeService.addGoodsExchange(goodsExchange);
		return "redirect:/admin/approvalExchange_Refund";
	}
	@GetMapping("/listExchange")
	public String listExchange(Model model) {

		return "admin/exchange_refund/exchangeList";
	}
	@GetMapping("/addRefundStandard")
	public String addRefundStandard() {
		
		return "admin/exchange_refund/refundAddStandard";
	}
	@GetMapping("/listRefundStandard")
	public String listRefundStandard(Model model) {
		model.addAttribute("title","listRefundStandard");
		model.addAttribute("pageTitle","환불기준 조회");
		List<RefundStandard>refundStandardList=refundStandardMapper.listRefundStandard();
		model.addAttribute("refundStandardList",refundStandardList);
		return "admin/exchange_refund/refundListStandard";
	}
		
	@GetMapping("/modifyRefund")
	public String modifyRefund() {
		
		return "admin/exchange_refund/refundModify";
	}
	@GetMapping("/requestRefund")
	public String requestRefund() {
		
		return "admin/exchange_refund/refundRequest";
	}
}

