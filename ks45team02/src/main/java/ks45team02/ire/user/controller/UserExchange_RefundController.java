package ks45team02.ire.user.controller;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.controller.UserController;
import ks45team02.ire.admin.dto.*;
import ks45team02.ire.admin.mapper.*;
import ks45team02.ire.admin.service.GoodsExchangeService;
import ks45team02.ire.admin.service.GoodsRefundService;
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
@RequestMapping("/")
public class UserExchange_RefundController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	private final GoodsExchangeMapper goodsExchangeMapper;
	private final ExchangeStandardMapper exchangeStandardMapper;
	private final PaymentCompleteMapper paymentCompleteMapper;
	private final GoodsRefundMapper goodsRefundMapper;
	private final UserMapper userMapper;
	private final GoodsMapper goodsMapper;
	private final GoodsExchangeService goodsExchangeService;
	private final GoodsRefundService goodsRefundService;

	private final RefundStandardMapper refundStandardMapper;

	public UserExchange_RefundController(GoodsExchangeMapper goodsExchangeMapper, ExchangeStandardMapper exchangeStandardMapper, PaymentCompleteMapper paymentCompleteMapper, GoodsRefundMapper goodsRefundMapper, UserMapper userMapper, GoodsMapper goodsMapper, GoodsExchangeService goodsExchangeService, GoodsRefundService goodsRefundService, RefundStandardMapper refundStandardMapper) {
		this.goodsExchangeMapper = goodsExchangeMapper;
		this.exchangeStandardMapper = exchangeStandardMapper;
		this.paymentCompleteMapper = paymentCompleteMapper;
		this.goodsRefundMapper = goodsRefundMapper;
		this.userMapper = userMapper;
		this.goodsMapper = goodsMapper;
		this.goodsExchangeService = goodsExchangeService;
		this.goodsRefundService = goodsRefundService;
		this.refundStandardMapper = refundStandardMapper;
	}

	@GetMapping("/searchExchange_Refund")
	public String searchExchange_Refund(Model model, HttpSession httpSession) {
		model.addAttribute("pageTitle","교환환불내역");
		LoginInfo loginInfo= (LoginInfo) httpSession.getAttribute("S_MEMBER_INFO");
		List<GoodsExchange> useridExchangeList= goodsExchangeMapper.useridExchangeList(loginInfo.getLoginId());
		model.addAttribute("useridExchangeList",useridExchangeList);
		List<GoodsRefund>useridRefundList=goodsRefundMapper.useridRefundList(loginInfo.getLoginId());
		model.addAttribute("useridRefundList",useridRefundList);
		return "user/exchange_refund/exchange_refundSearch";
	}

	@GetMapping("/listExchangeStandard")
	public String listExchangeStandard() {
		
		return "user/exchange_refund/exchangeListStandard";
	}
		
	@GetMapping("/modifyExchange")
	public String modifyExchange() {
		
		return "user/exchange_refund/exchangeModify";
	}


	@GetMapping("/listRefundStandard")
	public String listRefundStandard() {
		
		return "user/exchange_refund/refundListStandard";
	}
		
	@GetMapping("/modifyRefund")
	public String modifyRefund() {
		
		return "user/exchange_refund/refundModify";
	}
	//환불 요청
	@GetMapping("/requestRefund")
	public String requestRefund(Model model,
								@RequestParam(value = "orderCode",required = false)String orderCode) {
		PaymentComplete getPaymentComplete= paymentCompleteMapper.getPaymentComplete(orderCode);
		List<RefundStandard>refundStandardList=refundStandardMapper.listRefundStandard();
		List<Goods>goodsList=goodsMapper.getListGoods();
		model.addAttribute("getPaymentComplete",getPaymentComplete);
		model.addAttribute("refundStandardList",refundStandardList);
		model.addAttribute("pageTitle","환불 요청");
		model.addAttribute("goodsList",goodsList);
		return "user/exchange_refund/refundRequest";
	}
	//환불 처리
	@PostMapping("/requestRefund")
	public String requestRefund(GoodsRefund goodsRefund){
		goodsRefundService.addGoodsRefund(goodsRefund);
		return "redirect:/searchExchange_Refund";
	}
	//교환 요청
	@GetMapping("/requestExchange")
	public String requestExchange(Model model,
								  @RequestParam(value = "orderCode",required = false)String orderCode) {
		model.addAttribute("pageTitle","교환 요청");
		PaymentComplete getPaymentComplete= paymentCompleteMapper.getPaymentComplete(orderCode);
		List<ExchangeStandard>exchangeStandardList=exchangeStandardMapper.listExchangeStandard();
		List<Goods>goodsList=goodsMapper.getListGoods();
		model.addAttribute("getPaymentComplete",getPaymentComplete);
		model.addAttribute("goodsList",goodsList);
		model.addAttribute("exchangeStandardList",exchangeStandardList);
		return "user/exchange_refund/exchangeRequest";
	}
	//교환 처리
	@PostMapping("requestExchange")
	public String requestExchange(GoodsExchange goodsExchange){
			goodsExchangeService.addGoodsExchange(goodsExchange);
		return "redirect:/searchExchange_Refund";
	}

}

