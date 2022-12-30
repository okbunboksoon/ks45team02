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
	@GetMapping("/deletePayment")
	public String deletePayment(Model model) {
		
		return "admin/payment/paymentDelete";
	}
	@GetMapping("/listPayment")
	public String listPayment(Model model) {
		
		return "admin/payment/paymentList";
	}
	@GetMapping("/modifyPayment")
	public String modifyPayment(Model model) {
		
		return "admin/payment/paymentModify";
	}
	

}

