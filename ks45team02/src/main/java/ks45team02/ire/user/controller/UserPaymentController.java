package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserPaymentController {

	@GetMapping("/addPayment")
	public String addPayment(Model model) {
		
		return "user/payment/paymentAdd";
	}
	
	@GetMapping("/buyNowPayment")
	public String buyNowPayment() {
		
		return "user/payment/paymentBuyNow";
	}
	@GetMapping("/buyNowCancelPayment")
	public String buyNowCancelPayment() {
		
		return "user/payment/paymentBuyNowCancel";
	}
	@GetMapping("/buyNowListPayment")
	public String buyNowListPayment() {
		
		return "user/payment/paymentBuyNowList";
	}
	@GetMapping("/deletePayment")
	public String deletePayment() {
		
		return "user/payment/paymentDelete";
	}
	
	
	@GetMapping("/listPayment")
	public String listPayment() {
		
		return "user/payment/paymentList";
	}

}

