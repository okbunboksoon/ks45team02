package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PaymentController {

	@GetMapping("/addPayment")
	public String addPayment(Model model) {
		
		return "admin/payment/paymentAdd";
	}
	
	@GetMapping("/buyNowPayment")
	public String buyNowPayment() {
		
		return "admin/payment/paymentBuyNow";
	}
	@GetMapping("/buyNowCancelPayment")
	public String buyNowCancelPayment() {
		
		return "admin/payment/paymentBuyNowCancel";
	}
	@GetMapping("/buyNowListPayment")
	public String buyNowListPayment() {
		
		return "admin/payment/paymentBuyNowList";
	}
	@GetMapping("/deletePayment")
	public String deletePayment() {
		
		return "admin/payment/paymentDelete";
	}
	
	
	@GetMapping("/listPayment")
	public String listPayment() {
		
		return "admin/payment/paymentList";
	}

}

