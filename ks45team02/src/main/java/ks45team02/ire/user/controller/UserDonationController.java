package ks45team02.ire.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.Donation;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.user.dto.UserDonation;
import ks45team02.ire.user.dto.UserOrder;
import ks45team02.ire.user.service.UserDonationService;

@Controller
@RequestMapping("/")
public class UserDonationController {

	private final UserDonationService userDonationService;
	
	public UserDonationController(UserDonationService userDonationService) {
		this.userDonationService = userDonationService;
	}

	//기부 내역 조회
	@GetMapping("/listDonation")
	public String listDonation(Model model, HttpSession session
							  ,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
							  ,@RequestParam(value="msg", required = false) String msg) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		Map<String, Object> pageMap = userDonationService.getDonationList(loginId, currentPage);
		
		int lastPage = (int) pageMap.get("lastPage");
		@SuppressWarnings("unchecked")
		List<UserDonation> userDonationList = (List<UserDonation>) pageMap.get("userDonationList");
		int startPageNum = (int) pageMap.get("startPageNum");
		int endPageNum = (int) pageMap.get("endPageNum");
		
		model.addAttribute("title", "기부 내역");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("userDonationList", userDonationList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "user/donation/donationList";
	}
		
	//기부 등록 처리
	@PostMapping("/addDonation")
	public String addDonation(Donation donation, RedirectAttributes reAttr, HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		donation.setUserId(loginId);
		
		int result = userDonationService.addDonation(donation);
		if(result == 0) {
			reAttr.addAttribute("msg", "기부 등록에 실패하였습니다.");
			return "redirect:/addDonation";
		}else {
			reAttr.addAttribute("msg", "기부가 등록되었습니다.");
		}
		return "redirect:/listDonation";
	}
	
	//기부 등록 페이지
	@GetMapping("/addDonation")
	public String addDonation(Model model, HttpSession session
							,@RequestParam(value="msg", required = false) String msg) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		
		model.addAttribute("title", "기부 등록");
		if(msg != null) {
			model.addAttribute("msg", msg);
		}
		
		return "user/donation/donationAdd";
	}

}

