package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.service.PaymentCompleteService;

@Controller
@RequestMapping("/admin")
public class PaymentController {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	private final PaymentCompleteService paymentCompleteService;
	
	public PaymentController(PaymentCompleteService paymentCompleteService) {
		this.paymentCompleteService = paymentCompleteService;
	}

	@GetMapping("/cancelPayment")
	public String cancelPayment(Model model) {
		
		return "admin/payment/paymentCancel";
	}
	
	@GetMapping("/addPayment")
	public String addPayment(Model model) {
		
		return "admin/payment/paymentAdd";
	}
	@GetMapping("/deletePayment")
	public String deletePayment(Model model) {
		
		return "admin/payment/paymentDelete";
	}
	
	//결제완료 조회 페이지
	@GetMapping("/listPayment")
	public String listPayment(Model model
							,@RequestParam(value="msg", required = false) String msg) {
		
		List<PaymentComplete> PaymentCompleteList = paymentCompleteService.getPaymentCompleteList();
		
		model.addAttribute("title", "결제완료 조회");
		model.addAttribute("pageTitle", "결제완료 조회");
		model.addAttribute("PaymentCompleteList", PaymentCompleteList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/payment/paymentList";
	}
	@GetMapping("/modifyPayment")
	public String modifyPayment(Model model) {
		
		return "admin/payment/paymentModify";
	}
	

}

