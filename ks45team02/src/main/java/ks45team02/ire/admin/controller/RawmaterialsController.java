package ks45team02.ire.admin.controller;

import ks45team02.ire.admin.dto.RawMaterials;
import ks45team02.ire.admin.dto.RawMaterialsIncoming;
import ks45team02.ire.admin.mapper.RawMaterialsMapper;
import ks45team02.ire.admin.service.RawMaterialsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RawmaterialsController {
	
	private static final Logger log=
	 LoggerFactory.getLogger(RawmaterialsController.class);
	
	private final RawMaterialsMapper rawmaterialsMapper;
	private final RawMaterialsService rawmaterialsService;
	
	public RawmaterialsController(RawMaterialsService rawmaterialsService,
			
			RawMaterialsMapper rawmaterialsMapper) {
		this.rawmaterialsMapper =rawmaterialsMapper;
		this.rawmaterialsService=rawmaterialsService;
		
	}
	
	//원자재 입고 등록 처리
	@PostMapping("/addIncomingRawmaterials")
	public String addIncomingRawmaterials(RawMaterialsIncoming rawMaterialsIncoming, RedirectAttributes reAttr) {
		
		int result = rawmaterialsService.addIncomingRawmaterials(rawMaterialsIncoming);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "등록에 실패하였습니다.");
			return "redirect:/admin/addIncomingRawmaterials";
		}else {
			reAttr.addAttribute("msg", result + "개의 데이터가 등록되었습니다.");
		}
		
		return "redirect:/admin/listIncomingRawmaterials";
	}
	
	//원자재 입고 등록 페이지
	@GetMapping("/addIncomingRawmaterials")
	public String addIncomingRawMatrials(Model model
										,@RequestParam(value="msg", required=false) String msg) {
		
		List<String> donationCodeNotIncoming = rawmaterialsMapper.getDonationCodeNotIncoming();
		
		model.addAttribute("title", "원자재 입고 등록");
		model.addAttribute("pageTitle", "원자재 입고 등록");
		model.addAttribute("donationCodeNotIncoming", donationCodeNotIncoming);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		
		
		return "admin/rawmaterials/rawmaterialsAddIncoming";
	}
	@GetMapping("/addoutgoingRawmaterials")
	public String addoutgoingRawMatrials(Model model) {
		
		return "admin/rawmatrials/rawmaterialsAddOutgoing";
	}
	
	@GetMapping("/deleteIncomingRawmaterials")
	public String deleteIncomingRawMatrials() {
		
		return "admin/rawmatrials/rawmaterialsDeleteIncoming";
	}
	@GetMapping("/deleteoutgoingRawmaterials")
	public String deleteoutgoingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsDeleteOutgoing";
	}
	
	//원자재 입고 리스트 페이지
	@GetMapping("/listIncomingRawmaterials")
	public String listIncomingRawMatrials(Model model
										,@RequestParam(value="msg", required = false) String msg) {
		
		List<RawMaterialsIncoming> rawMaterialsIncomingList = rawmaterialsMapper.getRawMaterialsIncomingList();
		
		model.addAttribute("title", "원자재 입고 조회");
		model.addAttribute("rawMaterialsIncomingList", rawMaterialsIncomingList);
		model.addAttribute("subTitle", "원자재 입고 조회");
		
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/rawmaterials/rawmaterialsListIncoming";
	}
	
	
	@GetMapping("/listNowRawmaterials")
	public String listNow() {
		
		return "admin/rawmaterials/rawmaterialsListNow";
	}
	@GetMapping("/listOutgoingRawmaterials")
	public String listOutgoingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsListOutgoing";
	}
	
	
	//원자재 입고 수정 페이지
	@GetMapping("/modifyIncomingRawmaterials")
	public String modifyIncomingRawMatrials(Model model
										  ,@RequestParam(value="rawMaterialsCode") String rawMaterialsCode) {
		
		RawMaterialsIncoming rawMaterialsIncomingInfo = rawmaterialsMapper.getRawMaterialsIncomingInfo(rawMaterialsCode);
		
		model.addAttribute("title", "원자재 입고 수정");
		model.addAttribute("pageTitle", "원자재 입고 수정");
		model.addAttribute("rawMaterialsIncomingInfo", rawMaterialsIncomingInfo);
		
		return "admin/rawmaterials/rawmaterialsModifyIncoming";
	}
	
	@GetMapping("/modifyOutgoingRawmaterials")
	public String modifyOutgoingRawMatrials() {
		
		return "admin/rawmaterials/rawmaterialsModifyOutgoing";
	}
	
	
	@GetMapping("/totalRawmaterialsInOut")
	public String totalRawMatrialsInOut(Model model) {
		List<RawMaterials> rawmaterialsList =rawmaterialsService.rawmaterialsList();
		
		model.addAttribute("title", "원자재리스트");
		model.addAttribute("rawmaterialsList",rawmaterialsList);
		log.info("찍히나?");
	
		return "admin/rawmaterials/rawmaterialsTotalInOut";
	}
	

}

