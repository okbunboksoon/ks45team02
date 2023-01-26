package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserExchange_RefundController {

	@GetMapping("/searchExchange_Refund")
	public String searchExchange_Refund() {
		
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
	public String requestRefund(Model model) {
		model.addAttribute("pageTitle","환불 요청");
		return "user/exchange_refund/refundRequest";
	}
	//교환 요청
	@GetMapping("/requestExchange")
	public String requestExchange(Model model) {
		model.addAttribute("pageTitle","교환 요청");

		return "user/exchange_refund/exchangeRequest";
	}

}

