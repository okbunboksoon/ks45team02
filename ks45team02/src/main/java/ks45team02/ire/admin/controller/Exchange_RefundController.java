package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.*;
import ks45team02.ire.admin.mapper.*;
import ks45team02.ire.admin.service.ExchangeStandardService;
import ks45team02.ire.admin.service.GoodsExchangeService;
import ks45team02.ire.admin.service.GoodsRefundService;
import ks45team02.ire.admin.service.RefundStandardService;
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
	private final GoodsRefundService goodsRefundService;
	private final RefundStandardMapper refundStandardMapper;
	private final GoodsRefundMapper goodsRefundMapper;
	private final RefundStandardService refundStandardService;
	private final ExchangeStandardService exchangeStandardService;
	private final GoodsExchangeService goodsExchangeService;
	private final GoodsMapper goodsMapper;
	private final UserMapper userMapper;
	private final PaymentCompleteMapper paymentCompleteMapper;
	private final GoodsExchangeMapper goodsExchangeMapper;

	public Exchange_RefundController(ExchangeStandardMapper exchangeStandardMapper, GoodsRefundService goodsRefundService, RefundStandardMapper refundStandardMapper, GoodsRefundMapper goodsRefundMapper, RefundStandardService refundStandardService, ExchangeStandardService exchangeStandardService, GoodsExchangeService goodsExchangeService, GoodsMapper goodsMapper, UserMapper userMapper, PaymentCompleteMapper paymentCompleteMapper, GoodsExchangeMapper goodsExchangeMapper) {
		this.exchangeStandardMapper = exchangeStandardMapper;
		this.goodsRefundService = goodsRefundService;
		this.refundStandardMapper = refundStandardMapper;
		this.goodsRefundMapper = goodsRefundMapper;
		this.refundStandardService = refundStandardService;
		this.exchangeStandardService = exchangeStandardService;
		this.goodsExchangeService = goodsExchangeService;
		this.goodsMapper = goodsMapper;
		this.userMapper = userMapper;
		this.paymentCompleteMapper = paymentCompleteMapper;
		this.goodsExchangeMapper = goodsExchangeMapper;
	}


	//?????? ??????
	@GetMapping("/approvalExchange")
	public String approvalExchange(Model model) {
		model.addAttribute("title","approvalExchange_Refund");
		model.addAttribute("pageTitle","?????? ??????");
		List<GoodsExchange>goodsExchangeList=goodsExchangeMapper.listGoodsExchange();
		model.addAttribute("goodsExchangeList",goodsExchangeList);
		log.info("goodsExchangeList:{}",goodsExchangeList);
		return "admin/exchange_refund/exchangeApproval";
	}
	//?????? ??????
	@GetMapping("/approvalRefund")
	public String approvalRefund(Model model) {
		model.addAttribute("title","approvalRefund");
		model.addAttribute("pageTitle","?????? ??????");
		List<GoodsRefund>goodsRefundList=goodsRefundMapper.listGoodsRefund();
		model.addAttribute("goodsRefundList",goodsRefundList);
		return "admin/exchange_refund/refundApproval";
	}


	//?????? ?????? ???????????????
	@GetMapping("/addExchangeStandard")
	public String addExchangeStandard(Model model) {
		model.addAttribute("title","addExchangeStandard");
		model.addAttribute("pageTitle","?????? ?????? ??????");
		return "admin/exchange_refund/exchangeAddStandard";
	}
	//????????????????????????
	@PostMapping("/addExchangeStandard")
	public String addExchangeStandard(ExchangeStandard exchangeStandard){
		exchangeStandardService.addExchangeStandard(exchangeStandard);
		return "redirect:/admin/listExchangeStandard";
	}
	//?????????????????????
	@GetMapping("/listExchangeStandard")
	public String listExchangeStandard(Model model) {
		model.addAttribute("title","listExchangeStandard");
		model.addAttribute("pageTitle","???????????? ??????");
		List<ExchangeStandard>exchangeStandardList=exchangeStandardMapper.listExchangeStandard();
		model.addAttribute("exchangeStandardList",exchangeStandardList);

		return "admin/exchange_refund/exchangeListStandard";
	}

	//?????????????????????
	@GetMapping("/modifyExchange")
	public String modifyExchange(Model model,
								 @RequestParam(value = "goodsExchangeCode",required = false)String goodsExchangeCode) {
		model.addAttribute("title","modifyExchange");
		model.addAttribute("pageTitle","????????????,??????/??????");
		GoodsExchange getGoodsExchange=goodsExchangeMapper.getGoodsExchange(goodsExchangeCode);
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		model.addAttribute("getGoodsExchange",getGoodsExchange);

		return "admin/exchange_refund/exchangeModify";
	}
	//??????????????????
	@PostMapping("/modifyExchange")
	public String modifyExchange(GoodsExchange goodsExchange){
		goodsExchangeService.modifyGoodsExchange(goodsExchange);
		return "redirect:/admin/approvalExchange";
	}
	//?????????????????????
	@GetMapping("/requestExchange")
	public String requestExchange(Model model,
								  @RequestParam(value = "paymentCompleteCode",required = false)String paymentCompleteCode) {
		model.addAttribute("title","requestExchange");
		model.addAttribute("pageTitle","?????? ??????");
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
	//??????????????????
	@PostMapping("/requestExchange")
	public String requestExchange(GoodsExchange goodsExchange){
		goodsExchangeService.addGoodsExchange(goodsExchange);
		return "redirect:/admin/listPayment";
	}

	//???????????????????????????
	@GetMapping("/addRefundStandard")
	public String addRefundStandard(Model model) {
		model.addAttribute("title","addRefundStandard");
		model.addAttribute("pageTitle","??????????????????");
		return "admin/exchange_refund/refundAddStandard";
	}
	//????????????????????????
	@PostMapping("/addRefundStandard")
	public String addRefundStandard(RefundStandard refundStandard){
		refundStandardService.addRefundStandard(refundStandard);
		return "redirect:/admin/listRefundStandard";
	}
	//???????????????????????????
	@GetMapping("/listRefundStandard")
	public String listRefundStandard(Model model) {
		model.addAttribute("title","listRefundStandard");
		model.addAttribute("pageTitle","???????????? ??????");
		List<RefundStandard>refundStandardList=refundStandardMapper.listRefundStandard();
		model.addAttribute("refundStandardList",refundStandardList);

		return "admin/exchange_refund/refundListStandard";
	}
	//?????????????????????
	@GetMapping("/modifyRefund")
	public String modifyRefund(Model model,
							   @RequestParam(value = "goodsRefundCode",required = false)String goodsRefundCode) {
		GoodsRefund getGoodsRefund=goodsRefundMapper.getGoodsRefund(goodsRefundCode);
		model.addAttribute("title","modifyRefund");
		model.addAttribute("pageTitle","?????? ??????");
		model.addAttribute("getGoodsRefund",getGoodsRefund);
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		return "admin/exchange_refund/refundModify";
	}
	//??????????????????
	@PostMapping("/modifyRefund")
	public String modifyRefund(GoodsRefund goodsRefund){
		goodsRefundService.modifyRefund(goodsRefund);
		return "redirect:/admin/approvalRefund";
	}
	//?????????????????????
	@GetMapping("/requestRefund")
	public String requestRefund(Model model,
								@RequestParam(value = "paymentCompleteCode",required = false)String paymentCompleteCode) {
		model.addAttribute("title","requestRefund");
		model.addAttribute("pageTitle","?????? ??????");
		PaymentComplete paymentComplete=paymentCompleteMapper.getPaymentCompleteInfo(paymentCompleteCode);
		model.addAttribute("paymentComplete",paymentComplete);
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		List<Goods>goodsList=goodsMapper.getListGoods();
		model.addAttribute("goodsList",goodsList);
		List<RefundStandard>refundStandardList=refundStandardMapper.listRefundStandard();
		model.addAttribute("refundStandardList",refundStandardList);
		log.info("refundStandardList:{}",refundStandardList);
		return "admin/exchange_refund/refundRequest";
	}
	//??????????????????
	@PostMapping("/requestRefund")
	public String requestRefund(GoodsRefund goodsRefund){
		goodsRefundService.addGoodsRefund(goodsRefund);
		return "redirect:/admin/approvalRefund";
	}
}

