package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.mapper.PaymentCompleteMapper;
import ks45team02.ire.admin.service.PaymentCompleteService;

@Controller
@RequestMapping("/admin")
public class PaymentController {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	private final PaymentCompleteService paymentCompleteService;
	private final PaymentCompleteMapper paymentCompleteMapper;
	
	public PaymentController(PaymentCompleteService paymentCompleteService, PaymentCompleteMapper paymentCompleteMapper) {
		this.paymentCompleteService = paymentCompleteService;
		this.paymentCompleteMapper = paymentCompleteMapper;
	}

	//장바구니 구매와 즉시구매 검색
	@GetMapping("/searchBuybasketAndBuynow")
	public String searchBuybasketAndBuynow(Model model
										  ,@RequestParam(value="searchKey", required = false) String searchKey
										  ,@RequestParam(value="searchValue", required = false) String searchValue) {
		
		List<PaymentComplete> buybasketAndBuynowList = paymentCompleteService.searchBuybasketAndBuynow(searchKey, searchValue);
		
		model.addAttribute("title", "주문 검색");
		model.addAttribute("pageTitle", "주문 검색");
		model.addAttribute("buybasketAndBuynowList", buybasketAndBuynowList);
		
		return "admin/search/buybasketAndBuynowSearch";
	}
	
	@GetMapping("/cancelPayment")
	public String cancelPayment(Model model) {
		
		return "admin/payment/paymentCancel";
	}
	
	//결제내역 등록 처리
	@PostMapping("/addPayment")
	public String addPayment(PaymentComplete paymentComplete, RedirectAttributes reAttr) {
		
		int result = paymentCompleteService.addPayment(paymentComplete);
		
		if(result == 30) {
			reAttr.addAttribute("msg", "배송코드를 확인해주세요.");
			return "redirect:/admin/addPayment";
		}else if(result == 40) {
			reAttr.addAttribute("msg", "결제종류코드를 확인해주세요.");
			return "redirect:/admin/addPayment";
		}else if(result == 0) {
			reAttr.addAttribute("msg", "결제내역 등록에 실패하였습니다.");
			return "redirect:/admin/addPayment";
		}
		reAttr.addAttribute("msg", "결제내역 등록에 성공하였습니다.");
		
		return "redirect:/admin/listPayment";
	}
	
	//결제내역 등록 페이지
	@GetMapping("/addPayment")
	public String addPayment(Model model
						   ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "결제내역 등록");
		model.addAttribute("pageTitle", "결제내역 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/paymentComplete/paymentAdd";
	}
	@GetMapping("/deletePayment")
	public String deletePayment(Model model) {
		
		return "admin/paymentComplete/paymentDelete";
	}
	
	//결제내역 조회 페이지
	@GetMapping("/listPayment")
	public String listPayment(Model model
							,@RequestParam(value="msg", required = false) String msg) {
		
		List<PaymentComplete> PaymentCompleteList = paymentCompleteService.getPaymentCompleteList();
		
		model.addAttribute("title", "결제내역 조회");
		model.addAttribute("pageTitle", "결제내역 조회");
		model.addAttribute("PaymentCompleteList", PaymentCompleteList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/paymentComplete/paymentList";
	}
	
	//결제내역 수정 처리
	@PostMapping("/modifyPayment")
	public String modifyPayment(PaymentComplete paymentComplete, RedirectAttributes reAttr) {
		
		int result = paymentCompleteService.modifyPayment(paymentComplete);
		
		if(result == 30) {
			reAttr.addAttribute("msg", "배송코드를 확인해주세요.");
			reAttr.addAttribute("paymentCompleteCode", paymentComplete.getPaymentCompleteCode());
			return "redirect:/admin/modifyPayment";
		}else if(result == 40) {
			reAttr.addAttribute("msg", "결제종류코드를 확인해주세요.");
			reAttr.addAttribute("paymentCompleteCode", paymentComplete.getPaymentCompleteCode());
			return "redirect:/admin/modifyPayment";
		}else if(result == 0) {
			reAttr.addAttribute("msg", "결제내역 수정에 실패하였습니다.");
			reAttr.addAttribute("paymentCompleteCode", paymentComplete.getPaymentCompleteCode());
			return "redirect:/admin/modifyPayment";
		}
		reAttr.addAttribute("msg", "결제내역 수정에 성공하였습니다.");
		
		return "redirect:/admin/listPayment";
	}
	
	//결제내역 수정 페이지
	@GetMapping("/modifyPayment")
	public String modifyPayment(Model model
							   ,@RequestParam(value="paymentCompleteCode") String paymentCompleteCode
							   ,@RequestParam(value="msg", required = false) String msg) {
		
		PaymentComplete paymentCompleteInfo = paymentCompleteMapper.getPaymentCompleteInfo(paymentCompleteCode);
		
		model.addAttribute("title", "결제내역 수정");
		model.addAttribute("pageTitle", "결제내역 수정");
		model.addAttribute("paymentCompleteInfo", paymentCompleteInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/paymentComplete/paymentModify";
	}
	

}

