package ks45team02.ire.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ks45team02.ire.admin.dto.LoginInfo;
import ks45team02.ire.admin.dto.PointSaveAndMinus;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.user.mapper.UserPointMapper;

@Controller
@RequestMapping("/")
public class UserPointController {
	
	private final PointMapper pointMapper;
	private final UserPointMapper userPointMapper;
	
	public UserPointController(PointMapper pointMapper, UserPointMapper userPointMapper) {
		this.pointMapper = pointMapper;
		this.userPointMapper = userPointMapper;
	}

	//포인트 내역 조회
	@GetMapping("/listPoint")
	public String listPoint(Model model, HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		List<PointSaveAndMinus> userPointSaveAndMinusList = userPointMapper.getUserPointSaveAndMinusList(loginId);
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("userPointSaveAndMinusList", userPointSaveAndMinusList);
		
		
		return "user/point/pointList";
	}
	
	//포인트 지급 기준 조회
	@GetMapping("/listStandardPoint")
	public String listStandardPoint(Model model) {
		
		List<PointSaveStandard> pointSaveStandardList = pointMapper.getPointSaveStandardList();
		
		model.addAttribute("title", "포인트 지급 기준");
		model.addAttribute("pointSaveStandardList", pointSaveStandardList);
		
		return "user/point/pointListStandard";
	}


}

