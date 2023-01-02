package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypePaymentInfoController {

	@GetMapping("/addTypePaymentInfo")
	public String addTypePaymentInfo(Model model) {
		
		return "admin/type_payment_info/typePaymentInfoAdd";
	}
	@GetMapping("/deleteTypePaymentInfo")
	public String deleteTypePaymentInfo(Model model) {
		
		return "admin/type_payment_info/typePaymentInfoDelete";
	}
	@GetMapping("/listTypePaymentInfo")
	public String listTypePaymentInfo(Model model) {
		
		return "admin/type_payment_info/typePaymentInfoList";
	}
	@GetMapping("/modifyTypePaymentInfo")
	public String modifyTypePaymentInfo(Model model) {
		
		return "admin/type_payment_info/typePaymentInfoModify";
	}
}
