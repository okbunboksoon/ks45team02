package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Exchange_RefundController {

	@GetMapping("/approvalExchange_Refund")
	public String approvalExchange_Refund(Model model) {
		
		return "/admin/exchange_refund/exchange_refundApproval";
	}
		
	@GetMapping("/InquiryExchange_Refund")
	public String InquiryExchange_Refund() {
		
		return "/admin/exchange_refund/exchange_refundInquiry";
	}
	
	@GetMapping("/addExchangeStandard")
	public String addExchangeStandard() {
		
		return "/admin/exchange_refund/exchangeAddStandard";
	}
	@GetMapping("/listExchangeStandard")
	public String listExchangeStandard() {
		
		return "/admin/exchange_refund/exchangeListStandard";
	}
		
	@GetMapping("/modifyExchange")
	public String modifyExchange() {
		
		return "/admin/exchange_refund/exchangeModify";
	}
	@GetMapping("/requestExchange")
	public String requestExchange() {
		
		return "/admin/exchange_refund/exchangeRequest";
	}
	@GetMapping("/addRefundStandard")
	public String addRefundStandard() {
		
		return "/admin/exchange_refund/refundAddStandard";
	}
	@GetMapping("/listRefundStandard")
	public String listRefundStandard() {
		
		return "/admin/exchange_refund/refundListStandard";
	}
		
	@GetMapping("/modifyRefund")
	public String modifyRefund() {
		
		return "/admin/exchange_refund/refundModify";
	}
	@GetMapping("/requestRefund")
	public String requestRefund() {
		
		return "/admin/exchange_refund/refundRequest";
	}
}

