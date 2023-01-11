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

import ks45team02.ire.admin.dto.TypePaymentInfo;
import ks45team02.ire.admin.mapper.TypePaymentInfoMapper;
import ks45team02.ire.admin.service.TypePaymentInfoService;

@Controller
@RequestMapping("/admin")
public class TypePaymentInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(TypePaymentInfoController.class);

	private final TypePaymentInfoService typePaymentInfoService;
	private final TypePaymentInfoMapper typePaymentInfoMapper;
	
	public TypePaymentInfoController(TypePaymentInfoService typePaymentInfoService, TypePaymentInfoMapper typePaymentInfoMapper) {
		this.typePaymentInfoService = typePaymentInfoService;
		this.typePaymentInfoMapper = typePaymentInfoMapper;
	}

	//구매자별 결제 종류 처리 
	@PostMapping("/addTypePaymentInfo")
	public String addTypePaymentInfo(TypePaymentInfo typePaymentInfo, RedirectAttributes reAttr) {
		
		int result = typePaymentInfoService.addTypePaymentInfo(typePaymentInfo);
		
		if(result == 10) {
			reAttr.addAttribute("msg", "존재하지 않는 아이디입니다.");
			return "redirect:/admin/addTypePaymentInfo";
		}else {
			reAttr.addAttribute("msg", "구매자별 결제 종류 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listTypePaymentInfo";
	}
	
	//구매자별 결제 종류 등록 페이지
	@GetMapping("/addTypePaymentInfo")
	public String addTypePaymentInfo(Model model
								    ,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "구매자별 결제 종류 등록");
		model.addAttribute("pageTitle", "구매자별 결제 종류 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/type_payment_info/typePaymentInfoAdd";
	}
	
	@GetMapping("/deleteTypePaymentInfo")
	public String deleteTypePaymentInfo(Model model) {
		
		return "admin/type_payment_info/typePaymentInfoDelete";
	}
	
	//구매자별 결제 종류 조회 페이지
	@GetMapping("/listTypePaymentInfo")
	public String listTypePaymentInfo(Model model
									 ,@RequestParam(value="msg", required = false) String msg) {
		
		List<TypePaymentInfo> typePaymentInfoList = typePaymentInfoService.getTypePaymentInfoList();
		
		model.addAttribute("title", "구매자별 결제 종류 조회");
		model.addAttribute("pageTitle", "구매자별 결제 종류 조회");
		model.addAttribute("typePaymentInfoList", typePaymentInfoList);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/type_payment_info/typePaymentInfoList";
	}
	
	
	//구매자별 결제 종류 수정 처리
	@PostMapping("/modifyTypePaymentInfo")
	public String modifyTypePaymentInfo(TypePaymentInfo typePaymentInfo, RedirectAttributes reAttr) {
		
		int result = typePaymentInfoService.modifyPaymentInfo(typePaymentInfo);
		
		if(result == 10) {
			reAttr.addAttribute("msg", "존재하지 않는 아이디입니다.");
			reAttr.addAttribute("paymentTypeCode", typePaymentInfo.getPaymentTypeCode());
			return "redirect:/admin/addTypePaymentInfo";
		}else {
			reAttr.addAttribute("msg", "구매자별 결제 종류 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listTypePaymentInfo";
	}
	
	//구매자별 결제 종류 수정 페이지
	@GetMapping("/modifyTypePaymentInfo")
	public String modifyTypePaymentInfo(Model model
									  ,@RequestParam(value="paymentTypeCode") String paymentTypeCode
									  ,@RequestParam(value="msg", required = false) String msg) {
		
		TypePaymentInfo typePaymentInfo = typePaymentInfoMapper.getTypePaymentInfoByPaymentTypeCode(paymentTypeCode);
		
		model.addAttribute("title", "구매자별 결제 종류 수정");
		model.addAttribute("pageTitle", "구매자별 결제 종류 수정");
		model.addAttribute("typePaymentInfo", typePaymentInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/type_payment_info/typePaymentInfoModify";
	}
}
