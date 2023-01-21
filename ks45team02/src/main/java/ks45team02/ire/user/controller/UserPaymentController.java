package ks45team02.ire.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.user.service.UserPaymentService;

@Controller
@RequestMapping("/")
public class UserPaymentController {

	private final UserPaymentService userPaymentService;
	
	public UserPaymentController(UserPaymentService userPaymentService) {
		this.userPaymentService = userPaymentService;
	}
	
	@GetMapping("/listPayment")
	public String listPayment() {
		
		return "user/payment/paymentList";
	}
	
	//구매 확정 처리
	@GetMapping("/paymentConfirm")
	public String paymentConfirm(Model model, HttpSession session, RedirectAttributes reAttr
								,@RequestParam(value="orderCode") String orderCode) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		int result = userPaymentService.updatePaymentConfirm(orderCode);
		if(result == 0) {
			reAttr.addAttribute("msg", "구매확정에 실패하였습니다.");
		}else if(result == 1) {
			reAttr.addAttribute("msg", "구매를 확정하였습니다.");
		}
		return "redirect:/listOrder";
	}
	
	@GetMapping("/cancelPayment")
	public String cancelPayment() {
		
		return "user/payment/paymentCancel";
	}

}

