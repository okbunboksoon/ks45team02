package ks45team02.ire.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team02.ire.admin.dto.CashReceipts;
import ks45team02.ire.admin.service.CashReceiptsService;

@Controller
@RequestMapping("/admin")
public class CashReceiptsController {
	
	private static final Logger log = LoggerFactory.getLogger(CashReceiptsController.class);

	private final CashReceiptsService cashReceiptsService;
	
	public CashReceiptsController(CashReceiptsService cashReceiptsService) {
		this.cashReceiptsService = cashReceiptsService;
	}

	//현금영수증 추가 페이지
	@GetMapping("/addCashReceipts")
	public String addCashReceipts(Model model
								 ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "현금영수증 추가");
		model.addAttribute("pageTitle", "현금영수증 추가");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/cashreceipts/cashreceiptsAdd";
	}
	@GetMapping("/deleteCashReceipts")
	public String deleteCashReceipts(Model model) {
		
		return "admin/cashreceipts/cashreceiptsDelete";
	}
	
	//현금영수증 조회 페이지
	@GetMapping("/listCashReceipts")
	public String listCashReceipts(Model model
								 ,@RequestParam(value="msg", required = false) String msg) {
		
		List<CashReceipts> cashReceiptsList = cashReceiptsService.getCashReceiptsList();
		
		model.addAttribute("title", "현금영수증 조회");
		model.addAttribute("pageTitle", "현금영수증 조회");
		model.addAttribute("cashReceiptsList", cashReceiptsList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/cashreceipts/cashreceiptsList";
	}
	@GetMapping("/modifyCashReceipts")
	public String modifyCashReceipts(Model model) {
		
		return "admin/cashreceipts/cashreceiptsModify";
	}
}
