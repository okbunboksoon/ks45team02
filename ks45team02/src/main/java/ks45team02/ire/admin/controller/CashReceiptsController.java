package ks45team02.ire.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CashReceiptsController {

	@GetMapping("/addCashReceipts")
	public String addCashReceipts(Model model) {
		
		return "admin/cashreceipts/cashreceiptsAdd";
	}
	@GetMapping("/deleteCashReceipts")
	public String deleteCashReceipts(Model model) {
		
		return "admin/cashreceipts/cashreceiptsDelete";
	}
	@GetMapping("/listCashReceipts")
	public String listCashReceipts(Model model) {
		
		return "admin/cashreceipts/cashreceiptsList";
	}
	@GetMapping("/modifyCashReceipts")
	public String modifyCashReceipts(Model model) {
		
		return "admin/cashreceipts/cashreceiptsModify";
	}
}
