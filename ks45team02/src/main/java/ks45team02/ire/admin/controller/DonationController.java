package ks45team02.ire.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks45team02.ire.admin.dto.Donation;
import ks45team02.ire.admin.mapper.DonationMapper;
import ks45team02.ire.admin.service.DonationService;

@Controller
@RequestMapping("/admin")
public class DonationController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DonationController.class);

	private final DonationService donationService;
	private final DonationMapper donationMapper;
	
	public DonationController(DonationService donationService, DonationMapper donationMapper) {
		this.donationService = donationService;
		this.donationMapper = donationMapper;
	}
	
	//기부 등록 처리
	@PostMapping("/addDonation")
	public String addDonation(Donation donation, RedirectAttributes reAttr) {
		
		int result = donationService.addDonation(donation);

		if(result == 0) {
			reAttr.addAttribute("msg", "기부 등록에 실패하였습니다.");
			return "redirect:/admin/addDonation";
		}else{
			reAttr.addAttribute("msg", "기부 등록에 성공하였습니다.");
		}
		
		return "redirect:/admin/listDonation";
	}

	//기부 등록 페이지
	@GetMapping("/addDonation")
	public String addDonation(Model model
							 ,@RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "기부 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}

		return "admin/donation/donationAdd";
	}
	
	@GetMapping("/addDonationPointSave")
	public String addDonationPointSave() {
		
		return "admin/donation/donationAddPointSave";
	}
	
	//기부 삭제 처리
	@PostMapping("/deleteDonation")
	public String deleteDonation(@RequestParam(value="donationCode") String donationCode
								,RedirectAttributes reAttr) {
		
		int result = donationService.deleteDonation(donationCode);
		
		if(result == 0) {
			reAttr.addAttribute("msg", "삭제에 실패하였습니다.");
			return "redirect:/admin/deleteDonation";
		}else {
			reAttr.addAttribute("msg", result + "개의 데이터가 삭제되었습니다.");
		}
		
		return "redirect:/admin/listDonation";
	}
	
	
	//기부 삭제 페이지
	@GetMapping("/deleteDonation")
	public String deleteDonation(@RequestParam(value="donationCode") String donationCode
								,@RequestParam(value="msg", required=false) String msg
								,Model model) {
		
		Donation donationInfo = donationMapper.getDonationInfo(donationCode);
		
		model.addAttribute("title", "기부 삭제");
		model.addAttribute("donationInfo", donationInfo); 
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/donation/donationDelete";
	}
	
	//기부 조회
	@GetMapping("/listDonation")
	public String listDonation(@RequestParam(value="searchKey", required=false) String searchKey
							  ,@RequestParam(value="searchValue", required=false) String searchValue
							  ,@RequestParam(value="startDate", required=false) String startDate		
							  ,@RequestParam(value="endDate", required=false) String endDate	
							  ,@RequestParam(value="msg", required=false)String msg
							  ,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage
							  ,Model model) {
		
		Map<String, Object> paramMap = donationService.getDonationList(searchKey, searchValue, startDate, endDate, currentPage);
		
		@SuppressWarnings("unchecked")
		List<Donation> donationList = (List<Donation>) paramMap.get("donationList");
		int lastPage = (int) paramMap.get("lastPage");
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		
		model.addAttribute("title", "기부 조회");
		model.addAttribute("pageTitle", "기부 조회");
		model.addAttribute("donationList", donationList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/donation/donationList";
	}
		
	//기부 수정 처리
	@PostMapping("/modifyDonation")
	public String modifyDonation(Donation donation, RedirectAttributes reAttr) {
		
		int result = donationService.modifyDonation(donation);
		if(result == 0) {
			reAttr.addAttribute("msg", "기부 수정에 실패하였습니다.");
			return "redirect:/admin/modifyDonation";
		}else {
			reAttr.addAttribute("msg", "기부 수정에 성공하였습니다.");
		}
		
		return "redirect:/admin/listDonation";
		
	}
	
	//기부 수정 페이지
	@GetMapping("/modifyDonation")
	public String modifyDonation(@RequestParam(value="donationCode") String donationCode
								,@RequestParam(value="msg", required=false) String msg
								,Model model) {
			
		Donation donationInfo = donationMapper.getDonationInfo(donationCode);
		
		model.addAttribute("title", "기부 수정");
		model.addAttribute("donationInfo", donationInfo);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "admin/donation/donationModify";
	}

}

