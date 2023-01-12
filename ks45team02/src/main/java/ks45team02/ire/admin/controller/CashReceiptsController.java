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

import ks45team02.ire.admin.dto.CashReceipts;
import ks45team02.ire.admin.mapper.CashReceiptsMapper;
import ks45team02.ire.admin.service.CashReceiptsService;

@Controller
@RequestMapping("/admin")
public class CashReceiptsController {
	
	private static final Logger log = LoggerFactory.getLogger(CashReceiptsController.class);

	private final CashReceiptsService cashReceiptsService;
	private final CashReceiptsMapper cashReceiptsMapper;
	
	public CashReceiptsController(CashReceiptsService cashReceiptsService, CashReceiptsMapper cashReceiptsMapper) {
		this.cashReceiptsService = cashReceiptsService;
		this.cashReceiptsMapper = cashReceiptsMapper;
	}

	
	//현금영수증 등록 처리
	@PostMapping("/addCashReceipts")
	public String addCashReceipts(CashReceipts cashReceipts, RedirectAttributes reAttr) {
		
		int result = cashReceiptsService.addCashReceipts(cashReceipts);
		if(result == 10) {
			reAttr.addAttribute("msg", "존재하지 않는 아이디입니다.");
			return "redirect:/admin/addCashReceipts"; 
		}else if(result == 20) {
			reAttr.addAttribute("msg", "아이디 혹은 결제종류 코드를 확인해주세요.");
			return "redirect:/admin/addCashReceipts"; 
		}else if(result == 0) {
			reAttr.addAttribute("msg", "현금영수증 등록에 실패하였습니다.");
			return "redirect:/admin/addCashReceipts"; 
		}else {
			reAttr.addAttribute("msg", "현금영수증 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listCashReceipts"; 
	}
	
	//현금영수증 등록 페이지
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
	
	//현금영수증 삭제 처리
	@PostMapping("/deleteCashReceipts")
	public String deleteCashReceipts(@RequestParam(value="cashCode") String cashCode, RedirectAttributes reAttr) {
		
		int result = cashReceiptsService.deleteCashReceipts(cashCode);
		if(result == 0) {
			reAttr.addAttribute("msg", "현금영수증 삭제에 실패하였습니다.");
			reAttr.addAttribute("cashCode", cashCode);
			return "redirect:/admin/deleteCashReceipts"; 
		}else {
			reAttr.addAttribute("msg", "현금영수증 삭제에 성공하였습니다.");
		}
		
		return "redirect:/admin/listCashReceipts"; 
	}
	
	//현금영수증 삭제 페이지
	@GetMapping("/deleteCashReceipts")
	public String deleteCashReceipts(Model model
									,@RequestParam(value="cashCode") String cashCode
									,@RequestParam(value="msg", required = false) String msg) {
		
		CashReceipts cashReceiptsInfo = cashReceiptsMapper.getCashReceiptsInfo(cashCode);
		
		model.addAttribute("title", "현금영수증 삭제");
		model.addAttribute("pageTitle", "현금영수증 삭제");
		model.addAttribute("cashReceiptsInfo", cashReceiptsInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
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
	
	//현금영수증 수정 처리
	@PostMapping("/modifyCashReceipts")
	public String modifyCashReceipts(CashReceipts cashReceipts, RedirectAttributes reAttr) {
		
		int result = cashReceiptsService.modifyCashReceipts(cashReceipts);
		
		if(result == 10) {
			reAttr.addAttribute("msg", "존재하지 않는 아이디입니다.");
			reAttr.addAttribute("cashCode", cashReceipts.getCashCode());
			return "redirect:/admin/modifyCashReceipts"; 
		}else if(result == 20) {
			reAttr.addAttribute("msg", "아이디 혹은 결제종류 코드를 확인해주세요.");
			reAttr.addAttribute("cashCode", cashReceipts.getCashCode());
			return "redirect:/admin/modifyCashReceipts"; 
		}else if(result == 0) {
			reAttr.addAttribute("msg", "현금영수증 수정에 실패하였습니다.");
			reAttr.addAttribute("cashCode", cashReceipts.getCashCode());
			return "redirect:/admin/modifyCashReceipts"; 
		}else {
			reAttr.addAttribute("msg", "현금영수증 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listCashReceipts"; 
	}
	
	//현금영수증 수정 페이지
	@GetMapping("/modifyCashReceipts")
	public String modifyCashReceipts(Model model
									,@RequestParam(value="cashCode") String cashCode
									,@RequestParam(value="msg", required = false) String msg) {
		
		CashReceipts cashReceiptsInfo = cashReceiptsMapper.getCashReceiptsInfo(cashCode);
		
		model.addAttribute("title", "현금영수증 수정");
		model.addAttribute("pageTitle", "현금영수증 수정");
		model.addAttribute("cashReceiptsInfo", cashReceiptsInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/cashreceipts/cashreceiptsModify";
	}
}
