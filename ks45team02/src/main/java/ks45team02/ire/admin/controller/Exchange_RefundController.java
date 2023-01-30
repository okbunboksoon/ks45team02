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


	//교환 승인
	@GetMapping("/approvalExchange")
	public String approvalExchange(Model model) {
		model.addAttribute("title","approvalExchange_Refund");
		model.addAttribute("pageTitle","교환 승인");
		List<GoodsExchange>goodsExchangeList=goodsExchangeMapper.listGoodsExchange();
		model.addAttribute("goodsExchangeList",goodsExchangeList);
		log.info("goodsExchangeList:{}",goodsExchangeList);
		return "admin/exchange_refund/exchangeApproval";
	}
	//환불 승인
	@GetMapping("/approvalRefund")
	public String approvalRefund(Model model) {
		model.addAttribute("title","approvalRefund");
		model.addAttribute("pageTitle","환불 승인");
		List<GoodsRefund>goodsRefundList=goodsRefundMapper.listGoodsRefund();
		model.addAttribute("goodsRefundList",goodsRefundList);
		return "admin/exchange_refund/refundApproval";
	}


	//교환 기준 등록페이지
	@GetMapping("/addExchangeStandard")
	public String addExchangeStandard(Model model) {
		model.addAttribute("title","addExchangeStandard");
		model.addAttribute("pageTitle","교환 기준 등록");
		return "admin/exchange_refund/exchangeAddStandard";
	}
	//교환기준등록처리
	@PostMapping("/addExchangeStandard")
	public String addExchangeStandard(ExchangeStandard exchangeStandard){
		exchangeStandardService.addExchangeStandard(exchangeStandard);
		return "redirect:/admin/listExchangeStandard";
	}
	//교환기준페이지
	@GetMapping("/listExchangeStandard")
	public String listExchangeStandard(Model model) {
		model.addAttribute("title","listExchangeStandard");
		model.addAttribute("pageTitle","교환기준 조회");
		List<ExchangeStandard>exchangeStandardList=exchangeStandardMapper.listExchangeStandard();
		model.addAttribute("exchangeStandardList",exchangeStandardList);

		return "admin/exchange_refund/exchangeListStandard";
	}

	//교환수정페이지
	@GetMapping("/modifyExchange")
	public String modifyExchange(Model model,
								 @RequestParam(value = "goodsExchangeCode",required = false)String goodsExchangeCode) {
		model.addAttribute("title","modifyExchange");
		model.addAttribute("pageTitle","교환수정,승인/반려");
		GoodsExchange getGoodsExchange=goodsExchangeMapper.getGoodsExchange(goodsExchangeCode);
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		model.addAttribute("getGoodsExchange",getGoodsExchange);

		return "admin/exchange_refund/exchangeModify";
	}
	//교환수정처리
	@PostMapping("/modifyExchange")
	public String modifyExchange(GoodsExchange goodsExchange){
		goodsExchangeService.modifyGoodsExchange(goodsExchange);
		return "redirect:/admin/approvalExchange";
	}
	//교환요청페이지
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
	//교환요청처리
	@PostMapping("/requestExchange")
	public String requestExchange(GoodsExchange goodsExchange){
		goodsExchangeService.addGoodsExchange(goodsExchange);
		return "redirect:/admin/listPayment";
	}

	//환불기중등록페이지
	@GetMapping("/addRefundStandard")
	public String addRefundStandard(Model model) {
		model.addAttribute("title","addRefundStandard");
		model.addAttribute("pageTitle","환불기준등록");
		return "admin/exchange_refund/refundAddStandard";
	}
	//환불기준등록처리
	@PostMapping("/addRefundStandard")
	public String addRefundStandard(RefundStandard refundStandard){
		refundStandardService.addRefundStandard(refundStandard);
		return "redirect:/admin/listRefundStandard";
	}
	//환불기준조회페이지
	@GetMapping("/listRefundStandard")
	public String listRefundStandard(Model model) {
		model.addAttribute("title","listRefundStandard");
		model.addAttribute("pageTitle","환불기준 조회");
		List<RefundStandard>refundStandardList=refundStandardMapper.listRefundStandard();
		model.addAttribute("refundStandardList",refundStandardList);

		return "admin/exchange_refund/refundListStandard";
	}
	//환불수정페이지
	@GetMapping("/modifyRefund")
	public String modifyRefund(Model model,
							   @RequestParam(value = "goodsRefundCode",required = false)String goodsRefundCode) {
		GoodsRefund getGoodsRefund=goodsRefundMapper.getGoodsRefund(goodsRefundCode);
		model.addAttribute("title","modifyRefund");
		model.addAttribute("pageTitle","환불 수정");
		model.addAttribute("getGoodsRefund",getGoodsRefund);
		List<User>userList=userMapper.listUser();
		model.addAttribute("userList",userList);
		return "admin/exchange_refund/refundModify";
	}
	//환불수정처리
	@PostMapping("/modifyRefund")
	public String modifyRefund(GoodsRefund goodsRefund){
		goodsRefundService.modifyRefund(goodsRefund);
		return "redirect:/admin/approvalRefund";
	}
	//환불요청페이지
	@GetMapping("/requestRefund")
	public String requestRefund(Model model,
								@RequestParam(value = "paymentCompleteCode",required = false)String paymentCompleteCode) {
		model.addAttribute("title","requestRefund");
		model.addAttribute("pageTitle","환불 요청");
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
	//환불요청처리
	@PostMapping("/requestRefund")
	public String requestRefund(GoodsRefund goodsRefund){
		goodsRefundService.addGoodsRefund(goodsRefund);
		return "redirect:/admin/approvalRefund";
	}
}

