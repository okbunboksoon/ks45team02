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
import ks45team02.ire.admin.dto.PointSaveAndMinus;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.user.mapper.UserPointMapper;
import ks45team02.ire.user.service.UserPointService;

@Controller
@RequestMapping("/")
public class UserPointController {
	
	private final PointMapper pointMapper;
	private final UserPointMapper userPointMapper;
	private final UserPointService userPointService;
	
	public UserPointController(PointMapper pointMapper, UserPointMapper userPointMapper, UserPointService userPointService) {
		this.pointMapper = pointMapper;
		this.userPointMapper = userPointMapper;
		this.userPointService = userPointService;
	}

	//포인트 내역 조회
	@GetMapping("/listPoint")
	public String listPoint(Model model, HttpSession session
						   ,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_MEMBER_INFO");
		if(loginInfo == null) {
			return "redirect:/loginUser";
		}
		String loginId = loginInfo.getLoginId();
		
		Map<String, Object> pageMap = userPointService.getUserPointSaveAndMinusList(loginId, currentPage);
		
		int lastPage = (int) pageMap.get("lastPage");
		@SuppressWarnings("unchecked")
		List<PointSaveAndMinus> userPointSaveAndMinusList = (List<PointSaveAndMinus>) pageMap.get("userPointSaveAndMinusList");
		int startPageNum = (int) pageMap.get("startPageNum");
		int endPageNum = (int) pageMap.get("endPageNum");
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("userPointSaveAndMinusList", userPointSaveAndMinusList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
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

