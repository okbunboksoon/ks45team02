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

import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.mapper.BuynowMapper;
import ks45team02.ire.admin.service.BuynowService;

@Controller
@RequestMapping("/admin")
public class BuynowController {
	
	private static final Logger log = LoggerFactory.getLogger(BuynowController.class);

	private static BuynowService buynowService;
	private static BuynowMapper buynowMapper;
	
	public BuynowController(BuynowService buynowService, BuynowMapper buynowMapper) {
		this.buynowService = buynowService;
		this.buynowMapper = buynowMapper;
	}
	
	//즉시구매 등록 처리
	@PostMapping("/addBuynow")
	public String addBuyNow(Buynow buynow, RedirectAttributes reAttr) {
		
		int result = buynowService.addBuynow(buynow);
		if(result == 0) {
			reAttr.addAttribute("msg", "즉시구매 등록에 실패하였습니다.");
			return "redirect:/admin/addBuyNow";
		}else {
			reAttr.addAttribute("msg", "즉시구매 등록에 성공하였습니다.");
		}
		return "redirect:/admin/listBuyNow";
	}
	
	//즉시구매 등록 페이지
	@GetMapping("/addBuyNow")
	public String addBuyNow(Model model
						  ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "즉시구매 등록");
		model.addAttribute("pageTitle", "즉시구매 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buynow/buynowAdd";
	}
	
	//즉시구매 조회 페이지
	@GetMapping("/listBuyNow")
	public String listBuyNow(Model model
							,@RequestParam(value="msg", required = false) String msg) {
		
		List<Buynow> buynowList = buynowService.getBuynowList();
		
		model.addAttribute("title", "즉시구매 조회");
		model.addAttribute("pageTitle", "즉시구매 조회");
		model.addAttribute("buynowList", buynowList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buynow/buynowList";
	}
	
	//즉시구매 수정 처리
	@PostMapping("/modifyBuyNow")
	public String modifyBuyNow(Buynow buynow, RedirectAttributes reAttr) {
		
		int result = buynowService.modifyBuynow(buynow);
		if(result == 0) {
			reAttr.addAttribute("msg", "즉시구매 수정에 실패하였습니다.");
			reAttr.addAttribute("buynowCode", buynow.getBuynowCode());
			return "redirect:/admin/modifyBuyNow";
		}else {
			reAttr.addAttribute("msg", "즉시구매 수정에 성공하였습니다.");
		}
		return "redirect:/admin/listBuyNow";
	}
	
	//즉시구매 수정 페이지
	@GetMapping("/modifyBuyNow")
	public String modifyBuyNow(Model model
							  ,@RequestParam(value="msg", required = false) String msg
							  ,@RequestParam(value="buynowCode") String buynowCode) {
		
		Buynow buynowInfo = buynowMapper.getBuynowInfo(buynowCode);
		
		model.addAttribute("title", "즉시구매 수정");
		model.addAttribute("pageTitle", "즉시구매 수정");
		model.addAttribute("buynowInfo", buynowInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/buynow/buynowModify";
	}
}
