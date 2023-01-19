package ks45team02.ire.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
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
							  ,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
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
		
		return "user/donation/donationList";
	}
		
	
	@GetMapping("/addDonation")
	public String addDonation(Model model) {
		
		
		
		return "user/donation/donationAdd";
	}

}

